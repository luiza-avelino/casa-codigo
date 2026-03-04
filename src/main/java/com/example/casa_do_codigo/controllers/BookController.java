package com.example.casa_do_codigo.controllers;

import com.example.casa_do_codigo.controllers.dto.request.CreateBookDto;
import com.example.casa_do_codigo.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateBookDto body) {
        Long createdBookId = bookService.create(body);

        return ResponseEntity.created(URI.create("/books/" + createdBookId)).build();
    }
}
