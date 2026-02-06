## Spring Boot REST — Day 7 (API-to-API Communication)

Today I implemented API-to-API communication between two REST services using Spring Boot.

---

## What I built
- Order API and Payment API communication
- Order service calling Payment service via REST
- DTO-based request and response handling
- Clean layered architecture for inter-service calls

---

## Project Structure
- controller
  - OrderController
  - PaymentController
- service
  - OrderService
  - PaymentService
- model
  - Order
- dto
  - OrderRequest
  - OrderResponse
  - PaymentResponse

---

## API-to-API Communication Implemented
- Order API sends request to Payment API
- Payment API processes payment and returns response
- Order API handles external API response
- No business logic in controller

---

## Communication Flow
- Client → OrderController
- OrderController → OrderService
- OrderService → Payment API
- PaymentService → OrderService
- OrderService → OrderController → Client

---

## Concepts Practiced
- API-to-API communication
- RestTemplate usage
- DTO-based API design
- Service-to-service interaction
- Layered architecture
- Separation of concerns

---

## APIs Covered
- POST   /api/orders
- POST   /api/payments

---

## Layers Used
- Controller
- Service
- Model
- DTO

---

## Tools & Tech
- Spring Boot
- RestTemplate
- Postman
- Java 21

---

### Status

REST Day 7 Completed