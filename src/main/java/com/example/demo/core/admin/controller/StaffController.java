package com.example.demo.core.admin.controller;

import com.example.demo.core.admin.model.request.StaffRequest;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StaffResponse;
import com.example.demo.core.admin.service.AdStaffService;
import com.example.demo.core.admin.service.impl.IAdStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/staff")
public class StaffController {

    private final AdStaffService staffService;

    @Autowired
    public StaffController(IAdStaffService iStaffService) {
        this.staffService = iStaffService;
    }

    //    get all employee
    @GetMapping
    public List<StaffResponse> getAllEmployees() {
        return staffService.findAllStaff();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return staffService.findByStaff(id);
        }

//     create employee rest api
    @PostMapping
    public ResponseEntity<ResponseObject>  createEmployee(@RequestBody StaffRequest staffRequest) {
        return staffService.createStaff(staffRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody StaffRequest staffRequest,@PathVariable Long id) {
        return staffService.updateStaff(staffRequest,id);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<ResponseObject> deleteStaff(@PathVariable Long id) {
        System.out.println("check id"+id);
        return staffService.deleteStaff(id);
    }
}
