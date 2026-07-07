package com.example.demo.domain.dto;

import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Telefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PacienteDto(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @Pattern(regexp = "\\d{11}") String cpf,
        @NotNull @Valid Endereco endereco,
        @NotNull Telefone telefone
) {
}
