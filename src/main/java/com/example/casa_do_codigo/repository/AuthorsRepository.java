package com.example.casa_do_codigo.repository;

import com.example.casa_do_codigo.entites.AuthorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorsRepository extends JpaRepository<AuthorsEntity, Long> {
    Optional<AuthorsEntity> findByEmail(String email);
}
