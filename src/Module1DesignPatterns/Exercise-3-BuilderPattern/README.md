# Exercise 3 - Builder Pattern

## Objective

The **Builder Pattern** is a creational design pattern that lets you construct complex objects **step by step**. Instead of passing a long list of parameters to a constructor, you use a separate Builder object to set each field individually and then create the final object.

**In simple words:**
> Imagine ordering a custom burger. You don't tell the chef everything at once. Instead, you say: "I want a bun... add lettuce... add cheese... add patty... done!" The Builder Pattern works the same way — you configure an object piece by piece and then "build" it when you're ready.

---

## Problem Statement

### Why is the Builder Pattern needed?

Consider creating a `Pizza` object with 5 attributes: size, crust, Cheese, pepperoni, and Mushrooms. Some of these are **optional** (e.g., not every pizza has a dedicated pepperoni).

**Without the Builder Pattern, you face these problems:**

### ❌ Problem 1: Telescoping Constructor
```java
// Which parameter is which? Hard to read!
Pizza pc = new Pizza("Medium", "Thin Crust", "true (cheese)", "true (pepperoni)", "false (mushrooms)");

// What if pepperoni is optional? Pass null? Ugly and confusing!
Pizza pc = new Pizza("Large", "Thick Crust", "true (cheese)", null, "false (mushrooms)");
```

### ❌ Problem 2: Too Many Constructor Overloads
```java
Pizza(String cpu, String ram)
Pizza(String cpu, String ram, String cheese)
Pizza(String cpu, String ram, String cheese, String gpu)
Pizza(String cpu, String ram, String cheese, String gpu, String os)
// This grows out of control with more fields!
```

### ❌ Problem 3: JavaBean Pattern (Setters)
```java
Pizza pc = new Pizza();
pc.setsize("Medium");
pc.setcrust("Thin Crust");
// Object is in an inconsistent state between setter calls!
// Also, the object is mutable — anyone can change it later.
```

### ✅ Solution: Builder Pattern
```java
Pizza margherita = new Pizza.Builder()
        .setsize("Medium")
        .setcrust("Thin Crust")
        .setCheese("true (cheese)")
        .setpepperoni("true (pepperoni)")
        .setMushrooms("false (mushrooms)")
        .build();
// Readable, flexible, and the result is immutable!
```

---

## Design Pattern Used

**Builder Pattern** (Creational Pattern)

- **Category:** Creational Design Pattern
- **Intent:** Separate the construction of a complex object from its representation, allowing the same construction process to create different representations.
- **Source:** Gang of Four (GoF) Design Patterns

---

## Project Structure

```
Exercise-3-BuilderPattern/
│
├── Pizza.java           ← Product class with nested Builder
├── BuilderPatternTest.java ← Client code demonstrating the pattern
└── README.md               ← Documentation (this file)
```

---

## UML Class Diagram

```
┌─────────────────────────────────────────┐
│              Pizza                   │
│─────────────────────────────────────────│
│ - size: String                           │
│ - crust: String                           │
│ - cheese: String                       │
│ - pepperoni: String                           │
│ - mushrooms: String               │
│─────────────────────────────────────────│
│ - Pizza(builder: Builder)            │
│ + getsize(): String                      │
│ + getcrust(): String                      │
│ + getCheese(): String                  │
│ + getpepperoni(): String                      │
│ + getOperatingSystem(): String          │
│ + toString(): String                    │
│                                         │
│  ┌───────────────────────────────────┐  │
│  │     <<static>> Builder            │  │
│  │───────────────────────────────────│  │
│  │ - size: String                     │  │
│  │ - crust: String                     │  │
│  │ - cheese: String                 │  │
│  │ - pepperoni: String                     │  │
│  │ - mushrooms: String         │  │
│  │───────────────────────────────────│  │
│  │ + setsize(cpu): Builder            │  │
│  │ + setcrust(ram): Builder            │  │
│  │ + setCheese(cheese): Builder    │  │
│  │ + setpepperoni(gpu): Builder            │  │
│  │ + setMushrooms(os): Builder │  │
│  │ + build(): Pizza               │  │
│  └───────────────────────────────────┘  │
└─────────────────────────────────────────┘
```

---

## Implementation Details

### Product (`Pizza`)

The `Pizza` class is the complex object we want to build. It has:
- **5 attributes** — size, crust, Cheese, pepperoni, Mushrooms
- **Private constructor** — cannot be instantiated directly with `new Pizza()`
- **No setter methods** — making the object **immutable** after construction
- **`toString()` override** — for clean, formatted output

