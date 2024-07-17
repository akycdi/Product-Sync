package com.productSync.Service;

import com.productSync.Model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    List<Order> getOrdersByCustomerId(Long customerId);
}
