# api-contatos

## Como executar a aplicação

A aplicação foi feita com Java 17 e com Maven 3.9.6.

Para subir a aplicação, execute o comando:

``` shell
mvn spring-boot:run
```

## Banco de dados utilizado
Nesse projeto, foi utilizado o Banco de Dados H2 em memória.

Para acessar o banco, com a aplicação rodando, pode usar a URL: http://localhost:8080/h2-console

username: sa  
password: (Está em branco, não precisa passar)  
url: jdbc:h2:mem:testdb

As configurações de conexão podem ser alteradas no arquivo "application.properties"

## Documentação do OpenAPI
Para acessar a documentação com os contratos da aplicação, acesse a URL: http://localhost:8080/swagger-ui/index.html 
