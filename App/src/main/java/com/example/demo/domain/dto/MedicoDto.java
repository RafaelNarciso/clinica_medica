package com.example.demo.domain.dto;

import com.example.demo.domain.enumered.Especialidade;
import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Telefone;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record MedicoDto(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,

        @NotBlank (message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,


        @NotBlank(message = "{crm.obrigatorio}")
        @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}")
        String crm,

        @NotNull(message = "{especialidade.obrigatoria}")
        Especialidade especialidade,

        @NotBlank(message = "{telefone.obrigatorio}")
        @NotNull Telefone telefone,

        @NotNull(message = "{endereco.obrigatorio}")
        @Valid Endereco endereco
) {
}
