package com.example.demo.dto;

import com.example.demo.enumered.Especialidade;
import com.example.demo.model.Endereco;
import com.example.demo.model.Telefone;
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
