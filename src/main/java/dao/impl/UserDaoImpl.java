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

        return Optional.empty();
    }

    @Override
    public Optional<User> getByEmail(String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT id, first_name,last_name,email,password, role FROM user WHERE email=?");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        return Optional.ofNullable(UserMapper.mapToUser(resultSet));
    }

    @Override
    public void removeUser(int userId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE id=?");
        statement.setInt(1, userId);
        statement.execute();
    }

}
