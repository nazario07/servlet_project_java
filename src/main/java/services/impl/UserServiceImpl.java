package services.impl;

import dao.UserDao;
import entities.User;
import exceptions.IncorrectCredsExceptions;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;
import services.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

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
    public void insert(User user) throws UserAlreadyExistException {
        try {
            Optional<User> byEmail = userDao.getByEmail(user.getEmail());
            if (byEmail.isPresent()) {
                throw new UserAlreadyExistException(user.getEmail());
            }
            userDao.insert(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void displayById(int id) throws UserNotFoundException {
        try {
            Optional<User> optional = userDao.getById(id);
            if (optional.isPresent()) {
                System.out.println(optional.get());
            } else {
                throw new UserNotFoundException("User with id " + id + " not found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public User login(String email, String password) throws IncorrectCredsExceptions {
        try {
            Optional<User> byEmail = userDao.getByEmail(email);
            if(byEmail.isPresent()){
                User user = byEmail.get();
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new IncorrectCredsExceptions();
    }
}
