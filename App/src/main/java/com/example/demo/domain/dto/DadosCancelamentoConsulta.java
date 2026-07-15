package com.example.demo.domain.dto;

import com.example.demo.domain.enumered.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosCancelamentoConsulta(

        @NotNull
        UUID idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
}