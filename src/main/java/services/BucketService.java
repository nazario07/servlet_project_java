package services;

import entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface BucketService {
    List<Product> getProductFromBucket(int bucketId);
    void addProductToBucket(int bucketId, int productId);

    void removeItem(int bucketId, int productId) throws SQLException;

}
