# Exercise 5 - Decorator Pattern

## Objective

The **Decorator Pattern** is a structural design pattern that lets you **dynamically add new behavior** to objects by wrapping them inside special wrapper classes called "decorators". Each decorator adds a specific feature on top of the original object without modifying it.

**In simple words:**
> Imagine you order a plain pizza (base). You can add cheese (decorator), then mushrooms (decorator), then olives (decorator) — each topping is added on TOP of what's already there. You don't change the original pizza; you just keep adding layers. The Decorator Pattern works exactly like this — each decorator wraps the previous one and adds new behavior.

---

## Problem Statement

### Why is inheritance alone not sufficient?

Let's say we want to support coffees via Basic Coffee, Milk, and Sugar. Users might want **any combination**:

| Combination | Class Needed (with Inheritance) |
|-------------|--------------------------------|
| Basic Coffee only | `BasicCoffee` |
| Basic Coffee + Milk | `Basic CoffeeMilkCoffee` |
| Basic Coffee + Sugar | `Basic CoffeeSugarCoffee` |
| Basic Coffee + Milk + Sugar | `Basic CoffeeMilkSugarCoffee` |
| Milk only | `MilkCoffee` |
| Milk + Sugar | `MilkSugarCoffee` |
| Sugar only | `SugarCoffee` |

**That's 7 classes for just 3 channels!** With 4 channels, you'd need **15 classes**. With 5 channels, **31 classes**. This is called the **class explosion problem**.

### ❌ Problems with Inheritance:
1. **Class Explosion** — The number of subclasses grows exponentially with each new feature
2. **Static** — Combinations are fixed at compile time; you can't add/remove features at runtime
3. **Rigid** — Adding a new channel requires creating multiple new subclasses
4. **Code Duplication** — Same coffee logic repeated across many subclasses

### ✅ Solution with Decorator Pattern:
1. **Just 5 classes** — 1 interface + 1 base + 1 abstract decorator + 2 concrete decorators
2. **Dynamic** — Features are added at runtime by wrapping objects
3. **Flexible** — Adding a new channel = creating just 1 new decorator class
4. **No Duplication** — Each channel's logic exists in exactly one class

---

## Design Pattern Used

**Decorator Pattern** (Structural Pattern)

- **Category:** Structural Design Pattern
- **Intent:** Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
- **Also Known As:** Wrapper Pattern
- **Source:** Gang of Four (GoF) Design Patterns

---

## Project Structure

```
Exercise-5-DecoratorPattern/
│
├── Coffee.java               ← Component Interface
├── BasicCoffee.java          ← Concrete Component (base)
├── CoffeeDecorator.java      ← Abstract Decorator
├── MilkCoffeeDecorator.java   ← Concrete Decorator (Milk)
├── SugarCoffeeDecorator.java ← Concrete Decorator (Sugar)
├── DecoratorPatternTest.java   ← Client Code (test)
└── README.md                   ← Documentation (this file)
```

---

## UML Class Diagram

```
       ┌──────────────────────┐
       │    <<interface>>     │
       │      Coffee        │
       │──────────────────────│
       │ + prepare(msg: String)  │
       └──────────┬───────────┘
                  │ implements
         ┌────────┴────────┐
         │                 │
         ▼                 ▼
┌─────────────────┐  ┌──────────────────────┐
│  BasicCoffee   │  │  <<abstract>>         │
│  (Concrete       │  │  CoffeeDecorator    │
│   Component)     │  │───────────────────────│
│─────────────────│  │ # coffee: Coffee   │
│ + prepare(msg)     │  │───────────────────────│
└─────────────────┘  │ + prepare(msg)            │
                     └──────────┬─────────────┘
                                │ extends
                       ┌────────┴────────┐
                       │                 │
                       ▼                 ▼
              ┌─────────────────┐ ┌─────────────────┐
              │  MilkCoffee    │ │  SugarCoffee   │
              │  Decorator      │ │  Decorator       │
              │─────────────────│ │─────────────────│
              │ + prepare(msg)     │ │ + prepare(msg)     │
              └─────────────────┘ └─────────────────┘
```

---

## Components

### Component — `Coffee`

The **Component** interface defines the common contract (`prepare()`) for both the base coffee and all decorators. The client always works with this interface.

| Role | Details |
|------|---------|
| Type | Interface |
| Method | `prepare(String details)` |
| Purpose | Unified interface for base and decorated objects |

### Concrete Component — `BasicCoffee`

The **Concrete Component** provides the default, core behavior — prepareing an email coffee. This is the object that gets wrapped by decorators.

| Role | Details |
|------|---------|
| Implements | `Coffee` |
| Behavior | Prints "Basic Coffee Coffee Sent: \<details\>" |
| Purpose | Base coffee functionality |

### Decorator — `CoffeeDecorator`

The **Abstract Decorator** implements `Coffee` and holds a reference to a wrapped `Coffee`. It delegates calls to the wrapped object, and concrete decorators extend this to add their own behavior.

| Role | Details |
|------|---------|
| Implements | `Coffee` |
| Contains | `protected Coffee coffee` (the wrapped object) |
| Behavior | Delegates `prepare()` to the wrapped coffee |
| Purpose | Base class for all concrete decorators |

