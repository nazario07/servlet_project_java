package dao.impl;

import dao.UserDao;
import jdbc.MySqlConnector;
import entities.User;
import mappers.UserMapper;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private final Connection connection;

    public UserDaoImpl() {
        this.connection = new MySqlConnector().getConnection();
    }

    @Override
    public List<User> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        return UserMapper.mapToListOfUsers(resultSet);
    }

    @Override
    public void insert(User object) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO user (first_name, last_name, email, password,role) VALUES(?,?,?,?,?)");
        statement.setString(1, object.getFirstName());
        statement.setString(2, object.getLastName());
        statement.setString(3, object.getEmail());
        statement.setString(4, object.getPassword());
        statement.setString(5, object.getRole().name());
        statement.execute();


    }

    @Override
    public Optional<User> getById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE id ='" + id + "'");
        List<User> users = UserMapper.mapToListOfUsers(resultSet);
        User user = null;
        if (users.size() != 0) {
            user = users.get(0);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> getByEmail(String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT first_name,last_name,email,password FROM user WHERE email=?");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        return Optional.ofNullable(UserMapper.mapToUser(resultSet));
    }

}