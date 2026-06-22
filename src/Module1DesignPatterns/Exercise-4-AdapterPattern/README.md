# Exercise 4 - Adapter Pattern

## Objective

The **Adapter Pattern** is a structural design pattern that allows objects with **incompatible interfaces** to work together. It acts as a bridge (or translator) between two interfaces that couldn't otherwise communicate.

**In simple words:**
> Imagine you travel from India to Europe. Your Indian charger plug doesn't fit into a European socket. You use a **plug adapter** — it doesn't change your charger or the socket; it simply makes them compatible. The Adapter Pattern does the same thing in code — it wraps an existing class and makes it compatible with a different interface.

---

## Problem Statement

### Why do different print printers create integration problems?

In real-world applications, we often need to integrate **multiple third-party services** (print printers, notification services, cloud providers, etc.). Each service comes with its **own unique API**:

| Printer | Method Name | Our App Expects |
|---------|-------------|-----------------|
| InkJet  | `printInkJet(double document)` | `print(double document)` |
| Laser  | `pay(double document)` | `print(double document)` |
| Razorpay (future) | `executePrint(double document)` | `print(double document)` |

**The problems:**
1. ❌ Our client code would need **different logic** for each printer
2. ❌ Adding a new printer requires **modifying existing code**
3. ❌ We **can't change** third-party code (we don't own it)
4. ❌ **Tight coupling** between client code and specific printer implementations

**The solution — Adapter Pattern:**
1. ✅ Define ONE common interface (`Printer`)
2. ✅ Create an adapter for each printer that **translates** the call
3. ✅ Client code uses ONLY the common interface — **zero coupling** to printers
4. ✅ Adding a new printer = adding a new adapter — **no existing code changes**

---

## Design Pattern Used

**Adapter Pattern** (Structural Pattern)

- **Category:** Structural Design Pattern
- **Intent:** Convert the interface of a class into another interface that clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
- **Also Known As:** Wrapper Pattern
- **Source:** Gang of Four (GoF) Design Patterns

---

## Project Structure

```
Exercise-4-AdapterPattern/
│
├── Printer.java       ← Target Interface
├── InkJetPrinter.java          ← Adaptee (third-party)
├── LaserPrinter.java          ← Adaptee (third-party)
├── InkJetPrinterAdapter.java          ← Adapter (bridge)
├── LaserPrinterAdapter.java          ← Adapter (bridge)
├── AdapterPatternTest.java     ← Client Code (test)
└── README.md                   ← Documentation (this file)
```

---

## UML Class Diagram

```
  ┌──────────────────────┐
  │   <<interface>>      │
  │  Printer    │
  │──────────────────────│
  │ + print(    │
  │     double document)   │
  └──────────┬───────────┘
             │ implements
      ┌──────┴──────┐
      │             │
      ▼             ▼
┌────────────┐ ┌────────────┐
│  InkJet    │ │  Laser    │
│  Adapter   │ │  Adapter   │
│────────────│ │────────────│
│ - printer  │ │ - printer  │
│────────────│ │────────────│
│ + process  │ │ + process  │
│  Print() │ │  Print() │
└─────┬──────┘ └─────┬──────┘
      │ delegates     │ delegates
      ▼               ▼
┌────────────┐ ┌────────────┐
│  InkJet    │ │  Laser    │
│  Printer   │ │  Printer   │
│────────────│ │────────────│
│ + make     │ │ + pay()    │
│  Print() │ │            │
└────────────┘ └────────────┘
   (Adaptee)     (Adaptee)
```

---

## Components

### Target — `Printer`

The **Target** is the interface that the client code expects. It defines the common method `print(double document)` that all print printers should support.

| Role | Description |
|------|-------------|
| Type | Interface |
| Method | `print(double document)` |
| Purpose | Defines the contract the client uses |

### Adaptees — `InkJetPrinter` & `LaserPrinter`

The **Adaptees** are existing third-party classes with their own incompatible interfaces. We cannot modify them.

| Adaptee | Method | Why Incompatible |
|---------|--------|------------------|
| `InkJetPrinter` | `printInkJet(double document)` | Different method name than `print()` |
| `LaserPrinter` | `pay(double document)` | Different method name than `print()` |

### Adapters — `InkJetPrinterAdapter` & `LaserPrinterAdapter`

The **Adapters** are the bridge classes that make the Adaptees compatible with the Target interface.