### Concrete Decorators — `MilkCoffeeDecorator` & `SugarCoffeeDecorator`

The **Concrete Decorators** extend `CoffeeDecorator` and add their specific coffee channels.

| Decorator | Added Behavior |
|-----------|---------------|
| `MilkCoffeeDecorator` | Calls wrapped coffee, then prepares Milk |
| `SugarCoffeeDecorator` | Calls wrapped coffee, then prepares Sugar |

### Client — `DecoratorPatternTest`

The **Client** creates different decorator combinations to demonstrate dynamic feature addition.

---

## How Decorator Stacking Works

```
Case 3: Basic Coffee + Milk + Sugar

new SugarCoffeeDecorator(            ← Outer layer (Sugar)
    new MilkCoffeeDecorator(          ← Middle layer (Milk)
        new BasicCoffee()            ← Core (Basic Coffee)
    )
)

When prepare("") is called:

→ SugarDecorator.prepare()
    → super.prepare() [delegates to wrapped]
        → MilkDecorator.prepare()
            → super.prepare() [delegates to wrapped]
                → BasicCoffee.prepare()
                    → prints "Basic Coffee Coffee Sent: "
            → prints "Milk Coffee Sent: "
    → prints "Sugar Coffee Sent: "
```

---

## How to Compile and Run

```bash
# Navigate to the project folder
cd Exercise-5-DecoratorPattern

# Compile all Java files
javac *.java

# Run the test class
java DecoratorPatternTest
```

---

## Expected Output

```
=============================================
   Decorator Pattern - Coffee System    
=============================================

--- Case 1: Basic Coffee Only ---
Basic Coffee Coffee Sent: 

--- Case 2: Basic Coffee + Milk ---
Basic Coffee Coffee Sent: 
Milk Coffee Sent: 

--- Case 3: Basic Coffee + Milk + Sugar ---
Basic Coffee Coffee Sent: 
Milk Coffee Sent: 
Sugar Coffee Sent: 

=============================================
   All coffees sent successfully!       
=============================================
```

---

## Advantages of the Decorator Pattern

| Advantage | Explanation |
|-----------|-------------|
| **Open/Closed Principle** | Existing classes are never modified. New features are added via new decorator classes — open for extension, closed for modification. |
| **Dynamic Feature Addition** | Features (coffee channels) can be added or removed at **runtime** by wrapping or unwrapping decorators. No recompilation needed. |
| **Better Flexibility** | Any combination of decorators can be stacked in any order, giving maximum flexibility without class explosion. |
| **Avoid Class Explosion** | Instead of creating a subclass for every feature combination, we create one decorator per feature and combine them freely. |
| **Single Responsibility** | Each decorator handles exactly one feature (Milk, Sugar). Easy to understand, test, and maintain independently. |

---

## What is the Decorator Pattern?

The Decorator Pattern is a **structural design pattern** that attaches additional responsibilities to an object **dynamically**. It wraps the original object inside a decorator class that implements the same interface, enabling transparent layering of behaviors.

**Core idea:** Instead of modifying existing code or using inheritance, we "decorate" (wrap) objects with new functionality.

**Four key participants:**

| Participant | Role | In Our Example |
|-------------|------|----------------|
| **Component** | Common interface for base and decorators | `Coffee` |
| **Concrete Component** | The base object with core behavior | `BasicCoffee` |
| **Decorator** | Abstract wrapper implementing the Component | `CoffeeDecorator` |
| **Concrete Decorator** | Adds specific new behavior | `MilkCoffeeDecorator`, `SugarCoffeeDecorator` |

---

## Difference Between Decorator and Adapter Pattern

| Aspect | Decorator Pattern | Adapter Pattern |
|--------|-------------------|-----------------|
| **Purpose** | **Adds new behavior** to an existing object | Makes **incompatible interfaces** compatible |
| **Interface** | Keeps the **same interface** | **Changes** the interface |
| **What it wraps** | Wraps an object to **enhance** it | Wraps an object to **translate** its interface |
| **Relationship** | Decorator and Component share the **same** interface | Adapter and Adaptee have **different** interfaces |
| **Use Case** | Adding Milk/Sugar channels to an Basic Coffee coffee | Making PayPal's `makePayment()` work as `processPayment()` |
| **Stacking** | Decorators can be **stacked** (multiple layers) | Adapters are usually **not stacked** |
| **Simple Rule** | "I make it **better**" (enhancement) | "I make it **fit**" (conversion) |

---

## Difference Between Decorator and Inheritance

| Aspect | Decorator Pattern | Inheritance |
|--------|-------------------|-------------|
| **When features are added** | At **runtime** (dynamically) | At **compile time** (statically) |
| **Flexibility** | Any combination of features can be stacked in any order | Combinations are fixed in the class hierarchy |
| **Class Count** | Grows **linearly** (1 class per feature) | Grows **exponentially** (1 class per combination) |
| **Modification** | No existing classes modified | Subclasses tightly coupled to parent |
| **Open/Closed Principle** | ✅ Follows (open for extension, closed for modification) | ❌ Often violates (needs new subclasses for each combo) |
| **Example** | 3 channels → 5 classes total | 3 channels → 7+ subclass combinations |

