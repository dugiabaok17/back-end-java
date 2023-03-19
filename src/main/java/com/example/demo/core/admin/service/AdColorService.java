package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.entity.Color;
import com.example.demo.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdColorService {
    List<Color> findAllColor();

    ResponseEntity<ResponseObject> findByColorId(Long id);

    List<String> getColorName();

    ResponseEntity<ResponseObject> createColor(Color color);

    ResponseEntity<ResponseObject> updateColor(Color color,Long id);

    ResponseEntity<ResponseObject> deleteColor(Long id);
}
