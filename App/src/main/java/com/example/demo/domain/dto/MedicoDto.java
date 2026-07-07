package com.example.demo.domain.dto;

import com.example.demo.domain.enumered.Especialidade;
import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Telefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record MedicoDto(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotEmpty @Pattern(regexp = "\\d{4,6}") String crm,
        @NotNull Especialidade especialidade,
        @NotNull Telefone telefone,
        @NotNull @Valid Endereco endereco
) {
}
