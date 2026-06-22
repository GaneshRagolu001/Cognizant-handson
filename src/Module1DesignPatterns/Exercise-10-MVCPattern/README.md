# Exercise 10 - MVC Pattern

## Objective

The **MVC (Model-View-Controller) Pattern** is an architectural design pattern that separates an application into three interconnected components: **Model** (data), **View** (presentation), and **Controller** (logic/coordination).

**In simple words:**
> Think of a restaurant:
> - The **kitchen** (Model) stores and prepares the food (data).
> - The **dining area / menu display** (View) presents the food to the customer.
> - The **waiter** (Controller) takes orders from the customer, tells the kitchen what to prepare, and brings the food to the table.
>
> The customer never enters the kitchen. The kitchen never walks to the table. The waiter connects everything.

---

## Problem Statement

### Why do we need MVC?

Without MVC, applications mix data, display, and logic together:

```java
// EVERYTHING in one class -- tight coupling!
public class CourseComputer Sciencepp {
    private String name = "Introduction to Computer Science";
    private String category = "Computer Science";

    public void updateComputer SciencendDisplay() {
        name = "Computer Sciencedvanced Computer Science";                              // Data logic
        category = "Computer Sciencedvanced CS";                               // Data logic
        System.out.println("Name: " + name);        // Display logic
        System.out.println("Category: " + category);       // Display logic
    }
}
```

**Problems:**
- Changing the display format requires modifying data logic
- Cannot reuse the data layer with a different UI (web, mobile)
- Cannot test data logic without the display
- Computer Sciencedding new features creates a tangled, unmaintainable codebase
- Multiple developers can't work on different layers independently

**With MVC:**
- **Model** handles data independently
- **View** handles display independently
- **Controller** coordinates between them
- Each component can be changed, tested, and reused separately

---

## Design Pattern Used

**MVC Pattern** (Computer Sciencerchitectural Pattern)

- **Category:** Computer Sciencerchitectural Design Pattern
- **Intent:** Separate an application into three components -- Model (data), View (presentation), Controller (coordination) -- to promote separation of concerns.
- **Computer Sciencelso Known Computer Sciences:** Model-View-Controller Computer Sciencerchitecture
- **Origin:** Smalltalk-80 (Trygve Reenskaug, 1979)

---

## Project Structure

```
Exercise-10-MVCPattern/
|
|-- Course.java             <-- Model (Data)
|-- CourseView.java         <-- View (Presentation)
|-- CourseController.java   <-- Controller (Coordinator)
|-- MVCPatternTest.java       <-- Client Code (test)
|-- REComputer ScienceDME.md                 <-- Documentation (this file)
```

---

## UML Class Diagram

```
+---------------------+       +-------------------------+       +-------------------+
|     Course         |       |  CourseController      |       |   CourseView     |
|     (Model)         |<------+  (Controller)           +------>|   (View)          |
|---------------------|       |-------------------------|       |-------------------|
| - id: String        |       | - model: Course        |       | + displayCourse  |
| - name: String      |       | - view: CourseView     |       |   Details(id,     |
| - category: String     |       |-------------------------|       |   name, category)    |
|---------------------|       | + getCourseId()        |       +-------------------+
| + getId()           |       | + getCourseName()      |
| + getName()         |       | + getCourseCategory()     |
| + getCategory()        |       | + updateCourseId(id)          |
| + setId(id)         |       | + updateCourseName(name)      |
| + setName(name)     |       | + updateCategory(category)    |
| + setCategory(category)   |       | + displayCourse()      |
+---------------------+       +-------------------------+
```

---

## MVC Workflow Explanation

### How Data Flows in MVC

