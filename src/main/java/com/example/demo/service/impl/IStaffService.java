package com.example.demo.service.impl;

import com.example.demo.model.Staff;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStaffService implements StaffService {

    @Autowired
    private StaffRepository staffRepository;


    @Override
    public List<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }
}
