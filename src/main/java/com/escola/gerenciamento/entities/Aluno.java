package com.escola.gerenciamento.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alunos")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    @Column(nullable = false, length = 100)
    private String nome;

    private LocalDate dataNascimento;

    @Column(length = 14)
    private String cpf;

    @Column(length = 20)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(length = 200)
    private String endereco;

    /*
     * Muitos alunos podem pertencer a uma turma.
     * O aluno pode existir sem turma.
     */
    @ManyToOne(fetch = FetchType.EAGER)
   // @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma", nullable = true)
    private Turma turma;



}
