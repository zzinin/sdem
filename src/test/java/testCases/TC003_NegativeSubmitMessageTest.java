package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC003_NegativeSubmitMessageTest extends BaseClass {
	
	 @Test
	   public void NegativeSubmit() {
	    	
		   try {
		   
	    	HomePage hp= new HomePage(driver);
	    	BaseClass bc=new BaseClass();
	    	
	        hp.setNameSubmit(p.getProperty("nname"));
	        hp.setEmailSubmit(p.getProperty("nemail"));
	        hp.Mobile(p.getProperty("nphone"));
	        hp.setSubject(p.getProperty("nsubject"));
	        hp.setMessage(p.getProperty("nmessage"));
	   //     bc.focusOn(driver, By.xpath("//div[@class='card shadow']//div[@class='card-body p-4']"));
	        hp.submit();
	        bc.focusOn(driver, By.xpath("//div[@class='alert alert-danger']"));
	    //    Thread.sleep(3000);
	        
	        if (driver.findElement(By.xpath("//*[@id=\"contact\"]/div/div/div/div/div/div")).isDisplayed()) {
	        	Thread.sleep(4000);
	        	bc.focusOn(driver, By.xpath("//div[@class='card shadow']//div[@class='card-body p-4']"));
	        	hp.setNameSubmit(p.getProperty("name"));
		        hp.setEmailSubmit(p.getProperty("email"));
		        Thread.sleep(3000);
		        hp.Mobile(p.getProperty("phone"));
		        hp.setSubject(p.getProperty("subject"));
		        hp.setMessage(p.getProperty("message"));
		        hp.submit();
	        	
	        }else {
	        	
	        	
	        	//Do Nothing
	        	
	        	
	        	
	        }
	      /*  if (driver.findElement(By.xpath("//div[@class='card shadow']//div[@class='card-body p-4']")).isDisplayed()) {
	        	Assert.assertEquals(true, null);
	        	hp.MessageConfirmation();
	        	
	        }else {
	        	Assert.assertEquals(false, null);
	        	
	        }*/
	    	
	        
	        
	    
	        By cardBody = By.xpath("//div[@class='card shadow']//div[@class='card-body p-4']");
             Thread.sleep(2000);
	      
	        boolean cardVisible = driver.findElements(cardBody)
	                                    .stream()
	                                    .anyMatch(WebElement::isDisplayed);

	        
	        Assert.assertTrue(cardVisible,   // or assertFalse(...) for a negative test
	                          "Confirmation card should be visible");

	        
	        if (cardVisible) {
	            hp.MessageConfirmation();
	        }
            
	        bc.focusOn(driver, cardBody) ;
	    } catch (Exception e)
		   {
			   Assert.fail("Test threw an unexpected exception:" +e.getMessage() );
		   }
	    	
	    }


  
	
	
	
}
	    	


