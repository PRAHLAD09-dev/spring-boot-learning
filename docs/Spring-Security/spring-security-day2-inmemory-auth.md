# Spring Security — Day 2 (In-Memory Authentication)

This module covers Spring Security fundamentals with in-memory authentication
for securing REST APIs.  
It focuses on understanding how Spring Security works internally
before moving to database and JWT-based security.

---

## What I Implemented

- Spring Security configuration using SecurityFilterChain
- In-memory authentication with hardcoded users
- Password encryption using BCryptPasswordEncoder
- Role-based authorization (USER / ADMIN)
- HTTP Basic Authentication for REST APIs
- Stateless security configuration (no sessions)

---

## Authentication Setup

### In-Memory Users

| Username | Password | Role  |
|--------|---------|------|
| user   | user123 | USER |
| admin  | admin123 | ADMIN |

Passwords are encrypted using BCrypt.

---

## Authorization Rules

| Endpoint Pattern        | Access |
|------------------------|--------|
| /api/public/**       | Public (No Auth) |
| /api/user/**         | USER, ADMIN |
| /api/admin/**        | ADMIN only |
| Any other endpoint     | Authenticated |

---

## API Endpoints

### Public
- GET /api/public/health  
  → No authentication required

### User
- GET /api/user/dashboard  
  → Requires USER or ADMIN role

### Admin
- GET /api/admin/dashboard  
  → Requires ADMIN role only

---

## Security Configuration Highlights

- CSRF disabled (REST APIs)
- HTTP Basic authentication enabled
- Role-based access control
- Stateless design (no server-side session storage)

---

## Concepts Learned

- What is SecurityFilterChain
- How Spring Security intercepts requests
- Difference between authentication and authorization
- Role-based endpoint protection
- Why BCrypt is used for passwords
- Stateless security for REST APIs

---

## Tech Stack

- Java
- Spring Boot
- Spring Security
- BCrypt Password Encoder
- Maven

---

## Status

 Spring Security Day 2 Completed  
(In-Memory Authentication & Authorization)

Next:
➡ Database-backed authentication  
➡ JWT-based security