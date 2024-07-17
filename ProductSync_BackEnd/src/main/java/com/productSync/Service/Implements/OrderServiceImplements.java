package com.productSync.Service.Implements;

import com.productSync.DAO.OrderDAO;
import com.productSync.Model.Order;
import com.productSync.Repository.OrderRepository;
import com.productSync.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplements implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    public List<Order> getAllOrders() {
        return orderDAO.findAll();
    }

    @Override
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderDAO.findByCustomerId(customerId);
    }
}
