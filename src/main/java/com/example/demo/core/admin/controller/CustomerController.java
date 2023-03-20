package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdCustomerService;
import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final AdCustomerService adCustomerService;

    @Autowired
    public CustomerController(AdCustomerService adCustomerService) {
        this.adCustomerService = adCustomerService;
    }

    @GetMapping
    private List<Customer> findAllCustomer() {
        return adCustomerService.findAllCustomer();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findByCustomerId(@PathVariable Long id) {
        return adCustomerService.findByCustomer(id);
    }

    @PostMapping
    private ResponseEntity<ResponseObject> createCustomer(@RequestBody Customer customer) {
        return adCustomerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseObject> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return adCustomerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseObject> deletePosCustomer(@PathVariable Long id) {
        return adCustomerService.deleteCustomer(id);
    }
}
