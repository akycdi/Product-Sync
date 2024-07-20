package com.productSync.DTO.Statistics;

import lombok.Data;

import java.util.Date;

@Data
public class OrderStatisticsDTO {
    private Long id;
    private Date orderDate;
    private int quantity;
    private Double totalRevenue;
}
