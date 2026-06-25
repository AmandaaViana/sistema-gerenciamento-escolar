package com.escola.gerenciamento.services;



import com.escola.gerenciamento.entities.Turma;
import com.escola.gerenciamento.repositories.TurmaRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TurmaService {

    private final TurmaRepository repository;

    public List<Turma> listarTodos() {

        return repository.findAll();
    }

  public List<Turma> listarTodosTurmass() {

        return repository.findAll();
    }



    public Turma buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Turma não encontrada"));
    }

    public Turma salvar(Turma turma) {

        return repository.save(turma);
    }

    public Turma atualizar(Long id, Turma turma) {

        Turma turmaBanco = buscarPorId(id);

        turmaBanco.setNomeTurma(turma.getNomeTurma());
        turmaBanco.setPeriodo(turma.getPeriodo());
        turmaBanco.setSala(turma.getSala());
        turmaBanco.setAno(turma.getAno());

        return repository.save(turmaBanco);
    }

    public void deletar(Long id) {

        repository.deleteById(id);
    }

}
    

