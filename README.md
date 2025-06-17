# Selenium_Project
# 🛒 DemoBlaze E-Commerce Testing Project

A comprehensive automation and manual testing framework built to ensure the functionality, reliability, and scalability of the **DemoBlaze** online store.

## 📌 Project Overview

This project validates the core features of the DemoBlaze e-commerce site using both **manual testing** and **automated testing** (UI and API). Key functionalities tested include:

- User Authentication
- Product Browsing
- Cart Operations
- Checkout Process
- Responsive Design & Cross-Browser Compatibility
- Error Handling & Edge Case Testing

Built using industry-standard tools such as **Selenium**, **Java**, **Cucumber (BDD)**, and **Extent Reports**, this framework supports scalability and maintainability.

---

## 🛠 Tools & Technologies

### 🔹 Automation Testing

- **Selenium WebDriver** – For UI automation.
- **Java** – Primary scripting language.
- **Cucumber (BDD)** – Gherkin-based test scenarios.
- **Page Object Model (POM)** – For cleaner, maintainable code.

### 🔹 Manual Testing

- **Functional Testing** – Validates all key features.
- **Cross-Browser Testing** – Ensures app works on Chrome, Firefox, Edge, etc.
- **Responsive Testing** – Verifies UI on multiple screen sizes.
- **Exploratory Testing** – Identifies bugs beyond scripted test cases.

### 🔹 Build & Reporting Tools

- **Maven** – Project build & dependency management.
- **JUnit** – Test execution framework.
- **Extent Reports** – Rich test reporting in HTML.

---

## ✅ Features Tested

### ✅ UI Automation

- Login and Logout Functionality
- Product Catalog Display
- Add to Cart, Remove from Cart
- Order Placement
- Error/Alert Handling

### ✅ Manual Testing

- UI/UX Consistency Across Devices
- Exploratory Testing for Edge Cases
- Responsive Layouts on Different Devices
- Negative Testing Scenarios

---

## 📂 Project Structure

```plaintext
DemoBlaze-Testing/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── pageObjects/         # Page Object Model (POM) classes
│   └── test/
│       ├── java/
│       │   └── stepDefinitions/     # Step definitions for Cucumber (BDD)
│       └── resources/
│           └── features/            # Gherkin .feature files
├── pom.xml                          # Maven project configuration
├── testng.xml / junit configs       # Test execution configuration (JUnit/TestNG)
├── extent-config.xml                # ExtentReports configuration
└── README.md                        # Project documentation

### ✅ Conclusion
The DemoBlaze Testing Project successfully implements a scalable and maintainable test automation framework by integrating UI automation, manual testing, and planned API testing.
By leveraging best practices and tools, this project enhances product quality and reduces manual effort.
Future improvements will further ensure excellence in software validation and overall testing efficiency.
