# Food Order Management System (Spring Boot + JPA)

This project is a complete Spring Boot REST API application built using
Spring Data JPA.  
It represents a real-world backend system for managing food orders with
clean architecture and proper database relationships.

The project focuses on backend fundamentals such as entity relationships,
DTO-based APIs, pricing logic, pagination, sorting, and global exception handling.

---

## Project Overview

Mini Project: Food Order Management System

The system manages:
- Users
- Products (admin controlled)
- Orders placed by users
- Items inside each order

Each order item price is calculated dynamically using:
product price × quantity

This project is database-driven and demonstrates JPA best practices.

---

## Features Implemented

### User Management
- Create user
- Get user by ID
- Get all users
- Update user
- Delete user
- View all orders of a user

---

### Product Management (Admin)
- Create product
- Update product
- Delete product
- Get all products

Each product contains:
- Product name
- Price per unit
- Active status

---

### Order Management
- Place order for a user (order ID auto-generated)
- Get order by ID
- Get all orders
- Get orders by status
- Update order status (admin)
- Delete order (admin)

---

### Order Item Management
- Add items while placing an order
- Auto price calculation based on quantity
- Get items by order ID
- Get items with price greater than a value
- Remove item from order

---
## Architecture & Design

This project follows a standard layered architecture:

- Controller Layer  
  Handles HTTP requests and responses.

- Service Layer  
  Contains business logic and validations.

- Repository Layer  
  Handles database operations using Spring Data JPA.

- DTO Layer  
  Used for request and response mapping to avoid exposing entities.

- Entity Layer  
  Contains JPA entities and relationships.

- Exception Layer  
  Centralized exception handling using @ControllerAdvice.

---

## Entity Relationships

- User → Order  
  One user can place multiple orders  
  (@OneToMany)

- Order → OrderItem  
  One order can contain multiple items  
  (@OneToMany)

- Order → User  
  Each order belongs to one user  
  (@ManyToOne)

- OrderItem → Order  
  Each order item belongs to one order  
  (@ManyToOne)

Relationships use:
- cascade = CascadeType.ALL
- orphanRemoval = true

---

## Pricing Logic

- Product price is stored in Product table.
- User sends only productName and quantity.
- Backend calculates item price automatically.

Formula used:
price = product.price × quantity

Price is never accepted from client side.

---

## Project Structure

Food-Order-Management-System
│
├── src/main/java
│   └── com/prahlad/jpa
│
│       ├── controller
│       │   ├── AdminController.java
│       │   ├── ProductController.java
│       │   ├── UserController.java
│       │   └── OrderController.java
│
│       ├── dto
│       │   ├── AdminOrderItemResponseDto.java
│       │   ├── AdminOrderResponseDto.java
│       │   ├── AdminUserResponseDto.java
│       │   ├── OrderItemRequestDto.java
│       │   ├── OrderItemResponseDto.java
│       │   ├── OrderRequestDto.java
│       │   ├── OrderResponseDto.java
│       │   ├── OrderStatusUpdateDto.java
│       │   ├── PageResponseDto.java
│       │   ├── ProductRequestDto.java
│       │   ├── ProductResponseDto.java
│       │   ├── UserRequestDto.java
│       │   └── UserResponseDto.java
│
│       ├── entity
│       │   ├── User.java
│       │   ├── Product.java
│       │   ├── Order.java
│       │   └── OrderItem.java
│
│       ├── exception
│       │   ├── BadRequestException.java
│       │   ├── ResourceNotFoundException.java
│       │   └── GlobalExceptionHandler.java
│
│       ├── repository
│       │   ├── UserRepository.java
│       │   ├── ProductRepository.java
│       │   ├── OrderRepository.java
│       │   └── OrderItemRepository.java
│
│       ├── service
│       │   ├── Admin
│       │   │   ├── AdminService.java
│       │   │   └── AdminServiceImpl.java
│       │   │
│       │   ├── OrderService
│       │   │   ├── OrderService.java
│       │   │   └── OrderServiceImpl.java
│       │   │
│       │   ├── ProductService
│       │   │   ├── ProductService.java
│       │   │   └── ProductServiceImpl.java
│       │   │
│       │   └── UserService
│       │       ├── UserService.java
│       │       └── UserServiceImpl.java
│
│       └── SpringbootJpaFoodOrderApplication.java
│
├── src/main/resources
│   └── application.properties
│
├── src/test/java
│
├── pom.xml
└── README.md

---

## User vs Admin Responsibility

This application clearly separates User operations and Admin operations
at API level to simulate a real-world system.

### User Responsibilities

Users are allowed to:
- Create their own profile
- View and update their own details
- Place orders
- View their own orders and order details

User APIs:
- POST   /api/users
- GET    /api/users/{userId}
- PUT    /api/users/{userId}
- DELETE /api/users/{userId}
- GET    /api/users/{userId}/orders
- POST   /api/users/{userId}/orders
- GET    /api/users/{userId}/orders/{orderId}

Users:
- Cannot create or update products
- Cannot change order status
- Cannot control prices
- Only send productName and quantity while placing order

---

### Admin Responsibilities

Admin controls system-level data and operations.

Admin is allowed to:
- Manage products (create, update, delete)
- View all users
- View all orders
- Filter orders by status
- Update order status
- Delete orders
- View order items across the system

Admin APIs:
- POST   /api/admin/products
- GET    /api/admin/products
- PUT    /api/admin/products/{productId}
- DELETE /api/admin/products/{productId}

- GET    /api/admin/users
- GET    /api/admin/users/{userId}
- DELETE /api/admin/users/{userId}

- GET    /api/admin/orders
- GET    /api/admin/orders/{orderId}
- GET    /api/admin/orders/status/{status}
- PUT    /api/admin/orders/{orderId}/status
- DELETE /api/admin/orders/{orderId}

- GET    /api/admin/order-items/order/{orderId}
- GET    /api/admin/order-items/price-greater-than/{price}

---


## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Swagger UI

---

## How to Run

1. Clone the repository
2. Import as Maven project
3. Configure database in application.properties
4. Run SpringbootJpaFoodOrderApplication
5. Test APIs using Swagger UI or Postman

---

## Project Status

Completed

This project demonstrates real-world backend development using Spring Boot and Spring Data JPA and is suitable for interviews and portfolio usage.