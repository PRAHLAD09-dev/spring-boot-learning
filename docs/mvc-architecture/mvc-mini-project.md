# Spring Boot MVC — Day 5 (Mini Project)

Today I built a complete Spring Boot MVC Mini Project implementing a User Management System using clean layered architecture.

---

## What I built
- Full User Management System
- CRUD operations with validation
- Search and filter functionality
- Clean Controller → Service → Model architecture
- In-memory data storage (No database yet)

---

## Features Implemented
- User Registration (Create)
- View All Users (Read)
- Edit User Details (Update)
- Delete User (Delete)
- Search Users (Filter)
- Server-side validation using Spring Boot

---

## Controllers Implemented
- UserController

---

## Service Layer
- UserService
- Business logic separated from controller
- Clean service-based architecture

---

## Model
- User
  - id
  - name
  - email
  - validation annotations (Jakarta Validation)

---

## Pages (Views)
- home.html      → Entry page
- register.html  → Add user form
- list.html      → Display all users
- edit.html      → Update user details

---

## Architecture
Controller  
→ Service  
→ Model  
→ Thymeleaf View  

---

## Key Concepts Practiced
- Spring MVC Routing
- @Controller, @GetMapping, @PostMapping
- @PathVariable
- @RequestParam
- @ModelAttribute
- Form validation (@Valid)
- Thymeleaf templating
- CRUD workflow in MVC
- Clean layered backend architecture

---

## MVC Flow
Request  
→ Controller  
→ Service  
→ Model  
→ Thymeleaf View  
→ Response (HTML)

---

## Tools
- Spring Boot
- Thymeleaf
- Maven
- Java 21

---

## Status
MVC Mini Project Day 5 Completed