package com.example.demo.controller;


import com.example.demo.domain.dto.DadosAgendamentoConsulta;
import com.example.demo.domain.dto.DadosCancelamentoConsulta;
import com.example.demo.domain.dto.DadosDetalhamentoConsulta;
import com.example.demo.domain.service.AgendaDeConsultas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private  AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        return ResponseEntity.ok().body(new DadosDetalhamentoConsulta(null,null,null,null,null));
    }


    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
