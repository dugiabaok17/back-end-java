package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.response.PositionResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdPositionService;
import com.example.demo.entity.Position;
import com.example.demo.entity.Store;
import com.example.demo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/position")
public class PositionController {

    private final AdPositionService adPositionService;

    @Autowired
    public PositionController(AdPositionService adPositionService) {
        this.adPositionService = adPositionService;
    }

    @GetMapping
    public List<Position> findAllPosition() {
        return  adPositionService.findAllPosition();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findByPositionId(@PathVariable Long id) {
        return adPositionService.findByPositionId(id);
    }

    @GetMapping("/name")
    private List<PositionResponse> getStoreName() {
        adPositionService.getPositionName().forEach(data -> System.out.println(data));
        return adPositionService.getPositionName();
    }

    @PostMapping
    private ResponseEntity<ResponseObject> createStore(@RequestBody Position position) {
        return adPositionService.createPosition(position);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseObject> updatePosition(@PathVariable Long id,@RequestBody Position position) {
        return adPositionService.updatePosition(position,id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseObject> deletePosition(@PathVariable Long id) {
        return adPositionService.deletePosition(id);
    }


}
