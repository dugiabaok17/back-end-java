package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StoreResponse;
import com.example.demo.core.admin.service.AdStoreService;
import com.example.demo.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
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

    @GetMapping
    private List<Store> getAllStore() {
       return adStoreService.findAllStore();
    }

    @GetMapping("/name")
    private List<StoreResponse> getStoreName() {
        return adStoreService.getStoreName();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findByStoreId(@PathVariable Long id) {
        return adStoreService.findByStore(id);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseObject> updateStore(@PathVariable Long id,@RequestBody Store store) {
        return adStoreService.updateStore(store,id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseObject> deleteStore(@PathVariable Long id) {
        return adStoreService.deleteStore(id);
    }
}
