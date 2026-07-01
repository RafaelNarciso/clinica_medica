package com.example.demo.dto;

import com.example.demo.model.Endereco;
import com.example.demo.model.Telefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public record PacienteDto(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @Pattern(regexp = "\\d{11}") String cpf,
        @NotNull @Valid Endereco endereco,
        @NotNull Telefone telefone
) {
}
