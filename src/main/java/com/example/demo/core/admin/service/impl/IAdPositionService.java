package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.PositionResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.repository.AdPositionRepository;
import com.example.demo.core.admin.service.AdPositionService;
import com.example.demo.entity.Position;
import com.example.demo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IAdPositionService implements AdPositionService {

    private final AdPositionRepository adpositionRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public IAdPositionService(AdPositionRepository adpositionRepository,PositionRepository positionRepository) {
        this.adpositionRepository = adpositionRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public ResponseEntity<ResponseObject> findByPositionId(Long id) {
        Optional<Position> foundPosition = positionRepository.findById(id);
        return foundPosition.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query store successfully",0, foundPosition)
                ) :   ResponseEntity.status(HttpStatus.NOT_FOUND).
                body(new ResponseObject("false", "Cannot find staff with id = " + id, -1, ""));
    }

    @Override
    public List<PositionResponse> getPositionName() {
        return adpositionRepository.getPositionName();
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> createPosition(Position position) {
        Position p = new Position();
        p.setName(position.getName());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert successfully",0,positionRepository.save(p))
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updatePosition(Position position, Long id) {
        Optional<Position> p = positionRepository.findById(id);
         if(p.isPresent()) {
            p.get().setName(position.getName());
             return ResponseEntity.status(HttpStatus.OK).body(
                     new ResponseObject("ok", "update successfully",0,positionRepository.save(p.get())));
         }
         return ResponseEntity.status(HttpStatus.OK).body(
                 new ResponseObject("fail", "Can not update position",1, ""));

    }

    @Override
    public ResponseEntity<ResponseObject> deletePosition(Long id) {
        boolean exists = positionRepository.existsById(id);
        if (exists) {
            positionRepository.updateStatus(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete position successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find position to delete", -1, ""));
    }

}
