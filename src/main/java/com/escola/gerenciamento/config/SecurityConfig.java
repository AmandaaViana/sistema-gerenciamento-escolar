package com.escola.gerenciamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // Páginas públicas
                .requestMatchers("/login").permitAll()

                // Somente ADMINISTRADOR
                .requestMatchers("/admin/**")
                .hasRole("ADMINISTRADOR")

                // ADMINISTRADOR e GERENTE
                .requestMatchers(
                        "/gerente/**",
                        "/usuarios/**",
                        "/cadastro/**"
                )
                .hasAnyRole("ADMINISTRADOR", "GERENTE")

                // Todas as telas do sistema
                .requestMatchers(
                        "/view/**"
                )
                .hasAnyRole(
                        "ADMINISTRADOR",
                        "GERENTE",
                        "USUARIO"
                )

                .anyRequest()
                .authenticated()
            )

            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/view/alunos", true)
                    .permitAll()
            )

            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .permitAll()
            );

        return http.build();
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}