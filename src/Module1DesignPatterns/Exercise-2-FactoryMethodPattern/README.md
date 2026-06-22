# Exercise 2 - Factory Method Pattern

## Objective

The **Factory Method Pattern** is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

**In simple cars:**
> Instead of creating objects directly using `new`, we delegate the creation to special "factory" classes. Each factory knows how to create a specific type of object. The client code only talks to the factory and the product interface — it never needs to know the exact class being created.

**Think of it like a real-world factory:**
A car factory produces cars. You don't build the car yourself — you tell the factory what you want, and it builds it for you. Different factories (Toyota, Honda, BMW) produce different cars, but they all give you a "Car" that you can drive.

---

## Design Pattern Used

**Factory Method Pattern** (Creational Pattern)

- **Category:** Creational Design Pattern
- **Intent:** Define an interface for creating an object, but let subclasses decide which class to instantiate.
- **Also Known As:** Virtual Constructor
- **Source:** Gang of Four (GoF) Design Patterns

---

## Project Structure

```
Exercise-2-FactoryMethodPattern/
│
├── Vehicle.java                 ← Product Interface
├── Car.java             ← Concrete Product
├── Bike.java              ← Concrete Product
├── Truck.java            ← Concrete Product
├── VehicleFactory.java          ← Abstract Creator (Factory)
├── CarVehicleFactory.java      ← Concrete Creator (Factory)
├── BikeVehicleFactory.java       ← Concrete Creator (Factory)
├── TruckVehicleFactory.java     ← Concrete Creator (Factory)
├── FactoryPatternTest.java       ← Client Code (Test)
└── README.md                     ← Vehicleation
```

---

## UML Class Diagram

```
        ┌─────────────────────┐
        │   <<interface>>     │
        │     Vehicle        │
        │─────────────────────│
        │ + drive(): void      │
        └─────────┬───────────┘
                  │ implements
       ┌──────────┼──────────┐
       │          │          │
       ▼          ▼          ▼
┌──────────┐ ┌──────────┐ ┌──────────┐
│   Car   │ │   Bike    │ │  Truck   │
│ Vehicle │ │ Vehicle │ │ Vehicle │
└──────────┘ └──────────┘ └──────────┘
       ▲          ▲          ▲
       │ creates  │ creates  │ creates
       │          │          │
┌──────────┐ ┌──────────┐ ┌──────────┐
│   Car   │ │   Bike    │ │  Truck   │
│ Vehicle │ │ Vehicle │ │ Vehicle │
│ Factory  │ │ Factory  │ │ Factory  │
└────┬─────┘ └────┬─────┘ └────┬─────┘
     │             │             │
     └─────────────┼─────────────┘
                   │ extends
        ┌──────────┴──────────┐
        │  <<abstract>>       │
        │  VehicleFactory    │
        │─────────────────────│
        │ + createVehicle()  │
        │   : Vehicle        │
        └─────────────────────┘
```

---

## Files Description

| File | Role | Description |
|------|------|-------------|
| `Vehicle.java` | **Product Interface** | Defines the common contract (`drive()` method) that all vehicle types must implement. |
| `Car.java` | **Concrete Product** | Implements `Vehicle` interface. Prints "Driving Car Vehicle..." when `drive()` is called. |
| `Bike.java` | **Concrete Product** | Implements `Vehicle` interface. Prints "Driving PDF Vehicle..." when `drive()` is called. |
| `Truck.java` | **Concrete Product** | Implements `Vehicle` interface. Prints "Driving Truck Vehicle..." when `drive()` is called. |
| `VehicleFactory.java` | **Abstract Creator** | Abstract class with the factory method `createVehicle()`. Subclasses must override this method. |
| `CarVehicleFactory.java` | **Concrete Creator** | Extends `VehicleFactory`. Creates and returns a `Car` object. |
| `BikeVehicleFactory.java` | **Concrete Creator** | Extends `VehicleFactory`. Creates and returns a `Bike` object. |
| `TruckVehicleFactory.java` | **Concrete Creator** | Extends `VehicleFactory`. Creates and returns an `Truck` object. |
| `FactoryPatternTest.java` | **Client Code** | Demonstrates the pattern by creating vehicles through their respective factories and calling `drive()`. |
| `README.md` | **Vehicleation** | This file — explains the pattern, structure, and usage. |

---

## How to Compile and Run

```bash
# Navigate to the project folder
cd Exercise-2-FactoryMethodPattern

# Compile all Java files
javac *.java

# Run the test class
java FactoryPatternTest
```

