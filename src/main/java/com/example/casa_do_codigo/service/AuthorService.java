package com.example.casa_do_codigo.service;

import com.example.casa_do_codigo.controllers.dto.request.CreateAuthorRequestDto;
import com.example.casa_do_codigo.entites.AuthorEntity;
import com.example.casa_do_codigo.exceptions.FieldAlreadyInUseException;
import com.example.casa_do_codigo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorsRepository;

    public AuthorService(AuthorRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Long create(CreateAuthorRequestDto body) throws FieldAlreadyInUseException {

        boolean emailExists = authorsRepository.existsByEmail(body.email().toLowerCase());

        if(emailExists) {
            throw new FieldAlreadyInUseException("Email já sendo usado por outro usuário.");
        }

        AuthorEntity author = new AuthorEntity();
        author.setName(body.name());
        author.setDescription(body.description());
        author.setEmail(body.email().toLowerCase());

        return authorsRepository.save(author).getId();
    }
}
