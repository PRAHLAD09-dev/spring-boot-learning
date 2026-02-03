# Spring Boot Learning

This repository tracks my Spring Boot learning journey for backend development.

## Spring Boot Basics

### (DAY 1)
Covered:
- Spring Boot project setup
- @Service and business layer
- Constructor-based Dependency Injection
- @Configuration and @Bean usage
- Time-based greeting example
- CommandLineRunner execution

Status: Completed (Day 1)

### (DAY 2)
Covered:
- Interface-based service architecture
- Amazon Delivery business use case
- Multiple delivery partners (strategy pattern)
- Constructor-based Dependency Injection
- Service layer separation (business logic)
- Real-world order processing simulation

Status: Completed (Day 2)

## Spring Boot MVC — Day 1

Today I implemented a basic Spring Boot MVC project using Thymeleaf.

### What I built
- Multi-controller MVC structure
- Class-level and method-level request mapping
- Home, Profile, Dashboard and Profit pages
- Navigation between pages
- Data passing using Model
- Thymeleaf view rendering

### Controllers
- HomeController
- UserController
- AdminController

### Pages
- home.html
- profile.html
- dashboard.html
- profit.html

### Concepts Practiced
- @Controller
- @RequestMapping
- @GetMapping
- MVC flow (Controller → View)
- Thymeleaf integration

Status: MVC Day-1 Completed

### DAY 2 — Spring Boot MVC (Forms & POST Mapping)

## Spring Boot MVC — Day 2

Today I implemented Spring Boot MVC form handling using Controller, Service Layer, and Model with Thymeleaf integration.

### What I built
- User registration form (Name + Email)
- POST request handling using @PostMapping
- Service layer for business logic processing
- Model class for form data (User entity)
- Form data binding using @ModelAttribute
- Dynamic success page rendering
- Navigation between register and success pages
- Thymeleaf form and data rendering

### Controllers
- UserController

### Service Layer
- UserService

### Model
- User (Name, Email)

### Pages
- register.html
- success.html

### Concepts Practiced
- @PostMapping
- @ModelAttribute
- Service layer architecture
- Model class usage (DTO / Entity)
- Form submission in Spring MVC
- MVC flow (Controller → Service → View)
- Thymeleaf form handling

Status: MVC Day-2 Completed

## Spring Boot MVC — Day 3

Today I implemented advanced Spring Boot MVC concepts including routing, validation, and model binding.

### What I built
- Path Parameter example (/user/profile/{name})
- Query Parameter example (/user/search?keyword=...)
- User registration form with validation
- Form binding using @ModelAttribute
- Server-side validation using Jakarta Validation
- Success page after valid form submission

### Controllers
- UserController

### Model
- User (name, email) with validation annotations

### Pages
- register.html
- success.html
- profile.html
- search.html

### Concepts Practiced
- @PathVariable
- @RequestParam
- @ModelAttribute
- Form validation (@Valid)
- BindingResult error handling
- Spring MVC routing flow (Controller → View)

Status: MVC Day-3 Completed

## Spring Boot MVC — Day 4 (CRUD Module)

In Day 4, I implemented a full CRUD (Create, Read, Update, Delete) system using Spring Boot MVC and Thymeleaf.

### Features Implemented
- User Registration (Create)
- List All Users (Read)
- Edit User Details (Update)
- Delete User (Delete)
- In-memory data storage (No database yet)
- MVC architecture with Controller and Model
- Thymeleaf page rendering

### Pages Created
- register.html — Add user form
- list.html — Display all users
- edit.html — Update user details

### Key Concepts Practiced
- Spring MVC Controllers
- @GetMapping and @PostMapping
- PathVariable usage
- Model attribute binding
- Thymeleaf templating
- CRUD workflow in MVC

Status: MVC CRUD Completed

## Spring Boot MVC — Day 5 (Mini Project)

Built a complete Spring Boot MVC Mini Project implementing a User Management System.

### Features Implemented
- User Registration (Create)
- View All Users (Read)
- Edit User Details (Update)
- Delete User (Delete)
- Search Users (Filter)
- Validation using Spring Boot
- Service Layer for business logic
- Clean MVC architecture (Controller → Service → Model)
- In-memory storage (No database yet)

