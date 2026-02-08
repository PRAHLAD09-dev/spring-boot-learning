## Spring Boot REST — Day 9 (Pagination, Search & File Upload)

Today I implemented pagination, search filtering, and file upload functionality
in REST APIs while strictly following clean layered architecture.

---

## What I built
- Pagination using page and size query parameters
- Search / filter support using keyword parameter
- Profile image upload API using multipart/form-data
- DTO-based request and response handling
- Centralized global exception handling
- In-memory data storage (no database, no JPA)
- Clean Controller → Service → DTO architecture

---

## Project Structure
- controller
  - UserController
- service
  - UserService
  - FileService
- model
  - User
- dto
  - UserRequestDto
  - UserResponseDto
  - PageResponseDto
- exception
  - UserNotFoundException
  - FileUploadException
  - GlobalExceptionHandler

---

## APIs Covered
- POST   /api/users
- GET    /api/users?page=0&size=5&keyword=name
- POST   /api/users/{id}/upload

---

## Pagination Response Format
`json
{
  "content": [
    {
      "id": 1,
      "name": "Prahlad",
      "email": "prahlad@gmail.com",
      "profileImage": "uploads/profile.png"
    }
  ],
  "page": 0,
  "size": 8,
  "totalElements": 10,
  "totalPages": 2
}

---

## Concepts Practiced
- Pagination logic (page & size)
- Search and filtering
- Multipart file upload handling
- DTO mapping and immutability
- Global exception handling
- REST API best practices
- Clean layered backend design

---

## Layers Used
- Controller
- Service
- Model
- DTO
- Exception

---

## Tools & Tech
- Spring Boot
- Spring REST APIs
- Swagger / OpenAPI
- Postman
- Java 21
- Maven

---

## Status

REST Day 9 Completed