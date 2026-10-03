package com.service;

import com.Repository.ProductRepository;
import com.dto.ProductDto;
import com.model.Product;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    public Map<String, Integer> countProductsByVendor() throws SQLException {
        return productRepository.countProductsByVendor();
    }
}
