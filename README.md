# Projeto Java Spring Boot + Docker + MySQL

Este projeto consiste em uma aplicação Java Spring Boot integrada com um banco MySQL executado em container Docker.  
A pasta `docker/` contém os arquivos necessários para subir o banco de dados.

---

## 📁 Estrutura do Projeto
/.idea
/demo       -> Código do projeto Java Spring Boot
/docker     -> Arquivos Docker (docker-compose.yml, scripts, etc)

---

## Requisitos

- Java 17 ou superior
- Docker
- Docker Compose
- IDE (IntelliJ, Eclipse, VSCode etc)

---

# 🐳 Subindo o banco com Docker

1. Abra um terminal
2. Vá até a pasta `docker`
3. Execute:

```bash
cd docker
docker compose up -d --build
```

Isso irá:

Criar um container MySQL

Criar o banco de dados configurado

Liberar a porta configurada (ex: 3306)

⚠️ Use o docker compose up -d para rodar em segundo plano.

📦 Configurações de Conexão no Spring Boot

No arquivo application.properties, configure:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/NOME_DO_BANCO
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

▶️ Executando o Projeto Spring Boot
1️⃣ Navegue até o diretório do projeto
cd demo

2️⃣ Compile e execute

Se estiver utilizando Gradle:

```bash
./gradlew bootRun
```

Ou no Windows:

```bash
gradlew bootRun
```

🔎 Verificando o Status
➤ Ver containers ativos
docker ps

➤ Logs do banco
docker logs nome_do_container_mysql

📡 Endpoints

Depois que a aplicação iniciar, acesse:

http://localhost:8080


Substitua a porta se configurada de forma diferente.

🛑 Parando o container

Para parar o MySQL:

cd docker
docker compose down
