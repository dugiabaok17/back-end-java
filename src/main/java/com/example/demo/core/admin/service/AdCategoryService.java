package com.example.demo.core.admin.service;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.entity.Category;
import com.example.demo.entity.Color;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdCategoryService {
    List<Category> findAllCategory();

    ResponseEntity<ResponseObject> findByCategoryId(Long id);

    Long getCategoryName(String name);

    ResponseEntity<ResponseObject> createCategory(Category category);

    ResponseEntity<ResponseObject> updateCategory(Category category,Long id);

    ResponseEntity<ResponseObject> deleteCategory(Long id);
}
