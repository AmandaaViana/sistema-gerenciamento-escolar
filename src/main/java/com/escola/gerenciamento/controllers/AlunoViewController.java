package com.escola.gerenciamento.controllers;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.escola.gerenciamento.entities.Aluno;
import com.escola.gerenciamento.services.AlunoService;
import com.escola.gerenciamento.services.TurmaService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/view/alunos")
@RequiredArgsConstructor
public class AlunoViewController {

    private final AlunoService service;
    private final TurmaService turmaService;

    // ==========================================
    // LISTAR COM PAGINAÇÃO (5 REGISTROS)
    // ==========================================

    @GetMapping
    public String listar(
            @RequestParam(defaultValue = "0") int pagina,
            Model model) {

        Page<Aluno> paginaAlunos =
                service.listarPaginado(pagina);

        model.addAttribute(
                "paginaAlunos",
                paginaAlunos);

        return "alunos/lista7";
    }

    // ==========================================
    // NOVO ALUNO
    // ==========================================

    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute(
                "aluno",
                new Aluno());

        model.addAttribute(
                "turmas",
                turmaService.listarTodos());

        return "alunos/formulario2";
    }

    // ==========================================
    // SALVAR
    // ==========================================

    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute Aluno aluno) {

        service.salvar(aluno);

        return "redirect:/view/alunos";
    }

    // ==========================================
    // EDITAR
    // ==========================================

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "aluno",
                service.buscarPorId(id));

        model.addAttribute(
                "turmas",
                turmaService.listarTodos());

        return "alunos/formulario2";
    }

    // ==========================================
    // EXCLUIR
    // ==========================================

    @GetMapping("/deletar/{id}")
    public String deletar(
            @PathVariable Long id) {

        service.deletar(id);

        return "redirect:/view/alunos";
    }

} 
    

