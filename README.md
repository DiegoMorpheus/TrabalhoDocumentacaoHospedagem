# 📚 Documentos & Categorias — API REST

API REST desenvolvida em **Spring Boot 3.5.7** para gerenciamento de **categorias** e **documentos**, utilizando arquitetura em camadas, banco de dados H2/PostgreSQL e documentação automática com Swagger/OpenAPI.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.7**
- **Spring Web**
- **Spring Data JPA**
- **Spring Validation**
- **Spring Boot Actuator**
- **SpringDoc OpenAPI 2.5.0 (Swagger UI)**
- **H2 Database (dev)**
- **PostgreSQL (produção)**
- **Maven**

---

## 📁 Estrutura do Projeto

```
src/main/java/com/pratica09/documentos_categorias
│
├── controller
├── service
├── repository
├── dto
└── model
```

---

## 🛠 Principais Dependências (POM)

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>

    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>

    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
</dependencies>
```

---

## ▶ Como executar o projeto

### 1️⃣ Executar com Maven
```
mvn spring-boot:run
```

### 2️⃣ Gerar e rodar o .jar
```
mvn clean package
java -jar target/documentos-categorias-0.0.1-SNAPSHOT.jar
```

---

## 🗃 Configuração do Banco de Dados

### 🔹 H2 (padrão - desenvolvimento)

```
spring.datasource.url=jdbc:h2:mem:docdb
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

Acesso ao console H2:  
➡ http://localhost:8080/h2-console

---

### 🔹 PostgreSQL (produção)

```
spring.datasource.url=jdbc:postgresql://localhost:5432/documentos
spring.datasource.username=postgres
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

---

## 📘 Documentação da API (Swagger)

Acesse:

➡ http://localhost:8080/swagger-ui.html  
ou  
➡ http://localhost:8080/swagger-ui/index.html

---

## 📡 Endpoints Existentes (Exemplo)

### Categorias
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/categorias` | Lista todas |
| GET | `/categorias/{id}` | Busca por ID |
| POST | `/categorias` | Cria nova categoria |
| PUT | `/categorias/{id}` | Atualiza categoria |
| DELETE | `/categorias/{id}` | Remove |

---

## 📊 Actuator (monitoramento)

➡ http://localhost:8080/actuator  
➡ http://localhost:8080/actuator/health

---

## 📄 Licença

Este projeto é distribuído sob a licença **MIT**.
