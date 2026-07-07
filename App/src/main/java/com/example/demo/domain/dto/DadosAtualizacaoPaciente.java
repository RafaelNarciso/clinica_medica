package com.example.demo.domain.dto;

import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Telefone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record DadosAtualizacaoPaciente(
        @NotNull UUID id,
        String nome,
        @Email  String email,
        @Pattern (regexp = "\\d{11}") String cpf,
        Endereco endereco,
        Telefone telefone
) {
}
