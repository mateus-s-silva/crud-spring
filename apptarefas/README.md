# APP TAREFA - TESTE TÉCNICO ESIG

## O que foi feito?

Foi feita uma API REST para cadastro de tarefas. Nesta API, o usuário é capaz de cadastrar, atualizar, listar e excluir suas tarefas.  

## Ferramentas

- Java na versão 11
- Spring boot na versão 2.7.16
- Maven para gerenciamento de dependências
- PostgreSQL como banco de dados

## Dependências

- Starter Web
- JDBC
- JPA
- Validation
- Flyway
- PostgreSQL JDBC Driver

## Itens feitos
- b) Desenvolver o backend utilizando Java 11 e Spring Boot.
- c) Os endpoints devem ser em REST.
- e) Utilizar persistência em um banco de dados PostgreSQL e persistência JPA.

## Como executar

- Navegue no diretório até onde estiver o arquivo *pom.xml*
- Injete todas as dependências com o comando:
 ~~~shell
  mvn clean install
~~~~
- Para conexão com banco de dados, crie um servidor chamado ***tarefa***. O flyway ficará responsável por criar as tabelas automaticamente.  
Caso queira conectar com um outro servidor, altere as configurações no arquivo *application.properties*, em /src/main/resourcers.
- Altere o nome do usuário e senha do seu servidor de banco de dados em *application.properties* 
  
  
- Agora basta navegar até /apptarefas/apptarefas e executar o seguinte comando:
~~~shell
mvn spring-boot:run
~~~