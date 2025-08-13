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

public class TC001_LoginTest extends BaseClass {

    @Test(dataProvider = "ContactData", dataProviderClass = DataProviders.class)
    public void testLogin(String userid, String password) throws InterruptedException {

        test = extent.createTest("TC001 Test for Login user:" + userid);
        driver.get(p.getProperty("url"));
        test.info("Navigated to Login Page.");

        LoginPage login = new LoginPage(driver);

        login.Userid(userid);
        test.info("Entered username: " + userid);
        login.Password(password);
        test.info("Entered Password.");
        slowDown(3);

        login.Login();
        test.info("Clicked Login button.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")),
                ExpectedConditions.urlContains("inventory")));

        // Check if error message is displayed
        try {
            WebElement error = driver.findElement(
                    By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
            String errorMsg = error.getText();

            test.warning("Login failed with error message:" + errorMsg);

            if (userid.equalsIgnoreCase("locked_out_user")) {
                Assert.assertEquals(errorMsg,
                        "Epic sadface: Sorry, this user has been locked out.");
                test.pass("Correct error is displayed for locked_out_user.").addScreenCaptureFromPath(captureScreenshot("ERROR_Login" +errorMsg));
            } else {
                System.out.println("User: " + userid + " Login Failed - Message: " + errorMsg);
                test.fail("Unexpected login failure for user:" + userid);
            }
        } catch (Exception e) {
            // If no error, assume login success
            boolean success = driver.getCurrentUrl().contains("inventory");
            Assert.assertTrue(success, "Login failed for userid: " + userid);

            if (success) {
                test.pass("Login successful for userid " + userid).addScreenCaptureFromPath(captureScreenshot("LoginSuccess" +userid));
            } else {
                test.fail("Login failed for userid " + userid).addScreenCaptureFromPath(captureScreenshot("Unsuccessful_Login" +userid));
            }
        } finally {
            driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
            driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
        }
    }
}
