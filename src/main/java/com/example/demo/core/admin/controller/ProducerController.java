package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdProducerService;
import com.example.demo.core.admin.service.AdProductService;
import com.example.demo.entity.Producer;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/producer")
public class ProducerController {

    private AdProducerService adProducerService;

    @Autowired
    public ProducerController(AdProducerService adProducerService) {
        this.adProducerService = adProducerService;
    }

    @GetMapping
    private List<Producer> findAllProducer() {
        return adProducerService.findAllProducer();
    }


    @GetMapping("/name")
    private List<String> getProducerName() {
        return adProducerService.getProducerName();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findByProducerId(@PathVariable Long id) {
        return adProducerService.findByProducerId(id);
    }

    @PostMapping
    private ResponseEntity<ResponseObject> createProducer(@RequestBody Producer producer) {
        return adProducerService.createProducer(producer);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseObject> updateProducer(@PathVariable Long id, @RequestBody Producer producer) {
        return adProducerService.updateProducer(producer, id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseObject> deletePosProducer(@PathVariable Long id) {
        return adProducerService.deleteProducer(id);
    }
}
