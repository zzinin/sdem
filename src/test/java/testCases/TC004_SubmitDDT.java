package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import utilities.DataProviders;

// Excel-based data-driven test to verify input handling.

public class TC004_SubmitDDT extends BaseClass{

	
	@Test(dataProvider="ContactData",dataProviderClass=DataProviders.class)
	   public void SendMessage(String name,String email, String phone,String subject,String message) throws InterruptedException {
	    	
		driver.get(p.getProperty("url"));
		   
	    	HomePage hp= new HomePage(driver);
	    	BaseClass bc=new BaseClass();
	    	
	    	
	        hp.setNameSubmit(name);
	        hp.setEmailSubmit(email);
	        hp.Mobile(phone);
	        hp.setSubject(subject);
	        Thread.sleep(2000);
	        hp.setMessage(message);
	        hp.submit();
	        
	    	hp.MessageConfirmation();
	    	bc.focusOn(driver, By.xpath("//*[@id=\"contact\"]/div/div/div/div/div/p[1]"));
	    	Thread.sleep(2000);
		 
	    	
	    }
}
