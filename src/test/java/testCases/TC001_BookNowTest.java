package testCases;


import org.testng.Assert;

import org.testng.annotations.Test;



import pageObjects.HomePage;

public class TC001_BookNowTest extends BaseClass{
	
	@Test
    void verify_Reservation() {
    	
    	HomePage hp= new HomePage(driver);
    	
  //  	hp.bookNow1();
    	
 //   	hp.pickCheckInDate("12/11/2025");
 //   	hp.pickCheckOutDate("13/11/2025");
    	hp.Datepicker1("July 2026", "05");
    	hp.chkAvailability();
    	hp.bookNow();
    	hp.doReservation();
    	hp.setFirstName("Rahul");
    	hp.setLastName("Ranjan");
    	hp.Email("zzinin@yahoo.com");
    	hp.Phone("07586137331");
    	hp.FinalReservation();
    	
    	String ConfirmMessage= hp.chkConfirmationMessage();
    	Assert.assertEquals(ConfirmMessage,"Booking Confirmed");
    	
    	
    	
    	
    }


}
