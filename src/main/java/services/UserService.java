package services;

import entities.User;
import exceptions.IncorrectCredsExceptions;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> getAll();
    void registration(User user) throws SQLException, UserAlreadyExistException;
    void displayById(int id) throws UserNotFoundException;
    User login(String email, String password) throws IncorrectCredsExceptions;

    void removeUser(int userId) throws SQLException;

}
