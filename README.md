Car Rental Management System
Assignment 4 – SOLID Architecture & Advanced OOP
Endterm Project (Spring Boot REST API)
<br>
Project Information

Course: Object-Oriented Programming
Assignment: Assignment 4 (based on Assignment 3) + Endterm
Topic: Car Rental Management System
Language: Java
Framework: Spring Boot
Database: PostgreSQL
Architecture: Layered (Controller → Service → Repository)

<br><br>

Project Overview

This project is a Car Rental Management System implemented as a Spring Boot REST API.

It is a refactored continuation of Assignment 3, redesigned to fully satisfy
Assignment 4 and Endterm requirements, with a strong focus on:

SOLID principles

Clean layered architecture

Advanced Object-Oriented Programming

Proper separation of concerns

JDBC-based database access

RESTful API design

The primary goal of this project is architectural quality, not feature quantity.

<br><br>

A. SOLID Principles Documentation
Single Responsibility Principle (SRP)

Each class has one clearly defined responsibility:

model/ – Domain entities (Car, Customer, Rental)

repository/ – Database access via JDBC

service/ – Business logic and validation

controller/ – REST API request handling

utils/ – Reflection and sorting utilities

<br>
Open–Closed Principle (OCP)

Car is implemented as an abstract class

EconomyCar and LuxuryCar extend Car

New car types can be added through subclassing without modifying existing code

<br>
Liskov Substitution Principle (LSP)

Subclasses are used through Car references

Overridden methods preserve expected behavior

<br>
Interface Segregation Principle (ISP)

Small, focused interfaces are used:

Validatable – validation behavior

PricedItem – pricing behavior

CrudRepository<T> – generic CRUD operations

<br>
Dependency Inversion Principle (DIP)

RentalService depends on CarRepositoryInterface

Concrete implementations are injected using Spring

High-level modules depend on abstractions

<br><br>

B. Advanced OOP Features
Generics

Use of generic interface CrudRepository<T>

Improves reusability and type safety

<br>
Lambda Expressions

Lambdas are used to sort cars by price

Implemented in SortingUtils

<br>
Reflection

Implemented using ReflectionUtils.
At runtime it outputs:

Class name

Fields

Methods

Output is visible in the console.

<br>
Interface Default and Static Methods

Validatable interface provides:

A default validation method

A static helper method

<br><br>

C. Object-Oriented Design
Abstract Classes and Inheritance

BaseEntity – abstract base class

Car – abstract subclass

EconomyCar, LuxuryCar – concrete implementations

<br>
Composition

Rental contains a Car

Rental contains a Customer

<br>
Polymorphism

Pricing logic overridden in subclasses

Objects handled using Car references

<br><br>

D. Database Design
Schema

Tables used in the system:

cars

customers

rentals

<br>
Constraints

Primary keys on all tables

Foreign keys:

rentals.car_id → cars.id

rentals.customer_id → customers.id

CHECK constraints for numeric values

<br>
Sample Inserts
INSERT INTO cars (name, type, price_per_day, available)
VALUES ('Toyota Corolla', 'ECONOMY', 50, true);

INSERT INTO cars (name, type, price_per_day, available)
VALUES ('Mercedes S-Class', 'LUXURY', 150, true);


<br><br>

E. Architecture Explanation
Layered Architecture
Controller (REST API)
        ↓
Service (Business Logic)
        ↓
Repository (JDBC)
        ↓
PostgreSQL Database

<br>
Example Request Flow

Client sends an HTTP request

Controller processes the request

Service layer applies business rules

Repository executes SQL using JDBC

Response returned as JSON

<br><br>

F. Execution Instructions
Requirements

Java JDK 17 or higher

PostgreSQL

Maven

Spring Boot

<br>
How to Run

Create database tables using schema.sql

Configure database credentials in application.properties

Run the application:

mvn spring-boot:run


Server starts at:

http://localhost:8080


<br><br>

G. Screenshots

Screenshots are located in:

docs/screenshots/


They demonstrate:

Successful CRUD operations (GET)

Successful CRUD operations (POST)

Validation failure (400 Bad Request)

Reflection utility output

<br><br>

H. Reflection
What I Learned

Applying SOLID principles in a real-world project

Designing clean layered architecture

Using generics, lambdas, and reflection

Building REST APIs with Spring Boot

<br>
Challenges Faced

Correct application of Dependency Inversion

Transition from console-based logic to REST APIs

Proper validation and error handling

<br>
Value of SOLID Architecture

Applying SOLID principles significantly improved:

Maintainability

Extensibility

Readability

Real-world applicability

<br><br>

Conclusion

This project fully satisfies Assignment 4 and Endterm requirements, demonstrating:

SOLID principles

Advanced Object-Oriented Programming

Clean Spring Boot architecture

JDBC and PostgreSQL integration

Functional REST API with validation
