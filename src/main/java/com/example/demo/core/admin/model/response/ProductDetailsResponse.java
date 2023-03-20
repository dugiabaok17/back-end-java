package com.example.demo.core.admin.model.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class ProductDetailsResponse {
    @Id
    private Long id;
    private String description;
    private BigDecimal importPrices;
    private BigDecimal price;
    private Integer quantityInStock;
    private Integer warrantyYear;
    private String categoryName;
    private String colorName;
    private String producerName;
    private String productName;
}
