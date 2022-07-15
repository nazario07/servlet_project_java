package dao;

import entities.Product;

import java.sql.SQLException;

public interface ProductDao {

    void insert(Product product) throws SQLException;

}
