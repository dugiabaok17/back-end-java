package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdColorService;
import com.example.demo.entity.Color;
import com.example.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IAdColorService implements AdColorService {

    private final ColorRepository colorRepository;

    @Autowired
    private IAdColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public List<Color> findAllColor() {
        return colorRepository.findAll().stream().filter(data -> data.getStatus() == 1).toList();
    }

    @Override
    public ResponseEntity<ResponseObject> findByColorId(Long id) {
        Optional<Color> foundColor = colorRepository.findById(id);
        return foundColor.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "found Producer with id: " + id, 0, foundColor)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("fail", "not found Producer with id: " + id, 0, foundColor)
        );
    }

    @Override
    public Long getColorName(String name) {
        return colorRepository.findColorByName(name.trim()).getId();
    }

    @Override
    public ResponseEntity<ResponseObject> createColor(Color color) {
        Color c = new Color();
        c.setName(color.getName());
        c.setDateCreated(new Date(System.currentTimeMillis()));
        c.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "insert success color", 0, colorRepository.save(c))
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateColor(Color color, Long id) {
        Optional<Color> c = colorRepository.findById(id);
        if (c.isPresent()) {
            c.get().setName(color.getName());
            c.get().setDateUpdated(new Date(System.currentTimeMillis()));
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "update successfully", 0, colorRepository.save(c.get())));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("fail", "Can not update color ", 1, ""));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteColor(Long id) {
        boolean exists = colorRepository.existsById(id);
        if (exists) {
            colorRepository.updateStatus(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete color successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find color to delete", -1, ""));
    }
}
