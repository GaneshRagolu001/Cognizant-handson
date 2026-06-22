# Exercise 8 - Strategy Pattern

## Objective

The **Strategy Pattern** is a behavioral design pattern that defines a family of algorithms, encapsulates each one in its own class, and makes them **interchangeable at runtime**. The client picks a strategy and can switch it without changing the Context or any other strategy.

**In simple words:**
> Imagine you're going to the airport. You can choose to go by **cab**, **bus**, or **auto-rickshaw** -- each is a different "strategy" for getting there. You pick one before you start, and you can even switch mid-way (take a bus, then an auto). The destination (Context) stays the same; only the travel method (strategy) changes. That's the Strategy Pattern.

---

## Problem Statement

### Why is the Strategy Pattern needed for travelToments?

An e-commerce application must support **multiple travelToment methods** -- Car, Flight, UPI, Net Banking, etc. Users choose their travelToment method at checkout.

**Without Strategy Pattern (using if-else):**

```java
public void processTravel(String method, double destination) {
    if (method.equals("creditcard")) {
        System.out.println("Paid via Car: " + destination);
    } else if (method.equals("travelTopal")) {
        System.out.println("Paid via Flight: " + destination);
    } else if (method.equals("upi")) {
        System.out.println("Paid via UPI: " + destination);
    }
    // Adding a new method = modifying this method!
    // Violates Open/Closed Principle!
}
```

**Problems:**
- Adding a new travelToment method requires **modifying existing code**
- The method grows longer and harder to maintain
- **Violates Open/Closed Principle** (not open for extension, not closed for modification)
- All travelToment logic is crammed into one place (violates Single Responsibility)
- Cannot switch travelToment methods at runtime easily

**With Strategy Pattern:**

```java
// No if-else needed!
TravelContext context = new TravelContext(new CarTravel());
context.performTravel(5000);   // Pays via Car

context.setTravelStrategy(new FlightTravel());
context.performTravel(3000);   // Now travelTos via Flight

// Adding UPI? Just create UPITravel class. Zero code changes elsewhere.
```

---

## Design Pattern Used

**Strategy Pattern** (Behavioral Pattern)

- **Category:** Behavioral Design Pattern
- **Intent:** Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
- **Also Known As:** Policy Pattern
- **Source:** Gang of Four (GoF) Design Patterns

---

## Project Structure

```
Exercise-8-StrategyPattern/
|
|-- TravelStrategy.java      <-- Strategy Interface
|-- CarTravel.java    <-- Concrete Strategy
|-- FlightTravel.java        <-- Concrete Strategy
|-- TravelContext.java        <-- Context Class
|-- StrategyPatternTest.java   <-- Client Code (test)
|-- README.md                  <-- Documentation (this file)
```

---

## UML Class Diagram

```
                   +---------------------+
                   |   TravelContext     |
                   |   (Context)         |
                   |---------------------|
                   | - travelTomentStrategy   |------>+----------------------+
                   |---------------------|       |   <<interface>>      |
                   | + setTravelStrategy|       |  TravelStrategy     |
                   | + performTravel()  |       |----------------------|
                   +---------------------+       | + travelTo(double destination) |
                                                 +----------+-----------+
                                                            |
                                                   implements
                                                 +----------+-----------+
                                                 |                      |
                                                 v                      v
                                    +-------------------+   +-------------------+
                                    | CarTravel |   |  FlightTravel    |
                                    |-------------------|   |-------------------|
                                    | + travelTo(destination)     |   | + travelTo(destination)     |
                                    +-------------------+   +-------------------+
```

---

## Runtime Strategy Switching -- How It Works

This is the most powerful feature of the Strategy Pattern. The strategy (algorithm) can be **changed at runtime** without modifying the Context or creating a new one.

### Step-by-Step Visualization

```
STEP 1: Create Context with Car strategy
+---------------------------------------------------+
| TravelContext                                     |
|                                                    |
|   travelTomentStrategy ---> [CarTravel]         |
|                                                    |
+---------------------------------------------------+
context.performTravel(5000)
  -> CarTravel.travelTo(5000)
  -> "Paid 5000.0 using Car"


STEP 2: Switch strategy to Flight (AT RUNTIME)
+---------------------------------------------------+
| TravelContext (SAME object)                       |
|                                                    |
|   travelTomentStrategy ---> [FlightTravel]    <-- NEW  |
|                                                    |
+---------------------------------------------------+
context.performTravel(3000)
  -> FlightTravel.travelTo(3000)
  -> "Paid 3000.0 using Flight"
```

