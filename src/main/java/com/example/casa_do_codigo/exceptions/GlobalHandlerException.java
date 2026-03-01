package com.example.casa_do_codigo.exceptions;

import com.example.casa_do_codigo.controllers.dto.response.FieldErrorDto;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ProblemDetail handleInvalidBody(MethodArgumentNotValidException e) {
        var pd = ProblemDetail.forStatus(400);
        pd.setTitle("Parametros inválidos");

        List<FieldErrorDto> errors = e.getFieldErrors()
                .stream().map(error -> new FieldErrorDto(error.getField(), error.getDefaultMessage())).toList();
        pd.setProperty("invalid-params", errors);

        return pd;
    }

    @ExceptionHandler(EmailAlreadyInUseException.class)
    public ProblemDetail emailInUseException(EmailAlreadyInUseException e) {
        var pd = ProblemDetail.forStatus(422);
        pd.setTitle("Email em uso");
        pd.setDetail(e.getMessage());

        return pd;
    }
}
