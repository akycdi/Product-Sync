package com.productSync.Service.Implements;

import com.productSync.DAO.CustomerDAO;
import com.productSync.Model.Customer;
import com.productSync.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImplements implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerDAO.getCustomerById(id);
    }


}
