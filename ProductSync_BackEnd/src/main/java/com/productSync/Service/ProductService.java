package com.productSync.Service;

import com.productSync.Model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {

    public List<Product> getAllProducts();

    public Optional<Product> getProductById(Long id);

    public Product createProduct(Product product);

    public Product updateProduct(Long id, Product productDetails);

    public void deleteProduct(Long id);

    public List<Product> searchProductsByName(String name);

    public void sellProduct(Long productId, Long customerId);

    public long getTotalProductsSold();
    public long getStockInStorage() ;

    Map<String, Long> getLocationSalesData();
}
