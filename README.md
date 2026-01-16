# Java Web Application - Customer Management System

A full-stack web application built with Spring Boot and MySQL, demonstrating MVC architecture, RESTful design, and database integration.

## Tech Stack

- **Java 17** | **Spring Boot** | **Spring Data JPA** | **MySQL**
- **Thymeleaf** | **Bootstrap 5** | **Maven**

## Features

- Full CRUD operations for customer management
- RESTful API endpoints
- Responsive UI with Bootstrap
- Form validation and error handling
- JPA/Hibernate ORM with MySQL

## Quick Start

1. **Clone and configure**
```bash
git clone https://github.com/yourusername/java-web-app.git
cd java-web-app
```

2. **Set up database** - Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/customer_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. **Run**
```bash
mvn spring-boot:run
```

4. **Access**: `http://localhost:8080`

## Architecture

- **MVC Pattern** - Clean separation of concerns
- **Repository Pattern** - JPA data access layer
- **Dependency Injection** - Spring IoC container
- **Layered Architecture** - Controller → Service → Repository → Database

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/customers` | List all customers |
| POST | `/customers` | Create customer |
| GET | `/customers/{id}` | Get customer details |
| PUT | `/customers/{id}` | Update customer |
| DELETE | `/customers/{id}` | Delete customer |

## What This Demonstrates

- Enterprise Java development with Spring ecosystem
- Full-stack web application development
- Database design and ORM implementation
- RESTful API design principles
- Modern build tools and dependency management
