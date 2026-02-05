# Spring Boot MVC — Day 4 (CRUD Module)

Today I implemented a complete CRUD (Create, Read, Update, Delete) module using Spring Boot MVC and Thymeleaf.

---

## What I built
- User registration (Create)
- Display all users (Read)
- Update existing user details (Update)
- Delete user (Delete)
- In-memory data storage (No database yet)
- Proper MVC layered architecture

---

## Controllers Implemented
- UserController

---

## Features Implemented
- Create new user
- List all users
- Edit user details
- Delete user
- Navigation between CRUD pages
- Controller → Model → View flow

---

## Model
- User
  - id
  - name
  - email

---

## Pages (Views)
- register.html   → Add new user
- list.html       → Display all users
- edit.html       → Update user details

---

## CRUD Flow
Create → Register User  
Read   → View User List  
Update → Edit User  
Delete → Remove User  

---

## Key Concepts Practiced
- Spring MVC Controllers
- @GetMapping / @PostMapping
- @PathVariable
- @ModelAttribute
- Thymeleaf templating
- MVC architecture
- CRUD workflow in MVC

---

## MVC Flow
Request  
→ Controller  
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
MVC CRUD Day 4 Completed