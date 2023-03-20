package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Modifying
    @Transactional
    @Query(value = "update customer c set c.status = 0 where c.id = :id", nativeQuery = true)
    void updateStatus(@Param("id") Long id);
}
