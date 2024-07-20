package com.productSync.Service;

import java.util.List;

import com.productSync.Model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategoryService {

    public List<Category> getAllCategories();
    public List<Category> createCategories(List<Category> categories);

}
