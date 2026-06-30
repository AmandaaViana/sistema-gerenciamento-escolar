package com.escola.gerenciamento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.escola.gerenciamento.entities.Aluno;
import com.escola.gerenciamento.entities.Disciplina;
import com.escola.gerenciamento.entities.Professor;
import com.escola.gerenciamento.entities.Turma;
import com.escola.gerenciamento.repositories.AlunoRepository;
import com.escola.gerenciamento.repositories.DisciplinaRepository;
import com.escola.gerenciamento.repositories.NotaRepository;
import com.escola.gerenciamento.repositories.ProfessorRepository;
import com.escola.gerenciamento.repositories.TurmaRepository;

@SpringBootTest
class EscolaApplicationTests {

        @Autowired
        private NotaRepository notaRepository;

        @Autowired
        private TurmaRepository turmaRepository;

        @Autowired
        private AlunoRepository alunoRepository;

        @Autowired
        private ProfessorRepository professorRepository;

        @Autowired
        private DisciplinaRepository disciplinaRepository;

     //   @BeforeEach
    //    void limparBanco() {

    //    }

        @Test
        void deveCadastrarTudo2() {

                notaRepository.deleteAll();
                disciplinaRepository.deleteAll();
                professorRepository.deleteAll();
                alunoRepository.deleteAll();
                turmaRepository.deleteAll();

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

                // for (int i = 1; i <= 15; i++) {

                // Turma turma = (i <= 5) ? turma1 : (i <= 10 ? turma2 : turma3);

                // alunoRepository.save(Aluno.builder()
                // .nome("Aluno " + i)
                // .cpf("111111111" + i)
                // .telefone("(44)99999-00" + i)
                // .email("aluno" + i + "@escola.com")
                // .endereco("Rua " + i)
                // .dataNascimento(LocalDate.of(2005, 1, 1).plusDays(i))
                // .turma(turma)
                // .build());
                // }

                // ======================
                // ALUNOS (15)
                // ======================

                alunoRepository.save(Aluno.builder()
                                .nome("João Pedro Silva")
                                .cpf("12345678901")
                                .telefone("(44)99999-0001")
                                .email("joao.silva@escola.com")
                                .endereco("Rua das Flores, 120")
                                .dataNascimento(LocalDate.of(2005, 3, 15))
                                .turma(turma1)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Maria Eduarda Souza")
                                .cpf("12345678902")
                                .telefone("(44)99999-0002")
                                .email("maria.souza@escola.com")
                                .endereco("Av. Brasil, 245")
                                .dataNascimento(LocalDate.of(2005, 5, 10))
                                .turma(turma1)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Carlos Henrique Lima")
                                .cpf("12345678903")
                                .telefone("(44)99999-0003")
                                .email("carlos.lima@escola.com")
                                .endereco("Rua Paraná, 88")
                                .dataNascimento(LocalDate.of(2005, 7, 20))
                                .turma(turma1)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Ana Clara Mendes")
                                .cpf("12345678904")
                                .telefone("(44)99999-0004")
                                .email("ana.mendes@escola.com")
                                .endereco("Rua das Acácias, 54")
                                .dataNascimento(LocalDate.of(2005, 2, 5))
                                .turma(turma1)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Lucas Gabriel Rocha")
                                .cpf("12345678905")
                                .telefone("(44)99999-0005")
                                .email("lucas.rocha@escola.com")
                                .endereco("Rua Central, 300")
                                .dataNascimento(LocalDate.of(2005, 9, 12))
                                .turma(turma1)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Fernanda Oliveira")
                                .cpf("12345678906")
                                .telefone("(44)99999-0006")
                                .email("fernanda.oliveira@escola.com")
                                .endereco("Rua das Palmeiras, 77")
                                .dataNascimento(LocalDate.of(2006, 1, 8))
                                .turma(turma2)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Pedro Henrique Costa")
                                .cpf("12345678907")
                                .telefone("(44)99999-0007")
                                .email("pedro.costa@escola.com")
                                .endereco("Av. Independência, 120")
                                .dataNascimento(LocalDate.of(2006, 4, 18))
                                .turma(turma2)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Juliana Ferreira")
                                .cpf("12345678908")
                                .telefone("(44)99999-0008")
                                .email("juliana.ferreira@escola.com")
                                .endereco("Rua São Paulo, 45")
                                .dataNascimento(LocalDate.of(2006, 6, 22))
                                .turma(turma2)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Matheus Almeida")
                                .cpf("12345678909")
                                .telefone("(44)99999-0009")
                                .email("matheus.almeida@escola.com")
                                .endereco("Rua Rio Branco, 210")
                                .dataNascimento(LocalDate.of(2006, 8, 3))
                                .turma(turma2)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Beatriz Martins")
                                .cpf("12345678910")
                                .telefone("(44)99999-0010")
                                .email("beatriz.martins@escola.com")
                                .endereco("Rua Tiradentes, 98")
                                .dataNascimento(LocalDate.of(2006, 10, 11))
                                .turma(turma2)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Rafael Gomes")
                                .cpf("12345678911")
                                .telefone("(44)99999-0011")
                                .email("rafael.gomes@escola.com")
                                .endereco("Rua XV de Novembro, 500")
                                .dataNascimento(LocalDate.of(2007, 1, 19))
                                .turma(turma3)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Camila Barbosa")
                                .cpf("12345678912")
                                .telefone("(44)99999-0012")
                                .email("camila.barbosa@escola.com")
                                .endereco("Rua dos Ipês, 145")
                                .dataNascimento(LocalDate.of(2007, 3, 28))
                                .turma(turma3)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Gustavo Ribeiro")
                                .cpf("12345678913")
                                .telefone("(44)99999-0013")
                                .email("gustavo.ribeiro@escola.com")
                                .endereco("Rua das Oliveiras, 66")
                                .dataNascimento(LocalDate.of(2007, 5, 9))
                                .turma(turma3)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Larissa Nunes")
                                .cpf("12345678914")
                                .telefone("(44)99999-0014")
                                .email("larissa.nunes@escola.com")
                                .endereco("Av. Colombo, 890")
                                .dataNascimento(LocalDate.of(2007, 7, 14))
                                .turma(turma3)
                                .build());

                alunoRepository.save(Aluno.builder()
                                .nome("Thiago Fernandes")
                                .cpf("12345678915")
                                .telefone("(44)99999-0015")
                                .email("thiago.fernandes@escola.com")
                                .endereco("Rua Monte Castelo, 320")
                                .dataNascimento(LocalDate.of(2007, 11, 2))
                                .turma(turma3)
                                .build());

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