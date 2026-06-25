package com.escola.gerenciamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.escola.gerenciamento.entities.Turma;
import com.escola.gerenciamento.services.TurmaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/view/turmas")
@RequiredArgsConstructor
public class TurmaViewController {

    private final TurmaService service;

    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "turmas",
                service.listarTodos()
        );

        return "turmas/lista4";
    }

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute(
                "turma",
                new Turma()
        );

        return "turmas/formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Turma turma) {

        service.salvar(turma);

        return "redirect:/view/turmas";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "turma",
                service.buscarPorId(id)
        );

        return "turmas/formulario";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {

        service.deletar(id);

        return "redirect:/view/turmas";
    }
} 
    

