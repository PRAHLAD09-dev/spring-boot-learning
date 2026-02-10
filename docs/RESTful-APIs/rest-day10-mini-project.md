
## Spring Boot REST — Day 10 (Mini Project)

Today I built a complete REST mini project by combining all concepts learned
from Day 1 to Day 9 into a single, clean backend application.

This day focuses on project building, not new learning.

---

## Project Overview

Mini Project: Tourist Management REST API

The project demonstrates how a real backend REST application is structured
and how different layers work together.

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
- Clean JSON response format
- API-to-API call simulation (Ticket Booking)
- File upload support (profile image)
- In-memory storage (No database)

---

## Layers Used

- Controller  
- Service  
- DTO (Request & Response)  
- Model  
- Exception  
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
│   └── TicketService.java
│
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

- POST   /api/tourists
- GET    /api/tourists/{id}
- GET    /api/tourists?page=&size=
- PUT    /api/tourists/{id}
- DELETE /api/tourists/{id}
- POST   /api/tourists/{id}/upload
- Ticket booking via internal API-to-API call

---

## Concepts Applied (Day 1–9)

- REST fundamentals
- JSON ↔ Java mapping
- CRUD APIs
- Validation using @Valid
- Global exception handling
- Pagination logic
- API-to-API communication using RestTemplate
- Clean layered architecture
- DTO-based API contracts

---

## Tools & Tech

- Spring Boot
- Java 21
- Maven
- Postman
- Swagger (used earlier days)

---

## Status

REST Day 10 — Mini Project Completed 

---
