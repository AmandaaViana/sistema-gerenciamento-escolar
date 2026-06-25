package com.escola.gerenciamento.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;

    // Podem ficar nulas até o lançamento das notas
    private Double nota1;

    private Double nota2;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false)
    private Disciplina disciplina;

    public Double getMedia() {

        if (nota1 == null || nota2 == null) {
            return null;
        }

        return (nota1 + nota2) / 2;
    }

    public String getSituacao() {

        Double media = getMedia();

        if (media == null) {
            return "PENDENTE";
        }

        return media >= 6.0
                ? "APROVADO"
                : "REPROVADO";
    }
}