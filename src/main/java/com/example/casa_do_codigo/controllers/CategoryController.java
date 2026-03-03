package com.example.casa_do_codigo.controllers;

import com.example.casa_do_codigo.controllers.dto.request.CreateCategoryDto;
import com.example.casa_do_codigo.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateCategoryDto categoryDto) {
        Long createdId = service.create(categoryDto);

        return ResponseEntity.created(URI.create("/categories/" + createdId)).build();
    }

}
