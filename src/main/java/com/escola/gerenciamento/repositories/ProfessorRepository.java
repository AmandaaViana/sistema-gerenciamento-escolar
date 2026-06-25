package com.escola.gerenciamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escola.gerenciamento.entities.Professor;

@Repository
public interface ProfessorRepository
        extends JpaRepository<Professor, Long> {

    Professor findByNome(String nome);

    List<Professor> findByNomeContainingIgnoreCase(String nome);

    boolean existsByEmail(String email);

    Professor findByEmail(String email);

    List<Professor> findByEspecialidadeContainingIgnoreCase(
            String especialidade);
}