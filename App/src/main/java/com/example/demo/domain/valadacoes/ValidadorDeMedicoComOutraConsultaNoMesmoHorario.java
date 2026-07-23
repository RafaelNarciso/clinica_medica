package com.example.demo.domain.valadacoes;

import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import com.example.demo.domain.repository.ConsultaRepository;
import com.example.demo.domain.repository.ValidadorAgendamentoDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorDeMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), LocalDateTime.of(dados.data(), dados.horario()));

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new RuntimeException("Médico já possui outra consulta agendada nesse mesmo horário");
        }

    }

}
