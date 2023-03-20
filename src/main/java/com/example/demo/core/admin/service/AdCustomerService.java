package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StoreResponse;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Store;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdCustomerService {
    List<Customer> findAllCustomer();

    ResponseEntity<ResponseObject> findByCustomer(Long id);

    ResponseEntity<ResponseObject> createCustomer(Customer customer);

    ResponseEntity<ResponseObject> updateCustomer(Customer customer,Long id);

    ResponseEntity<ResponseObject> deleteCustomer(Long id);
}
