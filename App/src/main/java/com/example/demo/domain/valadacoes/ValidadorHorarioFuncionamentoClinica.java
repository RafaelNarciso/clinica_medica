package com.example.demo.domain.valadacoes;

import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import com.example.demo.domain.repository.ValidadorAgendamentoDeConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = LocalDateTime.of(dados.data(), dados.horario());
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);

        var antesDaAberturaDaClinica = dados.horario().getHour() < 7;
        var depoisDoFechamentoDaClinica = dados.horario().getHour() > 18;

        if(domingo && antesDaAberturaDaClinica || depoisDoFechamentoDaClinica){
            throw new RuntimeException("Consulta não pode ser agendada fora do horário de funcionamento da clínica");
        }
    }

}
