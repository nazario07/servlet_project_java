package dao.impl;

import dao.ProductDao;
import entities.Product;
import jdbc.MySqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {

    private final Connection connection;

    public ProductDaoImpl() {
        this.connection = new MySqlConnector().getConnection();
    }

    @Override
    public void insert(Product product) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO product (name, description, price) VALUES (?,?,?)");
        statement.setString(1,product.getName());
        statement.setString(2,product.getDescription());
        statement.setDouble(3,product.getPrice());
        statement.execute();
    }
}
