package com.productSync.Service.Implements;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.productSync.DAO.CustomerDAO;
import com.productSync.Model.Customer;
import com.productSync.Model.CustomerProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productSync.DAO.ProductDAO;
import com.productSync.Model.Product;
import com.productSync.Service.ProductService;

@Service
public class ProductServiceImplements implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CustomerDAO customerDAO;

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
        product.setCreatedDate(new Date());
        Product createdProduct = productDAO.createProduct(product);
        return productDAO.createProduct(createdProduct);
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


    public void sellProduct(Long productId, Long customerId) {
        Product product = productDAO.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Customer customer = customerDAO.getCustomerById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (product.getQuantity() > 0) {
            // Create a new CustomerProduct entity to represent the purchase
            CustomerProduct customerProduct = new CustomerProduct();
            customerProduct.setProduct(product);
            customerProduct.setCustomer(customer);
            customerProduct.setQuantity(1); // Assuming you sell only one quantity at a time

            // Set the sold date and update the product quantity
            product.setSoldDate(new Date());
            product.setQuantity(product.getQuantity() - 1);

            // Add the CustomerProduct to the customer's list
            customer.addCustomerProduct(customerProduct);

            // Update the product and customer entities
            productDAO.updateProduct(product);
            customerDAO.updateCustomer(customer);
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
        return currentDate.getTime() - createdDate.getTime();
    }
}
