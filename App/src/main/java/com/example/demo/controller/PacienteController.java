package com.example.demo.controller;

import com.example.demo.dto.DadosAtualizacaoPaciente;
import com.example.demo.dto.DadosListagemPaciente;
import com.example.demo.dto.PacienteDto;
import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Paciente> cadastrar(@RequestBody @Valid PacienteDto dados) {
        var paciente = repository.save(new Paciente(dados));
        return ResponseEntity.ok(paciente);
    }


    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(size = 10, sort ={"nome"},direction = Sort.Direction.ASC) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }
    @GetMapping("/listagem")
    public Page <DadosListagemPaciente> listagem(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable UUID id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }

}
