package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.response.PositionResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.entity.Position;
import com.example.demo.entity.Store;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdPositionService {

    ResponseEntity<ResponseObject> findByPositionId(Long id);

    List<PositionResponse> getPositionName();

    List<Position> findAllPosition();

    ResponseEntity<ResponseObject> createPosition(Position position);

    ResponseEntity<ResponseObject> updatePosition(Position position,Long id);

    ResponseEntity<ResponseObject> deletePosition(Long id);
}
