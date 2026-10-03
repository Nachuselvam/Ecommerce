package com.Repository;

import com.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveProduct(Product product) {
        String sql = "insert into Product values (?,?,?,?,?,?)";
        Object[] values = new Object[] {product.getId(),product.getName(),product.getPrice(),
                            product.getStockQuantity(),product.getCategory_id(),product.getVendor_id()};
        jdbcTemplate.update(sql,values);
    }
}
