package com.productSync.Service;


import com.productSync.DTO.Statistics.*;

import java.util.List;

public interface StatisticsService {

    List<OrderStatisticsDTO> getOrderStatistics();

    List<LocationStatisticsDTO> getLocationStatistics();

    List<ProductStatisticsDTO> getProductStatistics();

    List<StockStatisticsDTO> getStockStatistics();

    List<RevenueStatisticsDTO> getRevenueStatistics();
}