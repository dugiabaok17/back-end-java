package com.example.demo.repository;

import com.example.demo.entity.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
}
