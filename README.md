# Projeto CarTest

## Descrição
O projeto CarTest é uma aplicação que permite gerenciar informações sobre marcas de carros e modelos de carros relacionados a essas marcas. Os usuários podem criar,
atualizar e visualizar marcas de carros, bem como criar modelos de carros e associá-los às marcas.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Jakarta Validation
- Docker

## Configuração do Banco de Dados
- Crie um banco de dados PostgreSQL chamado `postgres`.
- Configure as credenciais do banco de dados em `application.properties`.

  # Endpoints da API
## A API oferece alguns dos seguintes endpoints:

- POST /brands: Crie uma nova marca de carro.
- GET /brands: Liste todas as marcas de carro.
- POST /models: Crie um novo modelo de carro.
- GET /models: Liste todos os modelos de carro.
- POST /cars: Crie um novo carro.
- GET /cars: Liste todos carros.

Exemplos de Uso
Você pode fornecer exemplos de solicitações HTTP (usando cURL ou qualquer outra ferramenta) para interagir com sua API. Por exemplo:

Criar uma marca de carro:

curl -X POST -H "Content-Type: application/json" -d '{"brandName": "Toyota"}' http://localhost:8080/brands

Listar todas as marcas de carro:

curl http://localhost:8080/brands