### Pages Included
- home.html — Entry page
- register.html — Add user form
- list.html — Display all users
- edit.html — Update user details

### Key Concepts Practiced
- Spring MVC Routing
- @Controller, @GetMapping, @PostMapping
- Model data binding
- Validation (Jakarta Validation)
- Thymeleaf templating
- CRUD workflow
- Clean layered backend architecture

Status: MVC Mini Project Completed

## Spring Boot REST — Day 1

Today I implemented basic Spring Boot REST concepts including REST controllers and JSON responses.

### What I built
- Simple REST API using Spring Boot
- GET endpoint returning plain text
- Java Object → JSON API response
- Custom JSON response using Map
- Live time API response

### Controllers
- HelloController

### Model
- User (id, name, email)

### APIs Created
- GET /api/hello → Simple text response  
- GET /api/user → Java object as JSON  
- GET /api/time → Custom JSON with live server time  

### Concepts Practiced
- @RestController  
- @RequestMapping  
- @GetMapping  
- Java → JSON conversion  
- Returning custom JSON response  
- REST API fundamentals  

### Status
REST Day-1 Completed

## Spring Boot REST — Day 2

Today I focused on handling input in REST APIs using Spring Boot.

### What I built
- POST API to accept JSON input
- Path Variable handling
- Query Parameter handling
- JSON input → Java object conversion

### APIs Created
- POST /api/user
- GET /api/user/{name}
- GET /api/search?keyword=

### Concepts Practiced
- @PostMapping  
- @RequestBody  
- @PathVariable  
- @RequestParam  
- JSON input handling  

### Status
REST Day-2 Completed

## Spring Boot REST — Day 3

Today I implemented REST CRUD APIs using Spring Boot.

### What I built
- REST controller with CRUD endpoints
- Service layer for business logic
- In-memory data handling (no database)
- JSON request & response handling
- API testing using Postman

### APIs Implemented
- POST   /api/users        → Create user
- GET    /api/users        → Get all users
- GET    /api/users/{id}   → Get user by id
- PUT    /api/users/{id}   → Update user
- DELETE /api/users/{id}   → Delete user

### Layers Used
- Controller
- Service
- Model

### Concepts Practiced
- @RestController
- @RequestMapping
- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping
- @RequestBody
- @PathVariable
- JSON ↔ Java Object mapping
- RESTful API design
- Controller → Service flow

### Tools
- Spring Boot
- Postman

Status: REST Day 3 Completed
## Spring Boot REST — Day 4

Today I focused on Java ↔ JSON handling and clean API response design in Spring Boot.

### What I built
- Custom API response structure
- Wrapper-based JSON responses
- Clean and consistent API output
- Improved readability of REST responses

### APIs Enhanced
- GET    /api/users
- GET    /api/users/{id}
- POST   /api/users

### Response Structure
- status
- message
- data

### Layers Used
- Controller
- Service
- Model
- DTO (Response Wrapper)

### Concepts Practiced
- Java → JSON conversion
- JSON → Java conversion
- Wrapper response pattern
- Nested JSON structure
- In-memory data flow (POST → GET)

### Tools
- Spring Boot
- Postman

Status: REST Day 4 Completed

## Spring Boot REST — Day 5

Today I implemented validation in REST APIs using Spring Boot.

### What I built
- Input validation using Bean Validation
- Validation rules on request body
- Automatic 400 Bad Request on invalid input
- Tested validation errors using Postman

### Validation Rules
- id must not be null
- name must not be blank
- email must be valid email format

### Concepts Practiced
- @Valid
- @NotNull
- @NotBlank
- @Email
- Request body validation
- REST validation flow

### APIs Validated
- POST  /api/users
- GET  /api/users
### Layers Used
- Controller
- Service
- Model
- DTO (Response Wrapper)

### Tools
- Spring Boot
- Postman

Status: REST Day 5 Completed

## Modules Planned
- RESTful APIs
- Spring Data JPA
- Spring Security
- Mini and major backend projects

## Purpose
- Strengthen backend engineering skills
- Build production-level understanding
- Placement and real-world preparation

> Progress may have gaps due to semester examinations.