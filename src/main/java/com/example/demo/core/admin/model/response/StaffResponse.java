package com.example.demo.core.admin.model.response;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class StaffResponse {

    @Id
    private Long id;
    private String name;

    private String middleName;

    private String surname;

    private String gender;

    private Date dateOfBirth;

    private String address;

    private String phoneNumber;

    private String email;

    private Integer status;

    private String storeName;

    private String positionName ;
}
