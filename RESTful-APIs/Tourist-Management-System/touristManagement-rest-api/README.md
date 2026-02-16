
## Spring Boot REST API – Tourist Management System

This project is a complete Spring Boot REST mini project that consolidates all core backend concepts into a single, clean, and structured REST application.

The focus of this project is real-world REST API design, not just learning individual concepts in isolation.

---

## Project Overview

Mini Project: Tourist Management REST API  

This application demonstrates how a real backend REST system is structured and how different layers work together, including controller, service, DTOs, validation, exception handling, and inter-service communication.

The project uses in-memory storage (no database) to focus purely on REST design and Spring Boot fundamentals.

---

## Features Implemented

- Create Tourist (POST API)
- Get Tourist by ID (GET API)
- Get All Tourists (GET API)
- Update Tourist (PUT API)
- Delete Tourist (DELETE API)
- Pagination support (page & size)
- Validation on request data
- Global exception handling
- Clean and consistent JSON response format
- Inter-service communication using RestTemplate  
  (Ticket Booking – API-to-API call simulation)
- File upload support (Profile Image upload)
- In-memory storage (No database)

---

## Layers Used

- Controller Layer – Handles HTTP requests and responses  
- Service Layer – Business logic and validations  
- DTO Layer – Clean request/response mapping  
- Exception Layer – Global exception handling  
- Utility / Helper Methods – Reusable internal logic  
- Config (RestTemplate)
---

## Project Structure

com.prahlad.rest
│
├── config
│   └── AppConfig.java
│
├── controller
│   ├── TouristController.java
│   └── TicketController.java
│
├── service
│   ├── TouristService.java
│   ├── TicketService.java
│   ├── FileService.java
│   └─
├── dto
│   ├── TouristRequestDto.java
│   ├── TouristResponseDto.java
│   ├── TouristTicketResponseDto.java
│   ├── TicketResponseDto.java
│   └── PageResponseDto.java
│
├── model
│   ├── Tourist.java
│   └── Ticket.java
│
├── exception
│   ├── BadRequestException.java
│   ├── ResourceNotFoundException.java
│   └── GlobalExceptionHandler.java
│
└── RestDay10TouristManagementMiniProjectApplication.java

---

## APIs Exposed

- GET    /api/tourists/{id}
- PUT    /api/tourists/{id}
- DELETE /api/tourists/{id}
- GET   /api/tourists
- POST   /api/tourists
- POST   /api/tourists/{id}/upload
- GET    /api/tourists?page=&size=

- POST /api/tickes/book

- Ticket booking via internal API-to-API call

---



## REST API Design Highlights

- Proper use of HTTP methods (GET, POST, PUT, DELETE)
- DTO-based request and response handling
- Centralized exception handling using @ControllerAdvice
- Pagination implemented without database
- File upload handled via MultipartFile
- API-to-API communication simulated within the project

---

## Tech Stack

- Java
- Spring Boot
- Spring Web (REST)
- Validation API
- Swagger (API documentation)
- Maven

---



## How to Run

1. Clone the repository
2. Import the project as a Maven project
3. Run the Spring Boot application
4. Access APIs via browser, Postman, or Swagger UI

---

## Learning Outcome

This project helped reinforce:
- End-to-end REST API development
- Clean backend layering
- Real-world API structure
- API-to-API communication concepts
- Error handling and validation best practices

---

### This project represents a realistic backend REST application, not just a demo.