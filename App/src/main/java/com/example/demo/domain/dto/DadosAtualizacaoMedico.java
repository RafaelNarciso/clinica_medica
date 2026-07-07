package com.example.demo.domain.dto;

import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Telefone;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizacaoMedico(
        @NotNull  UUID id,
        String nome,
        String email,
        Telefone telefone,
        Endereco endereco
) {
}
