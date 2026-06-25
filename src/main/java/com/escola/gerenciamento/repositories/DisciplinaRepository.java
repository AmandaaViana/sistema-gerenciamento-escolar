package com.escola.gerenciamento.repositories;

import com.escola.gerenciamento.entities.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository
        extends JpaRepository<Disciplina, Long> {

    List<Disciplina> findByNomeDisciplinaContainingIgnoreCase(String nome);

}