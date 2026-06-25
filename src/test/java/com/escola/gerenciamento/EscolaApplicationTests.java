package com.escola.gerenciamento;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.escola.gerenciamento.entities.Aluno;
import com.escola.gerenciamento.entities.Disciplina;
import com.escola.gerenciamento.entities.Professor;
import com.escola.gerenciamento.entities.Turma;
import com.escola.gerenciamento.repositories.AlunoRepository;
import com.escola.gerenciamento.repositories.ProfessorRepository;
import com.escola.gerenciamento.repositories.TurmaRepository;
import com.escola.gerenciamento.repositories.DisciplinaRepository;

@SpringBootTest
class EscolaApplicationTests {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Test
    void deveCadastrarTudo() {

        // ======================
        // TURMAS
        // ======================

        Turma turma1 = turmaRepository.save(Turma.builder()
                .nomeTurma("1º Ano A Teste")
                .periodo("Matutino")
                .sala("101")
                .ano("2026")
                .build());

        Turma turma2 = turmaRepository.save(Turma.builder()
                .nomeTurma("2º Ano B Teste")
                .periodo("Vespertino")
                .sala("102")
                .ano("2026")
                .build());

        Turma turma3 = turmaRepository.save(Turma.builder()
                .nomeTurma("3º Ano C Teste")
                .periodo("Noturno")
                .sala("201")
                .ano("2026")
                .build());

        // ======================
        // ALUNOS (15)
        // ======================

        for (int i = 1; i <= 15; i++) {

            Turma turma = (i <= 5) ? turma1 : (i <= 10 ? turma2 : turma3);

            alunoRepository.save(Aluno.builder()
                    .nome("Aluno " + i)
                    .cpf("111111111" + i)
                    .telefone("(44)99999-00" + i)
                    .email("aluno" + i + "@escola.com")
                    .endereco("Rua " + i)
                    .dataNascimento(LocalDate.of(2005, 1, 1).plusDays(i))
                    .turma(turma)
                    .build());
        }

        // ======================
        // PROFESSORES
        // ======================

        List<Professor> professores = new ArrayList<>();

        professores.add(professorRepository.save(Professor.builder()
                .nome("Carlos Silva")
                .email("carlos@escola.com")
                .telefone("99999-0001")
                .especialidade("Matemática")
                .cpf("20000000001")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("Ana Souza")
                .email("ana@escola.com")
                .telefone("99999-0002")
                .especialidade("Português")
                .cpf("20000000002")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("João Pedro")
                .email("joao@escola.com")
                .telefone("99999-0003")
                .especialidade("História")
                .cpf("20000000003")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("Maria Oliveira")
                .email("maria@escola.com")
                .telefone("99999-0004")
                .especialidade("Geografia")
                .cpf("20000000004")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("Pedro Santos")
                .email("pedro@escola.com")
                .telefone("99999-0005")
                .especialidade("Física")
                .cpf("20000000005")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("Lucas Lima")
                .email("lucas@escola.com")
                .telefone("99999-0006")
                .especialidade("Química")
                .cpf("20000000006")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("Fernanda Alves")
                .email("fernanda@escola.com")
                .telefone("99999-0007")
                .especialidade("Biologia")
                .cpf("20000000007")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("Rafael Costa")
                .email("rafael@escola.com")
                .telefone("99999-0008")
                .especialidade("Inglês")
                .cpf("20000000008")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("Patrícia Gomes")
                .email("patricia@escola.com")
                .telefone("99999-0009")
                .especialidade("Artes")
                .cpf("20000000009")
                .build()));

        professores.add(professorRepository.save(Professor.builder()
                .nome("Bruno Ferreira")
                .email("bruno@escola.com")
                .telefone("99999-0010")
                .especialidade("Educação Física")
                .cpf("20000000010")
                .build()));

        // ======================
        // DISCIPLINAS
        // ======================

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Matemática I")
                .cargaHoraria(80)
                .professor(professores.get(0))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Português")
                .cargaHoraria(60)
                .professor(professores.get(1))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("História")
                .cargaHoraria(60)
                .professor(professores.get(2))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Geografia")
                .cargaHoraria(60)
                .professor(professores.get(3))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Física")
                .cargaHoraria(80)
                .professor(professores.get(4))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Química")
                .cargaHoraria(80)
                .professor(professores.get(5))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Biologia")
                .cargaHoraria(60)
                .professor(professores.get(6))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Inglês")
                .cargaHoraria(40)
                .professor(professores.get(7))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Artes")
                .cargaHoraria(40)
                .professor(professores.get(8))
                .build());

        disciplinaRepository.save(Disciplina.builder()
                .nomeDisciplina("Educação Física")
                .cargaHoraria(40)
                .professor(professores.get(9))
                .build());

        // ======================
        // VALIDAÇÕES
        // ======================

        assertNotNull(turma1.getIdTurma());

        System.out.println("==================================");
        System.out.println("SISTEMA ESCOLAR OK");
        System.out.println("15 alunos inseridos");
        System.out.println("10 professores inseridos");
        System.out.println("10 disciplinas inseridas");
        System.out.println("==================================");
    }
}