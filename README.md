# Product Manager Application

## Introdução

Bem-vindo ao Product Manager Application! Esta aplicação foi desenvolvida utilizando a arquitetura limpa para garantir um código modular, de fácil manutenção e escalável. A aplicação gerencia produtos, oferecendo operações de criação, leitura, atualização e exclusão (CRUD).


## Configurações da Aplicação

A aplicação utiliza o banco de dados H2, que é um banco de dados em memória, ideal para testes e desenvolvimento devido à sua simplicidade e rapidez. Além disso, a aplicação está configurada para expor um console H2 para facilitar o acesso e a visualização dos dados durante o desenvolvimento.

O banco de dados é inicializado com um script SQL especificado no arquivo `data.sql`, que cria as tabelas necessárias e popula o banco de dados com dados iniciais. Esta configuração garante que, ao iniciar a aplicação, todos os recursos necessários já estejam disponíveis e configurados.

A aplicação é configurada para rodar na porta **8080** por padrão. Portanto, após iniciar a aplicação, você pode acessar os recursos da API através de `http://localhost:8080`.


## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

product-service/<br>
├── src/<br>
│ ├── main/<br>
│ │ ├── java/<br>
│ │ │ └── com/<br>
│ │ │ └── example/<br>
│ │ │ └── productservice/<br>
│ │ │ ├── ProductServiceApplication.java<br>
│ │ │ ├── adapters/<br>
│ │ │ │ ├── controller/<br>
│ │ │ │ │ └── ProductController.java<br>
│ │ │ │ ├── dto/<br>
│ │ │ │ │ └── ProductDTO.java<br>
│ │ │ │ ├── mapper/<br>
│ │ │ │ │ └── ProductMapper.java<br>
│ │ │ │ └── repository/<br>
│ │ │ │ ├── ProductRepository.java<br>
│ │ │ ├── application/<br>
│ │ │ │ └── service/<br>
│ │ │ │ ├── ProductService.java<br>
│ │ │ │ └── ProductServiceUseCase.java<br>
│ │ │ ├── domain/<br>
│ │ │ │ ├── exception/<br>
│ │ │ │ │ ├── ErrorResponse.java<br>
│ │ │ │ │ ├── ProductAlreadyExistsException.java<br>
│ │ │ │ │ └── ProductNotFoundException.java<br>
│ │ │ │ ├── model/<br>
│ │ │ │ │ └── ProductEntity.java<br>
│ │ │ │ ├── repository/<br>
│ │ │ │ │ └── ProductModelUseCase.java<br>
│ │ │ │ └── service/<br>
│ │ │ │ └── ProductDomainService.java<br>


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
