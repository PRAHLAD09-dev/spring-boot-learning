# Spring Boot MVC — Day 3

Today I implemented advanced Spring Boot MVC concepts including routing, request parameters, and form validation.

---

## What I built
- Path Variable based routing
- Query Parameter handling
- User registration form
- Server-side form validation
- Error handling using BindingResult
- Proper MVC controller → model → view flow

---

## Controllers Implemented
- UserController

---

## Endpoints Covered
- /user/profile/{name} → Path Variable example
- /user/search?keyword= → Query Parameter example
- /user/register → Show registration form
- /user/save → Handle form submission with validation

---

## Model
- User
  - name
  - email
  - Validation using Jakarta Validation annotations

---

## Pages (Views)
- register.html
- profile.html
- search.html
- success.html

---

## Concepts Practiced
- @PathVariable
- @RequestParam
- @ModelAttribute
- @Valid
- BindingResult error handling
- Form validation
- Spring MVC routing flow

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
MVC Day 3 Completed 