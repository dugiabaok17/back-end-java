package com.example.demo.core.admin.service;


import com.example.demo.core.admin.model.request.StaffRequest;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StaffResponse;
import com.example.demo.entity.Staff;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AdStaffService {
    List<StaffResponse> findAllStaff();

    ResponseEntity<ResponseObject> findByStaff(Long id);

    ResponseEntity<ResponseObject> createStaff(StaffRequest staffRequest);

    ResponseEntity<ResponseObject> updateStaff(StaffRequest staffRequest,Long id);

    ResponseEntity<ResponseObject> deleteStaff(Long id);
}