| Adapter | Implements | Wraps | Translation |
|---------|-----------|-------|-------------|
| `InkJetPrinterAdapter` | `Printer` | `InkJetPrinter` | `print()` → `printInkJet()` |
| `LaserPrinterAdapter` | `Printer` | `LaserPrinter` | `print()` → `pay()` |

### Client — `AdapterPatternTest`

The **Client** works exclusively with the `Printer` interface. It doesn't know (or care) which printer is being used behind the scenes.

---

## How to Compile and Run

```bash
# Navigate to the project folder
cd Exercise-4-AdapterPattern

# Compile all Java files
javac *.java

# Run the test class
java AdapterPatternTest
```

---

## Expected Output

```
=============================================
   Adapter Pattern - Print Processing      
=============================================

InkJet Print Processed: 1000.0

Laser Print Processed: 2500.0

--- Processing Multiple Prints ---
InkJet Print Processed: 500.0
Laser Print Processed: 1500.0

=============================================
   All prints processed successfully!       
=============================================
```

---

## Advantages of the Adapter Pattern

| Advantage | Explanation |
|-----------|-------------|
| **Reusability** | Existing third-party classes (InkJetPrinter, LaserPrinter) can be reused without modification. |
| **Compatibility** | Incompatible interfaces are made compatible through the adapter, enabling seamless integration. |
| **Loose Coupling** | Client code depends only on the Target interface (`Printer`), not on specific printers. |
| **Easier Maintenance** | Changes to a printer's API only require updating its adapter — client code remains unchanged. |
| **Open/Closed Principle** | New printers can be added by creating new adapters without modifying any existing code. |
| **Single Responsibility** | Each adapter has one job — translating between two interfaces. |

---

## What is the Adapter Pattern?

The Adapter Pattern is a **structural design pattern** that allows two incompatible interfaces to collaborate. It wraps an existing class (the Adaptee) with a new class (the Adapter) that implements the interface the client expects (the Target).

**Key participants:**

| Participant | Role | In Our Example |
|-------------|------|----------------|
| **Target** | The interface the client expects | `Printer` |
| **Adaptee** | The existing class with an incompatible interface | `InkJetPrinter`, `LaserPrinter` |
| **Adapter** | Wraps the Adaptee and implements the Target | `InkJetPrinterAdapter`, `LaserPrinterAdapter` |
| **Client** | Uses the Target interface | `AdapterPatternTest` |

---

## Why is it Called a "Wrapper" Pattern?

The Adapter Pattern is called a **Wrapper** because the Adapter class literally "wraps" the Adaptee:

```java
public class InkJetPrinterAdapter implements Printer {
    
    private InkJetPrinter payPalPrinter;  // ← Wrapped (hidden) inside
    
    public void print(double document) {
        payPalPrinter.printInkJet(document);  // ← Delegated internally
    }
}
```

- The **outside** of the wrapper conforms to the Target interface (`print`)
- The **inside** of the wrapper contains the Adaptee (`payPalPrinter.printInkJet`)
- The client sees only the wrapper — never the Adaptee directly

Just like a gift wrapper changes the outside appearance without changing what's inside!

---

## Difference Between Adapter Pattern and Decorator Pattern

| Aspect | Adapter Pattern | Decorator Pattern |
|--------|----------------|-------------------|
| **Purpose** | Makes **incompatible** interfaces compatible | **Adds new behavior** to an existing object |
| **Interface Change** | Changes the interface (from Adaptee's to Target's) | Keeps the **same interface** but enhances it |
| **Motivation** | Integration — making existing code work with new code | Extension — adding features without modifying the class |
| **Wrapping** | Wraps an object with a **different** interface | Wraps an object with the **same** interface |
| **Example** | InkJetPrinterAdapter converts `printInkJet()` to `print()` | LoggingDecorator adds logging before calling `print()` |
| **Relationship** | Adapter and Adaptee have **different** interfaces | Decorator and Component share the **same** interface |
| **GoF Category** | Structural | Structural |

**Simple rule of thumb:**
- **Adapter** = "I make it fit" (interface conversion)
- **Decorator** = "I make it better" (behavior enhancement)

---

## Real-World Examples of Adapter Pattern

