package com.example.casa_do_codigo.service;

import com.example.casa_do_codigo.controllers.dto.request.CreateCategoryDto;
import com.example.casa_do_codigo.entites.CategoryEntity;
import com.example.casa_do_codigo.exceptions.FieldAlreadyInUseException;
import com.example.casa_do_codigo.repository.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Long create(@Valid CreateCategoryDto categoryDto) {
        boolean categoryExists = repository.existsByName(categoryDto.name());

        if(categoryExists) {
            throw new FieldAlreadyInUseException("Category already exists.");
        }

        var entity = new CategoryEntity();
        entity.setName(categoryDto.name());

        return repository.save(entity).getId();
    }
}
