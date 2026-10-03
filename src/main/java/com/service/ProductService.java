package com.service;

import com.Repository.ProductRepository;
import com.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        int product_id = (int) (Math.random() * 10000);
        product.setId(product_id);
        productRepository.saveProduct(product);
    }
}
