package com.Repository;

import com.dto.ProductDto;
import com.mapper.ProductMapper;
import com.mapper.VendorMapper;
import com.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;
    private final VendorMapper vendorMapper;

    public ProductRepository(JdbcTemplate jdbcTemplate, ProductMapper productMapper, VendorMapper vendorMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
        this.vendorMapper = vendorMapper;
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

    public void updateStockQuantity(int productId, int newStockQuantity) {
        String sql = "update Product set stockQuantity = ? where id = ?";
        jdbcTemplate.update(sql,newStockQuantity,productId);
    }

    public Map<String, Integer> countProductsByVendor() throws SQLException {
        String sql = """
                SELECT v.name AS vendor_name,
                                      COUNT(p.id) AS product_count
                                      FROM Vendor v
                                      JOIN Product p ON v.id = p.vendor_id
                                      GROUP BY v.id, v.name;
                """;
        List<Map.Entry<String, Integer>> entries  = jdbcTemplate.query(sql,vendorMapper);
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
