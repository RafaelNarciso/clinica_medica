package com.example.demo.controller;

import com.example.demo.domain.dto.DadosAtualizacaoMedico;
import com.example.demo.domain.dto.DadosDetalhamentoMedico;
import com.example.demo.domain.dto.DadosListagemMedico;
import com.example.demo.domain.dto.MedicoDto;
import com.example.demo.domain.model.Medico;
import com.example.demo.domain.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 3, sort = {"crm"}) Pageable paginacao) {
        return repository.findByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable UUID id){
        var medico = repository.findById(id).get();
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping("/listagem")
    public ResponseEntity<Page<DadosListagemMedico>> listagem(Pageable paginacao) {
        return ResponseEntity.ok(repository.findAll(paginacao).map(DadosListagemMedico::new));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid MedicoDto dados, UriComponentsBuilder uriBuilder) {

        var medico = new Medico(dados);
         repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }


}
