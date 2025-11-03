# Brinquedoteca - Execução com Docker Compose

Este projeto entrega uma aplicação completa (frontend, backend e banco de dados) executando inteiramente em containers Docker.

## Pré-requisitos
- Docker 20+
- Docker Compose v2

## Serviços
O arquivo `docker-compose.yml` provisiona três serviços:

| Serviço   | Descrição | Porta externa |
|-----------|-----------|---------------|
| `frontend` | Interface web estática servida por Nginx | `8081` |
| `backend`  | API Spring Boot responsável pela lógica da aplicação | `8080` |
| `db`       | Banco PostgreSQL que armazena os dados da aplicação | `5432` |

Os containers se comunicam em rede interna utilizando os próprios nomes dos serviços (por exemplo, o backend acessa o banco em `jdbc:postgresql://db:5432/brinquedoteca`).

## Como executar
1. Construa e inicialize os containers:
   ```bash
   docker compose up --build
   ```
2. Acesse o frontend em [http://localhost:8081](http://localhost:8081).
3. A API REST permanecerá disponível em [http://localhost:8080/api](http://localhost:8080/api).

Para encerrar a aplicação utilize `Ctrl+C` no terminal e, opcionalmente, remova os containers/paradas com:
```bash
docker compose down
```

## Configurações adicionais
- Os dados do PostgreSQL são persistidos em um volume nomeado `db-data`.
- O backend é executado com o profile `postgres`, definido no arquivo `src/main/resources/application-postgres.properties`, que carrega automaticamente o schema SQL localizado em `src/main/resources/db/migration/V1__create_tables.sql`.

## Desenvolvimento local
Se preferir executar o backend sem containers, mantenha o profile padrão (H2 em memória) definido em `src/main/resources/application.properties`.
