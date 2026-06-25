package com.escola.gerenciamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.escola.gerenciamento.entities.Disciplina;
import com.escola.gerenciamento.services.DisciplinaService;
import com.escola.gerenciamento.services.ProfessorService;

@Controller
@RequestMapping("/view/disciplinas")
public class DisciplinaViewController {

    private final ProfessorService professorService;
    private final DisciplinaService disciplinaService;

    public DisciplinaViewController(
            ProfessorService professorService,
            DisciplinaService disciplinaService) {

        this.professorService = professorService;
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public String listar(Model model) {

        model.addAttribute("disciplina", new Disciplina());

        model.addAttribute(
                "professores",
                professorService.listarTodos());

        model.addAttribute(
                "disciplinas",
                disciplinaService.listarTodos());

        return "disciplinas/lista";
    }

    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute Disciplina disciplina) {

        disciplinaService.salvar(disciplina);

        return "redirect:/view/disciplinas";
    }

    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "disciplina",
                disciplinaService.buscarPorId(id));

        model.addAttribute(
                "professores",
                professorService.listarTodos());

        model.addAttribute(
                "disciplinas",
                disciplinaService.listarTodos());

        return "disciplinas/lista";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(
            @PathVariable Long id) {

        disciplinaService.deletar(id);

        return "redirect:/view/disciplinas";
    }

    @GetMapping("/pesquisar")
    public String pesquisar(
            String nome,
            Model model) {

        model.addAttribute(
                "disciplina",
                new Disciplina());

        model.addAttribute(
                "professores",
                professorService.listarTodos());

        model.addAttribute(
                "disciplinas",
                disciplinaService.listarTodos()
                        .stream()
                        .filter(d -> d.getNomeDisciplina()
                                .toLowerCase()
                                .contains(nome.toLowerCase()))
                        .toList());

        return "disciplinas/lista";
    }
}