package com.example.demo.model;

import com.example.demo.dto.DadosAtualizacaoPaciente;
import com.example.demo.dto.PacienteDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="pacientes")
public class Paciente {

    private boolean ativo;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telefone_id")
    private Telefone telefone;

    @Column(nullable = false, updatable = true)
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Paciente(PacienteDto dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = new Telefone(dados.telefone());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.email() != null) {
            this.email = dados.email();
        }

        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }

        if (dados.telefone() != null) {
            if (this.telefone == null) {
                this.telefone = new Telefone();
            }
            this.telefone.setDdd(dados.telefone().getDdd());
            this.telefone.setNumero(dados.telefone().getNumero());
        }

        if (dados.endereco() != null) {
            if (this.endereco == null) {
                this.endereco = new Endereco();
            }
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
