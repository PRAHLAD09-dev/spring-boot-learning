
## Spring Boot REST — Day 6 (Exception Handling)

Today I implemented DTO-based REST APIs with centralized exception handling in Spring Boot.

---

## What I built
- Request DTO and Response DTO based REST APIs
- Centralized exception handling using @ControllerAdvice
- Custom exception for business logic errors
- Proper HTTP status codes for REST errors
- Clean and consistent JSON error responses

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
  - UserNotFoundException

---

## Exception Handling Implemented
- User not found → 404 Not Found
- Invalid request / bad data → 400 Bad Request
- Centralized error handling (no try-catch in controller)
- Standard JSON error response for all failures

---

## Error Response Format
`json
{
    "status": 404,
    "error": "NOT_FOUND",
    "message": "User not found with id: 999",
    "timestamp": "2026-02-05T21:23:54.7333259"
}


---

### Concepts Practiced

- Request DTO vs Response DTO
- @RestController
- @ControllerAdvice
- @ExceptionHandler
- Custom RuntimeException
- REST error handling best practices
- Controller → Service → Exception flow

---

### APIs Covered
- POST   /api/users
- GET    /api/users
- GET    /api/users/{id}

---

### Layers Used

- Controller
- Service
- Model
- DTO
- Exception

---

## Tools & Tech
- Spring Boot
- Bean Validation (Jakarta Validation)
- Postman
- Java 21

---

### Status

REST Day 6 Completed 