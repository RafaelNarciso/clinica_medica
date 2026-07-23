package com.example.demo.domain.valadacoes;

import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import com.example.demo.domain.repository.ConsultaRepository;
import com.example.demo.domain.repository.ValidadorAgendamentoDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar (DadosAgendamentoConsulta dados){
        var primeiroHorario = LocalDateTime.of(dados.data(), LocalTime.of(7,0));
        var ultimoHorario = LocalDateTime.of(dados.data(), LocalTime.of(18,0));
        var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idMedico(), primeiroHorario, ultimoHorario);
    }
}