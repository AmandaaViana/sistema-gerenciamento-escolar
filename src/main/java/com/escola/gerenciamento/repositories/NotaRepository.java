package com.escola.gerenciamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.gerenciamento.entities.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}