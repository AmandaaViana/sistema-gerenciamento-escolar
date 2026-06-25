package com.escola.gerenciamento.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.escola.gerenciamento.entities.Usuario;
import com.escola.gerenciamento.enums.Role;
import com.escola.gerenciamento.repositories.UsuarioRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(
            UsuarioRepository repository,
            PasswordEncoder encoder) {

        return args -> {

            if (repository.findByUsername("admin").isEmpty()) {

                Usuario admin = new Usuario();

                admin.setUsername("admin");
                admin.setPassword(encoder.encode("123456"));
                admin.setRole(Role.ADMINISTRADOR);

                repository.save(admin);
                
                System.out.println("INICIOU DATALOADER");
                System.out.println("USUARIO SALVO");
            }

        };
    }
}