package com.example.casa_do_codigo.controllers.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateBookDto(@NotBlank(message = REQUIRED) String isbn,
                            @NotBlank(message = REQUIRED) String title,
                            @NotNull(message = REQUIRED) @Min(value = 20, message = MINIMUN_PRICE) BigDecimal price,
                            @NotNull(message = REQUIRED) @Min(value = 100, message = MINIMUN_NUMBER_OF_PAGES)
                            @JsonProperty("number_of_pages") Integer numberOfPages,
                            @NotBlank(message = REQUIRED) @Size(max = 500, message = MINIMUN_SUMMARY)  String summary,
                            @JsonProperty("table_of_contents") String tableOfContents,
                            @JsonProperty("release_date") @NotNull(message = REQUIRED)
                            @FutureOrPresent(message = RELEASE_DATE) LocalDateTime releaseDate,
                            @NotBlank(message = REQUIRED) String category,
                            @JsonProperty("author_id") @NotNull(message = REQUIRED) Long authorId) {
    private final static String REQUIRED = "é obrigatório";
    private final static String MINIMUN_PRICE = "deve custar no minimo 20";
    private final static String MINIMUN_NUMBER_OF_PAGES = "deve ter no minimo 100";
    private final static String MINIMUN_SUMMARY = "deve ter no minimo 500 caracteres";
    private final static String RELEASE_DATE = "must be in the present or future";
}
