package com.example.casa_do_codigo.service;

import com.example.casa_do_codigo.controllers.dto.request.CreateAuthorRequestDto;
import com.example.casa_do_codigo.entites.AuthorsEntity;
import com.example.casa_do_codigo.exceptions.EmailAlreadyInUseException;
import com.example.casa_do_codigo.repository.AuthorsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public AuthorsEntity create(CreateAuthorRequestDto body) throws EmailAlreadyInUseException {

        Optional<AuthorsEntity> emailExists = authorsRepository.findByEmail(body.email());

        if(emailExists.isPresent()) {
            throw new EmailAlreadyInUseException("Email já sendo usado por outro usuário.");
        }

        AuthorsEntity author = new AuthorsEntity();
        author.setName(body.name());
        author.setDescription(body.description());
        author.setEmail(body.email());
        author.setCreatedAt(LocalDateTime.now());

        return authorsRepository.save(author);
    }
}
