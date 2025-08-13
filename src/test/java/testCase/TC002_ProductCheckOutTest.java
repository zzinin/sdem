package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductPage;
import utilities.DataProviders;

public class TC002_ProductCheckOutTest extends BaseClass {

    @Test(dataProvider = "ContactData1", dataProviderClass = DataProviders.class)
    public void testLogin(String userid, String password, String firstname, String lastname, String postcode)
            throws InterruptedException {

        test = extent.createTest("TC002 Test for Product Purchased By: " + userid);
        driver.get(p.getProperty("url"));
        test.info("Navigated to Login Page.");

        ProductPage buyproduct = new ProductPage(driver);
        LoginPage login = new LoginPage(driver);

        try {
            login.Userid(userid);
            test.info("Entered username: " + userid);

            login.Password(password);
            test.info("Entered Password.");

            login.Login();
            test.info("Clicked Login button.");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")),
                    ExpectedConditions.urlContains("inventory")));

            // Verify login success
            boolean loginSuccess = driver.getCurrentUrl().contains("inventory");

            if (loginSuccess) {
                test.pass("Login success for user: " + userid).addScreenCaptureFromPath(captureScreenshot("Login_Success_"+ userid));
                
                
                
                
            } else {
                String errorMessage = driver.findElement(By.xpath(
                        "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
                test.fail("Login failed for userid " + userid + " | error: " + errorMessage);
            }

            Assert.assertTrue(loginSuccess, "Login Failed for user: " + userid);

            // Product purchase steps
            buyproduct.addToCart();
            test.info("Product added to cart.");

            slowDown(3);
            buyproduct.clickToCart();
            test.info("Navigated to cart.");

            slowDown(3);
            buyproduct.checkOut();
            test.info("Proceeded to checkout.");

            buyproduct.enterFirstName(firstname);
            test.info("Entered first name: " + firstname);

            buyproduct.enterLastName(lastname);
            test.info("Entered last name: " + lastname);

            buyproduct.enterPostalCode(postcode);
            test.info("Entered postcode: " + postcode);

            focusOn(driver, By.xpath("//*[@id=\"continue\"]"));
            slowDown(3);

            buyproduct.clickContinue();
            test.info("Clicked Continue.");

            slowDown(3);
            focusOn(driver, By.xpath("//button[@id='finish']"));

            buyproduct.finishOrder();
            String  finalScreenshotPath= captureScreenshot("Order_Success_" +userid); 
            test.pass("Order completed successfully for user: " + userid).addScreenCaptureFromPath(finalScreenshotPath);
            slowDown(3);

        } catch (Exception e) {
            test.fail("Test encountered an exception for user: " + userid + " | " + e.getMessage());
            Assert.fail("Exception during checkout process for user: " + userid, e);
            System.out.println("Error during test for user: " + userid);

        } finally {
            buyproduct.openBurgerMenu();
            slowDown(3);
            buyproduct.logout();
            test.info("User logged out.");
        }
    }
}

