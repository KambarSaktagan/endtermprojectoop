Car Rental Management System

Assignment 4 – SOLID Architecture & Advanced OOP
Endterm Project (Spring Boot REST API)

Project Information

Course: Object-Oriented Programming

Assignment: Assignment 4 (based on Assignment 3) + Endterm

Topic: Car Rental Management System

Language: Java

Framework: Spring Boot

Database: PostgreSQL

Architecture: Layered (Controller → Service → Repository)

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

A. SOLID Principles Documentation
1. Single Responsibility Principle (SRP)

Each class has one clearly defined responsibility:

model/ – Domain entities (Car, Customer, Rental)

repository/ – Database access via JDBC

service/ – Business logic and validation

controller/ – REST API request handling

utils/ – Reflection and sorting utilities

2. Open–Closed Principle (OCP)

Car is implemented as an abstract class

EconomyCar and LuxuryCar extend Car

New car types can be added through subclassing without modifying existing code

3. Liskov Substitution Principle (LSP)

Subclasses (EconomyCar, LuxuryCar) are used through Car references

Overridden methods maintain expected behavior

4. Interface Segregation Principle (ISP)

Small, focused interfaces are used:

Validatable – validation behavior

PricedItem – pricing behavior

CrudRepository<T> – generic CRUD operations

Classes implement only the interfaces they require.

5. Dependency Inversion Principle (DIP)

RentalService depends on CarRepositoryInterface

Concrete implementations are injected using Spring

High-level modules depend on abstractions rather than concrete classes

B. Advanced OOP Features
Generics

Use of generic interface CrudRepository<T>

Improves reusability and type safety

Lambda Expressions

Lambdas are used to sort cars by price

Implemented in SortingUtils

Reflection

Implemented via ReflectionUtils.
At runtime it outputs:

Class name

Fields

Methods

The output is visible in the console.

Interface Default and Static Methods

The Validatable interface includes:

A default validation method

A static helper method

C. Object-Oriented Design
Abstract Classes and Inheritance

BaseEntity – abstract base class

Car – abstract subclass

EconomyCar, LuxuryCar – concrete implementations

Composition

Rental contains a Car

Rental contains a Customer

Polymorphism

Pricing logic is overridden in subclasses

Objects are handled using Car references

D. Database Design
Schema

Tables used in the system:

cars

customers

rentals

Constraints

Primary keys on all tables

Foreign keys:

rentals.car_id → cars.id

rentals.customer_id → customers.id

CHECK constraints for numeric values

Sample Inserts
INSERT INTO cars (name, type, price_per_day, available)
VALUES ('Toyota Corolla', 'ECONOMY', 50, true);

INSERT INTO cars (name, type, price_per_day, available)
VALUES ('Mercedes S-Class', 'LUXURY', 150, true);

E. Architecture Explanation
Layered Architecture
Controller (REST API)
        ↓
Service (Business Logic)
        ↓
Repository (JDBC)
        ↓
PostgreSQL Database

Example Request Flow

Client sends an HTTP request

Controller processes the request

Service layer applies business rules

Repository executes SQL using JDBC

Response is returned as JSON

F. Execution Instructions
Requirements

Java JDK 17 or higher

PostgreSQL

Maven

Spring Boot

How to Run

Create database tables using schema.sql

Configure database credentials in application.properties

Run the application:

mvn spring-boot:run


The server starts at:

http://localhost:8080

G. Screenshots

Screenshots are located in:

docs/screenshots/


They demonstrate:

Successful CRUD operations (GET)
<img width="1593" height="992" alt="scsh1" src="https://github.com/user-attachments/assets/034feffa-9e9a-4c5c-8633-967172c281ca" />

Successful CRUD operations (POST)
<img width="1585" height="960" alt="scsh2" src="https://github.com/user-attachments/assets/37631730-f646-48dc-8ceb-cd13b07310c5" />

Validation failure (400 Bad Request)
<img width="1597" height="955" alt="scsh3" src="https://github.com/user-attachments/assets/618ae882-5e80-49a3-ab05-ca1077c78ba0" />

Reflection utility output
<img width="1583" height="989" alt="scsh4" src="https://github.com/user-attachments/assets/f81953ff-d62f-47ba-ac40-69d62bf23006" />

Screenshots were taken using Postman and the application console.

H. Reflection
What I Learned

Applying SOLID principles in a real-world project

Designing clean layered architecture

Using generics, lambda expressions, and reflection

Building REST APIs with Spring Boot

Challenges Faced

Correct application of Dependency Inversion

Transition from console-based logic to REST APIs

Proper validation and error handling

Value of SOLID Architecture

Applying SOLID principles significantly improved:

Maintainability

Extensibility

Readability

Real-world applicability

Conclusion

This project fully satisfies Assignment 4 and Endterm requirements, demonstrating:

SOLID principles

Advanced Object-Oriented Programming

Clean Spring Boot architecture

JDBC and PostgreSQL integration

Functional REST API with validation and error handling
