package com.example.demo.domain.repository;

import com.example.demo.domain.model.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID > {
    Page<Consulta> findByAtivoTrue(Pageable pageable);
}
