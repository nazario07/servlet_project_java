package services;

import entities.Product;

import java.util.List;

public interface BucketService {
    List<Product> getProductFromBucket(int bucketId);
    void addProductToBucket(int bucketId, int productId);

}
