package exceptions;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super("User with email " + message + " already exist");
    }
}
