#  Automation Exercise QA Automation Project

This repository contains a Selenium WebDriver automation testing project for the **Automation Exercise** web application.

The project was developed as part of a collaborative Software QA Automation team project, focusing on automated functional testing, Page Object Model (POM) architecture, GitHub collaboration workflow, and full integration testing.

---

# 📌 Project Scope

The automation suite covers the major user workflows of the Automation Exercise website, including:

* Authentication & User Registration
* Products & Navigation
* Cart & Subscription
* Checkout & Order Placement
* UI Validation & Scroll Behavior

---

# 🛠 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* Page Object Model (POM)
* Git & GitHub

---

# 📂 Project Structure

```text
automation-exercise-qa-project
│
├── docs
│   ├── SRS
│   ├── Test-Cases
│   └── Presentation
│
├── src/test/java
│   ├── base
│   │   └── BaseTest.java
│   │
│   ├── pages
│   │   ├── LoginPage.java
│   │   ├── SignupPage.java
│   │   ├── ProductsPage.java
│   │   ├── CartPage.java
│   │   ├── CheckoutPage.java
│   │   └── HomePage.java
│   │
│   ├── tests
│   │   ├── AuthenticationTests.java
│   │   ├── ProductsTests.java
│   │   ├── CartTests.java
│   │   └── CheckoutTests.java
│   │
│   └── utils
│       └── TestData.java
│
├── pom.xml
├── testng.xml
└── README.md
```

---

# 👥 Test Case Distribution

| Team Member       | Module                   | Test Cases                               |
| ----------------- | ------------------------ | ---------------------------------------- |
| Ahmad             | Authentication           | TC 1, TC 2, TC 3, TC 4, TC 5, TC 6       |
| Basil             | Products & Navigation    | TC 7, TC 8, TC 9, TC 18, TC 19, TC 21    |
| Hamza             | Cart & Subscription      | TC 10, TC 11, TC 12, TC 13, TC 17, TC 20 |
| Mohammed Al Swesy | Checkout & UI Validation | TC 16, TC 22, TC 23, TC 24, TC 25, TC 26 |

---

# ✨ Key Features

* Automated functional test execution
* Page Object Model (POM) implementation
* Reusable page classes and methods
* Centralized test data management
* Explicit waits for dynamic elements
* JavaScript click handling for overlay advertisements
* Branch-based GitHub collaboration workflow
* Maven-based dependency management
* TestNG suite execution

---

# ▶️ How to Run the Project

## Prerequisites

Make sure the following tools are installed:

* Java JDK 17 or later
* Maven
* Eclipse or IntelliJ IDEA
* Google Chrome
* Git

---

## Steps

### 1. Clone the Repository

```bash
git clone https://github.com/mohammedswesy/automation-exercise-qa-project.git
```

### 2. Open the Project

Open the project using Eclipse or IntelliJ IDEA.

---

### 3. Update Maven Dependencies

In Eclipse:

```text
Right Click Project → Maven → Update Project
```

---

### 4. Run the Test Suite

Using TestNG:

```text
Right Click testng.xml → Run As → TestNG Suite
```

Or run from terminal:

```bash
mvn test
```

---

# 📊 Test Execution Result

The project was executed as a complete integration suite after merging all team branches into the `main` branch.

The automation suite validates major workflows across:

* Authentication
* Products
* Cart
* Checkout

> Note: Some test failures may occur due to external website behavior such as advertisements, dynamic elements, or temporary page loading delays.

---

# 🌿 GitHub Workflow

The team followed a branch-based Git workflow:

```text
main
├── auth-tests
├── products-tests
├── cart-tests
└── checkout-tests
```

Each team member worked on a separate branch, pushed their changes, and created a Pull Request before merging into the `main` branch.

---

# 📑 Documentation

The repository includes supporting QA documentation:

* Software Requirement Specification (SRS)
* Test Cases
* Presentation Slides
* Project Documentation Files

---

# 👨‍💻 Team Members

* Mohammed Al Swesy
* Ahmad
* Basil
* Hamza

---

# 🔗 Repository

GitHub Repository:

https://github.com/mohammedswesy/automation-exercise-qa-project