| Example | Explanation |
|---------|-------------|
| **Power Plug Adapter** | Converts a US plug shape to fit a European socket — doesn't change the electrical current, just the physical interface. |
| **`Arrays.asList()` in Java** | Adapts an array (which has no `List` methods) to the `List` interface. The array is the Adaptee; the returned List is the adapted view. |
| **`InputStreamReader` in Java** | Adapts a byte stream (`InputStream`) to a character stream (`Reader`). It wraps the byte stream and translates bytes to characters. |
| **JDBC Drivers** | Each database vendor provides a JDBC driver that adapts their proprietary protocol to Java's standard `java.sql.Connection` interface. |
| **Android `RecyclerView.Adapter`** | Adapts a data source (like a List of items) to the RecyclerView's interface for displaying items in a scrollable list. |
| **SLF4J Logging** | SLF4J provides adapters for different logging frameworks (Log4j, java.util.logging) so your code uses one common logging API. |
| **Print Printer SDKs** | Real print platforms like Laser, InkJet, and Square all have different APIs. Adapter classes standardize them for e-commerce platforms. |

---

## Viva Questions with Answers (Interview Preparation)

### Q1: What is the Adapter Pattern?
**A:** The Adapter Pattern is a structural design pattern that converts the interface of one class into another interface that clients expect. It allows classes with incompatible interfaces to work together by wrapping the incompatible class inside an adapter.

---

### Q2: What are the key components of the Adapter Pattern?
**A:** The four key components are:
1. **Target** — the interface the client expects (`Printer`)
2. **Adaptee** — the existing class with an incompatible interface (`InkJetPrinter`)
3. **Adapter** — the class that wraps the Adaptee and implements the Target (`InkJetPrinterAdapter`)
4. **Client** — the code that uses the Target interface (`AdapterPatternTest`)

---

### Q3: What is the difference between Object Adapter and Class Adapter?
**A:**
- **Object Adapter** uses **composition** — the adapter holds an instance of the Adaptee. This is the approach used in Java and is more flexible.
- **Class Adapter** uses **multiple inheritance** — the adapter extends both the Target and the Adaptee. This is NOT possible in Java (no multiple class inheritance), but works in C++.

Our implementation uses the Object Adapter approach.

---

### Q4: Why is the Adapter Pattern also called the Wrapper Pattern?
**A:** Because the adapter "wraps" the Adaptee inside itself. The outside of the wrapper exposes the Target interface, while the inside holds and delegates to the Adaptee. The client only interacts with the wrapper, never seeing the Adaptee directly.

---

### Q5: How is the Adapter Pattern different from the Decorator Pattern?
**A:** The Adapter changes the **interface** (converts one interface to another), while the Decorator keeps the **same interface** but adds new behavior. Adapter is about compatibility; Decorator is about enhancement.

---

### Q6: Can we add a new print printer without changing existing code?
**A:** Yes! This is a key benefit. To add a new printer (e.g., Razorpay):
1. Create `RazorpayPrinter` (the Adaptee)
2. Create `RazorpayAdapter implements Printer` (the Adapter)
3. Use it in client code: `Printer razorpay = new RazorpayAdapter();`

No existing adapters or client code need to change.

---

### Q7: Does the Adaptee know it is being adapted?
**A:** No. The Adaptee (`InkJetPrinter`, `LaserPrinter`) has no knowledge of the adapter or the target interface. It is completely independent. This is a key advantage — we don't modify third-party code.

---

### Q8: Give a real-world Java example of the Adapter Pattern.
**A:** `InputStreamReader` is a classic example. It adapts an `InputStream` (byte-based) to a `Reader` (character-based):
```java
Reader reader = new InputStreamReader(new FileInputStream("file.txt"));
```
Here, `InputStreamReader` is the Adapter, `FileInputStream` is the Adaptee, and `Reader` is the Target.

---

### Q9: What design principle does the Adapter Pattern follow?
**A:** It follows the **Open/Closed Principle** (open for extension, closed for modification) and the **Dependency Inversion Principle** (depend on abstractions, not concrete classes). The client depends on the `Printer` interface, not on specific printers.

---

### Q10: When should you use the Adapter Pattern?
**A:** Use the Adapter Pattern when:
- You want to use an existing class but its interface is incompatible with your system
- You are integrating third-party libraries or legacy code
- You want to create a reusable class that cooperates with unrelated classes
- You need to provide a uniform interface to a set of alternative implementations

---

*This project is part of the Cognizant Java FSE Assignment — Exercise 4.*
