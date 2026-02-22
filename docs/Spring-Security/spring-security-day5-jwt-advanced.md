# Spring Security — Day 5 (JWT Authentication + Role Based Access)

This module focuses on implementing JWT based authentication
with role based authorization using Spring Boot and Spring Security.

The main goal of this day was to secure REST APIs using JWT tokens
and understand how authentication and authorization work together
in a stateless backend system.

---

## What I Implemented Today

- User signup with email, password and role
- Password encryption using BCryptPasswordEncoder
- User login with email and password
- JWT access token generation after successful login
- Custom JwtAuthenticationFilter implementation
- Token validation on every secured request
- SecurityContextHolder based authentication
- Role based authorization (ROLE_USER / ROLE_ADMIN)
- Protected APIs using roles
- Stateless session configuration
- CSRF disabled for REST APIs
- Refresh token implementation (learning purpose)
- Refresh token stored in database
- Logout functionality (basic)

---

## Authentication Flow

### Signup Flow

Client  
→ AuthController  
→ AuthService  
→ PasswordEncoder (BCrypt)  
→ Database  

- Password is encrypted before saving
- Role is stored in database
- Password is never returned in response

---

### Login Flow

Client  
→ AuthController  
→ AuthService  
→ Database  
→ Password match using BCrypt  
→ JWT Access Token generated  

- Email is used as username
- Password is matched using BCrypt
- On success, JWT token is returned

---

### JWT Validation Flow

Client  
→ Sends Authorization header  
→ JwtAuthenticationFilter  
→ JwtUtil validates token  
→ UserDetails loaded from database  
→ SecurityContextHolder set  

- Token is validated on every request
- No session is stored on server
- Application remains stateless

---

## Role Based Authorization

- USER role:
  - Can access user specific APIs
  - Can fetch and update own data

- ADMIN role:
  - Can access admin APIs
  - Can access all users data

Role is fetched from database and converted into
Spring Security authorities.

---

## Refresh Token (Learning)

- Refresh token generated during login
- Stored in database
- Used to generate new access token
- Logout deletes refresh token

Note:
This refresh token implementation is for learning only
and not production ready.

---

## Security Configuration Highlights

- SecurityFilterChain based configuration
- Stateless session policy
- CSRF disabled
- JWT filter added before UsernamePasswordAuthenticationFilter
- Role based endpoint protection

---

## Tech Stack Used

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- MySQL
- Hibernate
- BCrypt Password Encoder
- Maven
- Postman

---

## Key Learnings

- How JWT authentication works internally
- Difference between authentication and authorization
- Stateless security in REST APIs
- How SecurityContextHolder works
- Role based access control
- Why passwords must always be encrypted
- How custom security filters work

---

## Current Limitations

- Refresh token flow needs improvement
- Logout does not invalidate access token
- Token expiry handling is basic
- This is a learning implementation

---

## Status

Spring Security Day 5 Completed  
(JWT Authentication + Role Based Authorization)

Next:
- Improve refresh token handling
- Secure user specific data access
- Production ready JWT flow