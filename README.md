🚀 Projeto Spring Boot + MySQL com Docker

Este projeto consiste em uma aplicação Java Spring Boot e um banco de dados MySQL executado dentro de um container Docker.
A pasta docker/ contém os arquivos necessários para subir o banco de dados sem necessidade de instalação local.

📁 Estrutura do Projeto
/.idea
/demo       -> Código do projeto Java Spring Boot
/docker     -> Arquivos Docker (docker-compose.yml, scripts, etc)

🔧 Pré-requisitos

Antes de iniciar, certifique-se de que possui instalado:

✔️ Java 17+ (ou versão usada no projeto)
✔️ Docker e Docker Compose
✔️ (Opcional) IDE como IntelliJ IDEA ou VSCode

🐳 Subindo o Banco com Docker

Dentro da pasta docker execute:

cd docker
docker compose up -d --build


Isso irá:

Criar um container MySQL

Criar o banco de dados configurado

Liberar a porta configurada (ex: 3306)

⚠️ Use o docker compose up -d para rodar em segundo plano.

📦 Configurações de Conexão no Spring Boot

No arquivo application.properties (ou application.yml), configure:

spring.datasource.url=jdbc:mysql://localhost:3306/NOME_DO_BANCO
spring.datasource.username=root
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


Substitua NOME_DO_BANCO, usuário e senha conforme definidos no seu docker-compose.yml.

▶️ Executando o Projeto Spring Boot
1️⃣ Navegue até o diretório do projeto
cd demo

2️⃣ Compile e execute

Se estiver utilizando Gradle:

./gradlew bootRun


Ou no Windows:

gradlew bootRun


Se estiver usando Maven:

mvn spring-boot:run

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
