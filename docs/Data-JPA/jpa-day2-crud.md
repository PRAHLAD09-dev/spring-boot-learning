## Spring Boot Data JPA — Day 2 (CRUD Operations)

Today I implemented complete CRUD operations using Spring Data JPA with MySQL database.

---

## What I built
- REST APIs connected with MySQL database
- Full CRUD operations using Spring Data JPA
- Service layer for business logic
- Repository layer for database access
- Entity mapping using Hibernate (no SQL queries)

---

## Architecture Used

Controller  
↓  
Service  
↓  
Repository (JPA)  
↓  
Database (MySQL)

---

## Layers Implemented

### 1. Entity Layer
- User
- Represents database table

Annotations used:
- @Entity
- @Id
- @GeneratedValue
- @Column

---

### 2. Repository Layer
- UserRepository
- Extends JpaRepository<User, Long>

Responsibilities:
- Handles database operations
- No SQL queries written manually

Methods used:
- save()
- findAll()
- findById()
- deleteById()

---

### 3. Service Layer
- UserService
- Contains business logic
- Interacts with repository
- Keeps controller clean

Responsibilities:
- Create user
- Fetch users
- Update user
- Delete user

---

### 4. Controller Layer
- UserController
- Exposes REST APIs
- Delegates logic to Service layer
- Returns JSON responses

---

## CRUD APIs Implemented

| Operation | HTTP Method | Endpoint |
|---------|------------|----------|
| Create User | POST | /api/users |
| Get All Users | GET | /api/users |
| Get User by ID | GET | /api/users/{id} |
| Update User | PUT | /api/users/{id} |
| Delete User | DELETE | /api/users/{id} |

---

## JPA Concepts Practiced
- Spring Data JPA
- Repository abstraction
- Entity to table mapping
- Auto-generated primary keys
- Hibernate ORM
- Database persistence

---

## Database Configuration
- Database: MySQL
- ORM: Hibernate
- Tables created automatically using:

spring.jpa.hibernate.ddl-auto=update
---

## Key Learning
- No SQL queries required
- Repository replaces DAO layer
- Service layer handles business logic
- Controller only manages API routing
- Data persists in database (not in-memory)

---

## Tools & Tech
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate
- Java 21
- Maven
- Postman

---

## Status

JPA Day 2 Completed