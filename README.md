This project is designed to automate key functionalities of the Shady Meadows B&B website, including booking, message submission, and user experience (UX) validations.
The automation framework is built using Selenium WebDriver, Java, Maven, and TestNG. It follows the Page Object Model (POM) design pattern to promote reusability, maintainability, and scalability.
To support efficient collaboration and version control, GitHub is used for source management. Maven handles dependency management and project structure. The use of POM, along with modular test design, minimizes code duplication and enables easy integration and sharing across teams.
Autoamtion Framework is divided into below packages :
1. BasePage -This base page class holds the WebDriver instance,allowing all page objects to operate within the same browser session.
             PageFactory.initElements populates the @FindBy fields automatically.stores the driver and initialise web elements
2. TestCases -This section automated test cases script.For conveninece there are total 6 automated test cases covering: E2e automated test scenario for Booking functionality (TC001_BookNowTest), end to end Contact us form test scenario (TC002_SubmitMessageTest), Negative test to make sure that fields are being validated as per rules (TC003_NegativeSubmitMessageTest & TC004_NegativeBookNowTest), capability to accomodate input filed provided via xlsx file for multiple entry and can be used for negative scenarios as well(TC004SubmitDDT), Test to check that all the fields on the webpage are present and provising good user experience (TC006_HappyDaysTest)  
3. Utilities -This package contains Dataproviders  and excel utility file, to data drive the test scenarios for various combination of input                 data
4. Resources - This package contains config file which contains the variables to be resued in various test classes and scenarios
5. TestData - This folder contains the excel file(Contact.xlsx) is being used to data drive 
6. XML files - This are the xml files for the purpose of TestNG integration and further are of 2 types, "testng.xml" for test exeuction of all the test cases and other "parallelcrossbrowser.xml" for parallel test execution in cross browser type scenarios.

