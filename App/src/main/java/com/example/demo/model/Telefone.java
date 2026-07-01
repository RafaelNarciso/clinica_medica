package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "Telefone")
@Table(name = "telefones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String ddd;
    private String numero;

    public Telefone(Telefone dados) {
        this.ddd = dados.getDdd();
        this.numero = dados.getNumero();
    }
}
