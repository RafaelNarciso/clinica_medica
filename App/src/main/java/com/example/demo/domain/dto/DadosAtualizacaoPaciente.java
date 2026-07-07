package com.example.demo.domain.dto;

import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Telefone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record DadosAtualizacaoPaciente(
        @NotNull UUID id,

        @NotBlank(message = "{nome.obrigatorio}")
        String nome,

        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,

        @NotBlank(message = "{cpf.obrigatorio}")
        @Pattern (regexp = "\\d{11}") String cpf,

        @NotNull(message = "{endereco.obrigatorio}")
        Endereco endereco,

        @NotNull(message = "{telefone.obrigatorio}")
        Telefone telefone
) {
}
