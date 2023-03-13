package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.request.StaffRequest;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdStoreService;
import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("api/v1/store")
public class StoreController {

    private AdStoreService adStoreService;

    @Autowired
    public StoreController(AdStoreService adStoreService) {
        this.adStoreService = adStoreService;
    }


    @PostMapping
    private ResponseEntity<ResponseObject> createStore(@RequestBody Store store) {
        return adStoreService.createStore(store);

    }
}
