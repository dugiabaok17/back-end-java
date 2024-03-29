package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StoreResponse;
import com.example.demo.entity.Store;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdStoreService {
    List<Store> findAllStore();

    ResponseEntity<ResponseObject> findByStore(Long id);

    List<StoreResponse> getStoreName();

    ResponseEntity<ResponseObject> createStore(Store store);

    ResponseEntity<ResponseObject> updateStore(Store store,Long id);

    ResponseEntity<ResponseObject> deleteStore(Long id);
}
