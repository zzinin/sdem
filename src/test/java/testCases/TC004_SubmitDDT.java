package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import utilities.DataProviders;

public class TC004_SubmitDDT extends BaseClass{

	
	@Test(dataProvider="ContactData",dataProviderClass=DataProviders.class)
	   public void SendMessage(String name,String email, String phone,String subject,String message) {
	    	
		   
		   
	    	HomePage hp= new HomePage(driver);
	    	
	    	
	        hp.setNameSubmit(name);
	        hp.setEmailSubmit(email);
	        hp.Mobile(phone);
	        hp.setSubject(subject);
	        hp.setMessage(message);
	        hp.submit();
	    	hp.MessageConfirmation();
	   
		 
	    	
	    }
}
