package com.example.demo.controller;

import com.example.demo.model.Staff;
import com.example.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/staff")
public class EmployeeController {

    @Autowired
    private StaffService staffService;

    //    get all employee
    @GetMapping
    public List<Staff> getAllEmployees() {
        return staffService.findAllStaff();
    }

    // create employee rest api
    @PostMapping
    public Staff createEmployee(@RequestBody Staff staff) {
        return staffService.createStaff(staff);
    }

}
