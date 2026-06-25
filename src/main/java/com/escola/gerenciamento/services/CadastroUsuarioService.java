package com.escola.gerenciamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.escola.gerenciamento.entities.Usuario;
import com.escola.gerenciamento.enums.Role;
import com.escola.gerenciamento.repositories.UsuarioRepository;

@Service
public class CadastroUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrar(Usuario usuario) {

        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new RuntimeException("Usuário já cadastrado!");
        }

        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword())
        );

        if (usuario.getRole() == null) {
            usuario.setRole(Role.USUARIO);
        }

        return usuarioRepository.save(usuario);
    }
}