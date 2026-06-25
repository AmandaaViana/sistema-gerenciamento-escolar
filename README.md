# Sistema de Gerenciamento Escolar

Um sistema de gestão escolar desenvolvido como projeto prático para a disciplina de **Desenvolvimento Web III**. A aplicação foi construída utilizando a arquitetura MVC (Model-View-Controller) para centralizar o controle de alunos, professores, turmas, disciplinas e notas em uma única aplicação responsiva.

Além das operações de cadastro e consulta, o sistema implementa controle de acesso, segurança nas rotas, validações de dados e relacionamento entre entidades, simulando cenários reais de gestão acadêmica.

---

* **Back-end:** Java 25 & Spring Boot 4 (Spring MVC, Spring Data JPA e Spring Security).
* **Otimização:** Lombok (uso de anotações como `@Getter`, `@Setter` e `@Builder` para eliminação de código boiler-plate).
* **Banco de Dados:** MySQL (utilizando o driver de conexão nativo `mysql-connector-j`).
* **Front-end:** Thymeleaf (Motor de templates para renderização dinâmica HTML5 integrada ao back-end) e Tailwind CSS.
  
---

##  Estrutura do Projeto (Arquitetura)

O projeto segue o padrão estrito de separação de responsabilidades do Spring Boot:

```text
src/main/java/com/escola/gerenciamento/
│
├── config/             # Configurações globais e inicialização automática de dados (DataLoader)
├── controllers/        # Controladores Web (Processamento de requisições e rotas Thymeleaf)
├── entities/           # Modelos de dados mapeados para as tabelas JPA (Aluno, Professor, Usuario, etc.)
├── enums/              # Enumeradores de controle de domínio (ex: Role, Periodo)
├── repositories/       # Interfaces que herdam JpaRepository para persistência de dados
└── services/           # Camada de lógica de negócio e regras de validação do sistema

