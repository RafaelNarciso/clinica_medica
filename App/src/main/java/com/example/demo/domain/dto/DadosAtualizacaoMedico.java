package com.example.demo.domain.dto;

import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Telefone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DadosAtualizacaoMedico(
        @NotNull  UUID id,

        @NotBlank(message = "{nome.obrigatorio}") String nome,

        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,

        @NotNull(message = "{telefone.obrigatorio}") Telefone telefone,

        @NotNull(message = "{endereco.obrigatorio}") Endereco endereco
) {
}
