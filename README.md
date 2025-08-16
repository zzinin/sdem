# 🚀 Sauce Demo Test Automation Framework

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.x-brightgreen)
![TestNG](https://img.shields.io/badge/TestNG-7.x-orange)
![ExtentReport](https://img.shields.io/badge/Reporting-Extent-lightgrey)
![Build](https://img.shields.io/badge/Build-Passing-success)

This project is a **Test Automation Framework** for [Sauce Demo](https://www.saucedemo.com/) built using **Java, Selenium WebDriver, TestNG, and Extent Reports**.
It follows the **Page Object Model (POM)** design pattern, includes **data-driven testing** from Excel, and supports **functional + non-functional test cases**.

---

## 📂 Project Structure

```
saucedemo-automation/
│── TestNG.xml                    # Main suite file (entry point for execution)
│
├── src
│   └── test
│       └── java
│           ├── pageObject/        # Page Object classes
│           ├── testCase/          
│           │   ├── BaseTest.java          # Setup & teardown (browser, reports, etc.)
│           │   ├── TC001_LoginTest.java   # Login test (data-driven via Excel)
│           │   ├── TC002_ProductCheckOut.java # Product checkout test
│           │   ├── TC003_NonFunctionalTest.java # Page load performance test
│           └── utilities/         # Utilities (Excel reader, WebDriver manager, Extent logger)
│
├── testData/
│   └── LoginDetails.xlsx          # Data-driven Excel file for login credentials
│
├── target/
│   ├── ExtentReports/             # Extent HTML reports
│   └── test-output/               # Default TestNG reports
```

---

## ⚙️ Tech Stack

* **Java** (JDK 11+)
* **Selenium WebDriver 4.x**
* **TestNG 7.x** (test execution & reporting)
* **Extent Reports** (HTML reporting with screenshots)
* **Apache POI** (Excel data-driven testing)

---

## 🛠️ Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/saucedemo-automation.git
   
   ```

2. **Open in IDE**

   * Import the project in **IntelliJ / Eclipse**.
   * Add required libraries (**Selenium, TestNG, Apache POI, ExtentReports**) to your project build path.

3. **Update Test Data**

   * Add login credentials in `testData/LoginDetails.xlsx`
   * Example format:

     | Username          | Password      |
     | ----------------- | ------------- |
     | standard\_user    | secret\_sauce |
     | locked\_out\_user | secret\_sauce |

4. **Run Tests via TestNG**

   * Open `TestNG.xml`
   * Right-click → **Run As → TestNG Suite**
   * You can comment/uncomment individual `<class>` entries in `TestNG.xml` to run only selected test cases.

---

## 📊 Reporting

* **Extent Reports** generated at:

  ```
  target/ExtentReports/ExtentReport.html
  ```
* **TestNG default reports** generated at:

  ```
  target/test-output/index.html
  ```

---

## ✅ Test Cases

### 🔹 BaseTest.java

* Contains `@BeforeClass` (setup: browser, URL, reports)
* Contains `@AfterClass` (teardown: close browser, flush reports)

### 🔹 TC001\_LoginTest.java

* Data-driven login test using `LoginDetails.xlsx`
* Validates authentication for all user types
* Captures screenshots in Extent Report for failed logins

### 🔹 TC002\_ProductCheckOut.java

* Selects a product
* Performs checkout and final confirmation
* Validates welcome/thank-you message after successful order

### 🔹 TC003\_NonFunctionalTest.java

* Verifies **page load time** is within **3 seconds**
* Marks test as failed if threshold is exceeded

---

## 🔧 Sample TestNG.xml

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="SauceDemo Test Suite" parallel="false">
    <test name="SauceDemo Functional and Non-Functional Tests">
        <classes>
            <class name="testCase.TC001_LoginTest"/>
            <class name="testCase.TC002_ProductCheckOut"/>
            <class name="testCase.TC003_NonFunctionalTest"/>
        </classes>
    </test>
</suite>
```

👉 To run only **login test**, comment out other `<class>` entries.

---
📸 Sample Extent Reports (Attached in the repo for reference)

✅ Successful Login Test

❌ Failed Login Test (with screenshot in Extent Report)

🛒 Checkout Confirmation
---
## 📌 Next Enhancements

* Add **Cross-browser testing** (`parallelcrossbrowser.xml`)
* CI/CD pipeline with **Jenkins**
* Add **Docker + Selenium Grid** for parallel execution
* Integrate **Allure Reports**

---

👨‍💻 **Author**: RAHUL RANJAN 
📧 Reach out for collaboration or suggestions!



**Disclaimer**: I Referred AI system, to present my test automation design concept in user friendly manner in read me file. 


