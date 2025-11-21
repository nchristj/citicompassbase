
# Citi Compass Base  
**Repository:** `citicompassbase`  
**Purpose:** Base microservice project for the *Citi Compass* portfolio‑reporting/dashboard system.  
Provides foundation (Spring Boot, REST API, database connectivity, error handling, logging, configuration) on which your microservices will be built.

---

## Table of Contents  
1. Overview  
2. Features  
3. Prerequisites  
4. Repository Structure  
5. Configuration  
6. Running Locally  
7. Docker Setup  
8. Database Setup  
9. Testing  
10. CI/CD & Deployment  
11. Troubleshooting  
12. Contributing  
13. License  
14. Authors  
15. Acknowledgements  

---

## 1. Overview  
This repository acts as the baseline Java Spring Boot microservice for the *Citi Compass* system.  
It includes the required setup for REST APIs, service/repository layers, security, JPA, logging, Docker deployment, and externalized configuration.

---

## 2. Features  
- Spring Boot–based REST microservice  
- Controller → Service → Repository layered architecture  
- Global exception handling  
- OpenAPI/Swagger documentation  
- Logging via SLF4J & Logback  
- JPA/Hibernate support  
- External environment-based configs  
- Dockerfile included for container builds  
- Docker Compose setup for DB + service  
- Actuator health endpoints  
- Ready for CI/CD (GitHub Actions, Jenkins, Bitbucket Pipelines)

---

## 3. Prerequisites  
You need the following installed:

- Java 17+  
- Maven  
- Docker  
- Docker Compose  
- Git  

Optional for development:  
- Postman / Insomnia  
- IntelliJ IDEA / VS Code  

---

## 4. Repository Structure  

```
citicompassbase/
├── src/
│   ├── main/
│   │   ├── java/com/citicompass/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── model/
│   │   │   └── CitiCompassBaseApplication.java
│   │   └── resources/
│   │       ├── application.yml
│   │       ├── application-dev.yml
│   │       ├── application-prod.yml
│   │       └── logback-spring.xml
├── test/
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---
🧩 High-Level Architecture
```pgsql
           +--------------------------------------+
           |  (REACT UI)   Functional Requirement |
           +-------------+------------------------+
                         |
                         v
              +----------+----------+
              |     AI Reasoning    |
              |   (GLM-4.6 + Ollama)|
              +----------+----------+
                         |
                         v
              +----------+----------+
              |   PyCodeCompass     |
              |   Microservice      |
              +----------+----------+
                         |
       +-----------------+----------------+
       |                 |                |
       v                 v                v
+------+-----+   +-------+------+  +------+-------+
| CodeQL DB  |   |  DTO Scanner |  | Impact Graph |
| Generation |   | (Java Source)|  |  (NetworkX)  |
+------+-----+   +-------+------+  +------+-------+
       |                 |                |
       +-----------------+----------------+
                         |
                         v
               +---------+---------+
               |   Neo4j Storage   |
               |  Versioned Graphs |
               +-------------------+
```

## 5. Configuration  

### application.yml  
```
server:
  port: 8080

spring:
  datasource:
    url: ${DB_URL}
    username: ${DB_USER}
    password: ${DB_PASS}

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

logging:
  level:
    root: INFO
```

### Environment Variables  
| Variable | Description |
|----------|-------------|
| `DB_URL` | Your DB JDBC URL |
| `DB_USER` | DB Username |
| `DB_PASS` | DB Password |
| `SPRING_PROFILES_ACTIVE` | dev / prod |

---

## 6. Running Locally  

### 1. Clone the repo  
```
git clone https://github.com/nchristj/citicompassbase.git
cd citicompassbase
```

### 2. Build  
```
mvn clean package
```

### 3. Run  
```
mvn spring-boot:run
```

Or run Jar:  
```
java -jar target/citicompassbase.jar
```

### 4. Swagger URL  
```
http://localhost:8080/swagger-ui/index.html
```

---

## 7. Docker Setup  

### Dockerfile  
```
FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Build Image  
```
docker build -t citicompassbase .
```

### Run Container  
```
docker run -p 8080:8080     -e DB_URL="jdbc:postgresql://host.docker.internal:5432/citicompass"     -e DB_USER=postgres     -e DB_PASS=password     citicompassbase
```

---

## 8. Docker Compose  

### docker-compose.yml  
```
version: "3.9"
services:
  db:
    image: postgres:16
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: password
      POSTGRES_DB: citicompass
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

  app:
    build: .
    environment:
      DB_URL: jdbc:postgresql://db:5432/citicompass
      DB_USER: postgres
      DB_PASS: password
    ports:
      - "8080:8080"
    depends_on:
      - db

volumes:
  pgdata:
```

### Run Compose  
```
docker-compose up --build
```

---

## 9. Database Setup  
Example PostgreSQL table:

```
CREATE TABLE sample_entity (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100),
    created_at TIMESTAMP DEFAULT NOW()
);
```

Places migration SQL files under:  
```
src/main/resources/db/migration/
```

---

## 10. Testing  
Run tests:  
```
mvn test
```

Test features included:  
- Unit tests (JUnit 5)  
- MockMVC tests for controllers  
- Integration tests (optionally using Testcontainers)

---

## 11. CI/CD & Deployment  

### GitHub Actions Example  
```
name: CI Pipeline

on:
  push:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build
        run: mvn clean package -DskipTests
      - name: Docker Build
        run: docker build -t citicompassbase .
```

You can deploy using:  
- Docker Hub  
- AWS ECS/EKS  
- Kubernetes  
- Jenkins  
- Bitbucket Pipelines  

---

## 12. Troubleshooting  
| Error | Solution |
|-------|----------|
| DB connection failed | Verify environment variables & container networking |
| Swagger not loading | Check `springdoc` dependency |
| Container shutting down | Check logs: `docker logs <container>` |
| Port conflicts | Change port using `server.port` or Docker mapping |

---

## 13. Contributing  
1. Fork the repo  
2. Create a feature branch  
3. Commit changes  
4. Push and create PR  
5. Ensure tests pass before submitting PR  

---

## 14. License  
MIT License (you may update as required)

---

## 15. Authors  
- **Christon James Navaraj** — Architect & Developer
- - **Senthil Nayagam** — Developer
  - - **Janaki Ponnuswamy** — Developer  

---

## 16. Acknowledgements  
- Spring Boot  
- PostgreSQL  
- Docker  
- OpenAPI  
- JVM ecosystem  

---

