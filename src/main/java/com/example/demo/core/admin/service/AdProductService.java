package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdProductService {
    List<Product> findAllProduct();

    ResponseEntity<ResponseObject> findByProductId(Long id);

    Long getProductName(String name);

    ResponseEntity<ResponseObject> createProduct(Product product);

    ResponseEntity<ResponseObject> updateProduct(Product product,Long id);

    ResponseEntity<ResponseObject> deleteProduct(Long id);
}
