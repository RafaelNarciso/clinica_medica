package com.example.demo.domain.repository;

import com.example.demo.domain.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    Page<Paciente> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select p.ativo from Paciente p
            where p.id = :id
        """)
    boolean findAtivoById(@Param("id") UUID id);


}
