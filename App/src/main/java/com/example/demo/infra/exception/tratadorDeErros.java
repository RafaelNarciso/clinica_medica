package com.example.demo.infra.exception;

import com.example.demo.infra.menssage.DadosErroValidacao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class tratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(Exception ex) {
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new).toList());

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity tratarErroBanco(DataIntegrityViolationException ex) {
        return ResponseEntity.badRequest()
                .body("Erro de integridade dos dados");
    }

}
