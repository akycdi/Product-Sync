package com.productSync.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CustomerProduct> customerProducts = new ArrayList<>();

    public void addCustomerProduct(CustomerProduct customerProduct) {
        customerProducts.add(customerProduct);
        customerProduct.setCustomer(this);
    }

}
