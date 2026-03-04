package com.example.casa_do_codigo.controllers.dto.request;

import jakarta.validation.constraints.*;

public record CreateAuthorRequestDto(@NotBlank(message = "{field.required}")
                                     String name,
                                     @NotBlank(message = "{field.required}") @Size(min = 1, max = 400, message = "{field.minimum-max.characters}")
                                     String description,
                                     @NotBlank(message = "{field.required}") @Email(message = "{field.invalid}")
                                     String email) {
}
