package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.request.ProductDetailsRequest;
import com.example.demo.core.admin.model.response.ProductDetailsResponse;
import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.repository.AdProductDetailsRepository;
import com.example.demo.core.admin.service.*;
import com.example.demo.entity.Producer;
import com.example.demo.entity.ProductDetails;
import com.example.demo.repository.ProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IAdProductDetailService implements AdProductDetailService {

    private final ProductDetailsRepository productDetailsRepository;
    private final AdProductDetailsRepository adProductDetailsRepository;
    private final AdColorService adColorService;
    private final AdCategoryService adCategoryService;
    private final AdProductService adProductService;
    private final AdProducerService adProducerService;

    @Autowired
    public IAdProductDetailService(
            ProductDetailsRepository productDetailsRepository,
            AdProductDetailsRepository adProductDetailsRepository,
            AdColorService adColorService,
            AdCategoryService adCategoryService,
            AdProductService adProductService,
            AdProducerService adProducerService
    ) {
        this.productDetailsRepository = productDetailsRepository;
        this.adProductDetailsRepository = adProductDetailsRepository;
        this.adColorService = adColorService;
        this.adCategoryService = adCategoryService;
        this.adProductService = adProductService;
        this.adProducerService = adProducerService;
    }

    @Override
    public List<ProductDetailsResponse> findAllProductDetail() {
        return adProductDetailsRepository.findAllProductDetailsResponse();
    }

    public List<ProductDetails> findAllProduct() {
        return productDetailsRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> findByProductDetail(Long id) {
        Optional<ProductDetails> foundProduct = productDetailsRepository.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "found product details with id: " + id, 0, foundProduct.get()))
                :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("fail", "not found product details with id: " + id, -1, "")
                );
    }

    @Override
    public ResponseEntity<ResponseObject> createProductDetail(ProductDetailsRequest productDetailsRequest) {
        ProductDetails p = new ProductDetails();
        p.setDateCreated(new Date(System.currentTimeMillis()));
        p.setDescription(productDetailsRequest.getDescription());
        p.setImportPrices(productDetailsRequest.getImportPrices());
        p.setPrice(productDetailsRequest.getPrice());
        p.setQuantityInStock(productDetailsRequest.getQuantityInStock());
        p.setWarrantyYear(productDetailsRequest.getWarrantyYear());
        p.setStatus(1);
        p.setProductId(adProductService.getProductName(productDetailsRequest.getProductName()));
        p.setCategoryId(adCategoryService.getCategoryName(productDetailsRequest.getCategoryName()));
        p.setProducerId(adProducerService.getProducerName(productDetailsRequest.getProducerName()));
        p.setColorId(adColorService.getColorName(productDetailsRequest.getColorName()));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "insert success product", 0, productDetailsRepository.save(p))
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateProductDetail(ProductDetailsRequest productDetailsRequest, Long id) {
        Optional<ProductDetails> p = productDetailsRepository.findById(id);
        if (p.isPresent()) {
            p.get().setDateUpdated(new Date(System.currentTimeMillis()));
            p.get().setDescription(productDetailsRequest.getDescription());
            p.get().setImportPrices(productDetailsRequest.getImportPrices());
            p.get().setPrice(productDetailsRequest.getPrice());
            p.get().setQuantityInStock(productDetailsRequest.getQuantityInStock());
            p.get().setWarrantyYear(productDetailsRequest.getWarrantyYear());
            p.get().setProductId(adProductService.getProductName(productDetailsRequest.getProductName()));
            p.get().setCategoryId(adCategoryService.getCategoryName(productDetailsRequest.getCategoryName()));
            p.get().setProducerId(adProducerService.getProducerName(productDetailsRequest.getProducerName()));
            p.get().setColorId(adColorService.getColorName(productDetailsRequest.getColorName()));
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "update successfully", 0, productDetailsRepository.save(p.get())));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("fail", "Can not update producer ", 1, ""));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteProductDetail(Long id) {
        boolean exists = productDetailsRepository.existsById(id);
        if (exists) {
            productDetailsRepository.updateStatus(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete product details successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find product details to delete", -1, ""));

    }
}
