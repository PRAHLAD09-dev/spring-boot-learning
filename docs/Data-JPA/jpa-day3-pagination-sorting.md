## Spring Boot Data JPA — Day 3 (Pagination & Sorting)

Today I implemented pagination and sorting using Spring Data JPA.

---

### What I built
- Pagination using Spring Data JPA
- Sorting support with pageable requests
- Clean GET APIs for database records
- Repository-driven data fetching
- No manual SQL queries written

---

### Project Structure
- controller
  - UserController
- service
  - UserService
- model
  - User (Entity)
- repository
  - UserRepository
- config
  - application.properties

---

### APIs Implemented
- GET /api/users?page=0&size=5 
- GET /api/users?page=0&size=5&sort=name,ascending  

---

### JPA Concepts Practiced
- Pageable
- PageRequest
- Page<T>
- Sorting with Sort
- JpaRepository pagination support

---

### Key Learning
- Pagination and sorting handled by JPA internally
- No custom query required for basic paging
- Database handles limit & offset
- Service layer controls page logic
- Controller only exposes API endpoints

---

### Tools & Tech
- Spring Boot
- Spring Data JPA
- MySQL
- Hibernate
- Java 21
- Maven

---

### Status
JPA Day 3 Completed 