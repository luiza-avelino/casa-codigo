package com.example.casa_do_codigo.repository;

import com.example.casa_do_codigo.entites.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    boolean existsByIsbn(String isbn);
    boolean existsByTitle(String title);
}