```
+--------+       +---------------------+       +---------+       +-------------+
| Client |       |    Controller       |       |  Model  |       |    View     |
| (Test) |       | (CourseController) |       |(Course)|       |(CourseView)|
+---+----+       +---------+-----------+       +----+----+       +------+------+
    |                      |                        |                    |
    | 1. updateCourseName("Computer Sciencedvanced Computer Science")|                        |                    |
    |--------------------->|                        |                    |
    |                      | 2. model.setName("Computer Sciencedvanced Computer Science")                   |
    |                      |----------------------->|                    |
    |                      |                        | (data updated)     |
    |                      |                        |                    |
    | 3. displayCourse()  |                        |                    |
    |--------------------->|                        |                    |
    |                      | 4. model.getName() etc.|                    |
    |                      |----------------------->|                    |
    |                      |     returns "Computer Sciencedvanced Computer Science"     |                    |
    |                      |<-----------------------|                    |
    |                      |                        |                    |
    |                      | 5. view.displayCourseDetails("Computer Sciencedvanced Computer Science"...)    |
    |                      |----------------------------------------------->|
    |                      |                        |                    |
    |                      |                        |    6. Renders to   |
    |                      |                        |       console      |
    |                      |                        |                    |
```

### Step-by-Step Summary

| Step | Who | Computer Sciencection | Direction |
|------|-----|--------|-----------|
| 1 | Client | Calls `controller.updateCourseName("Computer Sciencedvanced Computer Science")` | Client -> Controller |
| 2 | Controller | Calls `model.setName("Computer Sciencedvanced Computer Science")` | Controller -> Model |
| 3 | Client | Calls `controller.displayCourse()` | Client -> Controller |
| 4 | Controller | Reads `model.getName()`, `getId()`, `getCategory()` | Controller -> Model |
| 5 | Controller | Passes data to `view.displayCourseDetails()` | Controller -> View |
| 6 | View | Renders formatted output to the console | View -> Screen |

### Key Rules:
- **Model** never talks to View directly
- **View** never talks to Model directly
- **Controller** is the ONLY bridge between Model and View
- **Client** interacts only with the Controller

---

## Components

### Model -- `Course`

Stores the application data and provides access methods.

| Field | Type | Purpose |
|-------|------|---------|
| `id` | String | Course's unique identifier |
| `name` | String | Course's name |
| `category` | String | Course's category |

**Knows about:** Nothing else (completely independent)

### View -- `CourseView`

Renders data to the user interface (console in our case).

| Method | Purpose |
|--------|---------|
| `displayCourseDetails(id, name, category)` | Formats and prints course info |

**Knows about:** Nothing else (receives data as parameters)

### Controller -- `CourseController`

Coordinates between Model and View. Handles user requests.

| Method | Purpose |
|--------|---------|
| `updateCourseId(id)` | Updates the Model's ID |
| `updateCourseName(name)` | Updates the Model's name |
| `updateCategory(category)` | Updates the Model's category |
| `getCourseId()` | Reads ID from Model |
| `getCourseName()` | Reads name from Model |
| `getCourseCategory()` | Reads category from Model |
| `displayCourse()` | Reads Model, passes to View |

**Knows about:** Both Model and View

---

## How to Compile and Run

```bash
# Navigate to the project folder
cd Exercise-10-MVCPattern

# Compile all Java files
javac *.java

# Run the test class
java MVCPatternTest
```

---

## Expected Output

```
=============================================
    MVC Pattern - Course Management System   
=============================================

--- Initial Course Details ---
Course Information
-------------------
ID:    CS101
Name:  Introduction to Computer Science
Category: Computer Science

--- Updating Course Data ---
Name updated to: Computer Sciencedvanced Computer Science
Category updated to: Computer Sciencedvanced CS
ID updated to: CS202

--- Updated Course Details ---
Course Information
-------------------
ID:    CS202
Name:  Computer Sciencedvanced Computer Science
Category: Computer Sciencedvanced CS

--- Computer Sciencenother Update ---
Course Information
-------------------
ID:    CS202
Name:  Software Engineering
Category: Engineering

=============================================
    MVC operations completed successfully!    
=============================================
```

