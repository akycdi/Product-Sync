package com.productSync.DAO;

import com.productSync.Model.Order;

import java.util.List;

public interface OrderDAO {
    Order createOrder(Order order);

    List<Order> findAll();

    List<Order> findByCustomerId(Long customerId);
}