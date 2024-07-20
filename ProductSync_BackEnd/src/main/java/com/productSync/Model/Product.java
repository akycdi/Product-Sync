package com.productSync.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private int quantity;

    @ManyToOne
    private Category category;

    private Date createdDate;
    private Date soldDate;

    private String url;

}
