package com.productSync.DTO;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class BroughtItemDTO {
    private Long id;
    private String name;
    private Double price;
}