package com.example.demo.domain.dto;

import com.example.demo.domain.enumered.Especialidade;
import com.example.demo.domain.model.Medico;

import java.util.UUID;

public record DadosListagemMedico(
        UUID id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {
    public DadosListagemMedico(Medico  medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }


}
