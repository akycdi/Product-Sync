package com.productSync.DTO.Statistics;
import lombok.Data;
import java.util.Date;

@Data
public class RevenueStatisticsDTO {
    private Date date;
    private Double revenue;
}