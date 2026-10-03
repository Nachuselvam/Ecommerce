package com.service;

import com.Repository.CategoryRepository;
import com.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void insert(Category category) {
        int categoryId = (int) (Math.random() * 10000);
        category.setId(categoryId);
        categoryRepository.insert(category);
    }
}
