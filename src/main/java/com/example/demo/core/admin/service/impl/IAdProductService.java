package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.model.response.StoreResponse;
import com.example.demo.core.admin.service.AdProductService;
import com.example.demo.entity.Product;
import com.example.demo.entity.Store;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IAdProductService implements AdProductService {

    private final ProductRepository productRepository;

    @Autowired
    public IAdProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll().stream().filter(data -> data.getStatus() == 1).toList();
    }

    @Override
    public ResponseEntity<ResponseObject> findByProductId(Long id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "found product with id: " + id, 0, foundProduct.get()))
                :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "not found product with id: " + id, -1, "")
                );
    }

    @Override
    public List<String> getProductName() {
        return productRepository.findAll().stream().filter(data -> data.getStatus() == 1).map(Product::getName).toList();
    }

    @Override
    public ResponseEntity<ResponseObject> createProduct(Product product) {
        Product p = new Product();
        p.setName(product.getName());
        p.setDateCreated(new Date(System.currentTimeMillis()));
        p.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "insert success product", 0, productRepository.save(p))
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateProduct(Product product, Long id) {
        Optional<Product> p = productRepository.findById(id);
        if (p.isPresent()) {
            p.get().setName(product.getName());
            p.get().setDateUpdated(new Date(System.currentTimeMillis()));
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "update successfully", 0, productRepository.save(p.get())));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("fail", "Can not update product ", 1, ""));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteProduct(Long id) {
        boolean exists = productRepository.existsById(id);
        if (exists) {
            productRepository.updateStatus(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete product successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find product to delete", -1, ""));
    }
}

