package com.escola.gerenciamento.repositories;

import com.escola.gerenciamento.entities.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository
        extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNomeContainingIgnoreCase(String nome);

    boolean existsByCpf(String cpf);

    Optional<Aluno> findByCpf(String cpf);



    

}