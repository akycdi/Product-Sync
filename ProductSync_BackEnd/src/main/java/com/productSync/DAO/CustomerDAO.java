package com.productSync.DAO;

import com.productSync.Model.Customer;

import java.util.Optional;

public interface CustomerDAO {
    Customer createCustomer(Customer customer);
    Optional<Customer> getCustomerById(Long customerId);
    Customer updateCustomer(Customer customer); // Add this method
}
