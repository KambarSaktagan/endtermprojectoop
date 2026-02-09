# Car Rental Management System

## Assignment 4 – SOLID Architecture & Advanced OOP
## Endterm Project (Spring Boot REST API)

---

## Project Information

Course: Object-Oriented Programming  
Assignment: Assignment 4 (based on Assignment 3) + Endterm  
Topic: Car Rental Management System  
Language: Java  
Framework: Spring Boot  
Database: PostgreSQL  
Architecture: Layered (Controller → Service → Repository)

---

## Project Overview

This project is a Car Rental Management System implemented as a Spring Boot REST API.

It is a refactored continuation of Assignment 3 and redesigned to fully satisfy
Assignment 4 and Endterm requirements. The primary focus of this project is
architectural quality rather than feature complexity.

The system demonstrates correct usage of SOLID principles, clean layered
architecture, advanced object-oriented programming features, JDBC-based
database access, and RESTful API design.

---

## A. SOLID Documentation

### Single Responsibility Principle (SRP)

Each class has exactly one responsibility:

- model package contains domain entities such as Car, Customer, and Rental
- repository package handles database access using JDBC
- service package contains business logic and validation
- controller package handles HTTP requests and responses
- utils package contains reflection and sorting utilities

---

### Open–Closed Principle (OCP)

- Car is implemented as an abstract class
- EconomyCar and LuxuryCar extend Car
- New car types can be added as subclasses without modifying existing code

---

### Liskov Substitution Principle (LSP)

- EconomyCar and LuxuryCar can safely replace Car
- Subclasses are used via base class references
- Overridden methods preserve correct behavior

---

### Interface Segregation Principle (ISP)

Small, focused interfaces are used:

- Validatable for validation logic
- PricedItem for pricing behavior
- CrudRepository<T> for generic CRUD operations

Classes implement only the interfaces they actually need.

---

### Dependency Inversion Principle (DIP)

- RentalService depends on CarRepositoryInterface
- Repository implementation is injected via constructor
- High-level modules depend on abstractions, not concrete implementations

---

## B. Advanced OOP Features

### Generics

Generics are used through the CrudRepository<T> interface, improving type safety
and reusability of CRUD operations.

Example:

public interface CrudRepository<T> {
    void create(T entity);
    List<T> getAll();
    void delete(int id);
}

---

### Lambdas

Lambda expressions are used to sort cars by price.

Example:

cars.sort(Comparator.comparingDouble(Car::getPricePerDay));

---

### Reflection

Reflection is demonstrated using ReflectionUtils.

Example:

Class<?> clazz = EconomyCar.class;
Method[] methods = clazz.getDeclaredMethods();

The reflection output prints class name, fields, and methods at runtime and is
visible in the application console.

---

### Interface Default and Static Methods

The Validatable interface contains default and static methods.

Example:

public interface Validatable {
    default boolean isValid() {
        return true;
    }

    static void logValidation() {
        System.out.println("Validation executed");
    }
}

---

## C. OOP Documentation

### Abstract Classes and Subclasses

- BaseEntity is an abstract base class
- Car is an abstract subclass of BaseEntity
- EconomyCar and LuxuryCar are concrete subclasses of Car

---

### Composition

Rental contains a Car and a Customer.

Example:

public class Rental {
    private Car car;
    private Customer customer;
}

---

### Polymorphism

Pricing logic is overridden in EconomyCar and LuxuryCar.
Objects are handled through base class references.

Example:

Car car = new LuxuryCar(...);
double price = car.calculatePrice(days);

---

## D. Database Section

### Schema

The database contains three tables:
- cars
- customers
- rentals

---

### Constraints

- Primary keys on all tables
- Foreign keys:
  rentals.car_id references cars.id
  rentals.customer_id references customers.id
- CHECK constraints ensure valid numeric values

---

### Sample Inserts

INSERT INTO cars (name, type, price_per_day, available)
VALUES ('Toyota Corolla', 'ECONOMY', 50, true);

INSERT INTO cars (name, type, price_per_day, available)
VALUES ('Mercedes S-Class', 'LUXURY', 150, true);

---

## E. Architecture Explanation

The application follows a layered architecture:

Controller (REST API)
↓
Service (Business Logic and Validation)
↓
Repository (JDBC)
↓
PostgreSQL Database

---

### Example Request Flow

1. Client sends HTTP request
2. Controller receives the request
3. Service validates business rules
4. Repository executes SQL via JDBC
5. Result is returned as JSON

---

## F. Execution Instructions

### Requirements

- Java JDK 17 or higher
- PostgreSQL
- Maven
- Spring Boot

---

### How to Run

mvn spring-boot:run

The server starts at:

http://localhost:8080

---

## G. Screenshots

Four screenshots are included in the docs/screenshots directory.

They demonstrate:
- Successful GET request (CRUD read)
  <img width="1593" height="992" alt="scsh1" src="https://github.com/user-attachments/assets/7ac0fd44-0004-4dd4-b703-efbdab4d8570" />

- Successful POST request (CRUD create)
 <img width="1585" height="960" alt="scsh2" src="https://github.com/user-attachments/assets/e51f2823-b69c-43f3-8dd8-3c1d4f63f425" />

- Validation failure with HTTP 400 Bad Request
  <img width="1597" height="955" alt="scsh3" src="https://github.com/user-attachments/assets/e65011d8-6bd5-46d0-860f-3e347ab36778" />

- Reflection utility output
<img width="1583" height="989" alt="scsh4" src="https://github.com/user-attachments/assets/fd2ee867-3ff1-4f6e-abad-b65d0bb968b1" />

---

## H. Reflection

### What I Learned

- Applying SOLID principles in a real project
- Designing clean layered architecture
- Using generics, lambdas, and reflection
- Building REST APIs with Spring Boot

---

### Challenges

- Applying dependency inversion correctly
- Transitioning from console-based logic to REST APIs
- Implementing proper validation and error handling

---

### Value of SOLID Architecture

SOLID principles significantly improved maintainability, extensibility,
readability, and real-world applicability of the code.

---

## Conclusion

This project fully satisfies Assignment 4 and Endterm requirements.
It demonstrates SOLID principles, advanced OOP features, clean Spring Boot
architecture, proper JDBC and PostgreSQL integration, and a functional REST API
with validation and error handling.
**