### Builder (`Pizza.Builder`)

The `Builder` is a **static nested class** inside `Pizza`. It has:
- **Same fields** as `Pizza` — it mirrors all the attributes
- **Setter methods** — each setter stores a value and returns `this` (the Builder itself)
- **`build()` method** — creates and returns the final `Pizza` object

### `build()` Method

The `build()` method is the final step:
```java
public Pizza build() {
    return new Pizza(this);
}
```
It passes the Builder (with all collected values) to Pizza's private constructor, which copies the values into the new Pizza object.

### Method Chaining

Each setter method in the Builder returns `this` (the Builder instance), allowing multiple calls to be **chained** together in a single fluent statement:

```java
// Without method chaining (verbose)
Pizza.Builder builder = new Pizza.Builder();
builder.setsize("Medium");
builder.setcrust("Thin Crust");
builder.setCheese("true (cheese)");
Pizza pc = builder.build();

// With method chaining (clean and readable)
Pizza pc = new Pizza.Builder()
        .setsize("Medium")
        .setcrust("Thin Crust")
        .setCheese("true (cheese)")
        .build();
```

---

## How to Compile and Run

```bash
# Navigate to the project folder
cd Exercise-3-BuilderPattern

# Compile all Java files
javac *.java

# Run the test class
java BuilderPatternTest
```

---

## Expected Output

```
=============================================
   Builder Pattern - Pizza Configurations  
=============================================

--- Margherita Pizza ---
  size            : Medium
  crust            : Thin Crust
  Cheese        : true (cheese)
  pepperoni            : true (pepperoni)
  Mushrooms: false (mushrooms)

--- Pepperoni Pizza ---
  size            : Large
  crust            : Thick Crust
  Cheese        : true (cheese)
  pepperoni            : N/A
  Mushrooms: false (mushrooms)

--- Veggie Pizza ---
  size            : Small
  crust            : Gluten Free
  Cheese        : true (cheese)
  pepperoni            : N/A
  Mushrooms: true (mushrooms)

=============================================
   All configurations created successfully!   
=============================================
```

---

## Advantages of the Builder Pattern

| Advantage | Explanation |
|-----------|-------------|
| **Readable Code** | Method chaining makes the object creation process self-documenting. You can clearly see what each field is set to. |
| **Handles Optional Parameters** | You can skip optional fields (like pepperoni) without passing `null` or creating multiple constructors. |
| **Easy Object Creation** | Complex objects with many fields can be created in a clean, step-by-step manner. |
| **Better Maintainability** | Adding a new field only requires adding it to the Builder — existing client code remains unaffected. |
| **Immutable Objects** | The constructed object has no setters, making it thread-safe and predictable. |
| **No Telescoping Constructors** | Eliminates the need for multiple overloaded constructors with different parameter combinations. |

---

## What Problem Does the Builder Pattern Solve?

The Builder Pattern solves the **telescoping constructor anti-pattern** — the problem of creating objects that have many fields, some of which are optional.

| Problem | How Builder Solves It |
|---------|----------------------|
| Too many constructor parameters | Builder sets fields individually with named methods |
| Can't remember parameter order | Each field has a clearly named setter method |
| Optional parameters need `null` | Optional fields are simply not set on the Builder |
| Object can be in inconsistent state | `build()` creates the object only when fully configured |
| Object is mutable after creation | Pizza has no setters — it's immutable |

---

## Difference Between Builder Pattern and Factory Pattern

| Aspect | Builder Pattern | Factory Pattern |
|--------|----------------|-----------------|
| **Purpose** | Constructs a **single complex object** step by step with many optional configurations. | Creates **different types** of objects from a common interface. |
| **Focus** | HOW to build an object (configuration) | WHICH object to create (type selection) |
| **Object Complexity** | Designed for objects with **many fields** (some optional) | Designed for objects from a **family of related types** |
| **Construction** | Multi-step process with method chaining | Single-step creation via factory method |
| **Return Type** | Always returns the **same type** of object (with different configurations) | Returns **different types** (e.g., WordDocument, PdfDocument) |
| **Example** | Building a custom Pizza with specific specs | Creating a Document (Word vs PDF vs Excel) |
| **Real Analogy** | Customizing a pizza with toppings | Choosing between pizza, burger, or pasta |

