package com.example.demo.core.admin.model.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDetailsRequest {
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
