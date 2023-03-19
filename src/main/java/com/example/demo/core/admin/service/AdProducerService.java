package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.entity.Producer;
import com.example.demo.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdProducerService {
    List<Producer> findAllProducer();

    ResponseEntity<ResponseObject> findByProducerId(Long id);

    List<String> getProducerName();

    ResponseEntity<ResponseObject> createProducer(Producer producer);

    ResponseEntity<ResponseObject> updateProducer(Producer producer,Long id);

    ResponseEntity<ResponseObject> deleteProducer(Long id);
}
