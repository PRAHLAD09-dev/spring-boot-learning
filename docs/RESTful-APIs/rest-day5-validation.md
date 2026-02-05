# Spring Boot REST — Day 5 (Request Validation)

On Day 5, I implemented request validation in REST APIs using Spring Boot Bean Validation to ensure clean and safe input handling.

---

## Objective
To prevent invalid data from reaching the service layer by validating request payloads at the controller level.

---

## What I Implemented
- Bean Validation on REST request bodies
- Automatic validation trigger using @Valid
- Structured error handling for invalid inputs
- Clean API responses using a response wrapper
- Validation testing using Postman

---

## Validation Rules Applied
- id → must not be null
- name → must not be blank
- email → must follow valid email format

---

## API Endpoints Validated
- POST /api/users → Create user with validation
- GET /api/users → Fetch all users

---

## Validation Flow
Client Request  
- Controller (@Valid)  
- Bean Validation checks  
- Validation Error → 400 Bad Request  
-  Valid Data → Service Layer  
- Response Wrapper → Client

---

## Key Annotations Used
- @Valid
- @NotNull
- @NotBlank
- @Email
- @RequestBody

---

## Layers Involved
- Controller – Handles validation and request mapping
- Service – Business logic
- Model – Request data structure
- DTO – Standard API response format

---

## Tools & Tech
- Spring Boot
- Bean Validation (Jakarta Validation)
- Postman
- Java 21

---

## Outcome
- Invalid requests are rejected automatically
- Cleaner controller logic
- More robust and production-ready REST APIs

---

## Status
REST Day 5 – Validation Completed 