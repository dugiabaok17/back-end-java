package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.PositionResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.repository.AdPositionRepository;
import com.example.demo.core.admin.service.AdPositionService;
import com.example.demo.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAdPositionService implements AdPositionService {

    private final AdPositionRepository adpositionRepository;

    @Autowired
    public IAdPositionService(AdPositionRepository adpositionRepository) {
        this.adpositionRepository = adpositionRepository;
    }

    @Override
    public ResponseEntity<ResponseObject> findByStore(Long id) {
        return null;
    }

    @Override
    public List<PositionResponse> getPositionName() {
        return adpositionRepository.getPositionName();
    }

    @Override
    public ResponseEntity<ResponseObject> createStore(Store store) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> updateStore(Store store, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseObject> deleteStore(Long id) {
        return null;
    }
}
