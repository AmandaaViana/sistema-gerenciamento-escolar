package com.escola.gerenciamento.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "turmas")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;

    @Column(nullable = false, length = 50)
    private String nomeTurma;

    @Column(nullable = false, length = 20)
    private String periodo;

    @Column(length = 20)
    private String sala;

    @Column(length = 10)
    private String ano;

    // causa mutiplicação dados /alunos
    // colocado pra teste
    // @OneToMany(mappedBy = "turma")
    // private List<Aluno> alunos;

}
