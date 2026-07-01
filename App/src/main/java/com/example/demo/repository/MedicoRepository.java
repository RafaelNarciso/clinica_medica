package com.example.demo.repository;

import com.example.demo.dto.MedicoDto;
import com.example.demo.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
    Page<Medico> findByAtivoTrue(Pageable pageable);
}
