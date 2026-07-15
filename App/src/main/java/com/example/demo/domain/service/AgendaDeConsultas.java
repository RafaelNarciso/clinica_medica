package com.example.demo.domain.service;

import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import com.example.demo.domain.dto.DadosCancelamentoConsulta;
import com.example.demo.domain.enumered.Especialidade;
import com.example.demo.domain.model.Consulta;
import com.example.demo.domain.model.Medico;
import com.example.demo.domain.repository.ConsultaRepository;
import com.example.demo.domain.repository.MedicoRepository;
import com.example.demo.domain.repository.PacienteRepository;
import com.example.demo.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente não existe");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do médico não existe");
        }

        var medico = escolherMedico(dados);

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());

        var dataConsulta = LocalDateTime.of(dados.data(), dados.horario());

        var consulta = new Consulta(null, medico, paciente, dataConsulta,null);

        repository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido");
        }

        var medicos = medicoRepository.escolherMedicoAleatorioLivreNaData(
                dados.especialidade(), LocalDateTime.of(dados.data(), dados.horario()), PageRequest.of(0, 1)
        );

        if (medicos.isEmpty()) {
            throw new ValidacaoException("Não existe médico disponível nessa data");
        }

        return medicos.get(0);
    }

    public void cancelar(DadosCancelamentoConsulta dados) {
        if (!repository.existsById(dados.idConsulta())) {
            throw new ValidacaoException("Id da consulta informado não existe!");
        }

        var consulta = repository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }

}
