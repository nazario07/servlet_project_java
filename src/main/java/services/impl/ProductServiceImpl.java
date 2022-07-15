package services.impl;

import dao.ProductDao;
import entities.Product;
import services.ProductService;

import java.sql.SQLException;

public class ProductServiceImpl implements ProductService {
   private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void createNewProduct(Product product) {
        try {
            productDao.insert(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
