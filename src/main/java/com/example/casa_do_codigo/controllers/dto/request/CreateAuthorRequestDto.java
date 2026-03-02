package com.example.casa_do_codigo.controllers.dto.request;

import jakarta.validation.constraints.*;

public record CreateAuthorRequestDto(@NotBlank(message = REQUIRED) String name,
                                     @NotBlank(message = REQUIRED)
                                     @Size(min = 1, max = 400, message = DESCRIPTION_LENGTH) String description,
                                     @NotBlank(message = REQUIRED) @Email(message = INVALID) String email) {

    private final static String REQUIRED = "é obrigatório";
    private final static String DESCRIPTION_LENGTH = "deve ter entre 1 e 400 caracteres";
    private final static String INVALID = "inválido";
}
