package com.productSync.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productSync.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
