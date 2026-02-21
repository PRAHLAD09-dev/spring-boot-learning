# Spring Security — Day 4 (JWT Authentication)

This module focuses on implementing JWT-based authentication
using Spring Boot and Spring Security.

The objective of this day is to move from stateful security
(session / basic auth) to fully stateless authentication
using JSON Web Tokens (JWT).

---

## What I Implemented

- JWT token generation on successful login
- JWT token validation for secured APIs
- Stateless authentication using JWT
- Custom JwtAuthenticationFilter
- Role-based authorization using JWT claims
- Password encryption using BCryptPasswordEncoder
- Database-backed authentication using JPA

---

## JWT Authentication Flow

1. User registers using signup API
2. Password is encrypted using BCrypt and stored in database
3. User logs in using email and password
4. On successful login, JWT token is generated
5. Client stores the JWT token
6. Token is sent in every request using Authorization header
7. JwtAuthenticationFilter validates the token
8. User is authenticated for protected APIs

---

## Token Usage

JWT token must be sent in request header:

Authorization: Bearer <JWT_TOKEN>

Without a valid token, protected APIs return 401 Unauthorized.

---

## API Endpoints

### Public APIs (No Authentication Required)

POST /api/auth/signup  
Registers a new user with encrypted password.

POST /api/auth/login  
Authenticates user and returns JWT token.

---

### Protected User APIs (JWT Required)

GET /api/users/{id}  
Fetch user details using JWT authentication.

PUT /api/users/{id}  
Update user email or password.

PUT /api/users/{id}/reset-password  
Reset user password securely.

---

## Security Configuration Highlights

- CSRF disabled (REST API use-case)
- Session management disabled (stateless)
- JWT filter added before UsernamePasswordAuthenticationFilter
- Role-based access control using Spring Security
- Passwords stored only in encrypted format

---

## Components Implemented

- SecurityConfig (JWT-based security rules)
- JwtUtil (Token generation & validation)
- JwtAuthenticationFilter (Token verification)
- CustomUserDetailsService (Load user from DB)
- AuthController (Signup & Login APIs)
- UserController (Protected APIs)

---

## Database Details

- Database: MySQL
- User credentials stored securely
- Passwords encrypted using BCrypt
- Roles stored and extracted via JWT

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (io.jsonwebtoken)
- MySQL
- BCrypt Password Encoder
- Maven
- Postman

---

## Key Learnings

- Difference between stateful and stateless authentication
- How JWT works internally
- How Spring Security processes JWT tokens
- Why JWT is preferred for REST APIs
- Secure password handling using BCrypt
- Custom security filter integration

---

## Project Status

Spring Security Day 4 Completed  
(JWT-based Stateless Authentication)