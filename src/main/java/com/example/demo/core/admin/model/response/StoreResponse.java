package com.example.demo.core.admin.model.response;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class StoreResponse {
    @Id
    private Long id;

    private String storeName;
}
