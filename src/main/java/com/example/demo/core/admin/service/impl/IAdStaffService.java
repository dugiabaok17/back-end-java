package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.request.StaffRequest;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StaffResponse;
import com.example.demo.core.admin.repository.AdStaffRepository;
import com.example.demo.core.admin.service.AdStaffService;
import com.example.demo.entity.Position;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Store;
import com.example.demo.repository.PositionRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IAdStaffService implements AdStaffService {

    private final AdStaffRepository adStaffRepository;
    private final StaffRepository staffRepository;

    private final StoreRepository storeRepository;

    private final PositionRepository positionRepository;

    @Autowired
    public IAdStaffService(AdStaffRepository adStaffRepository,
                           StaffRepository staffRepository,
                           StoreRepository storeRepository,
                           PositionRepository positionRepository) {
        this.adStaffRepository = adStaffRepository;
        this.staffRepository = staffRepository;
        this.storeRepository = storeRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public List<StaffResponse> findAllStaff() {
        return (List<StaffResponse>) adStaffRepository.getAllStaff();
    }

    @Override
    public ResponseEntity<ResponseObject> findByStaff(Long id) {
        Optional<StaffResponse> foundStaff = adStaffRepository.findByStaff(id);
        return foundStaff.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).
                        body(new ResponseObject("ok", "Query staff successfully", 0, foundStaff))
                :
                ResponseEntity.status(HttpStatus.NOT_FOUND).
                        body(new ResponseObject("false", "Cannot find staff with id = " + id, -1, ""));
    }

    @Override
    public ResponseEntity<ResponseObject> createStaff(@RequestBody StaffRequest staffRequest) {
        List<Staff> foundStaffs = staffRepository.findByEmail(staffRequest.getEmail());
        if (foundStaffs.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).
                    body(new ResponseObject("false", "Staff email already taken ", -1, ""));
        }

        Staff staff = new Staff();
        staff.setFirstName(staffRequest.getName());
        staff.setMiddleName(staffRequest.getMiddleName());
        staff.setSurname(staffRequest.getSurname());
        staff.setGender(staffRequest.getGender());
        staff.setAddress(staffRequest.getAddress());
        staff.setPhoneNumber(staffRequest.getPhoneNumber());
        staff.setEmail(staffRequest.getEmail());
        staff.setDateOfBirth(staffRequest.getDateOfBirth());
        Position position = new Position();
        position.setId(positionRepository.findByName(staffRequest.getPositionName()).get(0).getId());
        staff.setPosition(position);
        Store store = new Store();
        store.setId(storeRepository.findByName(staffRequest.getStoreName()).get(0).getId());
        staff.setStore(store);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).
                body(new ResponseObject("ok", "Insert staff successfully ", 0, staffRepository.save(staff)));

    }

    @Override
    public ResponseEntity<ResponseObject> updateStaff(StaffRequest staffRequest, Long id) {
        Optional<Staff> updateStaff = staffRepository.findById(id);
        if (updateStaff.isPresent()) {
            updateStaff.get().setFirstName(staffRequest.getName());
            updateStaff.get().setMiddleName(staffRequest.getMiddleName());
            updateStaff.get().setSurname(staffRequest.getSurname());
            updateStaff.get().setGender(staffRequest.getGender());
            updateStaff.get().setAddress(staffRequest.getAddress());
            updateStaff.get().setPhoneNumber(staffRequest.getPhoneNumber());
            updateStaff.get().setEmail(staffRequest.getEmail());
            updateStaff.get().setDateOfBirth(staffRequest.getDateOfBirth());
            Position position = new Position();
            position.setId(positionRepository.findByName(staffRequest.getPositionName()).get(0).getId());
            updateStaff.get().setPosition(position);
            Store store = new Store();
            store.setId(storeRepository.findByName(staffRequest.getStoreName()).get(0).getId());
            updateStaff.get().setStore(store);
            staffRepository.save(updateStaff.get());
            return ResponseEntity.status(HttpStatus.OK).
                    body(new ResponseObject("ok", "Update staff successfully", 0, updateStaff));

        }
        return null;

    }

    @Override
    public ResponseEntity<ResponseObject> deleteStaff(Long id) {
        Boolean exists = staffRepository.existsById(id);
        if (exists) {
            staffRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete staff successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find staff to delete", -1, ""));
    }


}
