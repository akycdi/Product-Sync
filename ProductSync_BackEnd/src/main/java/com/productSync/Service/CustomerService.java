package com.productSync.Service;

import com.productSync.Model.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Optional<Customer> getCustomerById(Long id);
}
