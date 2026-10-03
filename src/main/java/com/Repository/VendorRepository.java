package com.Repository;

import com.model.Vendor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VendorRepository {
    private final JdbcTemplate jdbcTemplate;

    public VendorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Vendor vendor) {
        String sql = "insert into Vendor values (?,?,?)";
        Object[] values = new Object[] {vendor.getId(),vendor.getName(),vendor.getEmail()};
        jdbcTemplate.update(sql,values);
    }
}
