package com.productSync.Controller;

import com.productSync.Service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/categories")
@CrossOrigin("http://localhost:5173/")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCategories() {
       return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
}
