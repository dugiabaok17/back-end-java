package com.example.demo.core.admin.controller;

import com.example.demo.core.admin.model.request.ProductDetailsRequest;
import com.example.demo.core.admin.model.response.ProductDetailsResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdProductDetailService;
import com.example.demo.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/product-details")
public class ProductDetailsController {

    private final AdProductDetailService adProductDetailService;

    @Autowired
    public ProductDetailsController(AdProductDetailService adProductDetailService) {
        this.adProductDetailService = adProductDetailService;
    }

    @GetMapping
    public List<ProductDetailsResponse> getAllProductDetails() {
        return adProductDetailService.findAllProductDetail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        return adProductDetailService.findByProductDetail(id);
    }
//
////     create employee rest api
    @PostMapping
    public ResponseEntity<ResponseObject>  createProductDetail(@RequestBody ProductDetailsRequest productDetailsRequest) {
        return adProductDetailService.createProductDetail(productDetailsRequest);
    }
//
    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateProductDetail(@RequestBody ProductDetailsRequest productDetailsRequest,@PathVariable Long id) {
        return adProductDetailService.updateProductDetail(productDetailsRequest,id);
    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteProductDetail(@PathVariable Long id) {
        System.out.println("check id"+id);
        return adProductDetailService.deleteProductDetail(id);
    }
}
