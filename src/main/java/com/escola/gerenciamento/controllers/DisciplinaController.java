package com.escola.gerenciamento.controllers;

import com.escola.gerenciamento.entities.Disciplina;
import com.escola.gerenciamento.services.DisciplinaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@RequiredArgsConstructor

public class DisciplinaController {

    private final DisciplinaService service;

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Disciplina> salvar(
            @RequestBody Disciplina disciplina
    ) {

        return ResponseEntity.ok(
                service.salvar(disciplina)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(
            @PathVariable Long id,
            @RequestBody Disciplina disciplina
    ) {

        return ResponseEntity.ok(
                service.atualizar(id, disciplina)
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