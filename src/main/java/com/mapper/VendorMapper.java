package com.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@Component
public class VendorMapper implements RowMapper<Map.Entry<String,Integer>> {

    @Override
    public Map.Entry<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
        String vendorName = rs.getString("vendor_name");
        int count = rs.getInt("product_count");

        return Map.entry(vendorName, count);
    }
}
