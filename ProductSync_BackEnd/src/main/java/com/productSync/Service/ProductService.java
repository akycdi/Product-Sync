package com.productSync.Service;

import com.productSync.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();

    public Optional<Product> getProductById(Long id);

    public Product createProduct(Product product);

    public Product updateProduct(Long id, Product productDetails);

    public void deleteProduct(Long id);

    public List<Product> searchProductsByName(String name);

    public Product sellProduct(Long productId);

    public long calculateDaysInDatabase(Long productId);
}
