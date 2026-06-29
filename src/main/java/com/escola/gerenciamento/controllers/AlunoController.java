package com.escola.gerenciamento.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.gerenciamento.entities.Aluno;
import com.escola.gerenciamento.services.AlunoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor

public class AlunoController {

    private final AlunoService service;

    // ==========================================
    // LISTAR TODOS
    // ==========================================
    
    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {

        return ResponseEntity.ok(
                service.listarTodos()
        );
    }

    // ==========================================
    // BUSCAR POR ID
    // ==========================================

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    // ==========================================
    // BUSCAR POR NOME
    // ==========================================

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarPorNome(
            @PathVariable String nome
    ) {

        return ResponseEntity.ok(
                service.buscarPorNome(nome)
        );
    }

    // ==========================================
    // SALVAR
    // ==========================================

    @PostMapping
    public ResponseEntity<Aluno> salvar(
            @RequestBody Aluno aluno
    ) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(aluno));
    }

    // ==========================================
    // ATUALIZAR
    // ==========================================

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(
            @PathVariable Long id,
            @RequestBody Aluno aluno
    ) {

        return ResponseEntity.ok(
                service.atualizar(id, aluno)
        );
    }

    // ==========================================
    // DELETAR
    // ==========================================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id
    ) {

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }

}