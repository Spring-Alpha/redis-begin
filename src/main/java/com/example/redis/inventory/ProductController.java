package com.example.redis.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@CacheConfig(cacheNames = "product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    @CachePut(key = "#id")
    public Product editProduct(@PathVariable long id, @RequestBody Product product) {
        return productService.editProduct(id, product);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(allEntries = true)
    public String removeProductById(@PathVariable long id) {
        return productService.removeProductById(id);
    }

    @GetMapping("/all")
    @Cacheable
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }
}
