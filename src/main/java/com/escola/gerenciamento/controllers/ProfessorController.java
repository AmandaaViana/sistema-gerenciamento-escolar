package com.escola.gerenciamento.controllers;

import com.escola.gerenciamento.entities.Professor;
import com.escola.gerenciamento.services.ProfessorService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
@RequiredArgsConstructor

public class ProfessorController {

    private final ProfessorService service;

    @GetMapping
    public ResponseEntity<List<Professor>> listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Professor> salvar(
            @RequestBody Professor professor
    ) {

        return ResponseEntity.ok(
                service.salvar(professor)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(
            @PathVariable Long id,
            @RequestBody Professor professor
    ) {

        return ResponseEntity.ok(
                service.atualizar(id, professor)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id
    ) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}