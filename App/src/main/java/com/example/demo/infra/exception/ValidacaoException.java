package com.example.demo.infra.exception;

public class ValidacaoException extends RuntimeException{

    public ValidacaoException(String mensagem) {
        super(mensagem);
    }

}
