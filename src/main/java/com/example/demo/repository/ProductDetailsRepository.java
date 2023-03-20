package com.example.demo.repository;

import com.example.demo.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

    @Modifying
    @Transactional
    @Query(value = "update product_details p set p.status = 0 where p.id = :id", nativeQuery = true)
    void updateStatus(@Param("id") Long id);
}