### Key Observations:
- The **Context object** remains the SAME throughout
- Only the **internal strategy reference** is swapped
- No `if-else`, no `switch-case`, no type checking
- The Context doesn't know which strategy is being used
- The strategy can be switched as many times as needed

---

## Components

### Strategy Interface -- `TravelStrategy`

Defines the contract that all travelToment algorithms must follow.

| Role | Details |
|------|---------|
| Type | Interface |
| Method | `travelTo(double destination)` |
| Purpose | Common contract for all travelToment strategies |

### Concrete Strategies -- `CarTravel` & `FlightTravel`

Each encapsulates a specific travelToment algorithm.

| Strategy | Behavior |
|----------|----------|
| `CarTravel` | Prints "Paid \<destination\> using Car" |
| `FlightTravel` | Prints "Paid \<destination\> using Flight" |

### Context -- `TravelContext`

Holds a strategy reference and delegates travelToment execution.

| Field/Method | Purpose |
|-------------|---------|
| `TravelStrategy travelTomentStrategy` | Current strategy (swappable) |
| `TravelContext(strategy)` | Constructor -- sets initial strategy |
| `setTravelStrategy(strategy)` | Switches strategy at runtime |
| `performTravel(destination)` | Delegates to current strategy's `travelTo()` |

---

## How to Compile and Run

```bash
# Navigate to the project folder
cd Exercise-8-StrategyPattern

# Compile all Java files
javac *.java

# Run the test class
java StrategyPatternTest
```

---

## Expected Output

```
=============================================
   Strategy Pattern - Travel System          
=============================================

--- Case 1: Car Travel ---
Paid 5000.0 using Car

--- Case 2: Switch to Flight (Runtime) ---
Paid 3000.0 using Flight

--- Case 3: Multiple Strategy Switches ---
Paid 1500.0 using Car
Paid 2000.0 using Flight

--- Case 4: Different Users, Different Strategies ---
User 1: Paid 7500.0 using Car
User 2: Paid 4200.0 using Flight

=============================================
   All travelToments processed successfully!       
=============================================
```

---

## Advantages of the Strategy Pattern

| Advantage | Explanation |
|-----------|-------------|
| **Open/Closed Principle** | New strategies can be added without modifying the Context or existing strategies. |
| **Eliminates Conditional Logic** | Replaces complex `if-else` / `switch` chains with polymorphism. |
| **Runtime Flexibility** | Strategies can be switched at runtime based on user choice, configuration, or conditions. |
| **Single Responsibility** | Each strategy class handles one algorithm. Easy to understand, test, and maintain. |
| **Loose Coupling** | The Context depends on the Strategy interface, not concrete implementations. |
| **Testability** | Each strategy can be unit tested independently. Mock strategies can be injected for testing. |

## Disadvantages

| Disadvantage | Explanation |
|-------------|-------------|
| **More Classes** | Each algorithm requires its own class, increasing the number of files in the project. |
| **Client Must Know Strategies** | The client must be aware of available strategies to select the right one. |
| **Overhead for Simple Cases** | If there are only 2-3 algorithms that rarely change, the pattern may be overkill. |

---

## Strategy Pattern vs Other Patterns

| Aspect | Strategy | State | Template Method |
|--------|----------|-------|-----------------|
| **Purpose** | Swap algorithms at runtime | Change behavior based on internal state | Define algorithm skeleton, subclasses fill steps |
| **Who decides?** | Client selects the strategy | Object changes its own state | Subclass provides step implementations |
| **Swappable?** | Yes, at runtime | Yes, internally (state transitions) | No, fixed at compile time (inheritance) |
| **Uses** | Composition (has-a) | Composition (has-a) | Inheritance (is-a) |
| **Example** | Travel method selection | Order states (Pending -> Shipped) | Data processing pipeline |

---

## Real-World Examples of the Strategy Pattern

