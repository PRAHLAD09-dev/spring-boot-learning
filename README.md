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

### Purpose
This module strengthens MVC fundamentals before moving to REST APIs and JPA (Database integration).

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

### Purpose
This mini project consolidates MVC concepts before moving to REST APIs and Database (JPA).

Status: MVC Mini Project Completed

## Modules Planned
- MVC architecture
- RESTful APIs
- Spring Data JPA
- Spring Security
- Mini and major backend projects

## Purpose
- Strengthen backend engineering skills
- Build production-level understanding
- Placement and real-world preparation

> Progress may have gaps due to semester examinations.