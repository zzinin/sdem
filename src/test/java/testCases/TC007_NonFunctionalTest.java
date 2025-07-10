package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC007_NonFunctionalTest extends BaseClass {
 
	@Test
    public void verifyPageLoadTimeUnder3Seconds() throws InterruptedException {
        long start = System.currentTimeMillis();
        driver.get(p.getProperty("url"));
  //      driver.get("https://automationintesting.online/");
        HomePage hp = new HomePage(driver);
//        Base
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(hp.footer));

        long end = System.currentTimeMillis();
        long loadTime = end - start;

        System.out.println("Page load time: " + loadTime + " ms");
        Assert.assertTrue(loadTime < 3000, "Page load time exceeds 3 seconds!");

        Thread.sleep(2000);
    }
	
	
	
} 
