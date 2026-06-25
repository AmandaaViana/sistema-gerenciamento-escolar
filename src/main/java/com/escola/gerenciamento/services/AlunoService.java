package com.escola.gerenciamento.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.escola.gerenciamento.entities.Aluno;
import com.escola.gerenciamento.repositories.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    // ==========================================
    // LISTAR TODOS
    // ==========================================

    public List<Aluno> listarTodos() {
        return repository.findAll();
    }

    // ==========================================
    // BUSCAR POR ID
    // ==========================================

    public Aluno buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Aluno não encontrado"));
    }

    // ==========================================
    // SALVAR
    // ==========================================

   public Aluno salvar(Aluno aluno) {

    // Novo cadastro
    if (aluno.getIdAluno() == null) {

        if (repository.existsByCpf(aluno.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }

        return repository.save(aluno);
    }

    // Atualização
    Aluno alunoBanco = buscarPorId(aluno.getIdAluno());

    alunoBanco.setNome(aluno.getNome());
    alunoBanco.setCpf(aluno.getCpf());
    alunoBanco.setTelefone(aluno.getTelefone());
    alunoBanco.setEmail(aluno.getEmail());
    alunoBanco.setEndereco(aluno.getEndereco());
    alunoBanco.setDataNascimento(aluno.getDataNascimento());
    alunoBanco.setTurma(aluno.getTurma());

    return repository.save(alunoBanco);
}
    // ==========================================
    // ATUALIZAR
    // ==========================================

    public Aluno atualizar(
            Long id,
            Aluno aluno) {

        Aluno alunoBanco =
                buscarPorId(id);

        if (aluno.getCpf() != null &&
            !aluno.getCpf().isBlank()) {

            Optional<Aluno> existente =
                    repository.findByCpf(
                            aluno.getCpf());

            if (existente.isPresent()
                    && !existente.get()
                            .getIdAluno()
                            .equals(id)) {

                throw new RuntimeException(
                        "CPF já cadastrado");
            }
        }

        alunoBanco.setNome(aluno.getNome());
        alunoBanco.setCpf(aluno.getCpf());
        alunoBanco.setTelefone(aluno.getTelefone());
        alunoBanco.setEmail(aluno.getEmail());
        alunoBanco.setEndereco(aluno.getEndereco());
        alunoBanco.setDataNascimento(
                aluno.getDataNascimento());

        // pode ser null
        alunoBanco.setTurma(
                aluno.getTurma());

        return repository.save(alunoBanco);
    }

    // ==========================================
    // DELETAR
    // ==========================================

    public void deletar(Long id) {

        buscarPorId(id);

        repository.deleteById(id);
    }

    // ==========================================
    // BUSCAR POR NOME
    // ==========================================

    public List<Aluno> buscarPorNome(
            String nome) {

        return repository
                .findByNomeContainingIgnoreCase(
                        nome);
    }

//// paginação

    public Page<Aluno> listarPaginado(int pagina) {

       return repository.findAll(
               PageRequest.of(pagina, 5)
  );
   }
   

   
    
}