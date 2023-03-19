package com.example.demo.core.admin.model.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PositionResponse {
    @Id
    private Long id;

    private String name;

//    private Integer status;

}
