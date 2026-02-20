# Spring Security — Day 3 (Database Authentication)

This module focuses on implementing database-backed authentication
using Spring Boot, Spring Security, and JPA.

The main goal of this day is to move from in-memory authentication
to real database-based user authentication.

---

## What I Implemented

- User signup using MySQL database
- Password encryption using BCryptPasswordEncoder
- User login with email and password
- Fetching user details from database
- Basic role handling (USER / ADMIN)
- Proper exception handling
- Layered architecture (Controller, Service, Repository)

---

## Database Setup

- Database: MySQL
- Database Name: security_db
- Table: users

Passwords are never stored in plain text.
They are encrypted using BCrypt before saving into the database.

---

## Authentication Flow

### Signup Flow

Client → Controller → Service → Password Encoder → Database

- Password is encoded before saving
- Safe response is returned (password never exposed)

---

### Login Flow

Client → Controller → Service → Database → Password Match

- User is fetched using email
- Password is verified using BCrypt
- Invalid credentials return Bad Request error

---

## API Endpoints

This project exposes REST APIs for user authentication and
password security using database-backed authentication.

---

### Authentication APIs

POST /api/auth/signup  
Registers a new user.  
Password is encrypted using BCrypt before saving to database.

POST /api/auth/login  
Authenticates user using email and password.  
Password is verified using BCrypt password matching.


PUT /api/auth/reset-password

Resets user password using email.
This API is useful when user forgets password.

New password is encrypted using BCrypt before saving
to the database.

---

### User APIs

GET /api/users/{id}  
Fetch user details by user ID.

PUT /api/users/{id}/password  
Update or reset user password.  
New password is encrypted before storing.

---

## Sample Request Payloads

### Signup Request
{
  "name": "Prahlad Bhakat",
  "email": "prahlad@gmail.com",
  "password": "password123",
  "role": "USER"
}
### Login Request
{
  "email": "prahlad@gmail.com",
  "password": "password123"
}

### Reset Password Request
{
  "email": "prahlad@gmail.com",
  "newPassword": "newStrongPassword123"
}

---

## Security Flow

- User registers using signup API
- Password is encrypted using BCryptPasswordEncoder
- Encrypted password is stored in database
- During login, raw password is matched with encrypted password
- Authentication succeeds only if password matches

## Reset Password Flow

- User sends email and new password
- User is fetched from database using email
- New password is encrypted using BCryptPasswordEncoder
- Old password is replaced with encrypted new password
- Updated password is stored in database

---

## Exception Handling

Centralized exception handling is implemented using @ControllerAdvice.

Handled scenarios:
- Invalid login credentials
- User not found
- Duplicate email registration
- Validation errors

All errors return meaningful HTTP status codes
with proper JSON responses.

---
## Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- BCrypt Password Encoder
- Maven
- Postman

---

## Key Learnings

- How Spring Security works internally
- Difference between authentication and authorization
- Why passwords should never be stored in plain text
- How BCrypt hashing and matching works
- Database-backed authentication using JPA
- Centralized exception handling using @ControllerAdvice
- Clean separation of Controller, Service, Repository and DTO layers

---

## Current Security Scope

- Password encryption using BCrypt
- Secure password verification during login
- Basic authentication logic (no JWT yet)
- Database-backed user authentication

Note:
This module focuses only on password security
and authentication basics, not full authorization.

---

## Project Status

 Spring Security Day 3 Completed  
(Database-backed authentication with encrypted passwords)

---
