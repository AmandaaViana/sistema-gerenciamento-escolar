package com.escola.gerenciamento.controllers;

import com.escola.gerenciamento.entities.Turma;
import com.escola.gerenciamento.services.TurmaService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@RequiredArgsConstructor

public class TurmaController {

    private final TurmaService service;

    @GetMapping
    public ResponseEntity<List<Turma>> listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    @PostMapping
    public ResponseEntity<Turma> salvar(
            @RequestBody Turma turma
    ) {

        return ResponseEntity.ok(
                service.salvar(turma)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizar(
            @PathVariable Long id,
            @RequestBody Turma turma
    ) {

        return ResponseEntity.ok(
                service.atualizar(id, turma)
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