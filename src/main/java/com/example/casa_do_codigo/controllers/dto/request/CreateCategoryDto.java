package com.example.casa_do_codigo.controllers.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryDto(@NotBlank(message = REQUIRED) String name) {
    private static final String REQUIRED = "é obrigatório";
}
