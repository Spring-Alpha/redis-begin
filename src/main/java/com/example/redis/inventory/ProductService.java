package com.example.redis.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Data not found!"));
    }

    @Override
    public Product editProduct(long id, Product product) {
        Product product1 = getProductById(id);
        BeanUtils.copyProperties(product1, product);
        return productRepository.save(product1);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String removeProductById(long id) {
        productRepository.deleteById(id);
        return "Deleted Successfully!";
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

}
