package com.example.demo.core.admin.repository;

import com.example.demo.core.admin.model.response.StoreResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdStoreRepository extends JpaRepository<StoreResponse,Long> {

    @Query(value = "select s.id, s.name store_name from store s where s.status = 1",nativeQuery = true)
    List<StoreResponse> getStoreName();
}
