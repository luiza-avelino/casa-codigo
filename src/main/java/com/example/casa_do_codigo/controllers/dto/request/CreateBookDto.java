package com.example.casa_do_codigo.controllers.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateBookDto(@NotBlank(message = "{field.required}")
                            String isbn,
                            @NotBlank(message = "{field.required}")
                            String title,
                            @NotNull(message = "{field.required}") @Min(value = 20, message = "{field.minimum.value}")
                            BigDecimal price,
                            @NotNull(message = "{field.required}") @Min(value = 100, message = "{field.minimum.value}") @JsonProperty("number_of_pages")
                            Integer numberOfPages,
                            @NotBlank(message = "{field.required}") @Size(max = 500, message = "{field.max.characters}")
                            String summary,
                            @JsonProperty("table_of_contents")
                            String tableOfContents,
                            @JsonProperty("release_date") @NotNull(message = "{field.required}") @FutureOrPresent(message = "{field.presentOrFuture}")
                            LocalDateTime releaseDate,
                            @NotBlank(message = "{field.required}")
                            String category,
                            @JsonProperty("author_id") @NotNull(message = "{field.required}")
                            Long authorId) {
}
