package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdProductService;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    private final AdProductService adProductService;

    @Autowired
    public ProductController(AdProductService adProductService) {
        this.adProductService = adProductService;
    }

    @GetMapping
    private List<Product> findAllProduct() {
        return adProductService.findAllProduct();
    }


    @GetMapping("/name")
    private List<String> getProductName() {
        return adProductService.findAllProduct().stream().filter(data -> data.getStatus() == 1).
                map(name -> name.getName()).toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findByProductId(@PathVariable Long id) {
        return adProductService.findByProductId(id);
    }

    @PostMapping
    private ResponseEntity<ResponseObject> createProduct(@RequestBody Product product) {
        return adProductService.createProduct(product);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseObject> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return adProductService.updateProduct(product, id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseObject> deletePosProduct(@PathVariable Long id) {
        return adProductService.deleteProduct(id);
    }
}
