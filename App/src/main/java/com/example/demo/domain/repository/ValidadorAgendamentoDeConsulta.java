package com.example.demo.domain.repository;

import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import jakarta.validation.ValidationException;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados)
            throws ValidationException;
}
