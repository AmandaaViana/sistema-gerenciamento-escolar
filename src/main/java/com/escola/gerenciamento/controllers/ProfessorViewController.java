package com.escola.gerenciamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.escola.gerenciamento.entities.Professor;
import com.escola.gerenciamento.services.ProfessorService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/view/professores")
@RequiredArgsConstructor
public class ProfessorViewController {

    private final ProfessorService service;

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("professor", new Professor());
        model.addAttribute("professores", service.listarTodos());

        return "professores/lista4";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Professor professor) {

        service.salvar(professor);

        return "redirect:/view/professores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id,
                         Model model) {

        model.addAttribute("professor",
                service.buscarPorId(id));

        model.addAttribute("professores",
                service.listarTodos());

        return "professores/lista4";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        service.excluir(id);

        return "redirect:/view/professores";
    }

    @GetMapping("/pesquisar")
    public String pesquisar(
            @RequestParam(required = false) String nome,
            Model model) {

        if (nome != null && !nome.isBlank()) {

            model.addAttribute(
                    "professores",
                    service.buscarPorNome(nome)
            );

        } else {

            model.addAttribute(
                    "professores",
                    service.listarTodos()
            );
        }

        model.addAttribute("professor", new Professor());

        return "professores/lista4";
    }
}