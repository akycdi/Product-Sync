package com.productSync.DTO.Statistics;
import lombok.Data;

@Data
public class LocationStatisticsDTO {
    private String location;
    private Long orderCount;
    private Double totalRevenue;
}