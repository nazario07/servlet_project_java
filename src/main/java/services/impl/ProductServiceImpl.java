package services.impl;

import dao.ProductDao;
import entities.Product;
import jdbc.MySqlConnector;
import org.apache.log4j.Logger;
import services.ProductService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
   private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    private static final Logger log = Logger.getLogger(String.valueOf(ProductServiceImpl.class));

    @Override
    public void createNewProduct(Product product) {
        try {
            productDao.insert(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            products=  productDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        try {
            Optional<Product> byId = productDao.getById(id);
            if (byId.isPresent()) {
                return byId.get();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return  null;
    }

}