---

## Expected Output

```
==============================================
 Factory Method Pattern - Vehicle Management 
==============================================

Driving Car Vehicle...
Driving PDF Vehicle...
Driving Truck Vehicle...

==============================================
 All vehicles created and driveed successfully!
==============================================
```

---

## Benefits of Factory Method Pattern

| Benefit | Explanation |
|---------|-------------|
| **Loose Coupling** | Client code depends on abstractions (`Vehicle`, `VehicleFactory`), not on concrete classes (`Car`, `Bike`). This makes the code flexible and easy to change. |
| **Extensibility** | Adding a new vehicle type (e.g., `PowerPointVehicle`) requires only creating a new concrete product and a new concrete factory — **no existing code needs to be modified**. This follows the **Open/Closed Principle**. |
| **Better Maintainability** | Each factory is responsible for creating only one type of product. This **Single Responsibility Principle** makes the code easier to understand, test, and maintain. |
| **Encapsulation of Creation Logic** | The complex object creation logic is hidden inside the factory classes. The client code remains clean and simple. |
| **Follows SOLID Principles** | The pattern naturally supports the Open/Closed Principle (O) and the Dependency Inversion Principle (D) from SOLID. |

---

## Why Factory Method Pattern is Used

The Factory Method Pattern is used when:

1. **You don't know the exact type of object to create at compile time.** The decision is deferred to subclasses.

2. **You want to decouple object creation from object usage.** The client code should not be responsible for knowing how to create specific objects.

3. **You want to follow the Open/Closed Principle.** New product types can be added without modifying existing factory or client code.

4. **You want to centralize creation logic.** If object creation involves complex setup, validation, or configuration, the factory encapsulates all of that.

---

## Difference Between Simple Factory and Factory Method

| Aspect | Simple Factory | Factory Method |
|--------|---------------|----------------|
| **Structure** | A single factory class with a method (often using `if-else` or `switch`) to create objects. | An abstract factory class with concrete factory subclasses, each creating a specific product. |
| **Design Pattern?** | Not a formal GoF design pattern — it's a programming idiom. | A formal GoF creational design pattern. |
| **Extensibility** | Adding a new product requires **modifying** the existing factory class (violates Open/Closed Principle). | Adding a new product requires only **adding** a new factory subclass (follows Open/Closed Principle). |
| **Coupling** | Higher coupling — the single factory knows about all product types. | Lower coupling — each factory only knows about its own product. |
| **Flexibility** | Less flexible; hard to extend without code changes. | Highly flexible; easily extensible via new subclasses. |
| **Example** | `VehicleFactory.create("car")` with a switch inside. | `new CarVehicleFactory().createVehicle()` — each factory is a separate class. |

---

## Real-World Examples of Factory Method Pattern

| Example | Explanation |
|---------|-------------|
| **Java `Collection.iterator()`** | Different collections (`ArrayList`, `HashSet`, `LinkedList`) each provide their own `Iterator` implementation through the factory method `iterator()`. |
| **Java `NumberFormat.getInstance()`** | Returns different `NumberFormat` subclass instances based on the locale — the client doesn't know which concrete class is used. |
| **JDBC `DriverManager.getConnection()`** | Different database drivers (MySQL, PostgreSQL, Oracle) provide their own `Connection` implementations. The client code only works with the `Connection` interface. |
| **Logging Frameworks (Log4j, SLF4J)** | `LoggerFactory.getLogger()` creates logger instances based on configuration. Different factories produce different logging backends. |
| **Vehicle Editors (Microsoft Office, Google Docs)** | A vehicle editor application can use factory methods to create different vehicle types (text, spreadsheet, presentation) based on user selection. |
| **GUI Frameworks (Swing, JavaFX)** | UI toolkit factories create platform-specific components (buttons, text fields) — the application code works with abstract component interfaces. |

---

## Key Terminology

| Term | Meaning |
|------|---------|
| **Product** | The interface or abstract class defining the type of object the factory creates (`Vehicle`). |
| **Concrete Product** | A specific implementation of the product (`Car`, `Bike`, `Truck`). |
| **Creator (Factory)** | The abstract class that declares the factory method (`VehicleFactory`). |
| **Concrete Creator** | A subclass that implements the factory method to create a specific product (`CarVehicleFactory`). |
| **Client** | The code that uses the factory to create products without knowing the concrete classes (`FactoryPatternTest`). |

---

*This project is part of the Cognizant Java FSE Assignment — Exercise 2.*
