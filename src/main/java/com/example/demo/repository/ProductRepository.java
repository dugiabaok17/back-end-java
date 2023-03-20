package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query(value = "update product p set p.status = 0 where p.id = :id", nativeQuery = true)
    void updateStatus(@Param("id") Long id);

    Product findProductByName(String name);
}
