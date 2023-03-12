package com.example.demo.core.admin.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class StaffRequest {

    private String name;

    private String middleName;

    private String surname;

    private String gender;

    private Date dateOfBirth;

    private String address;

    private String phoneNumber;

    private String email;

    private String storeName;

    private String positionName;
}
