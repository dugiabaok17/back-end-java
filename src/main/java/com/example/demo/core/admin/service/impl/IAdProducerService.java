package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdProducerService;
import com.example.demo.entity.Producer;
import com.example.demo.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IAdProducerService implements AdProducerService {

    private final ProducerRepository producerRepository;

    @Autowired
    public IAdProducerService(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }


    @Override
    public List<Producer> findAllProducer() {
        return producerRepository.findAll().stream().filter(data -> data.getStatus() == 1).toList();
    }

    @Override
    public ResponseEntity<ResponseObject> findByProducerId(Long id) {
        Optional<Producer> foundProducer = producerRepository.findById(id);
        return foundProducer.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "found Producer with id: " + id, 0, foundProducer)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("fail", "not found Producer with id: " + id, 0, foundProducer)
        );
    }

    @Override
    public Long getProducerName(String name) {
        return producerRepository.findProducerByName(name).getId();
    }

    @Override
    public ResponseEntity<ResponseObject> createProducer(Producer producer) {
        Producer p = new Producer();
        p.setName(producer.getName());
        p.setDateCreated(new Date(System.currentTimeMillis()));
        p.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "insert success product", 0, producerRepository.save(p))
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateProducer(Producer producer, Long id) {
        Optional<Producer> p = producerRepository.findById(id);
        if (p.isPresent()) {
            p.get().setName(producer.getName());
            p.get().setDateUpdated(new Date(System.currentTimeMillis()));
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "update successfully", 0, producerRepository.save(p.get())));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("fail", "Can not update producer ", 1, ""));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteProducer(Long id) {
        boolean exists = producerRepository.existsById(id);
        if (exists) {
            producerRepository.updateStatus(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete producer successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find producer to delete", -1, ""));
    }
}
