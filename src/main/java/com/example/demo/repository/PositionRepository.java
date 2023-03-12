package com.example.demo.repository;

import com.example.demo.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PositionRepository extends JpaRepository<Position, Long> {

    List<Position> findByName(String name);
}
