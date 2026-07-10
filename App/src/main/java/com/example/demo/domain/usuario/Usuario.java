package com.example.demo.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String login;
    private String senha;
}
