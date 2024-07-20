package com.productSync.Controller;

import com.productSync.DAO.OrderDAO;
import com.productSync.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.productSync.Model.Product;
import com.productSync.Service.ProductService;

import java.util.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        try {
            Optional<Product> productOptional = productService.getProductById(id);
            if (productOptional.isPresent()) {
                return ResponseEntity.ok(productOptional.get());
            } else {
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "No product found with ID: " + id);
                return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

            }
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        try {
            Product createdProduct = productService.createProduct(product);
            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        try {
            Product updatedProduct = productService.updateProduct(id, productDetails);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Deleted Product");
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchProductsByName(@PathVariable String name) {
        try {
            List<Product> products = productService.searchProductsByName(name);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/sell/{productId}")
    public ResponseEntity<?> sellProduct(@PathVariable Long productId, @RequestParam Long customerId) {
        try {
            productService.sellProduct(productId, customerId);
            return new ResponseEntity<>("Product sold successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/totalProductsSold")
    public ResponseEntity<?> getTotalProductsSold() {
        try {
            long totalProductsSold = productService.getTotalProductsSold();
            return ResponseEntity.ok(totalProductsSold);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/stockInStorage")
    public ResponseEntity<?> getStockInStorage() {
        try {
            long stockInStorage = productService.getStockInStorage();
            return ResponseEntity.ok(stockInStorage);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/locationSales")
    public ResponseEntity<?> getLocationSalesData() {
        try {
            Map<String, Long> locationSales = productService.getLocationSalesData();
            List<String> labels = new ArrayList<>(locationSales.keySet());
            List<Long> data = new ArrayList<>(locationSales.values());

            // Structure data for Chart.js format
            Map<String, Object> chartData = new HashMap<>();
            chartData.put("labels", labels);
            chartData.put("datasets", List.of(Map.of("data", data)));

            return ResponseEntity.ok(chartData);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }




}
