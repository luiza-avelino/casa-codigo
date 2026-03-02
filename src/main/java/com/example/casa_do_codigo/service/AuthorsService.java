package com.example.casa_do_codigo.service;

import com.example.casa_do_codigo.controllers.dto.request.CreateAuthorRequestDto;
import com.example.casa_do_codigo.entites.AuthorEntity;
import com.example.casa_do_codigo.exceptions.EmailAlreadyInUseException;
import com.example.casa_do_codigo.repository.AuthorsRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public Long create(CreateAuthorRequestDto body) throws EmailAlreadyInUseException {

        boolean emailExists = authorsRepository.existsByEmail(body.email().toLowerCase());

        if(emailExists) {
            throw new EmailAlreadyInUseException("Email já sendo usado por outro usuário.");
        }

        AuthorEntity author = new AuthorEntity();
        author.setName(body.name());
        author.setDescription(body.description());
        author.setEmail(body.email());

        return authorsRepository.save(author).getId();
    }
}
