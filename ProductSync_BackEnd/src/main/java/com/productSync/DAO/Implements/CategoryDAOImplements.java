package com.productSync.DAO.Implements;

import com.productSync.DAO.CategoryDAO;
import com.productSync.Model.Category;
import com.productSync.Model.Product;
import com.productSync.Repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryDAOImplements implements CategoryDAO {

    CategoryRepository categoryRepository;

    public Optional<Category> getCategoryById(Long id){
        return categoryRepository.findById(id);
    }
}
