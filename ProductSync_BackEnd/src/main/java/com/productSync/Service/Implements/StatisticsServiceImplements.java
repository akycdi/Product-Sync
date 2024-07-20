package com.productSync.Service.Implements;

import com.productSync.DTO.Statistics.*;
import com.productSync.Model.Order;
import com.productSync.Model.Product;
import com.productSync.Repository.OrderRepository;
import com.productSync.Repository.ProductRepository;
import com.productSync.Service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatisticsServiceImplements implements StatisticsService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<OrderStatisticsDTO> getOrderStatistics() {
        List<Order> orders = orderRepository.findAll();
        List<OrderStatisticsDTO> orderStatistics = new ArrayList<>();

        for (Order order : orders) {
            OrderStatisticsDTO dto = new OrderStatisticsDTO();
            dto.setId(order.getId());
            dto.setOrderDate(order.getOrderDate());
            dto.setQuantity(order.getQuantity());

            double totalRevenue = 0;
            for (Product product : order.getProducts()) {
                totalRevenue += product.getPrice();
            }
            dto.setTotalRevenue(totalRevenue);

            orderStatistics.add(dto);
        }

        return orderStatistics;
    }

    @Override
    public List<LocationStatisticsDTO> getLocationStatistics() {
        List<Order> orders = orderRepository.findAll();
        Map<String, LocationStatisticsDTO> locationMap = new HashMap<>();

        for (Order order : orders) {
            String location = order.getCustomer().getLocation();
            double orderRevenue = 0;

            for (Product product : order.getProducts()) {
                orderRevenue += product.getPrice();
            }

            LocationStatisticsDTO dto = locationMap.get(location);
            if (dto == null) {
                dto = new LocationStatisticsDTO();
                dto.setLocation(location);
                dto.setOrderCount(0L);
                dto.setTotalRevenue(0.0);
                locationMap.put(location, dto);
            }

            dto.setOrderCount(dto.getOrderCount() + 1);
            dto.setTotalRevenue(dto.getTotalRevenue() + orderRevenue);
        }

        return new ArrayList<>(locationMap.values());
    }

    @Override
    public List<ProductStatisticsDTO> getProductStatistics() {
        List<Product> products = productRepository.findAll();
        List<Order> orders = orderRepository.findAll();
        List<ProductStatisticsDTO> productStatistics = new ArrayList<>();

        for (Product product : products) {
            ProductStatisticsDTO dto = new ProductStatisticsDTO();
            dto.setProductName(product.getName());

            long quantitySold = 0;
            for (Order order : orders) {
                for (Product p : order.getProducts()) {
                    if (p.getId().equals(product.getId())) {
                        quantitySold++;
                    }
                }
            }
            dto.setQuantitySold(quantitySold);

            productStatistics.add(dto);
        }

        return productStatistics;
    }

    @Override
    public List<StockStatisticsDTO> getStockStatistics() {
        List<Product> products = productRepository.findAll();
        List<StockStatisticsDTO> stockStatistics = new ArrayList<>();

        for (Product product : products) {
            StockStatisticsDTO dto = new StockStatisticsDTO();
            dto.setProductName(product.getName());
            dto.setStockQuantity(product.getQuantity());
            stockStatistics.add(dto);
        }

        return stockStatistics;
    }

    @Override
    public List<RevenueStatisticsDTO> getRevenueStatistics() {
        List<Order> orders = orderRepository.findAll();
        Map<Date, Double> revenueMap = new HashMap<>();

        for (Order order : orders) {
            Date orderDate = order.getOrderDate();
            double orderRevenue = 0;

            for (Product product : order.getProducts()) {
                orderRevenue += product.getPrice();
            }

            revenueMap.put(orderDate, revenueMap.getOrDefault(orderDate, 0.0) + orderRevenue);
        }

        List<RevenueStatisticsDTO> revenueStatistics = new ArrayList<>();
        for (Map.Entry<Date, Double> entry : revenueMap.entrySet()) {
            RevenueStatisticsDTO dto = new RevenueStatisticsDTO();
            dto.setDate(entry.getKey());
            dto.setRevenue(entry.getValue());
            revenueStatistics.add(dto);
        }

        return revenueStatistics;
    }
}
