package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StoreResponse;
import com.example.demo.core.admin.repository.AdStoreRepository;
import com.example.demo.core.admin.service.AdStoreService;
import com.example.demo.entity.Staff;
import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class IAdStoreService implements AdStoreService {

    private final StoreRepository storeRepository;
    private final AdStoreRepository adStoreRepository;


    @Autowired
    public IAdStoreService(StoreRepository storeRepository,AdStoreRepository adStoreRepository) {
        this.storeRepository = storeRepository;
        this.adStoreRepository = adStoreRepository;
    }

    @Override
    public List<Store> findAllStore() {
        return storeRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> findByStore(Long id) {
        return null;
    }

    @Override
    public List<StoreResponse> getStoreName() {
        return adStoreRepository.getStoreName();
    }

    @Override
    public ResponseEntity<ResponseObject> createStore(@RequestBody Store store) {
        Store s = new Store();
        s.setAddress(store.getAddress());
        s.setCity(store.getCity());
        s.setName(store.getName());
        s.setNation(store.getNation());
        return ResponseEntity.status(200).body(
                new ResponseObject("ok","insert success",0, storeRepository.save(s))
        );

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
