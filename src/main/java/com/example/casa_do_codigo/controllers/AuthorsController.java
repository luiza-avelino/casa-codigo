package com.example.casa_do_codigo.controllers;

import com.example.casa_do_codigo.controllers.dto.request.CreateAuthorRequestDto;
import com.example.casa_do_codigo.service.AuthorsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorsService service;

    public AuthorsController(AuthorsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody @Valid CreateAuthorRequestDto body) {
        Long authorId = service.create(body);

        return ResponseEntity.created(URI.create("/authors/" + authorId)).build();
    }
}
