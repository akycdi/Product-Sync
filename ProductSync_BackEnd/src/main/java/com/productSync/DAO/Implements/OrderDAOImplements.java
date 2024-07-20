package com.productSync.DAO.Implements;

import com.productSync.DAO.OrderDAO;
import com.productSync.Model.Order;
import com.productSync.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImplements implements OrderDAO {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }


}
