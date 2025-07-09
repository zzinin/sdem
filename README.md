
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