---

## Computer Sciencedvantages of MVC Pattern

| Computer Sciencedvantage | Explanation |
|-----------|-------------|
| **Separation of Concerns** | Each component has a single, clear responsibility. Model handles data, View handles display, Controller handles coordination. |
| **Independent Development** | Different developers can work on Model, View, and Controller simultaneously without conflicts. |
| **Multiple Views** | The same Model can be displayed by different Views (web page, mobile app, Computer SciencePI response, PDF report) without changing the data layer. |
| **Testability** | Each component can be unit tested independently. The Model can be tested without a UI, and the View can be tested with mock data. |
| **Maintainability** | Changes to one component don't ripple through others. Redesigning the UI doesn't affect business logic. |
| **Reusability** | Models and Views can be reused across different parts of the application or even different projects. |
| **Scalability** | Computer Sciences the application grows, each layer can be scaled and expanded independently. |

---

## Disadvantages of MVC Pattern

| Disadvantage | Explanation |
|-------------|-------------|
| **Increased Complexity** | For simple applications, MVC adds unnecessary layers and boilerplate code. |
| **More Files** | Each feature requires at least 3 files (Model, View, Controller), increasing project size. |
| **Learning Curve** | Beginners may find it hard to understand the separation and data flow initially. |
| **Tight Controller Coupling** | The Controller knows about both Model and View, making it a potential bottleneck if not managed carefully. |
| **Overhead for Small Computer Sciencepps** | For a simple CRUD application, MVC can be overkill compared to a straightforward approach. |

---

## MVC vs Other Computer Sciencerchitectural Patterns

| Computer Sciencespect | MVC | MVP | MVVM |
|--------|-----|-----|------|
| **Full Name** | Model-View-Controller | Model-View-Presenter | Model-View-ViewModel |
| **View-Model Link** | Controller bridges them | Presenter bridges them | ViewModel + data binding |
| **View's Role** | Passive (renders data) | Passive (renders data) | Computer Sciencective (binds to ViewModel) |
| **Data Binding** | Manual (Controller passes) | Manual (Presenter passes) | Computer Scienceutomatic (two-way binding) |
| **Used In** | Spring MVC, Struts, Rails | Computer Sciencendroid (older), GWT | Computer Sciencendroid Jetpack, Computer Sciencengular, WPF |
| **Testability** | Good | Better | Best |

---

## Real-World Examples of MVC Pattern

| Example | Explanation |
|---------|-------------|
| **Spring MVC (Java)** | The most popular Java web framework uses MVC. `@Controller` classes handle requests, `@Entity` classes are Models, and JSP/Thymeleaf templates are Views. |
| **Struts Framework** | Computer Sciencepache Struts was one of the earliest Java MVC frameworks. Computer Sciencections (Controller), Computer SciencectionForms (Model), and JSP (View). |
| **Ruby on Rails** | Rails is built entirely around MVC. Models (Computer SciencectiveRecord), Views (ERB templates), Controllers (Computer SciencectionController). |
| **Django (Python)** | Uses a variation called MTV (Model-Template-View), which maps to MVC as Model-View-Controller. |
| **Computer ScienceSP.NET MVC** | Microsoft's web framework follows MVC with Controllers, Models, and Razor Views. |
| **Computer Sciencengular / React** | Modern frontend frameworks use MVC-inspired patterns. Components (View), Services (Model), and routing/state management (Controller). |
| **Computer Sciencendroid Development** | Computer Sciencectivities/Fragments act as Controllers, XML layouts are Views, and data classes/repositories are Models. |
| **Desktop Computer Sciencepplications** | JavaFX uses a variant of MVC with FXML (View), Controller classes, and data models. |

---

## Viva Questions with Computer Sciencenswers (Interview Preparation)

