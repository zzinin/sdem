
# 🚀 Sauce Demo Test Automation Framework

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![Selenium](https://img.shields.io/badge/Selenium-4.x-brightgreen)
![TestNG](https://img.shields.io/badge/TestNG-7.x-orange)
![ExtentReport](https://img.shields.io/badge/Reporting-Extent-lightgrey)
![Build](https://img.shields.io/badge/Build-Passing-success)

This project is a **Test Automation Framework** for [Sauce Demo](https://www.saucedemo.com/) built using **Java, Selenium WebDriver, TestNG, and Extent Reports**.
It follows the **Page Object Model (POM)** design pattern and supports **data-driven testing** using Excel.

---

## 📂 Project Structure

```
saucedemo-automation/
│── TestNG.xml                    # TestNG suite file (entry point for execution)
│── parallelcrossbrowser.xml       # Parallel cross-browser execution suite (optional)
│
├── src
│   └── test
│       └── java
│           ├── pageObject/        # Page Object classes
│           ├── testCase/          # Test classes (TestNG)
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
* **Extent Reports** (HTML reports)
* **Apache POI** (Excel data-driven testing)

---

## 🛠️ Setup Instructions

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/saucedemo-automation.git
   cd saucedemo-automation
   ```

2. **Install Dependencies**

   * Import the project into your **IDE (IntelliJ / Eclipse)**.
   * Ensure all **required JARs** (Selenium, TestNG, Apache POI, ExtentReports) are added to your build path.

3. **Update Test Data**

   * Add login credentials in `testData/LoginDetails.xlsx`
   * Example format:

     | Username          | Password      |
     | ----------------- | ------------- |
     | standard\_user    | secret\_sauce |
     | locked\_out\_user | secret\_sauce |

4. **Run Tests via TestNG**

   * Right-click on `TestNG.xml` → **Run As → TestNG Suite**
   * Or from terminal (if TestNG is installed as plugin):

     ```bash
     java -cp "bin;libs/*" org.testng.TestNG TestNG.xml
     ```

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

## ✅ Features

* Page Object Model (**POM**) for maintainability
* **Data-driven** tests via Excel (`LoginDetails.xlsx`)
* **Cross-browser support** (if configured in parallelcrossbrowser.xml)
* **Parallel execution** with TestNG suite
* **Beautiful Extent Reports** with screenshots for failures

---

## 🔧 Sample Test Case

```java
@Test(dataProvider = "loginData")
public void testValidLogin(String username, String password) {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, password);

    Assert.assertTrue(
        new HomePage(driver).isProductsHeaderVisible(),
        "Login failed with username: " + username
    );
}
```

---

## 📌 Next Enhancements

* CI/CD integration with **Jenkins**
* Add **Docker + Selenium Grid** for distributed execution
* Integrate with **Allure Reports**

---

👨‍💻 **Author**: RAHUL RANJAN
📧 Reach out for collaboration or suggestions!

---

**Disclaimer**: I Referred AI system, to present my test automation design concept in user friendly manner in read me file. 


