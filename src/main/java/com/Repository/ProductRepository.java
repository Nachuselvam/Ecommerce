package com.Repository;

import com.dto.ProductDto;
import com.mapper.ProductMapper;
import com.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;

    public ProductRepository(JdbcTemplate jdbcTemplate, ProductMapper productMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
    }

    public void saveProduct(Product product) {
        String sql = "insert into Product values (?,?,?,?,?,?)";
        Object[] values = new Object[] {product.getId(),product.getName(),product.getPrice(),
                            product.getStockQuantity(),product.getCategory_id(),product.getVendor_id()};
        jdbcTemplate.update(sql,values);
    }

    public List<ProductDto> getProductById(int productId) {
        String sql = """
                    SELECT p.id,
                           p.name,
                           p.price,
                           p.stockQuantity,
                           c.name AS Category_name,
                           v.name AS Vendor_name
                    FROM Product p
                    JOIN Category c ON p.category_id = c.id
                    JOIN Vendor v ON p.vendor_id = v.id
                    WHERE p.id = ?
                    """;
        return jdbcTemplate.query(sql,productMapper,productId);
    }
}
