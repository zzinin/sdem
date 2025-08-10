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

		@Test(dataProvider="ContactData",dataProviderClass=DataProviders.class)
		   public void testLogin(String userid,String password) throws InterruptedException {
		    	
			driver.get(p.getProperty("url"));
		
			LoginPage login= new LoginPage(driver);
			
			login.Userid(userid);
			login.Password(password);
			
			slowDown(3);
			
			login.Login();
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.or(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")),
		        ExpectedConditions.urlContains("inventory")
		    ));
			
			
			
			
			// Check if error message is displayed
	        try {
	            
	            WebElement error=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
	            String errorMsg = error.getText();
	            if (userid.equalsIgnoreCase("locked_out_user")) {
	                Assert.assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.");
	            } else {
	                System.out.println("User: " + userid + " Login Failed - Message: " + errorMsg);
	            }
	        } catch (Exception e) {
	            // If no error, assume login success
	            Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login failed for: " + userid);
	        } finally
	            {driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
	            driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
	        }
		}
			

			
	}
		
	



