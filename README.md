
# 🧪 Shady Meadows B&B – Test Automation Framework

This project automates the key functionalities of the **Shady Meadows B&B** website, including:

- 🛏️ Room Booking
- 📩 Contact Form Submission
- 🎯 UX/UI Element Verification

The automation framework is implemented using "Selenium WebDriver", "Java", "Maven", and "TestNG", following the "Page Object Model (POM)" for modularity and scalability.

---

## 🧱 Framework Structure

### 🔸 `base/`
- Contains `BasePage.java`, which holds the shared WebDriver instance.
- Uses `PageFactory.initElements()` to initialize elements across all page objects, enabling reuse within a single browser session.

### 🔸 `testCases/`
Automated test classes include:

| Test Case Class   | Description |
|------------------|-------------|
| `TC001_BookNowTest` | Automates full room booking process |
| `TC002_SubmitMessageTest` | Validates the contact form with valid input |
| `TC003_NegativeSubmitMessageTest` | Tests field validation with incorrect contact form input |
| `TC004_NegativeBookNowTest` | Negative test for invalid room booking data |
| `TC004_SubmitDDT` | Data-driven contact form test using Excel input |
| `TC006_HappyDaysTest` | UI verification for user-friendly field visibility |

---

### 🔸 `utilities/`
- `ExcelUtil.java`: Apache POI-based utility to read/write `.xlsx` data.
- `DataProviders.java`: Supplies test data to TestNG tests via `@DataProvider`.

---

### 🔸 `resources/`
- Holds `config.properties`, containing reusable variables (like URLs, credentials, and driver configs).

---

### 🔸 `testData/`
- Contains `Contact.xlsx`, which provides dynamic input data for data-driven tests.

---

### 🔸 `testng.xml` and `parallelcrossbrowser.xml`
- `testng.xml`: Executes the full test suite.
- `parallelcrossbrowser.xml`: Enables parallel test execution across multiple browsers.

---

## ⚙️ Tech Stack

| Tool | Role |
|------|------|
| **Selenium WebDriver** | Web automation |
| **Java** | Core programming language |
| **TestNG** | Testing framework and reporting |
| **Maven** | Build and dependency management |
| **GitHub** | Version control and collaboration |
| **Apache POI** | Excel data handling |

---

## ✅ Key Benefits

- **POM Design**: Modular and scalable structure
- **Reusable Codebase**: Minimal duplication across pages and tests
- **Excel-Driven Testing**: External data integration via Apache POI
- **Maven**: Clean project lifecycle and dependency control
- **GitHub**: Collaboration-ready for team scaling
- **Parallel Execution**: Support for cross-browser and multi-threaded testing

---

> 🎯 This framework is designed to be flexible, maintainable, and easy to extend for broader test coverage and team collaboration.

************USER MANUAL for TEST EXCUTION ***************************
Absolutely! Here's the **final version of the User Manual** with explicit instructions that test execution in **Eclipse IDE** should be done by **right-clicking on either `testng.xml` or `parallelcrossbrowser.xml`**.

---

## 🧑‍💻 User Manual

### 📦 Prerequisites

Ensure the following tools are installed before setting up and running the test automation framework:

| Tool            | Version                   | Notes                                            |
| --------------- | ------------------------- | ------------------------------------------------ |
| Java            | 8 or higher               | Required for running Selenium + TestNG           |
| Maven           | 3.6+                      | Manages dependencies and project build lifecycle |
| Git             | Latest                    | For cloning the repository                       |
| IDE             | IntelliJ IDEA / Eclipse   | Recommended for working with Java projects       |
| Browser Drivers | ChromeDriver, GeckoDriver | Ensure compatibility with your browser version   |

> 💡 **Tip:** Place browser drivers in your system’s `PATH` or configure their paths in `resources/config.properties`.

---

### 🚀 Installation Steps

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/shady-meadows-automation.git
   cd shady-meadows-automation
   ```

2. **Open in Eclipse IDE**

   * Choose **"Import as Maven Project"** when importing into Eclipse.
   * Let Maven resolve dependencies automatically from `pom.xml`.

3. **Update Configuration**

   * Modify `resources/config.properties` as needed:

     ```properties
     baseUrl=https://shadymeadows.com
     browser=chrome
     timeout=10
     excelPath=./testData/Contact.xlsx
     ```

4. **Update Excel Test Data (if required)**

   * Modify `testData/Contact.xlsx` for data-driven testing.

---

### 🧪 Test Execution (Eclipse IDE Only)

All test executions must be initiated from the TestNG XML files directly within Eclipse.

#### ✅ Option 1: Run All Tests Sequentially

* Right-click on `testng.xml` in the Project Explorer.
* Select:
  **`Run As > TestNG Suite`**

This runs all test cases sequentially using default configuration.

#### 🔁 Option 2: Run Tests in Parallel Across Browsers

* Right-click on `parallelcrossbrowser.xml`
* Select:
  **`Run As > TestNG Suite`**

This executes tests in **parallel threads** using multiple browsers, based on the setup defined in the XML.

> ❗ **Important:** Command-line test execution is not supported or recommended. Always use Eclipse’s TestNG runner for proper environment and suite loading.

📄 **Test Reports**

* After execution, view the report at:

  ```
  /test-output/index.html
  ```

  Open this file in your browser to see a detailed breakdown of test results.

---

### 🏗️ Framework Structure Overview

```
.
├── base/
│   └── BasePage.java                # Shared WebDriver logic
├── testCases/
│   ├── TC001_BookNowTest.java
│   ├── TC002_SubmitMessageTest.java
│   ├── TC003_NegativeSubmitMessageTest.java
│   ├── TC004_NegativeBookNowTest.java
│   ├── TC005_SubmitDDT.java
│   └── TC006_HappyDaysTest.java
├── utilities/
│   ├── ExcelUtil.java
│   └── DataProviders.java
├── resources/
│   └── config.properties
├── testData/
│   └── Contact.xlsx
├── testng.xml                      # Main suite for sequential tests
├── parallelcrossbrowser.xml       # Suite for parallel browser execution
└── pom.xml                         # Maven configuration
```

---

### ✅ Key Benefits

* **🔧 POM Architecture**: Easy to maintain and scale
* **♻️ Reusability**: Centralized logic for pages and test steps
* **📊 Excel Integration**: Data-driven testing with Apache POI
* **⚙️ Configuration-Driven**: Change URL, browser, and timeouts easily
* **🧪 Parallel Execution**: Supports multi-browser testing with TestNG
* **📈 Auto-Generated Reports**: HTML reports generated after each run
* **🔁 IDE-First Execution**: TestNG execution tightly integrated with Eclipse

---

Let me know if you want this formatted into a downloadable `README.md` file, or want to include GitHub badges, CI setup steps, or GIF walkthroughs for beginners.


