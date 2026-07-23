package com.example.demo.domain.valadacoes;

import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import com.example.demo.domain.dto.DadosCancelamentoConsulta;
import com.example.demo.domain.repository.ConsultaRepository;
import com.example.demo.domain.repository.ValidadorAgendamentoDeConsulta;
import com.example.demo.domain.repository.ValidadorCancelamentoDeConsulta;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidadorDeHorarioAntecedencia implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());

        var agora = LocalDateTime.now();

        var diferencaMinutos = Duration.between(agora, consulta.getData()).toMinutes();

        if (diferencaMinutos < 30) {
            throw new RuntimeException("Consulta deve ser agendada com antecedência mínima de 30 horas");
        }
    }


}
