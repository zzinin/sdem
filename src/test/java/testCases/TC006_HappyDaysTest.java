package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
//Exploratory test to verify the presence of webpage fields, ensuring a better user experience.

public class TC006_HappyDaysTest extends BaseClass {

    @Test
    public void verifyHeaderBrand() throws InterruptedException {

      HomePage hp= new HomePage(driver);
      BaseClass bc= new BaseClass();
        // 2. set up explicit wait (10 s timeout)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 3. locator for the “Shady Meadows” <span>
       
        By brandLocator = By.xpath("//*[@id='root-container']/div/nav/div/a/span");
        By WelcomeM = By.xpath("//*[@id=\"root-container\"]/div/section[1]/div/div/div/h1");
        By ContactI = By.xpath("//*[@id=\"location\"]/div/div[2]/div[2]/div/div");
        // 4. wait until the span is visible, then read its text
        WebElement brand = wait.until(
                ExpectedConditions.visibilityOfElementLocated(brandLocator)
        );
       WebElement Welcome = wait.until(
                ExpectedConditions.visibilityOfElementLocated(WelcomeM)
        );
       WebElement ContactInfo = wait.until(
               ExpectedConditions.visibilityOfElementLocated(ContactI)
       );
        bc.focusOn(driver, By.xpath("//*[@id=\"root-container\"]/div/nav/div/a/span"));
        Thread.sleep(3000);
        String actualText1 = brand.getText().trim();
        System.out.println("Printing:" +actualText1);
        String actualText2 = Welcome.getText().trim();
        System.out.println("Printing:" +actualText2);
        String actualText3 =ContactInfo.getText().trim();
        System.out.println("Printing:" +actualText3);
        // 5. assert the text
        Assert.assertEquals(actualText1, "Shady Meadows B&B",
                "Site header text did not match!");
        Assert.assertEquals(actualText2, "Welcome to Shady Meadows B&B",
                "Site header text did not match!");
 //       Assert.assertEquals(actualText3, "Welcome to Shady Meadows B&B",
  //              "Site header text did not match!");
       
        bc.focusOn(driver, By.xpath("//*[@id=\"location\"]/div/div[2]/div[2]/div/div/div[1]/div[2]/h5"));
        Thread.sleep(3000);
        Assert.assertTrue(
        	    actualText3.contains("Contact Information"),
        	    "Site header text did not match!"
        	);
    }
}


