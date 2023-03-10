package com.example.demo.service;


import com.example.demo.model.Position;
import com.example.demo.model.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> findAllStaff();

    Staff createStaff(Staff staff);
}
