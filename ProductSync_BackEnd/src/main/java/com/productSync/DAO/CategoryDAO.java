package com.productSync.DAO;

import com.productSync.Model.Category;
import com.productSync.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryDAO {
    Optional<Category> getCategoryById(Long id);
}
