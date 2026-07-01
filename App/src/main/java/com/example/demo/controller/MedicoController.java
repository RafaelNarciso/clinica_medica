package com.example.demo.controller;

import com.example.demo.dto.DadosAtualizacaoMedico;
import com.example.demo.dto.DadosListagemMedico;
import com.example.demo.dto.MedicoDto;
import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/listagem")
    public ResponseEntity<Page<DadosListagemMedico>> listagem(Pageable paginacao) {
        return ResponseEntity.ok(repository.findAll(paginacao).map(DadosListagemMedico::new));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Medico> cadastrar(@RequestBody @Valid MedicoDto dados) {
        System.out.println("================Entrou no post ========================");
        var medico = repository.save(new Medico(dados));
        System.out.println("===== SALVOU O MÉDICO =====");
        return ResponseEntity.ok(medico);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable UUID id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }


}
