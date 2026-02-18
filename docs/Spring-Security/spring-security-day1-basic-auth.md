# Spring Boot Security — Day 1 (Security Basics)

Today I started learning Spring Security and implemented basic security
configuration for REST APIs using Spring Boot.

---

## What I Built

- Integrated Spring Security with Spring Boot
- Secured REST APIs using HTTP Basic Authentication
- Created public and secured endpoints
- Configured custom security using SecurityFilterChain
- Tested secured APIs using browser and Postman

---

## Project Structure

- controller
  - PublicController
  - SecureController
- config
  - SecurityConfig
- resources
  - application.properties

---

## Security Concepts Practiced

- Authentication vs Authorization
- Spring Security Filter Chain
- HttpSecurity configuration
- CSRF handling in REST APIs
- HTTP Basic Authentication
- Request matcher based authorization

---

## Security Configuration Details

- CSRF disabled (REST APIs are stateless)
- /public endpoint accessible without authentication
- All other endpoints are secured
- HTTP Basic Authentication enabled
- Default Spring Security behavior overridden using custom config

---

## Key Learnings

- Spring Security secures all endpoints by default
- Security is implemented using filters
- HttpSecurity is a builder used to configure security rules
- REST APIs do not need form login
- Credentials are sent using Authorization headers

---

## Tools & Technologies

- Spring Boot
- Spring Security
- Spring Web
- Java 21
- Maven
- Postman

---

## Status

Spring Security Day 1 Completed