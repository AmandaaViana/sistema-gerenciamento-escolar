package com.escola.gerenciamento.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "disciplinas")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisciplina;

    @Column(nullable = false, length = 100)
    private String nomeDisciplina;

    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(
            name = "id_professor",
            nullable = false
    )
    private Professor professor;

    @OneToMany(mappedBy = "disciplina")
    private List<Nota> notas;

}
