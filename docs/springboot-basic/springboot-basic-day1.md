# Spring Boot Basics — Day 1

## What I did
- Created Spring Boot project using Spring Initializr
- Understood Spring Boot startup flow
- Implemented service layer
- Used constructor-based dependency injection
- Used configuration class with @Bean
- Executed logic at startup using CommandLineRunner

---

## Key Concepts

### Spring Boot Startup
- Application starts from main()
- Spring creates ApplicationContext
- Beans are scanned and initialized automatically

### Service Layer
- Used @Service for business logic
- Keeps logic separate from configuration and startup code

### Dependency Injection
- Used constructor-based injection
- Recommended approach (safe, testable, clean)

### Configuration & Beans
- Used @Configuration and @Bean
- Explicit bean creation and control

### CommandLineRunner
- Runs code after application startup
- Used to test bean creation and logic execution
- Verified bean creation and execution order via console logs

---

## Output
- Beans created successfully
- Greeting message printed on startup

---

## Tools
- Spring Boot
- Maven
- Java 21

---

## Status
Status: Day 1 Completed