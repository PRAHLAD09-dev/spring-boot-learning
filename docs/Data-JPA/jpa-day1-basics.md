## Spring Boot Data JPA — Day 1 (JPA Basics)

Today I started Spring Data JPA and connected Spring Boot with MySQL database.

---

### What I built
- Spring Boot + MySQL integration
- JPA entity mapping using Hibernate
- Repository layer using Spring Data JPA
- Automatic table creation without writing SQL
- Basic data persistence verification

---

### Project Structure
- model
  - User (Entity)
- repository
  - UserRepository
- config
  - application.properties
- runner
  - CommandLineRunner for test data

---

### JPA Concepts Practiced
- @Entity
- @Id
- @GeneratedValue
- @Column
- JpaRepository
- Hibernate auto DDL
- Entity → Table mapping
- Repository abstraction

---

### Database Configuration
- MySQL database
- Hibernate used as JPA provider
- Tables created automatically using:
  spring.jpa.hibernate.ddl-auto=update

---

### Key Learning
- No SQL queries written
- No manual table creation required
- Repository layer handles CRUD operations
- Entity represents database structure
- Spring Data JPA reduces boilerplate code

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
JPA Day 1 Completed