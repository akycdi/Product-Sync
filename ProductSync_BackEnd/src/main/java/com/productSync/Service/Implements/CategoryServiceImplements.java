package com.productSync.Service.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productSync.Model.Category;
import com.productSync.Repository.CategoryRepository;
import com.productSync.Service.CategoryService;

@Service
public class CategoryServiceImplements implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> createCategories(List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }
}
