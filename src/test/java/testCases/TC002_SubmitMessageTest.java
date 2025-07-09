package testCases;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

//This test case checks if users are able to Send message to ShadyM B&B

public class TC002_SubmitMessageTest extends BaseClass {
	BaseClass bc= new BaseClass();
   @Test
   public void verify_Reservation() {
    	
	   try {
	   
    	HomePage hp= new HomePage(driver);
    	
    	bc.focusOn(driver, By.xpath("//h3[normalize-space()='Send Us a Message']"));

        hp.setNameSubmit(p.getProperty("name"));
        Thread.sleep(2000);
        
        hp.setEmailSubmit(p.getProperty("email"));
        hp.Mobile(p.getProperty("phone"));
        hp.setSubject(p.getProperty("subject"));
        Thread.sleep(2000);
        hp.setMessage(p.getProperty("message"));
        hp.submit();
    	hp.MessageConfirmation();
    	bc.focusOn(driver, By.xpath("//*[@id=\"contact\"]/div/div/div/div/div/h3"));
    	Thread.sleep(2000);
	   } catch (Exception e)
	   {
		   Assert.fail("Thows Exception:" +e.getMessage());
	   }
    	
    }


}
