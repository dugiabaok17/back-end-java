package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.request.StaffRequest;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StaffResponse;
import com.example.demo.entity.Store;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdStoreService {
    List<Store> findAllStore();

    ResponseEntity<ResponseObject> findByStore(Long id);

    ResponseEntity<ResponseObject> createStore(Store store);

    ResponseEntity<ResponseObject> updateStore(Store store,Long id);

    ResponseEntity<ResponseObject> deleteStore(Long id);
}
