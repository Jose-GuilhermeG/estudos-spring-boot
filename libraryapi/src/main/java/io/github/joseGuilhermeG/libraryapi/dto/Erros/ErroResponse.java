package io.github.joseGuilhermeG.libraryapi.dto.Erros;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResponse(int Status, String message, List<FieldErro> erros) {

    public static ErroResponse defaultReponse(String message){
        return new ErroResponse(HttpStatus.BAD_REQUEST.value(), message , List.of());
    }

    public static ErroResponse conflit(String message){
        return new ErroResponse(HttpStatus.CONFLICT.value(), message , List.of());
    }

}
