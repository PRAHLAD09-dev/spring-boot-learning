# Spring Boot Backend Learning

This repository represents my structured backend development learning journey
using Spring Boot.  
It follows real-world backend architecture and industry best practices
with a strong focus on clean layering, maintainability, and scalability.

The repository is organized module-wise and day-wise, exactly how backend
development is learned in real projects.

---

## Architecture Overview

Clean layered architecture followed across all modules:

Controller  
→ Service  
→ Repository  
→ Database  

Supporting layers:
- DTO (request / response)
- Entity (JPA mapping)
- Exception (global handling)
- Config (application & security config)

---

## Modules Covered

### Spring Boot Basics
- Dependency Injection
- Constructor Injection
- Bean lifecycle
- Configuration & profiles

###  Spring MVC
- Controller & View flow
- Thymeleaf integration
- Form handling
- Path params & query params
- MVC mini project (CRUD)

### Spring REST APIs
- RESTful CRUD APIs
- JSON request/response
- DTO based APIs
- Validation
- Global exception handling
- Pagination & sorting
- Swagger API documentation
- REST mini project (Tourist Management System)

### Spring Data JPA
- Entity mapping
- One-to-Many & Many-to-One relationships
- JpaRepository
- Custom finder methods
- JPQL queries
- Pagination & File Upload
- MySQL integration
- Complete Food Order Management System (User + Admin modules)

### Spring Security (In Progress)
- Authentication & Authorization
- SecurityFilterChain
- HTTP Basic Authentication
- Securing REST APIs
- Role based access (next)

---

## Project Structure

spring-boot-learning/
│
├── springboot-basic/
│   ├── springboot-basic-day1
│   └── springboot-basic-day2
│
├── mvc-architecture/
│   ├── springboot-mvc-day1
│   ├── springboot-mvc-day2
│   ├── springboot-mvc-day3
│   ├── springboot-mvc-crud-day4
│   └── mvc-mini-project
│
├── RESTful-APIs/
│   ├── rest-day1-basics
│   ├── rest-day2-input
│   ├── rest-day3-crud
│   ├── rest-day4-json
│   ├── rest-day5-validation
│   ├── rest-day6-exception-handling
│   ├── rest-day7-integration
│   ├── rest-day8-swagger
│   ├── rest-day9-pagination-search-upload
│   └── Tourist-Management-System
│
├── Data-JPA/
│   ├── jpa-day1-basics
│   ├── jpa-day2-crud
│   ├── jpa-day3-pagination-sorting
│   ├── jpa-day4-relationships
│   ├── jpa-day5-custom-queries
│   └── Food-Order-Management-System
│
├── Spring-Security/
│   └── spring-security-day1-basic-auth
│
└── docs/

---

---

## Documentation

Detailed learning notes and explanations are maintained separately
inside the docs/ folder to keep the main README clean.

Each document contains:
- Concepts learned
- Why it is used
- How it is implemented
- Project references

docs/
│
├── springboot-basic/
│   ├── springboot-basic-day1.md
│   └── springboot-basic-day2.md
│
├── mvc-architecture/
│   ├── springboot-mvc-day1.md
│   ├── springboot-mvc-day2.md
│   ├── springboot-mvc-day3.md
│   ├── springboot-mvc-crud-day4.md
│   └── mvc-mini-project.md
│
├── RESTful-APIs/
│   ├── rest-day1-basics.md
│   ├── rest-day2-input.md
│   ├── rest-day3-crud.md
│   ├── rest-day4-json.md
│   ├── rest-day5-validation.md
│   ├── rest-day6-exception-handling.md
│   ├── rest-day7-integration.md
│   ├── rest-day8-swagger.md
│   ├── rest-day9-pagination-search-upload.md
│   └── Tourist-Management-System.md
│
├── Data-JPA/
│   ├── jpa-day1-basics.md
│   ├── jpa-day2-crud.md
│   ├── jpa-day3-pagination-sorting.md
│   ├── jpa-day4-relationships.md
│   ├── jpa-day5-custom-queries.md
│   └── Food-Order-Management-System.md
│
└── Spring-Security/
    └── spring-security-day1-basic-auth.md

---

## Learning Status

- Spring Boot Basics — Completed  
- Spring MVC — Completed  
- Spring REST APIs — Completed  
- Spring Data JPA — Completed  
- Spring Security — In Progress  

---

## Tech Stack

### Core
- Java 21
- Spring Boot 4.0.2
- Maven

### Backend Frameworks
- Spring MVC
- Spring REST APIs
- Spring Data JPA
- Spring Security (in progress)

### Tools
- MySQL
- Hibernate
- Swagger / OpenAPI
- Postman
- Git & GitHub


---

## Purpose
- Build strong backend fundamentals
- Learn Spring Boot the right industry way
- Maintain a clean, professional GitHub portfolio
- Prepare for backend internships & placements

---

## Note

This repository is backend-focused.  
Frontend, JWT, OAuth2, and production security setups are added gradually
as part of advanced modules.