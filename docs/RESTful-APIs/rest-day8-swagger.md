## Spring Boot REST — Day 8 (Swagger / OpenAPI Documentation)

Today I integrated Swagger (OpenAPI) to automatically document REST APIs built in previous days.

---

## What I built
- Swagger UI integration for REST APIs
- Automatic API documentation using OpenAPI 3
- Request & Response DTOs visible in Swagger UI
- Validation and exception responses reflected in API docs
- Clean API exploration without Postman dependency

---

## Project Structure
- controller
  - UserController
- service
  - UserService
- model
  - User
- dto
  - UserRequestDto
  - UserResponseDto
  - ErrorResponseDto
- exception
  - GlobalExceptionHandler
- config
  - Swagger / OpenAPI auto-configuration (springdoc)

---

## Swagger Details
- Swagger UI URL  
  /swagger-ui/index.html

- OpenAPI JSON  
  /v3/api-docs

- APIs are grouped automatically based on controllers
- Request body schema generated from DTOs
- Validation errors visible as 400 responses
- Exception responses visible with proper status codes

---

## APIs Documented
- POST   /api/users
- GET    /api/users
- GET    /api/users/{id}

(All APIs were implemented earlier; this day focuses only on documentation)

---

## Concepts Practiced
- OpenAPI 3
- Swagger UI
- API documentation best practices
- DTO-based schema generation
- Validation + Exception visibility in Swagger
- Separation of documentation and business logic

---

## Layers Used
- Controller
- Service
- Model
- DTO
- Exception
- Documentation (Swagger)

---

## Tools & Tech
- Spring Boot
- springdoc-openapi
- Swagger UI
- Java 21
- Maven

---

## Status

REST Day 8 Completed