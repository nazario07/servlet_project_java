package services;

import entities.User;
import exceptions.IncorrectCredsExceptions;
import exceptions.UserAlreadyExistException;
import exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void insert(User user) throws UserAlreadyExistException;
    void displayById(int id) throws UserNotFoundException;
    User login(String email, String password) throws IncorrectCredsExceptions;

}
