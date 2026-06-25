package com.escola.gerenciamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escola.gerenciamento.entities.Nota;
import com.escola.gerenciamento.services.NotaService;

@RestController
@RequestMapping("/notas")
@CrossOrigin("*")
public class NotaController {

    @Autowired
    private NotaService service;

    // Listar todas as notas
    @GetMapping
    public List<Nota> listar() {
        return service.listarTodos();
    }

    // Buscar nota por ID
    @GetMapping("/{id}")
    public Nota buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Salvar nova nota
    @PostMapping("/salvar")
    public Nota salvar(@RequestBody Nota nota) {
        return service.salvar(nota);
    }


    
    // Atualizar nota existente
    @PutMapping("/{id}")
    public Nota atualizar(@PathVariable Long id,
                          @RequestBody Nota nota) {

        Nota notaExistente = service.buscarPorId(id);

        notaExistente.setNota1(nota.getNota1());
        notaExistente.setNota2(nota.getNota2());
        notaExistente.setAluno(nota.getAluno());
        notaExistente.setDisciplina(nota.getDisciplina());

        return service.salvar(notaExistente);
    }

    // Excluir nota
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {

        service.deletar(id);

        return "Nota removida com sucesso!";
    }

}