**When to use which?**
- Use **Builder** when you have **one complex object** with many optional fields.
- Use **Factory** when you have **multiple related object types** and need to decide which one to create.

---

## Real-World Use Cases of Builder Pattern

| Use Case | Explanation |
|----------|-------------|
| **`StringBuilder` in Java** | `new StringBuilder().append("Hello").append(" ").append("World").toString()` — builds a String step by step. |
| **`HttpRequest.Builder` (Java 11+)** | `HttpRequest.newBuilder().uri(URI.create("...")).GET().build()` — builds HTTP requests with optional headers, timeouts, etc. |
| **`AlertDialog.Builder` in Android** | `new AlertDialog.Builder(context).setTitle("...").setMessage("...").create()` — constructs dialog boxes with optional buttons and icons. |
| **`Stream.Builder` in Java 8+** | `Stream.builder().add(1).add(2).add(3).build()` — creates streams by adding elements one at a time. |
| **Lombok `@Builder`** | The popular Lombok library auto-generates Builder classes for POJOs using the `@Builder` annotation. |
| **SQL Query Builders** | Libraries like JOOQ and QueryDSL use builders to construct SQL queries fluently: `select(field).from(table).where(condition)`. |
| **Configuration Objects** | Frameworks like Spring Boot use builder-style patterns to configure beans, security, and routes. |

---

## Viva Questions with Answers (Interview Preparation)

### Q1: What is the Builder Pattern?
**A:** The Builder Pattern is a creational design pattern that separates the construction of a complex object from its representation. It allows you to create different configurations of the same object using a step-by-step approach with method chaining.

---

### Q2: Why do we make the Pizza constructor private?
**A:** The constructor is made private to ensure that Pizza objects can ONLY be created through the Builder. This prevents direct instantiation and guarantees that the object is always constructed in a controlled, consistent manner.

---

### Q3: What is method chaining? How does it work?
**A:** Method chaining is a technique where each method returns the object it belongs to (`return this`), allowing multiple method calls to be linked together in a single statement. In the Builder, each setter returns the Builder itself, so you can write:
```java
new Pizza.Builder().setsize("i9").setcrust("Thin Crust").build();
```

---

### Q4: Why is the Builder a static nested class?
**A:** It's `static` so it can be created without an instance of the outer class (Pizza). It's `nested` because it logically belongs to Pizza — it's the only class that should build Pizzas. Being nested also gives it access to Pizza's private constructor.

---

### Q5: How does the Builder Pattern handle optional parameters?
**A:** With the Builder Pattern, you simply don't call the setter for optional parameters. Unlike constructors where you'd need to pass `null`, the Builder lets you skip fields entirely. Unset fields remain `null` or can have default values.

---

### Q6: What is the difference between Builder Pattern and Factory Pattern?
**A:** The Factory Pattern decides **which type** of object to create (e.g., Word vs PDF). The Builder Pattern decides **how to configure** a single complex object (e.g., a Pizza with specific specs). Factory focuses on type selection; Builder focuses on step-by-step construction.

---

### Q7: Is the object created by Builder mutable or immutable?
**A:** The Pizza object is **immutable**. It has no setter methods, and all fields are set only once through the private constructor. This makes it thread-safe and predictable.

---

### Q8: Can you name real-world examples of Builder Pattern in Java?
**A:** Yes — `StringBuilder`, `StringBuffer`, `HttpRequest.Builder` (Java 11+), `Stream.Builder` (Java 8+), `ProcessBuilder`, `Locale.Builder`, and Android's `AlertDialog.Builder`.

---

### Q9: What happens if you call `build()` without setting any fields?
**A:** A Pizza object is created with all fields set to `null`. The `toString()` method handles this by displaying "N/A" for unset fields. In production code, you could add validation in the `build()` method to throw an exception if required fields are missing.

---

### Q10: What is the telescoping constructor problem?
**A:** It's when a class has multiple constructors with increasing numbers of parameters to handle optional fields:
```java
Pizza(String cpu)
Pizza(String cpu, String ram)
Pizza(String cpu, String ram, String cheese)
Pizza(String cpu, String ram, String cheese, String gpu)
Pizza(String cpu, String ram, String cheese, String gpu, String os)
```
This is hard to read, maintain, and use. The Builder Pattern eliminates this problem entirely.

---

*This project is part of the Cognizant Java FSE Assignment — Exercise 3.*
