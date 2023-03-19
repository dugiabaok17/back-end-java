package com.example.demo.repository;

import com.example.demo.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PositionRepository extends JpaRepository<Position, Long> {

    List<Position> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "update position p set p.status = 0 where p.id = :id", nativeQuery = true)
    void updateStatus(@Param("id") Long id);
}