---

## Real-World Examples of Decorator Pattern

| Example | Explanation |
|---------|-------------|
| **Java I/O Streams** | `new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")))` — each stream wraps and adds features (buffering, character conversion) to the base stream. This is the **classic** Decorator example in Java. |
| **Coffee Shop Orders** | Base coffee decorated with milk, sugar, whipped cream, caramel — each topping wraps the base and adds cost/description. |
| **Java `Collections.synchronizedList()`** | Wraps a regular `List` with synchronized access — same interface, added thread-safety behavior. |
| **Java `Collections.unmodifiableList()`** | Wraps a `List` and adds read-only behavior — throws exception on modification attempts. |
| **Web Middleware** | HTTP middleware (logging, authentication, compression) wraps a base handler, each adding a layer of processing. |
| **UI Components** | Scrollbars, borders, and shadows can be added as decorators around base UI components in GUI frameworks. |
| **Spring Security Filters** | Security filters in Spring wrap the request chain, each adding authentication, authorization, or logging. |

---

## Advantages and Disadvantages

### ✅ Advantages

| # | Advantage |
|---|-----------|
| 1 | **Flexible** — add/remove features at runtime |
| 2 | **Open/Closed Principle** — extend without modifying existing code |
| 3 | **Single Responsibility** — each decorator handles one concern |
| 4 | **No Class Explosion** — linear growth instead of exponential |
| 5 | **Composable** — decorators can be freely combined |

### ❌ Disadvantages

| # | Disadvantage |
|---|-------------|
| 1 | **Complexity** — many small classes can be hard to follow for beginners |
| 2 | **Order Matters** — the order of decorator wrapping can affect behavior |
| 3 | **Debugging** — stack traces through multiple decorators can be confusing |
| 4 | **Object Identity** — a decorated object is NOT the same as the original (`==` fails) |
| 5 | **Overhead** — multiple wrapping levels add slight performance overhead |

---

## Viva Questions with Answers (Interview Preparation)

### Q1: What is the Decorator Pattern?
**A:** The Decorator Pattern is a structural design pattern that allows adding new behavior to objects dynamically by wrapping them inside decorator classes. Each decorator implements the same interface as the original object and delegates calls to the wrapped object before or after adding its own behavior.

---

### Q2: What problem does the Decorator Pattern solve?
**A:** It solves the **class explosion problem** that occurs when using inheritance to combine multiple features. Instead of creating a subclass for every possible combination, you create one decorator per feature and stack them as needed at runtime.

---

### Q3: How is the Decorator Pattern different from Inheritance?
**A:** Inheritance adds behavior at **compile time** and is **static** — you can't change it at runtime. Decorator adds behavior at **runtime** and is **dynamic** — you can wrap and unwrap decorators freely. Decorator also avoids the exponential growth of subclasses.

---

### Q4: Why does the Decorator implement the same interface as the Component?
**A:** So the client can treat both the base component and the decorated component **identically**. The client doesn't know (or care) whether it's working with a plain `BasicCoffee` or an `BasicCoffee` wrapped in Milk and Sugar decorators — it just calls `prepare()`.

---

### Q5: Can decorators be stacked? How?
**A:** Yes! Since each decorator implements the same `Coffee` interface, a decorator can wrap another decorator:
```java
new SugarDecorator(new MilkDecorator(new BasicCoffee()))
```
Each layer calls the wrapped layer first, creating a chain of behavior.

---

### Q6: What is the role of the abstract decorator (CoffeeDecorator)?
**A:** The abstract decorator provides the common wrapping logic — it holds a reference to the wrapped `Coffee` and delegates the `prepare()` call. This avoids repeating the delegation code in every concrete decorator (DRY principle).

---

### Q7: Give a real-world Java example of the Decorator Pattern.
**A:** Java I/O Streams are the classic example:
```java
new BufferedReader(new InputStreamReader(new FileInputStream("file.txt")))
```
`FileInputStream` is the base, `InputStreamReader` is a decorator that converts bytes to characters, and `BufferedReader` is a decorator that adds buffering.

---

### Q8: How is Decorator different from Adapter?
**A:** Decorator **keeps** the same interface and adds behavior. Adapter **changes** the interface to make incompatible classes work together. Decorator enhances; Adapter translates.

---

### Q9: What are the disadvantages of the Decorator Pattern?
**A:** 1) Many small classes can increase complexity. 2) Order of wrapping can affect behavior. 3) Debugging through multiple decorator layers is harder. 4) Slight performance overhead from delegation chains.

---

### Q10: Does the order of decorators matter?
**A:** It can. In our example, the output order changes based on wrapping order:
- `new Sugar(new Milk(new Basic Coffee()))` → Basic Coffee, Milk, Sugar
- `new Milk(new Sugar(new Basic Coffee()))` → Basic Coffee, Sugar, Milk

The innermost decorator (closest to the base) executes first after the base.

---

*This project is part of the Cognizant Java FSE Assignment — Exercise 5.*
