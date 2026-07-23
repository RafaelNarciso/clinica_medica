package com.example.demo.domain.repository;

import com.example.demo.domain.enumered.Especialidade;
import com.example.demo.domain.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
    Page<Medico> findByAtivoTrue(Pageable pageable);

    @Query("""
       select m from Medico m
       where m.ativo = true
         and m.especialidade = :especialidade
         and m.id not in (
             select c.medico.id
             from Consulta c
             where c.data = :data
         )
       order by function('rand')
       """)
    List<Medico> escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data, Pageable pageable);

    @Query("""
        select m.ativo from Medico m where m.id = :id
        """)
    Boolean findAtivoById(@Param("id") UUID id);
}
