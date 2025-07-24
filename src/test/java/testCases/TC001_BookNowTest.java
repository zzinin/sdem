package testCases;


import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.Test;



import pageObjects.HomePage;

/*This Test script is used for booking of room end to end scenario. 
Checking availability to booking room and getting confirmation message.*/


public class TC001_BookNowTest extends BaseClass{
	
	@Test
   public void verify_Reservation() {
    	
    	try{
		
    	HomePage hp= new HomePage(driver);
    	BaseClass bc= new BaseClass();
        Thread.sleep(3000);
        String checkIn = bc.randomFutureDate(1,20);
    	hp.pickCheckInDate(checkIn);
        Thread.sleep(2000);
    	String checkOut= bc.randomFutureDate(22,30);
    	hp.pickCheckOutDate(checkOut);
        bc.focusOn(driver, By.xpath("//*[@id=\"booking\"]/div/div/div/form/div/div[4]/button"));
    	Thread.sleep(4000);
    	hp.chkAvailability();
   //Room Selection is done below 
    	hp.bookNow();
    	Thread.sleep(3000);
    	hp.doReservation();
    	hp.setFirstName(p.getProperty("firstname"));
    	hp.setLastName(p.getProperty("lastname"));
    	hp.Email(p.getProperty("email"));
    	hp.Phone(p.getProperty("phone"));
    	bc.focusOn(driver, By.xpath("//*[@id=\"root-container\"]/div/div[2]/div/div[2]/div/div/h2"));
    	Thread.sleep(2000);
  
    	hp.FinalReservation();
    	bc.focusOn(driver, By.xpath("//*[@id=\"root-container\"]/div/div[2]/div/div[2]/div/div/h2"));
    	Thread.sleep(2000);
    	String dates=hp.datesBooked();
    	System.out.println("Dates booked by Customer :" +dates);
    	
    	bc.focusOn(driver, By.xpath("//*[@id=\"root-container\"]/div/div[2]/div/div[2]/div/div/h2"));
    	Thread.sleep(2000);
    	
    	String ConfirmMessage= hp.chkConfirmationMessage();
    	Assert.assertEquals(ConfirmMessage,"Booking Confirmed");
    	hp.returnHome();
    	} catch (Exception e) 
    	{
    	  Assert.fail("Throws exception TC001:" +e.getMessage());	
    	}
    	
    	
    }


}
