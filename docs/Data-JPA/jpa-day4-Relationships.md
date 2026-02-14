## Spring Boot Data JPA — Day 4 (Entity Relationships)

Today I implemented JPA entity relationships using Spring Data JPA with proper cascade handling and orphan removal.

---

### What I built
- One-to-Many relationship using Spring Data JPA
- Parent–child entity mapping (User → Orders)
- Bidirectional relationship handling
- Cascade operations for automatic persistence
- Orphan removal for safe child deletion
- Transactional service logic
- Global exception handling for missing resources

---

### Relationship Design
- One User can have multiple Orders
- Each Order belongs to exactly one User
- User is the owning side of the relationship lifecycle

---

### Example Scenario
- A user is created
- Orders are added to the user
- Orders are saved automatically using cascade
- Removing an order deletes it from database using orphan removal
- No manual SQL required

---

### JPA Annotations Used
- @Entity
- @Id
- @GeneratedValue
- @OneToMany
- @ManyToOne
- @JoinColumn
- cascade = CascadeType.ALL
- orphanRemoval = true
- @Transactional

---

### APIs Implemented
- POST   /api/users  
  → Create a new user

- POST   /api/users/{id}/orders  
  → Add order to existing user

- GET    /api/users  
  → Fetch all users with orders

- GET    /api/users/{id}  
  → Fetch single user with orders

- DELETE /api/users/{userId}/orders/{orderId}  
  → Remove order from user

---

### Layers Used
- Controller  
- Service  
- Repository (JPA)  
- Entity  
- Exception  

---

### Key Learning
- Parent entity controls child lifecycle
- Cascade automatically saves related entities
- Orphan removal safely deletes child records
- Foreign key must be set in service layer
- Service layer manages relationship logic
- Controller remains thin and clean

---

### Tools & Tech
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Java 21
- Maven

---

### Status
JPA Day 4 Completed