package com.example.demo.domain.dto;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record DadosDetalhamentoConsulta(
        UUID id,
        UUID idMedico,
        UUID idPaciente,
        LocalDate data,
        LocalTime horario
) {
}
