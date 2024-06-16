package com.productSync.DAO;

import java.util.List;
import java.util.Optional;

import com.productSync.Model.Product;

public interface ProductDAO {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
    List<Product> searchProductsByName(String name);
}
