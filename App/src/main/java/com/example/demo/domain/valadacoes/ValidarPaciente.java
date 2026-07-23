package com.example.demo.domain.valadacoes;

import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import com.example.demo.domain.repository.PacienteRepository;
import com.example.demo.domain.repository.ValidadorAgendamentoDeConsulta;
import com.example.demo.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPaciente implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        if (dados.idPaciente() == null){
            return;
        }
        var PacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());

        if (!PacienteEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído/inativo");
        }

    }
}
