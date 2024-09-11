# Projeto de Gerenciamento de Produtos

Este é um projeto de API para gerenciamento de produtos. A API é construída utilizando **Spring Boot** e documentada com **Swagger**, proporcionando uma interface gráfica para explorar e testar os endpoints.

## Requisitos

- **Docker** e **Docker Compose** instalados em sua máquina.
- **Java 17** (ou superior) para rodar o projeto Spring Boot.

## Configuração do Banco de Dados

Este projeto utiliza **PostgreSQL** como banco de dados, e a configuração necessária está disponível no Docker. Siga os passos abaixo para subir o banco de dados.

### Como subir o banco de dados com Docker:

1. Certifique-se de que o Docker e o Docker Compose estão instalados.
2. No diretório raiz do projeto, execute o seguinte comando para iniciar o banco de dados:

    ```bash
    docker-compose up -d
    ```

    Isso fará com que o banco de dados **PostgreSQL** seja inicializado com os seguintes parâmetros:

    - **Nome do Banco de Dados**: `productdb`
    - **Usuário**: `postgres`
    - **Senha**: `postgres`

3. O banco de dados será iniciado e estará disponível na porta padrão do PostgreSQL (5432).

### Acessando o Banco de Dados

Se quiser verificar a base de dados manualmente, você pode utilizar qualquer cliente de PostgreSQL (como pgAdmin ou DBeaver) e se conectar usando as credenciais acima.

---

## Endpoints e Documentação

A API está totalmente documentada e pode ser explorada via **Swagger**. Após iniciar a aplicação, acesse a interface gráfica do Swagger para visualizar e testar os endpoints disponíveis.

### Como acessar o Swagger:

1. Execute o projeto Spring Boot (por exemplo, via comando `mvn spring-boot:run` ou rodando a aplicação pelo seu IDE).
2. Com a aplicação rodando, acesse a documentação interativa do Swagger no seguinte URL:

    - **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

    Lá você poderá ver a lista completa de endpoints e realizar testes diretamente na interface do Swagger.

---

## Comandos Importantes

### Subir a aplicação:

```bash
mvn spring-boot:run


