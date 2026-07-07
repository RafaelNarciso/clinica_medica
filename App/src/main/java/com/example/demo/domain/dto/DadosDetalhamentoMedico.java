package com.example.demo.domain.dto;

import com.example.demo.domain.enumered.Especialidade;
import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Medico;
import com.example.demo.domain.model.Telefone;

import java.util.UUID;

public record DadosDetalhamentoMedico(
        UUID id,
        String nome,
        String crm,
        String email,
        Especialidade especialidade,
        Telefone telefone,
        Endereco endereco
) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEmail(), medico.getEspecialidade(), medico.getTelefone(), medico.getEndereco());
    }
}
