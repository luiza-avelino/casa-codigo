package com.example.casa_do_codigo.repository;

import com.example.casa_do_codigo.entites.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<AuthorEntity, Long> {
    boolean existsByEmail(String email);
}
