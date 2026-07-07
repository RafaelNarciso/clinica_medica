package com.example.demo.domain.model;

import com.example.demo.domain.dto.DadosAtualizacaoMedico;
import com.example.demo.domain.dto.MedicoDto;
import com.example.demo.domain.enumered.Especialidade;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.UUID;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private boolean ativo;
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

    @Column(nullable = false,unique = true, length = 8)
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.telefone() != null){
            this.telefone.setDdd(dados.telefone().getDdd());
            this.telefone.setNumero(dados.telefone().getNumero());
        }
        if (dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }


    public Medico(MedicoDto dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.telefone = new Telefone(dados.telefone());
        this.especialidade = dados.especialidade();
    }

    public void excluir(){
        this.ativo = false;
    }

}
