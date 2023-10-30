# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes ferramentas estejam corretamente instaladas:
```
- Java 17
- PostgreSQL
- Maven
```
## Preparando ambiente

Criação da base de dados Postgres
```
- CREATE DATABASE "devolucaodb";
```
Criação do schema dentro da base devolucaodb
```
- CREATE SCHEMA "devolucaodbs";
```
Criação da tabela que vai receber os dados do script **V1__insert-into-estabelecimento.sql** que vai rodar ao iniciar a aplicação
```
- CREATE TABLE "devolucaodbs.tb_estabelecimento";
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
- https://repo.tcia.com.br/grupo_tcia/devolucao-rapida-backend/-/tree/main
```
Ajustar a porta que o projeto vai subir, algumas limitações do EXPO (Fronted) obrigam subir a aplicação backend com o IP, ajustar a porta no arquivo **application.properties**.

```
Alterar as linhas:

    - spring.mvc.cors.allowed-origins=http://SEUIP:8080/
    - server.address=SEUIP
```

Feito isso, acesse o projeto:
```
- cd devolucao-rapida-backend
```
É preciso compilar o código e baixar as dependências do projeto:
```
- mvn clean install
```
Finalizado esse passo, vamos iniciar a aplicação:
```
- mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://SEUIP:8080
```
```
## Segurança

```
A aplicação está rodando com autenticação JWT para validar algumas rotas, primeiramente será necessário criar um novo usuário para liberar o acesso a todas as rotas.


- Acessar o endpoint do registro : http://192.168.1.6:8080/auth/register
Enviar no corpo da requisição: 

    {
    "login": "userteste@gmail.com",
    "password": "1234567",
    "role": "ADMIN"
    }
```
