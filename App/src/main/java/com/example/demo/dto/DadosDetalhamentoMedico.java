package com.example.demo.dto;

import com.example.demo.enumered.Especialidade;
import com.example.demo.model.Endereco;
import com.example.demo.model.Medico;
import com.example.demo.model.Telefone;

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
