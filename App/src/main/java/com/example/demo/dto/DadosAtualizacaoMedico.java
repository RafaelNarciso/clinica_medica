package com.example.demo.dto;

import com.example.demo.model.Endereco;
import com.example.demo.model.Telefone;
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
