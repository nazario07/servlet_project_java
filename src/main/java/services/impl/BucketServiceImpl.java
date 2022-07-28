package services.impl;

import dao.BucketDao;
import entities.Product;
import services.BucketService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BucketServiceImpl implements BucketService {
    private BucketDao bucketDao;

    public BucketServiceImpl(BucketDao bucketDao) {
        this.bucketDao = bucketDao;
    }

    @Override
    public List<Product> getProductFromBucket(int bucketId) {
        List<Product> allProducts = new ArrayList<>();
        try {
            allProducts = bucketDao.getAllProducts(bucketId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProducts;
    }

    @Override
    public void addProductToBucket(int bucketId, int productId) {
        try {
            bucketDao.insertProduct(bucketId, productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeItem(int bucketId, int productId) throws SQLException {
        bucketDao.removeProductFromBucket(bucketId, productId);
    }
}
