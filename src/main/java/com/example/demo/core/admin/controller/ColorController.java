package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdColorService;
import com.example.demo.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/color")
public class ColorController {

    private final AdColorService adColorService;

    @Autowired
    public ColorController(AdColorService adColorService) {
        this.adColorService = adColorService;
    }

    @GetMapping
    private List<Color> findAllColor() {
        return adColorService.findAllColor();
    }


//    @GetMapping("/name/{name}")
//    private Color getColorName(@PathVariable String name) {
//        return adColorService.getColorName(name);
//    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findByColorId(@PathVariable Long id) {
        return adColorService.findByColorId(id);
    }

    @PostMapping
    private ResponseEntity<ResponseObject> createColor(@RequestBody Color color) {
        return adColorService.createColor(color);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseObject> updateProduct(@PathVariable Long id, @RequestBody Color color) {
        return adColorService.updateColor(color, id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseObject> deletePosColor(@PathVariable Long id) {
        return adColorService.deleteColor(id);
    }
}
