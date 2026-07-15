package com.example.demo.domain.model;

import com.example.demo.domain.enumered.MotivoCancelamento;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name ="Consulta")
@Table(name = "consultas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;

    public void cancelar(MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }
}
