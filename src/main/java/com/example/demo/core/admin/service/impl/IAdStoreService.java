package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StoreResponse;
import com.example.demo.core.admin.repository.AdStoreRepository;
import com.example.demo.core.admin.service.AdStoreService;
import com.example.demo.entity.Store;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Optional<Store> foundStore = storeRepository.findById(id);
        return foundStore.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query store successfully",0, foundStore)
                ) :   ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(new ResponseObject("false", "Cannot find store with id = " + id, -1, ""));
    }

    @Override
    public List<StoreResponse> getStoreName() {
        return adStoreRepository.getStoreName();
    }

    @Override
    public ResponseEntity<ResponseObject> createStore(@RequestBody Store store) {
        Store s = new Store();
        s.setAddress(store.getAddress());
        s.setDateCreated(new Date(System.currentTimeMillis()));
        s.setCity(store.getCity());
        s.setName(store.getName());
        s.setNation(store.getNation());
        return ResponseEntity.status(200).body(
                new ResponseObject("ok","insert success",0, storeRepository.save(s))
        );

    }

    @Override
    public ResponseEntity<ResponseObject> updateStore(Store store, Long id) {
        Optional<Store> s = storeRepository.findById(id);
        if(s.isPresent()) {
            s.get().setName(store.getName());
            s.get().setDateUpdated(new Date(System.currentTimeMillis()));
            s.get().setAddress(store.getAddress());
            s.get().setNation(store.getNation());
            s.get().setCity(store.getCity());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "update successfully",0,storeRepository.save(s.get())));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("fail", "Can not update store",1, ""));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteStore(Long id) {
        boolean exists = storeRepository.existsById(id);
        if (exists) {
            storeRepository.updateStatus(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete store successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find store to delete", -1, ""));
    }

}
