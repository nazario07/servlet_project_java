package dao;

import entities.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductDao {

    void insert(Product product) throws SQLException;
    List<Product> getAll() throws  SQLException;
    Optional<Product> getById(int id)  throws  SQLException;

}
