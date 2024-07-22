package com.productSync.Controller;

import com.productSync.DTO.Statistics.*;
import com.productSync.Service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/statistics")
@CrossOrigin("http://localhost:4200")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/orders")
    public ResponseEntity<?> getOrderStatistics() {
        try {
            List<OrderStatisticsDTO> orderStats = statisticsService.getOrderStatistics();
            List<Map<String, Object>> data = new ArrayList<>();
            for (OrderStatisticsDTO dto : orderStats) {
                Map<String, Object> entry = new HashMap<>();
                entry.put("id", dto.getId());
                entry.put("orderDate", dto.getOrderDate());
                entry.put("quantity", dto.getQuantity());
                entry.put("totalRevenue", dto.getTotalRevenue());
                data.add(entry);
            }
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/locations")
    public ResponseEntity<?> getLocationStatistics() {
        try {
            List<LocationStatisticsDTO> locationStats = statisticsService.getLocationStatistics();
            List<String> labels = new ArrayList<>();
            List<Double> data = new ArrayList<>();

            for (LocationStatisticsDTO stat : locationStats) {
                labels.add(stat.getLocation());
                data.add(stat.getTotalRevenue());
            }

            Map<String, Object> chartData = new HashMap<>();
            chartData.put("labels", labels);
            chartData.put("data", data);

            return ResponseEntity.ok(chartData);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProductStatistics() {
        try {
            List<ProductStatisticsDTO> productStats = statisticsService.getProductStatistics();
            List<String> labels = new ArrayList<>();
            List<Long> data = new ArrayList<>();

            for (ProductStatisticsDTO dto : productStats) {
                labels.add(dto.getProductName());
                data.add(dto.getQuantitySold());
            }

            Map<String, Object> chartData = new HashMap<>();
            chartData.put("labels", labels);
            chartData.put("data", data);

            return ResponseEntity.ok(chartData);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/stock")
    public ResponseEntity<?> getStockStatistics() {
        try {
            List<StockStatisticsDTO> stockStats = statisticsService.getStockStatistics();
            List<String> labels = new ArrayList<>();
            List<Integer> data = new ArrayList<>();

            for (StockStatisticsDTO dto : stockStats) {
                labels.add(dto.getProductName());
                data.add(dto.getStockQuantity());
            }

            Map<String, Object> chartData = new HashMap<>();
            chartData.put("labels", labels);
            chartData.put("data", data);

            return ResponseEntity.ok(chartData);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @GetMapping("/revenue")
    public ResponseEntity<?> getRevenueStatistics() {
        try {
            List<RevenueStatisticsDTO> revenueStats = statisticsService.getRevenueStatistics();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<String> labels = new ArrayList<>();
            List<Double> data = new ArrayList<>();

            for (RevenueStatisticsDTO dto : revenueStats) {
                labels.add(sdf.format(dto.getDate()));
                data.add(dto.getRevenue());
            }

            Map<String, Object> chartData = new HashMap<>();
            chartData.put("labels", labels);
            chartData.put("data", data);

            return ResponseEntity.ok(chartData);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Internal Server Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
