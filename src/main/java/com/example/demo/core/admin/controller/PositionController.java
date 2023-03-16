package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.response.PositionResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdPositionService;
import com.example.demo.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/position")
public class PositionController {

    private final AdPositionService adPositionService;

    @Autowired
    public PositionController(AdPositionService adPositionService) {
        this.adPositionService = adPositionService;
    }


    @PostMapping
    private ResponseEntity<ResponseObject> createStore(@RequestBody Store store) {
        return adPositionService.createStore(store);
    }

    @GetMapping("/name")
    private List<PositionResponse> getStoreName() {
        adPositionService.getPositionName().forEach(data -> System.out.println(data));
        return adPositionService.getPositionName();
    }
}
