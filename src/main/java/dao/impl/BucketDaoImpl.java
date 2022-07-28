package dao.impl;

import dao.BucketDao;
import entities.Product;
import jdbc.MySqlConnector;
import mappers.ProductMapper;

import java.sql.*;
import java.util.List;

public class BucketDaoImpl implements BucketDao {
    Connection connection;

    public BucketDaoImpl() {
        this.connection = new MySqlConnector().getConnection();
    }

    @Override
    public void create(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO bucket VALUES (?,?)");
        statement.setInt(1, id);
        statement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
        statement.execute();
    }

    @Override
    public void insertProduct(int bucketId, int productId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO bucket_product VALUES (?,?)");
        statement.setInt(1, bucketId);
        statement.setInt(2, productId);
        statement.execute();

    }

    @Override
    public List<Product> getAllProducts(int bucketId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT p.id, p.name,p.description,p.price, p.image FROM bucket_product bp INNER JOIN product p on bp.product_id = p.id WHERE bucket_id =?");
        statement.setInt(1, bucketId);
        ResultSet resultSet = statement.executeQuery();
        return ProductMapper.mapToListOfProducts(resultSet);
    }

    @Override
    public void removeProductFromBucket(int bucketId, int productId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("DELETE FROM bucket_product WHERE bucket_id=? AND product_id=?");
        statement.setInt(1, bucketId);
        statement.setInt(2, productId);
        statement.execute();
    }
}
