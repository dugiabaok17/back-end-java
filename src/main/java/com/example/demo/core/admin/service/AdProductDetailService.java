package com.example.demo.core.admin.service;


import com.example.demo.core.admin.model.request.ProductDetailsRequest;
import com.example.demo.core.admin.model.request.StaffRequest;
import com.example.demo.core.admin.model.response.ProductDetailsResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StaffResponse;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdProductDetailService {
    List<ProductDetailsResponse> findAllProductDetail();

    List<ProductDetails> findAllProduct();

    ResponseEntity<ResponseObject> findByProductDetail(Long id);

    ResponseEntity<ResponseObject> createProductDetail(ProductDetailsRequest productDetailsRequest);

    ResponseEntity<ResponseObject> updateProductDetail(ProductDetailsRequest productDetailsRequest,Long id);

    ResponseEntity<ResponseObject> deleteProductDetail(Long id);
}
