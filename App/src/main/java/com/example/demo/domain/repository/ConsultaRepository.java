package com.example.demo.domain.repository;

import com.example.demo.domain.model.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {

    Page<Consulta> findByMotivoCancelamentoIsNull(Pageable pageable);

    boolean existsByMedicoIdAndData(UUID id, LocalDateTime data);

    boolean existsByPacienteIdAndDataBetween(UUID idPaciente, LocalDateTime inicio, LocalDateTime fim);
}
