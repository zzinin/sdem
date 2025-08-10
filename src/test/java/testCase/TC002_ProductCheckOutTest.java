package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductPage;
import utilities.DataProviders;

public class TC002_ProductCheckOutTest extends BaseClass {
	
	@Test(dataProvider="ContactData1",dataProviderClass=DataProviders.class)
	   public void testLogin(String userid,String password,String firstname,String lastname, String postcode) throws InterruptedException {
	    	
		driver.get(p.getProperty("url"));
	
		ProductPage buyproduct= new ProductPage(driver);
		
		LoginPage login= new LoginPage(driver);
		
	try {	
		login.Userid(userid);
		login.Password(password);

		
		login.Login();
		
		
		
		
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.or(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")),
	        ExpectedConditions.urlContains("inventory")
	    ));
		
		buyproduct.addToCart();
		slowDown(3);
		buyproduct.clickToCart();
		slowDown(3);
		buyproduct.checkOut();
		buyproduct.firstName(firstname);
		buyproduct.lastName(lastname);
		buyproduct.postCode(postcode);
		focusOn(driver,By.xpath("//*[@id=\"continue\"]"));
		slowDown(3);
	
		buyproduct.checkContinue();
		//*[@id="continue"]
		slowDown(3);
		focusOn(driver,By.xpath("//button[@id='finish']"));
		buyproduct.finish();
		slowDown(3);
		
	} catch (Exception e) {
		
		System.out.println("Error during test for user: " +userid);
       
	} finally {
		
		buyproduct.btnBurger();
		slowDown(3);
        buyproduct.btnLogout();

     }
		

		
}	
	
	
	

}
