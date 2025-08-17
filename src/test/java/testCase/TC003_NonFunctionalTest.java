package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utilities.DataProviders;

/**
 * Non-Functional Test: Verifies the page load time is under 3 seconds.
 */
public class TC003_NonFunctionalTest extends BaseTest {

    @Test(dataProvider = "ContactData", dataProviderClass = DataProviders.class)
    public void verifyPageLoadTimeUnder3Seconds(String userid, String password) throws InterruptedException {
        
        // Create test in ExtentReports
        test = extent.createTest("TC003 Page Load Time Test for user: " + userid);

        try {
            long start = System.currentTimeMillis();
            driver.get(property.getProperty("url"));

            LoginPage login = new LoginPage(driver);
            login.Userid(userid);
            login.Password(password);
            //Below Slowdown function has been called intentionally to reduce execution speed
            slowDown(3);
            login.Login();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")),
                    ExpectedConditions.urlContains("inventory")));

            long end = System.currentTimeMillis();
            long loadTime = end - start;

            test.info("Page load time: " + loadTime + " ms");
            System.out.println("Page load time: " + loadTime + " ms");

            Assert.assertTrue(loadTime < 3000, "Page load time exceeds 3 seconds!");
            test.pass("Page load time is under 3 seconds");
            //Below Slowdown function has been called intentionally to reduce execution speed
            slowDown(3);

            // Check if error message is displayed
            try {
                WebElement error = driver.findElement(
                        By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
                String errorMsg = error.getText();

                if (userid.equalsIgnoreCase("locked_out_user")) {
                    Assert.assertEquals(errorMsg,
                            "Epic sadface: Sorry, this user has been locked out.");
                    test.pass("Locked out user error message verified");
                } else {
                    test.fail("Login failed with message: " + errorMsg);
                    System.out.println("User: " + userid + " Login Failed - Message: " + errorMsg);
                    Assert.fail("Login failed with message: " + errorMsg);
                }
            } catch (Exception e) {
                // If no error message, assume login success
                Assert.assertTrue(driver.getCurrentUrl().contains("inventory"),
                        "Login failed for: " + userid);
                test.pass("Login successful for user: " + userid);
            } finally {
                driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
                driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
            }

        } catch (AssertionError ae) {
            test.fail("Assertion failed: " + ae.getMessage());
            throw ae;  // rethrow to fail the test in TestNG
        } catch (Exception e) {
            test.fail("Test encountered exception: " + e.getMessage());
            throw e;   // rethrow to fail the test in TestNG
        } finally {
            BaseTest.flushReport();  // flush after each test (optional)
        }
    }
}
