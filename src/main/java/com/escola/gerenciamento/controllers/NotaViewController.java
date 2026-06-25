package com.escola.gerenciamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.escola.gerenciamento.entities.Aluno;
import com.escola.gerenciamento.entities.Disciplina;
import com.escola.gerenciamento.entities.Nota;
import com.escola.gerenciamento.repositories.AlunoRepository;
import com.escola.gerenciamento.repositories.DisciplinaRepository;
import com.escola.gerenciamento.services.NotaService;

@Controller
@RequestMapping("/view/notas")
public class NotaViewController {


@Autowired
private NotaService service;

@Autowired
private AlunoRepository alunoRepository;

@Autowired
private DisciplinaRepository disciplinaRepository;

// LISTAR
@GetMapping
public String listar(Model model) {

    Nota nota = new Nota();

    nota.setAluno(new Aluno());
    nota.setDisciplina(new Disciplina());

    model.addAttribute("nota", nota);
    model.addAttribute("notas", service.listarTodos());
    model.addAttribute("alunos", alunoRepository.findAll());
    model.addAttribute("disciplinas", disciplinaRepository.findAll());

    return "notas/lista";
}

// SALVAR E ATUALIZAR
@PostMapping("/salvar")
public String salvar(@ModelAttribute Nota nota) {

    service.salvar(nota);

    return "redirect:/view/notas";
}

// EDITAR
@GetMapping("/editar/{id}")
public String editar(@PathVariable Long id,
                     Model model) {

    Nota nota = service.buscarPorId(id);

    if (nota.getAluno() == null) {
        nota.setAluno(new Aluno());
    }

    if (nota.getDisciplina() == null) {
        nota.setDisciplina(new Disciplina());
    }

    model.addAttribute("nota", nota);
    model.addAttribute("notas", service.listarTodos());
    model.addAttribute("alunos", alunoRepository.findAll());
    model.addAttribute("disciplinas", disciplinaRepository.findAll());

    return "notas/lista";
}

// EXCLUIR
@GetMapping("/deletar/{id}")
public String deletar(@PathVariable Long id) {

    service.deletar(id);

    return "redirect:/view/notas";
}


}
