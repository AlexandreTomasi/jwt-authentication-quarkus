# Este projeto usa Quarkus, o Supersonic Subatomic Java Framework.
# Um microsserviço para autenticação JWT com regras e perfil de usuários.

### Arquitetura
- Java 11.0.9 https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- Framework Quarkus 1.13.1
- Apache Maven
- PostgreSQL 12
- Linux (Ubuntu 20.04.1 LTS)

### Ferramentas
- Intellij community edition 2021.1
- DBeaver 21.0.2.202104042040
- Swagger

### Configuração inicial
**Para executar o projeto deve existir um banco chamado “cadastro” vazio na conexão “localhost:5432”** usando o seguinte login:
- username: postgres
- password: postgres

### Iniciando
- O projeto usa a biblioteca "*flyway*" para criar as tabelas e inserir a carga inicial no banco. Somente necessário que o banco já tenha
  sido criado conforme na configuração inicial.

### Executando
- Na pasta raiz execute:  
*./mvnw compile quarkus:dev*
- Aguarde alguns segundos para inicializar, para verificar se executou acesse:
   [http://localhost:8080/q/swagger-ui/](http://localhost:8080/q/swagger-ui/). aonde se encontra a documentação das APIs.

### Testando
Utilizando o swagger:
1- fazer login, utilize o seguinte json no corpo:  
`{
"password": "admin",
"username": "ale@gmail.com"
}`
Como resposta irá ser recebido o token.  
2- No swagger clique no botão Authorize e adicione o token do login, pronto ja pode utilizar as APIs de pessoa.  
Inserir pessoa json:  
``{
"cpf": 3325696250,
"dataNascimento": "2021-05-05",
"email": "sa@teste",
"estadoCivil": {"name":"CASADO"},
"nome": "string",
"nomeMae": "string",
"nomePai": "string",
"sexo": {"name":"FEMININO"},
"password": "123456"
}``