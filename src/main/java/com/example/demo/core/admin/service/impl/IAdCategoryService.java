package com.example.demo.core.admin.service.impl;

import com.example.demo.core.admin.model.response.ResponseObject;
import com.example.demo.core.admin.service.AdCategoryService;
import com.example.demo.core.admin.service.AdColorService;
import com.example.demo.entity.Category;
import com.example.demo.entity.Color;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IAdCategoryService implements AdCategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    private IAdCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll().stream().filter(data -> data.getStatus() == 1).toList();
    }

    @Override
    public ResponseEntity<ResponseObject> findByCategoryId(Long id) {
        Optional<Category> foundCategory = categoryRepository.findById(id);
        return foundCategory.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "found Category with id: " + id, 0, foundCategory)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("fail", "not found Category with id: " + id, 0, foundCategory)
        );
    }

    @Override
    public Long getCategoryName(String name) {
        return categoryRepository.findCategoryByName(name).getId();
    }

    @Override
    public ResponseEntity<ResponseObject> createCategory(Category category) {
        Category c = new Category();
        c.setName(category.getName());
        c.setDateCreated(new Date(System.currentTimeMillis()));
        c.setStatus(1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "insert success Category", 0, categoryRepository.save(c))
        );
    }

    @Override
    public ResponseEntity<ResponseObject> updateCategory(Category category, Long id) {
        Optional<Category> c = categoryRepository.findById(id);
        if (c.isPresent()) {
            c.get().setName(category.getName());
            c.get().setDateUpdated(new Date(System.currentTimeMillis()));
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "update successfully", 0, categoryRepository.save(c.get())));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("fail", "Can not update category ", 1, ""));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteCategory(Long id) {
        boolean exists = categoryRepository.existsById(id);
        if (exists) {
            categoryRepository.updateStatus(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete category successfully", 0, "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "Cannot find category to delete", -1, ""));
    }
}
