package com.example.demo.core.admin.repository;

import com.example.demo.core.admin.model.response.PositionResponse;
import com.example.demo.core.admin.model.response.StoreResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdPositionRepository extends JpaRepository<PositionResponse,Long> {
    @Query(value = "select p.id, p.name  from position p ",nativeQuery = true)
    List<PositionResponse> getPositionName();
}
