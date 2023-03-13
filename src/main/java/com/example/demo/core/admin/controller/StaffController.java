package com.example.demo.core.admin.controller;

import com.example.demo.core.admin.model.request.StaffRequest;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StaffResponse;
import com.example.demo.core.admin.service.AdStaffService;
import com.example.demo.core.admin.service.impl.IAdStaffService;
import com.example.demo.entity.Position;
import com.example.demo.entity.Staff;
import com.example.demo.repository.PositionRepository;
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
    private PositionRepository positionRepository;
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
    @PostMapping("/create")
    public ResponseEntity<ResponseObject>  createEmployee(@RequestBody StaffRequest staffRequest) {
        return staffService.createStaff(staffRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody StaffRequest staffRequest,@PathVariable Long id) {
        return staffService.updateStaff(staffRequest,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteStaff(@PathVariable Long id) {
        return staffService.deleteStaff(id);
    }

    @PostMapping("/position")
    public ResponseEntity<ResponseObject> insertPosition(@RequestBody Position position) {
        positionRepository.save(position);
        return  ResponseEntity.status(200).body(
                new ResponseObject("ok","success",0,"")
        );
    }


}
