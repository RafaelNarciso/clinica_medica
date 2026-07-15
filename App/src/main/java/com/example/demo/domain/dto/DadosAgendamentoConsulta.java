package com.example.demo.domain.dto;

import com.example.demo.domain.enumered.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record DadosAgendamentoConsulta(
        UUID idMedico,
        @NotNull UUID idPaciente,
        @NotNull @Future LocalDate data,
        @NotNull LocalTime horario,
        Especialidade especialidade
        ) {
}