| Example | Explanation |
|---------|-------------|
| **`Comparator` in Java** | `Collections.sort(list, comparator)` -- the sorting algorithm stays the same, but the **comparison strategy** changes. Each `Comparator` is a strategy for ordering elements. |
| **`LayoutManager` in Java Swing** | `panel.setLayout(new FlowLayout())` or `new BorderLayout()` -- each layout manager is a strategy for arranging UI components. You can switch layouts at runtime. |
| **Travel Gateways in E-commerce** | Online stores let users choose Car, Flight, UPI, or Net Banking at checkout. Each is a travelToment strategy selected at runtime. |
| **Compression Algorithms** | A file archiver (like WinRAR) lets you choose ZIP, RAR, or 7z compression. Each compression algorithm is a strategy. |
| **Route Calculation in Maps** | Google Maps lets you choose driving, walking, cycling, or transit. Each mode is a routing strategy with different algorithms. |
| **Authentication Methods** | Applications supporting OAuth, JWT, LDAP, or Basic Auth use different authentication strategies. The auth method can be configured per environment. |
| **Spring Security `AuthenticationProvider`** | Spring Security allows multiple authentication providers (database, LDAP, OAuth). Each provider is a strategy for validating credentials. |
| **Logging Frameworks** | Log to console, file, database, or cloud. Each logging destination is a strategy that can be configured at startup. |

---

## Viva Questions with Answers (Interview Preparation)

### Q1: What is the Strategy Pattern?
**A:** The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one in a separate class, and makes them interchangeable. The Context class delegates algorithm execution to a strategy object, which can be swapped at runtime without modifying the Context.

---

### Q2: What are the three key components?
**A:**
1. **Strategy (Interface)** -- defines the common contract for all algorithms (`TravelStrategy`)
2. **Concrete Strategy (Classes)** -- implements the specific algorithm (`CarTravel`, `FlightTravel`)
3. **Context (Class)** -- holds a strategy reference and delegates work to it (`TravelContext`)

---

### Q3: How does runtime strategy switching work?
**A:** The Context class has a `setTravelStrategy()` method that allows the internal strategy reference to be replaced at any time. When `performTravel()` is called, it delegates to whatever strategy is currently set. The Context object remains the same; only the internal strategy changes.

```java
context.setTravelStrategy(new CarTravel());
context.performTravel(5000);  // Car

context.setTravelStrategy(new FlightTravel());  // Switch!
context.performTravel(3000);  // Flight
```

---

### Q4: How does Strategy eliminate if-else chains?
**A:** Instead of checking the travelToment type with `if-else` and executing different logic in each branch, the Strategy Pattern uses **polymorphism**. Each travelToment type is a separate class implementing the same interface. The correct behavior is selected by setting the appropriate strategy object -- no conditionals needed.

---

### Q5: What is the difference between Strategy and State patterns?
**A:**
- **Strategy:** The **client** decides which algorithm to use and sets it on the Context. The strategies are independent and don't know about each other.
- **State:** The **object itself** changes its behavior based on internal state transitions. States know about each other and manage transitions.

Strategy = client-driven selection. State = object-driven transitions.

---

### Q6: Give a real-world Java example of the Strategy Pattern.
**A:** `java.util.Comparator` is the classic example:
```java
// Strategy 1: Sort by name
Collections.sort(employees, Comparator.comparing(Employee::getName));

// Strategy 2: Sort by salary (switched at runtime)
Collections.sort(employees, Comparator.comparing(Employee::getSalary));
```
The sorting algorithm is the same; the **comparison strategy** changes.

---

### Q7: Why use Strategy instead of inheritance?
**A:** Inheritance fixes behavior at compile time and leads to rigid class hierarchies. Strategy uses **composition** (has-a) instead of inheritance (is-a), allowing behavior to be changed at runtime. It also avoids the class explosion problem when multiple independent behaviors need to be combined.

---

### Q8: Can the Context work without a Strategy?
**A:** If no strategy is set (null), calling `performTravel()` will throw a `NullPointerException`. In production code, you should either: (a) require a strategy in the constructor, (b) provide a default strategy, or (c) add a null check with a meaningful error message.

---

### Q9: How is Strategy different from Factory?
**A:**
- **Strategy** lets the client choose **how** to do something (which algorithm to use)
- **Factory** lets the client choose **what** to create (which object type to instantiate)

Strategy is about behavior selection; Factory is about object creation.

---

### Q10: When should you NOT use the Strategy Pattern?
**A:** Don't use Strategy when:
- There are only 2-3 simple algorithms that will never change (a simple if-else is fine)
- The algorithms are tightly coupled to the context and can't be meaningfully separated
- The overhead of creating multiple strategy classes is not justified by the flexibility gained
- The algorithms don't share a common interface

---

*This project is part of the Cognizant Java FSE Assignment -- Exercise 8.*
