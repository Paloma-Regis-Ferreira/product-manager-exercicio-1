# Product Manager Application

## Introdução

Bem-vindo ao Product Manager Application! Esta aplicação foi desenvolvida utilizando a arquitetura limpa para garantir um código modular, de fácil manutenção e escalável. A aplicação gerencia produtos, oferecendo operações de criação, leitura, atualização e exclusão (CRUD).


## Configurações da Aplicação

A aplicação utiliza o banco de dados H2, que é um banco de dados em memória, ideal para testes e desenvolvimento devido à sua simplicidade e rapidez. Além disso, a aplicação está configurada para expor um console H2 para facilitar o acesso e a visualização dos dados durante o desenvolvimento.

O banco de dados é inicializado com um script SQL especificado no arquivo `data.sql`, que cria as tabelas necessárias e popula o banco de dados com dados iniciais. Esta configuração garante que, ao iniciar a aplicação, todos os recursos necessários já estejam disponíveis e configurados.

A aplicação é configurada para rodar na porta **8080** por padrão. Portanto, após iniciar a aplicação, você pode acessar os recursos da API através de `http://localhost:8080`.


## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

product-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── productservice/
│   │   │               ├── ProductServiceApplication.java
│   │   │               ├── adapters/
│   │   │               │   ├── controller/
│   │   │               │   │   └── ProductController.java
│   │   │               │   ├── dto/
│   │   │               │   │   └── ProductDTO.java
│   │   │               │   ├── mapper/
│   │   │               │   │   └── ProductMapper.java
│   │   │               │   └── repository/
│   │   │               │       ├── ProductRepository.java
│   │   │               ├── application/
│   │   │               │   └── service/
│   │   │               │       ├── ProductService.java
│   │   │               │       └── ProductServiceUseCase.java
│   │   │               ├── domain/
│   │   │               │   ├── exception/
│   │   │               │   │   ├── ErrorResponse.java
│   │   │               │   │   ├── ProductAlreadyExistsException.java
│   │   │               │   │   └── ProductNotFoundException.java
│   │   │               │   ├── model/
│   │   │               │   │   └── ProductEntity.java
│   │   │               │   ├── repository/
│   │   │               │   │   └── ProductModelUseCase.java
│   │   │               │   └── service/
│   │   │               │       └── ProductDomainService.java


## Requisitos para Rodar a Aplicação

Para executar a aplicação, você precisará do seguinte:

- Java 22
- Gradle 7.5 ou superior

## Endpoints da API

### Obter produto por ID

```bash
curl -X GET "http://localhost:8080/api/products/{id}" -H "accept: application/json"
```

### Obter todos os produtos

```bash
curl -X GET "http://localhost:8080/api/products" -H "accept: application/json"
```

### Criar um novo produto

```bash
curl -X POST "http://localhost:8080/api/products" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"name\": \"string\", \"description\": \"string\", \"price\": 0.0 }"
```

### Atualizar um produto

```bash
curl -X PUT "http://localhost:8080/api/products/{id}" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"name\": \"string\", \"description\": \"string\", \"price\": 0.0 }"
```

### Deletar um produto

```bash
curl -X DELETE "http://localhost:8080/api/products/{id}" -H "accept: application/json"
```
