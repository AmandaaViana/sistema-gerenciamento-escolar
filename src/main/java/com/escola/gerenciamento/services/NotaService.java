package com.escola.gerenciamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escola.gerenciamento.entities.Nota;
import com.escola.gerenciamento.repositories.NotaRepository;

@Service
public class NotaService {

    @Autowired
    private NotaRepository repository;

    public List<Nota> listarTodos() {
        return repository.findAll();
    }

    public Nota salvar(Nota nota) {
        return repository.save(nota);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Nota buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota não encontrada"));
    }
}