# Spring Boot MVC — Day 2

Today I implemented form handling in Spring Boot MVC using Controller, Service layer, Model, and Thymeleaf integration.

---

## What I Built
- User registration form (Name + Email)
- Form submission using POST request
- Request parameter handling using @RequestParam
- Service layer for business logic
- Success page rendering with dynamic data
- Proper MVC flow (Controller → Service → View)

---

## Controllers Implemented
- UserController  
  - Handles form display
  - Handles form submission using POST mapping

---

## Service Layer
- UserService  
  - Contains business logic for user registration
  - Keeps controller clean and focused only on request handling

---

## Model
- User  
  - Simple model class containing:
    - name
    - email
  - Used to transfer data between layers

---

## Pages (Views)
- register.html  
  - User registration form
- success.html  
  - Displays registered user details and success message

---

## Request Parameter Handling
- Used @RequestParam to fetch form data from HTTP requests
- Individual form fields (name, email) are mapped directly to controller method parameters
- Suitable for simple forms with limited fields

Example Flow:
Form (HTML)  
→ POST request  
→ @RequestParam  
→ Controller  
→ Service  
→ Model  
→ Thymeleaf View

---

## MVC Flow 
Request  
→ Controller (@PostMapping)  
→ Request Parameters (@RequestParam)  
→ Service Layer (business logic)  
→ Model (data)  
→ Thymeleaf View  
→ Response (HTML)

---

## Concepts Practiced
- @Controller
- @GetMapping
- @PostMapping
- @RequestParam
- Service layer architecture
- Model data passing
- Controller → Service → View separation
- Thymeleaf form handling
- MVC request lifecycle

---

## Tools Used
- Spring Boot
- Thymeleaf
- Maven
- Java 21

---

## Status
MVC Day 2 Completed