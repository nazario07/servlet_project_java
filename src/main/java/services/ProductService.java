package services;

import entities.Product;

import java.util.List;

public interface ProductService {
    void createNewProduct(Product product);
    List<Product> getAll();
    Product getById(int id);
}
