package com.example.casa_do_codigo.repository;

import com.example.casa_do_codigo.entites.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);
    Optional<CategoryEntity> findByName(String name);
}