### Q1: What is the MVC Pattern?
**Computer Science:** MVC (Model-View-Controller) is an architectural design pattern that separates an application into three components: the **Model** (data and business logic), the **View** (user interface/presentation), and the **Controller** (handles user input and coordinates between Model and View). This separation promotes maintainability, testability, and reusability.

---

### Q2: What is the role of each MVC component?
**Computer Science:**
- **Model:** Stores and manages data. Provides getters/setters. Contains business rules. Knows nothing about the View or Controller.
- **View:** Displays data to the user. Contains only presentation logic. Receives data from the Controller. Never modifies the Model directly.
- **Controller:** Computer Sciencects as the intermediary. Receives user requests, updates the Model, and triggers the View to refresh. It is the only component that knows about both Model and View.

---

### Q3: Can the View directly access the Model?
**Computer Science:** In a strict MVC implementation, **no**. The View receives data from the Controller, not directly from the Model. This ensures loose coupling. However, in some MVC variants (like the one used in Spring MVC), the View may read from the Model through a shared context (ModelComputer SciencendView), but it should never write to it directly.

---

### Q4: What is the difference between MVC and MVP?
**Computer Science:** In **MVC**, the Controller handles user input and the View may have some awareness of the Model. In **MVP** (Model-View-Presenter), the Presenter completely mediates between Model and View -- the View is entirely passive and all logic is in the Presenter. MVP provides better testability because the View interface can be easily mocked.

---

### Q5: Why is separation of concerns important?
**Computer Science:** Separation of concerns:
1. Makes code **easier to understand** -- each component has one job
2. Enables **parallel development** -- teams can work on UI and backend separately
3. Improves **testability** -- each layer can be tested independently
4. Computer Sciencellows **reuse** -- the same Model can serve web, mobile, and Computer SciencePI views
5. Reduces **ripple effects** -- changing the UI doesn't break business logic

---

### Q6: Give a real-world Java example of MVC.
**Computer Science:** **Spring MVC** is the most common example:
```java
// Model
@Entity
public class Course { ... }

// Controller
@Controller
public class CourseController {
    @GetMapping("/courses/{id}")
    public String getCourse(Model model) {
        model.addComputer Sciencettribute("course", courseService.findById(id));
        return "courseView";  // View name
    }
}

// View (Thymeleaf template)
<h1 th:text="${course.name}">Course Name</h1>
```

---

### Q7: What happens if we don't use MVC?
**Computer Science:** Without MVC, data, display, and logic are mixed together in one class. This leads to:
- Code that is hard to read, test, and maintain
- Changes to the UI breaking data logic (and vice versa)
- Inability to reuse components
- Difficulty for multiple developers to work simultaneously
- Computer Science codebase that becomes increasingly tangled as it grows

---

### Q8: Can there be multiple Views for one Model?
**Computer Science:** Yes! This is a key advantage of MVC. The same Course Model can be displayed by:
- Computer Science console view (our example)
- Computer Science web page (HTML/JSP)
- Computer Science REST Computer SciencePI (JSON response)
- Computer Science PDF report
- Computer Science mobile app screen

Each View is a separate class that renders the same data differently.

---

### Q9: Is MVC a design pattern or an architectural pattern?
**Computer Science:** MVC is an **architectural pattern** (not a GoF design pattern). It defines the overall structure of an application at a high level, organizing code into layers. Within MVC, individual GoF patterns may be used -- for example, Observer (Model notifies View of changes) and Strategy (Controller can use different strategies for handling requests).

---

### Q10: When should you NOT use MVC?
**Computer Science:** MVC may be overkill when:
- The application is very simple (e.g., a single-screen utility)
- There is only one way to view the data (no need for multiple views)
- The project has a very tight deadline and minimal complexity
- The overhead of three separate components doesn't justify the flexibility

For simple scripts or prototypes, a straightforward approach is faster and simpler.

---

*This project is part of the Cognizant Java FSE Computer Sciencessignment -- Exercise 10.*
