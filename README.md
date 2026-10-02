# Rain — full-stack backend template

This project is now extended into a more complete Java Spring Boot backend template with:

- JPA (MySQL/Postgres/H2)
- Layered REST structure (controller → service → repository)
- Spring Security (HTTP Basic + BCrypt)
- Dockerfile + docker-compose templates for MySQL and Postgres

Quick run (H2, default):

```bash
mvn spring-boot:run
# register a user
curl -X POST http://localhost:8080/auth/register -H "Content-Type: application/json" -d '{"username":"alice","password":"pass"}'
# call protected endpoint
curl -u alice:pass http://localhost:8080/api/users
```

Using MySQL with docker-compose:

```bash
docker compose -f docker-compose-mysql.yml up --build
# the app will connect to the mysql container
```

Using Postgres with docker-compose:

```bash
docker compose -f docker-compose-postgres.yml up --build
```

Notes / next steps:
- Add JWT support if you want stateless authentication for APIs.
- Add role-based authorization (method security annotations are enabled).
- Add database migrations (Flyway/Liquibase) for production-ready schema management.
- Add CI / GitHub Actions and Docker image publishing if desired.
