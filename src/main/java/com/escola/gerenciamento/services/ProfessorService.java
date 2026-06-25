package com.escola.gerenciamento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.escola.gerenciamento.entities.Professor;
import com.escola.gerenciamento.repositories.ProfessorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;

    public List<Professor> listarTodos() {
        return repository.findAll();
    }

    public Professor buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Professor não encontrado"));
    }

    public Professor salvar(Professor professor) {
        return repository.save(professor);
    }

    public Professor atualizar(Long id, Professor professor) {

        Professor professorBanco = buscarPorId(id);

        professorBanco.setNome(professor.getNome());
        professorBanco.setEmail(professor.getEmail());
        professorBanco.setTelefone(professor.getTelefone());
        professorBanco.setEspecialidade(professor.getEspecialidade());

        return repository.save(professorBanco);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<Professor> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }
}