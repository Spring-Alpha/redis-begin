package com.example.redis.inventory;

import java.util.List;

public interface IProductService {
    Product getProductById(long id);

    Product editProduct(long id, Product product);

    Product createProduct(Product product);

    String removeProductById(long id);

    List<Product> getAllProduct();
}
