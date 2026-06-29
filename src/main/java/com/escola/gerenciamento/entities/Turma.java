package com.escola.gerenciamento.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "turma", fetch = FetchType.LAZY) 
    private List<Aluno> alunos;

}
