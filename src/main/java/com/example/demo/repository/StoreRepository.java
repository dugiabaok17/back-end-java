package com.example.demo.repository;

import com.example.demo.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "update store s set s.status = 0 where s.id = :id", nativeQuery = true)
    void updateStatus(@Param("id") Long id);
}
