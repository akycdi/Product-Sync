package com.productSync.Controller;

import com.productSync.Model.Category;
import com.productSync.Service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCategories() {
       return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<List<Category>> createCategories(@RequestBody List<Category> categories) {
        List<Category> createdCategories = categoryService.createCategories(categories);
        return new ResponseEntity<>(createdCategories, HttpStatus.CREATED);
    }


}
