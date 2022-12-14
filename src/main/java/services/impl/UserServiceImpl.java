package services.impl;

import dao.BucketDao;
import dao.UserDao;
import entities.User;
import exceptions.IncorrectCredsExceptions;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import org.apache.log4j.Logger;
import services.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final BucketDao bucketDao;

    public UserServiceImpl(UserDao userDao, BucketDao bucketDao) {
        this.userDao = userDao;
        this.bucketDao = bucketDao;
    }

    private static final Logger log = Logger.getLogger(String.valueOf(UserServiceImpl.class));

    @Override
    public List<User> getAll() {
        List<User> users;
        try {
            users = userDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void displayById(int id) throws UserNotFoundException {
        try {
            Optional<User> optional = userDao.getById(id);
            if (optional.isPresent()) {
                System.out.println(optional.get());
            } else {
                log.error("User with id " + id + " not found");
                throw new UserNotFoundException("User with id " + id + " not found");
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public User login(String email, String password) throws IncorrectCredsExceptions {
        try {
            Optional<User> byEmail = userDao.getByEmail(email);
            if (byEmail.isPresent()) {
                User user = byEmail.get();
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        throw new IncorrectCredsExceptions();
    }

    @Override
    public void removeUser(int userId) throws SQLException {
        userDao.removeUser(userId);
    }

    @Override
    public void registration(User user) throws SQLException, UserAlreadyExistException {
        Optional<User> byEmail = userDao.getByEmail(user.getEmail());
        if (byEmail.isPresent()) {
            throw new UserAlreadyExistException(user.getEmail());
        }

        userDao.insert(user);
        Optional<User> first = userDao.getByEmail(user.getEmail());
        first.ifPresent(u -> {
            try {
                bucketDao.create(u.getId());
            } catch (SQLException e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        });
    }
}

