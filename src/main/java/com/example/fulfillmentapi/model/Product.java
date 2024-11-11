package com.example.fulfillmentapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private String status;
    private String fulfillmentCenter;
    private Integer quantity;
    private BigDecimal value;
}