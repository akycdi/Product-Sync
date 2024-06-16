package com.productSync.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.productSync.Model.Product;
import com.productSync.Service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.get());
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "No product found with ID: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted Product", HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Product>> searchProductsByName(@PathVariable String name) {
        List<Product> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);
    }


    @PutMapping("/sell/{id}")
    public ResponseEntity<Product> sellProduct(@PathVariable Long id) {
        Product soldProduct = productService.sellProduct(id);
        return ResponseEntity.ok(soldProduct);
    }

    @GetMapping("/lastRecived/{id}")
    public ResponseEntity<Long> calculateDaysInDatabase(@PathVariable Long id) {
        long daysInDatabase = productService.calculateDaysInDatabase(id);
        return ResponseEntity.ok(daysInDatabase);
    }
}
