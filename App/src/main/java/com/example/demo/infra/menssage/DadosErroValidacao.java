package com.example.demo.infra.menssage;

import org.springframework.validation.FieldError;

public record DadosErroValidacao(
        String campo,
        String menssagem

) {

    public DadosErroValidacao(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }

}
