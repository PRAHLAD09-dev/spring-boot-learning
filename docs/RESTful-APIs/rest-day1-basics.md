# Spring Boot REST — Day 1

Today I implemented basic Spring Boot REST concepts focusing on REST controllers
and JSON responses.

---

## What I Built
- Simple REST API using Spring Boot
- GET endpoints returning different types of responses
- Java object to JSON conversion
- Custom JSON response structures
- Live server-time API response

---

## Controllers Implemented
- HelloController

---

## APIs Created

- GET /api/hello
  - Returns plain text response

- GET /api/user
  - Returns Java object as JSON

- GET /api/time
  - Returns custom JSON with live server time

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
- @RequestMapping
- Java → JSON conversion (Jackson)
- Returning custom JSON responses
- REST API fundamentals

---

## REST Flow
Client Request  
→ REST Controller  
→ Java Object / Map  
→ JSON Response

---

## Tools Used
- Spring Boot
- Spring Web
- Maven
- Java 21

---

## Status
REST Day 1 Completed