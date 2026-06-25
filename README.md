# Sistema de Gerenciamento Escolar

Um sistema de gestão escolar desenvolvido como projeto prático para a disciplina de **Desenvolvimento Web III**. A aplicação foi construída utilizando a arquitetura MVC (Model-View-Controller) para centralizar o controle de alunos, professores, turmas, disciplinas e notas em uma única aplicação responsiva.

Além das operações de cadastro e consulta, o sistema implementa controle de acesso, segurança nas rotas, validações de dados e relacionamento entre entidades, simulando cenários reais de gestão acadêmica.

---

## Integrantes do Grupo

* **Alysson Gabriel Neres Soares**
* **Amanda Hubner Viana**
* **Breno Goncalves Justus**
* **Germano Delenga**
  
---

## Tecnologias Utilizadas

* **Back-end:** Java 25 & Spring Boot 4 (Spring MVC, Spring Data JPA e Spring Security).
* **Otimização:** Lombok (uso de anotações como `@Getter`, `@Setter` e `@Builder` para eliminação de código boiler-plate).
* **Banco de Dados:** MySQL (utilizando o driver de conexão nativo `mysql-connector-j`).
* **Front-end:** Thymeleaf (Motor de templates para renderização dinâmica HTML5 integrada ao back-end) e Tailwind CSS.
  
---

##  Estrutura do Projeto (Arquitetura)

O projeto segue o padrão estrito de separação de responsabilidades do Spring Boot:

    src/main/java/com/escola/gerenciamento/
    │
    ├── config/             # Configurações globais e inicialização automática de dados (DataLoader)
    ├── controllers/        # Controladores Web (Processamento de requisições e rotas Thymeleaf)
    ├── entities/           # Modelos de dados mapeados para as tabelas JPA (Aluno, Professor, Usuario, etc.)
    ├── enums/              # Enumeradores de controle de domínio (ex: Role, Periodo)
    ├── repositories/       # Interfaces que herdam JpaRepository para persistência de dados
    └── services/           # Camada de lógica de negócio e regras de validação do sistema
    
--- 

## Módulos e Funcionalidades Implementadas

### Autenticação & Segurança

* **Login de usuários:** Tela de autenticação estilizada integrada com Spring Security.

* **Controle de Rotas:** Proteção de páginas e controle de acessos com base no perfil de usuário.

### Alunos

* **Cadastro:** Formulário para inclusão de novos estudantes com validações de dados.

* **Listagem:** Painel com tabelas organizadas exibindo informações estruturadas (CPF, Telefone, Turma).

* **Filtros:** Badges visuais que identificam o período (ex: Matutino ou Noturno).

### Turmas & Disciplinas

* **Gerenciamento:** Telas dedicadas para criação e vinculação de turmas (1º Ano A, 2º Ano B).

* **Vínculos:** Definição de anos letivos, salas de aula e atribuição de carga horária específica.

### Notas & Avaliações

* **Lançamento:** Fluxo integrado para seleção de alunos e atribuição de notas por disciplina.

* **Cálculos Dinâmicos:** Cálculo automático de médias com exibição de badges de situação coloridos (ex: APROVADO em verde ou REPROVADO em vermelho).

## Modelagem do Sistema

Os relacionamentos entre as entidades foram implementados utilizando as anotações nativas do JPA (@ManyToOne, @OneToMany), garantindo integridade referencial:

* Uma Turma pode possuir vários Alunos (@OneToMany).

* Um Aluno pertence a uma única Turma (@ManyToOne).
  
* Professores são vinculados a Disciplinas específicas para o lançamento e controle de notas.

## Configuração do Banco de Dados (MySQL)

O sistema utiliza o MySQL como banco de dados relacional estável. Antes de iniciar a aplicação, certifique-se de possuir um servidor MySQL ativo e configure suas credenciais locais acessando o arquivo:

    src/main/resources/application.properties

Altere as propriedades abaixo substituindo os valores correspondentes pelos dados do seu banco:
    
    spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_seu_esquema
    spring.datasource.username=seu_usuario_mysql
    spring.datasource.password=sua_senha_mysql
    
    # Mantém a tabela atualizada com a modelagem do código
    spring.jpa.hibernate.ddl-auto=update

Como Executar o Projeto Localmente
Pré-requisitos

* Java JDK 25 instalado.

*  Servidor MySQL ativo.

*   Maven instalado (ou utilização do wrapper ./mvnw).

Passo a Passo

* Clonar o Repositório:

      git clone [https://github.com/AmandaaViana/sistema-gerenciamento-escolar.git](https://github.com/AmandaaViana/sistema-gerenciamento-escolar.git)
      cd sistema-gerenciamento-escolar

* Compilar o Projeto:

      ./mvnw clean compile

* Executar a Aplicação:

      ./mvnw spring-boot:run

    (Também é possível executar diretamente na IDE utilizada no desenvolvimento através da extensão Spring Boot Dashboard).

* Acessar o Sistema:

  Após a inicialização correta no terminal, acesse via navegador:

      http://localhost:8080

## Credenciais para Teste (Acesso Padrão)

Como o sistema possui inicialização automática de dados, você pode utilizar os seguintes dados padrão para realizar o login inicial:

* **Usuário:** admin

* **Senha:** 123456
