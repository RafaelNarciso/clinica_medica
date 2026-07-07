package com.example.demo.domain.dto;

import com.example.demo.domain.model.Endereco;
import com.example.demo.domain.model.Paciente;
import com.example.demo.domain.model.Telefone;

import java.util.UUID;

public class DadosDetalhamentoPaciente {
    public DadosDetalhamentoPaciente(
            UUID id,
            String nome,
            String email,
            String cpf,
            Endereco endereco,
            Telefone telefone) {
    }
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco(), paciente.getTelefone());

    }
}
