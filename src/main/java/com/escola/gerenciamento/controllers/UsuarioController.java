package com.escola.gerenciamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.escola.gerenciamento.entities.Usuario;
import com.escola.gerenciamento.services.CadastroUsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private CadastroUsuarioService service;

    @GetMapping("/cadastro")
    public String formCadastro(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String salvar(
            @ModelAttribute Usuario usuario,
            Model model) {

        try {

            service.cadastrar(usuario);

            model.addAttribute(
                    "sucesso",
                    "Usuário cadastrado com sucesso!"
            );

            model.addAttribute(
                    "usuario",
                    new Usuario()
            );

            return "cadastro";

        } catch (RuntimeException e) {

            model.addAttribute(
                    "erro",
                    e.getMessage()
            );

            model.addAttribute(
                    "usuario",
                    usuario
            );

            return "cadastro";
        }
    }
}