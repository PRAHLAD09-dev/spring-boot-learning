# Spring Boot REST — Day 4 (JSON Response Wrapper)

Today I focused on improving REST API design by introducing
a clean and consistent JSON response structure using a wrapper DTO.

---

## What I Built
- Custom API response wrapper (ApiResponse)
- Clean and readable JSON responses
- Standard response format for all APIs
- Improved REST API consistency

---

## Project Structure
- controller → UserController
- service → UserService
- model → User
- dto → ApiResponse

---

## APIs Implemented
- GET /api/users
- GET /api/users/{id}
- POST /api/users

(All APIs return wrapped JSON responses)

---

## Response Format
Each API follows a standard structure:

{
  "status": "success",
  "message": "User list fetched",
  "data": {}
}
---

## Layers Used
- Controller
- Service
- Model
- DTO (Response Wrapper)

---

## Concepts Practiced
- Java → JSON conversion
- JSON → Java conversion
- DTO (Response Wrapper)
- Wrapper-based API responses
- Clean REST response design
- In-memory data handling

---

## REST Flow
Client  
→ REST Controller  
→ Service Layer  
→ ApiResponse (DTO)  
→ JSON Response

---

## Tools Used
- Spring Boot
- Spring Web
- Maven
- Java 21
- Postman

---

## Status
REST Day 4 Completed