## Spring Boot Data JPA — Day 5 (Custom Finder & Queries)

Today I implemented custom finder methods, JPQL queries, and native SQL queries
using Spring Data JPA to build flexible search and filter APIs.

---

### What I built
- Custom finder methods using Spring Data JPA
- JPQL-based queries using @Query
- Native SQL queries for advanced use cases
- Keyword-based search APIs
- Price-based filtering and range queries
- Clean Controller → Service → Repository architecture

---

### Domain Model
- Vaccine
  - id
  - name
  - company
  - price

Entity mapped directly to database table using JPA annotations.

---

### Query Features Implemented
- Search by exact field values
- Case-insensitive keyword search
- Price comparison queries
- Range-based filtering
- Native SQL execution through repository

---

### APIs Implemented

- GET   /api/vaccines/name?name=Covaxin  
  → Find vaccines by name

- GET   /api/vaccines/company?company=Bharat  
  → Find vaccines by company

- GET   /api/vaccines/above?price=500  
  → Find vaccines with price greater than given value

- GET   /api/vaccines/search?keyword=co  
  → Search by name or company using JPQL

- GET   /api/vaccines/range?min=300&max=800  
  → Find vaccines within price range

- GET   /api/vaccines/native?name=Covishield  
  → Native SQL query example

---

### JPA Annotations & Concepts Used
- @Entity
- @Id
- @GeneratedValue
- JpaRepository
- Derived query methods
- @Query (JPQL)
- Native queries
- Repository abstraction
- No manual SQL for standard operations

---

### Architecture Used
Controller  
↓  
Service  
↓  
Repository (Spring Data JPA)  
↓  
Database (MySQL)

---

### Key Learning
- Spring Data JPA generates queries automatically
- JPQL allows entity-based querying
- Native queries give full SQL control when needed
- Repository layer keeps data access clean
- Service layer handles business logic only
- Controller remains thin and request-focused

---

### Tools & Tech
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Java 21
- Maven
- Postman

---

### Status
JPA Day 5 Completed