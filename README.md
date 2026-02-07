# Spring Boot Backend Learning

This repository represents my structured backend development learning journey
using Spring Boot. It is designed to follow real-world backend architecture
and industry best practices, focusing on clean layering, maintainability,
and scalable design.

The project evolves module by module, starting from Spring fundamentals
and progressing towards secure, production-ready backend systems.

---

## Tech Stack

### Core Backend
- Java 21
- Spring Boot 4.0.2
- Spring MVC
- Spring REST APIs

### API & Development Tools
- Swagger UI / OpenAPI (API documentation)
- Postman (API testing)
- Maven (build & dependency management)
- Git & GitHub (version control)

### View & Persistence
- Thymeleaf (MVC views)
- MySQL (introduced with Spring Data JPA module)

---

## Architecture Overview

The project follows a clean layered backend architecture:

Controller  
→ Service  
→ Repository  
→ Database  

Supporting layers:
- DTO — API request and response contracts
- Model — Domain objects and entities
- Exception — Centralized error handling
- Config — Application-level configuration

---

## Modules Covered

- Spring Boot Fundamentals
- Spring MVC (with mini project)
- Spring REST APIs
  - CRUD APIs
  - Validation
  - Exception Handling
  - Swagger / OpenAPI Documentation
- Spring Data JPA (planned)
- Spring Security (planned)

---

## Project Structure

src/main/java
└── com.prahlad
    ├── controller
    ├── service
    ├── repository
    ├── model
    ├── dto
    ├── exception
    └── config

---

## Documentation

To keep the main README concise and professional, detailed learning notes,
daily progress, and implementation explanations are maintained separately.

All module-wise and day-wise documentation can be found under:

docs/
├── spring-boot-basics/
├── spring-mvc/
└── spring-rest/

Each folder contains focused notes and implementations corresponding
to that specific module.

---

## Learning Status

- Spring Boot Fundamentals — Completed
- Spring MVC (with Mini Project) — Completed
- Spring REST APIs — In Progress
- Spring Data JPA — Planned
- Spring Security — Planned
- Final Backend Mini Project — Planned

---

## Purpose

- Build strong backend fundamentals
- Learn Spring Boot with industry-standard practices
- Maintain a clean, professional GitHub portfolio
- Prepare for backend internships and placements

---

## Note

This repository focuses on backend development.
Frontend frameworks and database integrations are introduced incrementally
as part of later modules and projects.