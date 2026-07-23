package com.example.demo.domain.valadacoes;

import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import com.example.demo.domain.repository.MedicoRepository;
import com.example.demo.domain.repository.ValidadorAgendamentoDeConsulta;
import com.example.demo.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.idMedico() == null){
            return;
        }
        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído/inativo");
        }
    }

}

