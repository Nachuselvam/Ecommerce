package com.Repository;

import com.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Category category) {
        String sql = "insert into Category values (?,?,?)";
        Object[] values = new Object[] { category.getId(),category.getName(),category.getDescription()};
        jdbcTemplate.update(sql,values);
    }
}
