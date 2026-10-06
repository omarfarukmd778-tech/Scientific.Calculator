# 🧮 Scientific Calculator (Java Swing)

![Java](https://img.shields.io/badge/Java-JDK-orange?logo=openjdk)
![GUI](https://img.shields.io/badge/GUI-Java%20Swing-blue)
![Theme](https://img.shields.io/badge/Theme-Dark%20Mode-black)

A robust desktop **Scientific Calculator** built with **Java Swing**. It bridges the gap between simple arithmetic and advanced scientific calculations, offering a clean, modern, dark-themed and user-friendly interface.

---

## 📌 Table of Contents

- [Features](#-features)
- [Technical Details](#-technical-details)
- [Getting Started](#-getting-started)
- [Usage](#-usage)
- [Project Structure](#-project-structure)
- [Author](#-author)

---

## ✨ Features

### 🧮 Mathematical Capabilities

- **Basic Arithmetic:** Addition, subtraction, multiplication and division.
- **Trigonometry & Logarithms:** `sin`, `cos`, `tan`, `log` (base 10) and `ln` (natural log).
- **Exponents & Roots:** Square (`x²`), square root (`√x`) and general power (`x^y`).
- **Constants:** Quick buttons for **π (Pi)** and **e (Euler's number)**.

### 🖥 User Interface & Experience

- **Modern Dark Theme:** Custom color palette (`BG_DARK`, `BG_PANEL`) to reduce eye strain.
- **Dynamic Display:** Font size adjusts automatically based on input length.
- **Interactive Feedback:** Button hover effects and a status indicator showing the current state (`Power`, `Ready`, `Error`, `Result`).
- **User Control:**
  - `ANS` – recall the last answer
  - `CE` – clear entry
  - `AC` – all clear

### 🛡 Error Handling

Detects and displays errors for invalid input, such as division by zero and domain-specific math errors.

---

## 🛠 Technical Details

| Component | Description |
|-----------|-------------|
| Language | Java |
| GUI Framework | Java Swing (`javax.swing`) |
| Event Handling | `ActionListener` and `MouseAdapter` |
| Layouts | `BorderLayout` and `GridLayout` |
| Platform | Cross-platform (Windows, macOS, Linux) |

---

## 🚀 Getting Started

### Prerequisites

- **JDK (Java Development Kit)** installed and configured (JDK 8 or higher recommended).

Check your installation:

```bash
java -version
javac -version
```

### Installation & Execution

1. **Clone the repository**

```bash
   git clone https://github.com/<your-username>/<your-repo-name>.git
   cd <your-repo-name>
```

   Or simply download `Scientific_calculator.java`.

2. **Compile**

```bash
   javac Scientific_calculator.java
```

3. **Run**

```bash
   java Scientific_calculator
```

---

## 💡 Usage

1. Click number and operator buttons to build an expression.
2. Use function buttons (`sin`, `cos`, `tan`, `log`, `ln`, `√x`, `x²`, `x^y`) for scientific operations.
3. Press `π` or `e` to insert constants.
4. Press `ANS` to reuse the previous result.
5. Use `CE` to clear the current entry or `AC` to reset everything.

---

## 📂 Project Structure

```
Scientific-Calculator/
├── Scientific_calculator.java
└── README.md
```

---

## 👨‍💻 Author

**Md Omor Faruk**
Student ID: 11240321755

Developed as part of the **Object-Oriented Programming II Lab** project.

---

## 📄 License

This project is created for educational purposes.
