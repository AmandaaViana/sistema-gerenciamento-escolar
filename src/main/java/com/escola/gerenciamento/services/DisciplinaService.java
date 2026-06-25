package com.escola.gerenciamento.services;


import com.escola.gerenciamento.entities.Disciplina;
import com.escola.gerenciamento.repositories.DisciplinaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DisciplinaService {

    private final DisciplinaRepository repository;

    public List<Disciplina> listarTodos() {

        return repository.findAll();
    }

    public Disciplina buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Disciplina não encontrada"));
    }

    public Disciplina salvar(Disciplina disciplina) {

        return repository.save(disciplina);
    }

    public Disciplina atualizar(Long id,
                                Disciplina disciplina) {

        Disciplina disciplinaBanco = buscarPorId(id);

        disciplinaBanco.setNomeDisciplina(
                disciplina.getNomeDisciplina());

        disciplinaBanco.setCargaHoraria(
                disciplina.getCargaHoraria());

        disciplinaBanco.setProfessor(
                disciplina.getProfessor());

        return repository.save(disciplinaBanco);
    }

    public void deletar(Long id) {

        repository.deleteById(id);
    }

}