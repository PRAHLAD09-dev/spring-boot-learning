# Spring Security OAuth2 Login – Google & GitHub (Day 6)

This project is part of my Spring Boot + Spring Security learning series.

Day 6 is focused on understanding and implementing OAuth 2.0 login using
Spring Security with real OAuth providers.

The objective of this project is to learn the OAuth2 authentication flow,
not to build a production-ready system.

---

## What is covered in Day 6

- OAuth 2.0 authentication flow
- Login with Google account
- Login with GitHub account
- Spring Security OAuth2 Client configuration
- Custom login page
- Default success and logout handling
- Understanding redirect URI and callback flow

---

## What this project intentionally avoids

- No database
- No JPA
- No User entity
- No repository / DAO
- No service layer
- No JWT
- No role or authority mapping

This keeps the project simple and focused only on OAuth2 concepts.

---

## Why OAuth2

OAuth2 allows applications to authenticate users using trusted providers
instead of handling usernames and passwords directly.

Common OAuth providers:
- Google
- GitHub
- LinkedIn
- Facebook

Spring Security handles most of the OAuth2 flow internally.

---

## Technology Stack

- Java
- Spring Boot
- Spring Security
- OAuth 2.0 Client
- Maven
- Thymeleaf

---

## OAuth Provider Configuration

### Google OAuth Configuration

Configured using Google Cloud Console.

Steps followed:
1. Create a Google Cloud project
2. Configure OAuth consent screen
3. Create OAuth Client ID
4. Application type: Web Application
5. Authorized redirect URI:

http://localhost:8080/login/oauth2/code/google

---

### GitHub OAuth Configuration

Configured using GitHub Developer Settings.

Steps followed:
1. Create OAuth App
2. Set Homepage URL
3. Set Authorization callback URL:

http://localhost:8080/login/oauth2/code/github

---

## application.properties (Local Configuration)

OAuth credentials are configured locally.

Secrets are not committed to GitHub.

Example configuration:

spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID  
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET  

spring.security.oauth2.client.registration.github.client-id=YOUR_GITHUB_CLIENT_ID  
spring.security.oauth2.client.registration.github.client-secret=YOUR_GITHUB_CLIENT_SECRET  

---

## Security Configuration

Spring Security is configured to:
- Allow access to the login page
- Redirect unauthenticated users to OAuth login
- Handle OAuth callback automatically
- Use default OAuth2 success handling
- Support logout

No custom authentication provider is used.

---

## Login Flow Explanation

1. User opens application
2. User is redirected to custom login page
3. User clicks Google or GitHub login
4. User is redirected to OAuth provider
5. OAuth provider authenticates user
6. Provider redirects back to application
7. Spring Security completes authentication
8. User is logged in

---

## Logout Behaviour

- Logout clears session
- User is redirected back to login page
- OAuth provider may still keep the user logged in
- This is expected OAuth behaviour

---

## Learning Outcome

After completing this project, I understood:
- OAuth 2.0 flow
- Spring Security OAuth2 client configuration
- Redirect URI and callback handling
- Difference between authentication and authorization
- Why OAuth2 does not require a database by default

---

## Status

Spring Security Day 6 Completed  
(OAuth2 Login – Google & GitHub)
