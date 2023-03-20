package com.example.demo.repository;

import com.example.demo.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ProducerRepository extends JpaRepository<Producer, Long> {

    @Modifying
    @Transactional
    @Query(value = "update producer p set p.status = 0 where p.id = :id", nativeQuery = true)
    void updateStatus(@Param("id") Long id);

    Producer findProducerByName(String name);
}
