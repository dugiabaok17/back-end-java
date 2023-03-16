package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.response.PositionResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.entity.Store;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdPositionService {

    ResponseEntity<ResponseObject> findByStore(Long id);

    List<PositionResponse> getPositionName();

    ResponseEntity<ResponseObject> createStore(Store store);

    ResponseEntity<ResponseObject> updateStore(Store store,Long id);

    ResponseEntity<ResponseObject> deleteStore(Long id);
}
