package com.example.demo.controller;

import com.example.demo.domain.dto.DadosAtualizacaoPaciente;
import com.example.demo.domain.dto.DadosDetalhamentoPaciente;
import com.example.demo.domain.dto.DadosListagemPaciente;
import com.example.demo.domain.dto.PacienteDto;
import com.example.demo.domain.model.Paciente;
import com.example.demo.domain.repository.PacienteRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/v1/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid PacienteDto dados, UriComponentsBuilder uriBuilder) {

        var paciente = new Paciente(dados);
        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));

    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort ={"nome"},direction = Sort.Direction.ASC) Pageable paginacao){
        return ResponseEntity.ok(repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new));
    }

    @GetMapping("/listagem")
    public  ResponseEntity<Page<DadosListagemPaciente>> listagem(Pageable paginacao){
        return ResponseEntity.ok(repository.findAll(paginacao).map(DadosListagemPaciente::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }


}
