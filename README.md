# Question 01: JavaFX Circle Radius Calculator

A modern, production-grade JavaFX application built with Java 17 and Maven to calculate the radius of any given circle.

## Mathematical Principle

The standard equation of a circle is given by:
$$x^2 + y^2 + 2gx + 2fy + c = 0$$

Where $g$, $f$, and $c$ are constant real numbers.

The radius $R$ is calculated as:
$$R = \sqrt{g^2 + f^2 - c}$$

### Validation Rules
- **Real Circle**: $g^2 + f^2 - c > 0$
- **Point Circle**: $g^2 + f^2 - c = 0$ (Radius = 0)
- **Imaginary Circle**: $g^2 + f^2 - c < 0$ (Invalid input feedback shown to user)

---

## Technical Stack & Architecture

- **Language**: Java 17 (OpenJDK 17)
- **UI Framework**: OpenJFX 17 (JavaFX)
- **Build System**: Apache Maven 3.8+
- **Testing Framework**: JUnit 5 (JUnit Jupiter)
- **Architecture**: Model-View-Controller (MVC)
  - `RadiusCalculationResult`: Immutable domain model holding calculation result & state
  - `RadiusCalculatorService`: Pure Java service encapsulating circle formula and validation logic
  - `CalculatorController`: JavaFX UI controller managing FXML event bindings
  - `MainApp`: Stage launcher initializing custom FXML & CSS stylesheet

---

## How to Build & Run

### 1. Run Unit Tests
```bash
mvn clean test
```

### 2. Run JavaFX Application
```bash
mvn clean javafx:run
```

### 3. Package Executable JAR
```bash
mvn clean package
```
