package testCases;



import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC002_SubmitMessageTest extends BaseClass {
	
   @Test
    void verify_Reservation() {
    	
    	HomePage hp= new HomePage(driver);
    	
    	
        hp.setNameSubmit("Rahul Ranjan");
        hp.setEmailSubmit("zzinin@yahoo.com");
        hp.Mobile("07586137331");
        hp.setSubject("Test for ShadyMeadows");
        hp.setMessage("Please note that website is not taking the date picker and other clickable items not working");
        hp.submit();
    	hp.MessageConfirmation();
   
    	
    	
    }


}
