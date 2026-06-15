package io.github.joseGuilhermeG.libraryapi.controllers;

import io.github.joseGuilhermeG.libraryapi.dto.Erros.ErroResponse;
import io.github.joseGuilhermeG.libraryapi.dto.Erros.FieldErro;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroResponse handlerMMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> fieldErros = e.getFieldErrors();
        List<FieldErro> erros =fieldErros.stream().map(fe->new FieldErro(fe.getField() , fe.getDefaultMessage())).collect(Collectors.toList());
        return new ErroResponse(HttpStatus.UNPROCESSABLE_CONTENT.value(),null , erros);

    }

}
