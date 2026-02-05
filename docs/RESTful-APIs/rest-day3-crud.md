# Spring Boot REST — Day 3 (CRUD)

Today I implemented complete CRUD REST APIs using Spring Boot with a
proper Controller → Service → Model flow.

---

## What I Built
- REST controller with full CRUD endpoints
- Service layer for business logic
- In-memory data handling (no database)
- JSON request and response handling
- API testing using Postman

---

## APIs Implemented

- POST /api/users
  - Create a new user

- GET /api/users
  - Get all users

- GET /api/users/{id}
  - Get user by ID

- PUT /api/users/{id}
  - Update existing user

- DELETE /api/users/{id}
  - Delete user by ID

---

## Layers Used
- Controller
- Service
- Model

---

## Model
- User
  - id
  - name
  - email

---

## Concepts Practiced
- @RestController
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @RequestBody
- @PathVariable
- JSON ↔ Java object mapping
- RESTful API design
- Controller → Service flow

---

## REST Flow
Client (Postman / API call)  
→ REST Controller  
→ Service Layer  
→ In-memory Data  
→ JSON Response

---

## Tools Used
- Spring Boot
- Spring Web
- Maven
- Java 21
- Postman

---

## Status
REST Day 3 (CRUD) Completed