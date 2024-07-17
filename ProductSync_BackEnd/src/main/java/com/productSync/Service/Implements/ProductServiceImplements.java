package com.productSync.Service.Implements;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.productSync.DAO.CategoryDAO;
import com.productSync.DAO.CustomerDAO;
import com.productSync.DAO.OrderDAO;
import com.productSync.DAO.ProductDAO;
import com.productSync.Model.Customer;
import com.productSync.Model.Order;
import com.productSync.Model.Product;
import com.productSync.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplements implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private OrderDAO orderDAO; // Inject OrderDAO

    @Autowired
    private CategoryDAO categoryDAO;

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
        // Check if category exists
        categoryDAO.findById(product.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setCreatedDate(new Date());
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
    public void sellProduct(Long productId, Long customerId) {
        Product product = productDAO.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Customer customer = customerDAO.getCustomerById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (product.getQuantity() > 0) {
            // Decrease product quantity
            product.setQuantity(product.getQuantity() - 1);
            product.setSoldDate(new Date());
            productDAO.updateProduct(product);

            // Create new order
            Order order = new Order();
            order.setCustomer(customer);
            order.getProducts().add(product);
            order.setQuantity(1); // Set the quantity sold
            order.setOrderDate(new Date()); // Set the order date
            orderDAO.createOrder(order);
        } else {
            throw new RuntimeException("Product out of stock");
        }
    }

    @Override
    public long calculateDaysInDatabase(Long productId) {
        Product product = productDAO.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Date currentDate = new Date();
        Date createdDate = product.getCreatedDate();
        return (currentDate.getTime() - createdDate.getTime()) / (1000 * 60 * 60 * 24);
    }
}
