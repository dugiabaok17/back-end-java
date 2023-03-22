package com.example.demo.core.admin.controller;


import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdCategoryService;
import com.example.demo.core.admin.service.AdColorService;
import com.example.demo.entity.Category;
import com.example.demo.entity.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    private final AdCategoryService adCategoryService;

    @Autowired
    public CategoryController(AdCategoryService adCategoryService) {
        this.adCategoryService = adCategoryService;
    }

    @GetMapping
    private List<Category> findAllCategory() {
        return adCategoryService.findAllCategory();
    }


    @GetMapping("/name")
    private List<String> getCategoryName() {
        return adCategoryService.findAllCategory().stream().filter(data -> data.getStatus() == 1).
                map(name -> name.getName()).toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> findByCategoryId(@PathVariable Long id) {
        return adCategoryService.findByCategoryId(id);
    }

    @PostMapping
    private ResponseEntity<ResponseObject> createColor(@RequestBody Category category) {
        return adCategoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseObject> updateProduct(@PathVariable Long id, @RequestBody Category category) {
        return adCategoryService.updateCategory(category, id);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseObject> deletePosCategory(@PathVariable Long id) {
        return adCategoryService.deleteCategory(id);
    }
}
