package com.productSync.Service.Implements;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productSync.DAO.ProductDAO;
import com.productSync.Model.Product;
import com.productSync.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productDAO.getProductById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productDAO.createProduct(product);
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productDAO.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setCategory(productDetails.getCategory());

        return productDAO.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productDAO.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productDAO.deleteProduct(product);
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productDAO.searchProductsByName(name);
    }

      @Override
    public Product sellProduct(Long productId) {
        Product product = productDAO.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setSoldDate(LocalDate.now());
        return productDAO.updateProduct(product);
    }

    @Override
    public long calculateDaysInDatabase(Long productId) {
        Product product = productDAO.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        LocalDate currentDate = LocalDate.now();
        LocalDate createdDate = product.getCreatedDate();
        return ChronoUnit.DAYS.between(createdDate, currentDate);
    }
}
