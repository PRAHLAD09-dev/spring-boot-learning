# Spring Boot REST — Day 2

Today I focused on handling different types of input in REST APIs using
Spring Boot.

---

## What I Built
- POST API to accept JSON input
- Path Variable handling in REST endpoints
- Query Parameter handling
- JSON input mapped to Java object

---

## APIs Created

- POST /api/user
  - Accepts JSON body
  - Converts JSON → Java object using @RequestBody

- GET /api/user/{name}
  - Uses Path Variable to read dynamic URL data

- GET /api/search?keyword=
  - Uses Query Parameter for search input

---

## Model
- User
  - id
  - name
  - email

---

## Concepts Practiced
- @PostMapping
- @RequestBody
- @PathVariable
- @RequestParam
- JSON input handling
- REST input processing

---

## REST Flow
Client Request (JSON / URL params)  
→ REST Controller  
→ Java Object  
→ JSON Response

---

## Tools Used
- Spring Boot
- Spring Web
- Maven
- Java 21

---

## Status
REST Day 2 Completed