package com.service;

import com.Repository.ProductRepository;
import com.dto.ProductDto;
import com.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ProductDto> getProductById(int productId) {
        return productRepository.getProductById(productId);
    }

    public void updateStockQuantity(int productId, int newStockQuantity) {
        productRepository.updateStockQuantity(productId,newStockQuantity);
    }
}
