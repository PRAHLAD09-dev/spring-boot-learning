# Spring Boot Basics — Day 2

## What I did
- Implemented interface-based service architecture
- Created multiple delivery service implementations
- Used constructor-based dependency injection
- Simulated a real-world Amazon order processing flow
- Selected delivery partner dynamically at runtime

---

## Key Concepts

### Interface-Based Design
- Defined a common delivery interface
- Enabled loose coupling between services
- Allowed easy switching between implementations

### Strategy Pattern
- Used multiple delivery partners (FedEx, Amazon, FirstFlight)
- Selected delivery strategy at runtime
- Followed real-world business use case design

### Dependency Injection
- Used constructor-based dependency injection
- Spring injected the required delivery service automatically
- Improved testability and maintainability

### Service Layer Separation
- Business logic placed inside @Service classes
- Clear separation between execution flow and logic
- Followed clean architecture principles

---

## Output
- Delivery service beans created successfully
- Correct delivery partner selected dynamically
- Order processed and delivered successfully
- Console logs verified strategy pattern execution

---

## Tools
- Spring Boot
- Maven
- Java 21

---

## Status
Status: Day 2 Completed