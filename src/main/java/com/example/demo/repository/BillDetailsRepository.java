package com.example.demo.repository;

import com.example.demo.entity.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDetailsRepository extends JpaRepository<BillDetails, Long> {
}
