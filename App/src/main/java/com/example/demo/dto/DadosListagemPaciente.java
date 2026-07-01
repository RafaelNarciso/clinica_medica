package com.example.demo.dto;

import com.example.demo.model.Paciente;

import java.util.UUID;

public record DadosListagemPaciente(
        UUID id,
        String nome,
        String email,
        String cpf

) {
    public DadosListagemPaciente(Paciente dados) {
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getCpf());
    }
}
