package pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends BasePage {
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//*[@id=\"root-container\"]/div/section[1]/div/div/div/a")
	WebElement btnBookNow1;
	
	
	
	
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/form/div/div[1]/div/div/input")
	WebElement chkInDate;
	
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/form/div/div[2]/div/div/input")
	WebElement chkOutDate;
	
	@FindBy(xpath="//*[@id=\"booking\"]/div/div/div/form/div/div[4]/button")
	WebElement btnCheckAvailability;
	
	
	@FindBy(xpath="//*[@id=\"rooms\"]/div/div[2]/div[2]/div/div[3]/a")
	WebElement btnBookNow;
	
	
	
	@FindBy(xpath="//button[@id='doReservation']")
	WebElement btnReserveNow;
	
	
	@FindBy(xpath="//input[@placeholder='Firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@placeholder='Lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder='Phone']")
	WebElement txtPhone;
	
	@FindBy(xpath="//button[normalize-space()='Reserve Now']")
	WebElement btnFinalReserveNow;
	
	@FindBy(xpath="//h2[normalize-space()='Booking Confirmed']")
	WebElement txtBookingConfirmed;
	
	@FindBy(xpath="//*[@id=\"root-container\"]/div/div[2]/div/div[2]/div/div/p[2]/strong")
	WebElement txtDateBooked;
	
	@FindBy(xpath="//*[@id=\"root-container\"]/div/div[2]/div/div[2]/div/div/a")
	WebElement btnReturnHome;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement txtNameSubmit;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmailSubmit;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement txtPhoneSubmit;
	
	@FindBy(xpath="//input[@id='subject']")
	WebElement txtSubjectSubmit;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement txtMessageSubmit;
	
	@FindBy(xpath="//button[normalize-space()='Submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement errMessage;
	
	
	
	
	
	
	
	
	
	
	//Application error 
	//*[@id="__next_error__"]/body/div/div/h2
	//*[@id="__next_error__"]/body/div/div/h2
	
	//Booking confirmed message 
	
	//*[@id="root-container"]/div/div[2]/div/div[2]/div/div/h2
	
	
	
	
	
	
	
	
	


	
	
	
	 public void bookNow1() {
		   
		   btnBookNow1.click();
	   }
	
	
	
	
public void pickCheckInDate(String checkInDate) {
		
		
		
			 chkInDate.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
			 chkInDate.sendKeys(Keys.DELETE);                   // Delete
		      chkInDate.sendKeys(checkInDate);
		
		      
		      
		      
		      
		      
		      
		      
		      
		      
		
	}
	
   public void pickCheckOutDate(String checkOutDate) {
		
	     chkOutDate.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
		 chkOutDate.sendKeys(Keys.DELETE);                   // Delete
	     chkOutDate.sendKeys(checkOutDate);
		  chkOutDate.sendKeys(Keys.TAB);
		
	}
	 
	public void  Datepicker1(String month,String day){
	 driver.findElement(By.xpath("//*[@id=\"booking\"]/div/div/div/form/div/div[1]/div/div/input")).sendKeys(Keys.RETURN);
		while(true)
		{
		String currentMonth=driver.findElement(By.xpath("//h2[@class='react-datepicker__current-month']")).getText();
	//	String currentYear=driver.findElement(By.xpath("//div[@class='react-datepicker__day-names']")).getText(); 
		if(currentMonth.equals(month)) 
		{
			break;
		}
		driver.findElement(By.xpath("//*[@id=\"booking\"]/div/div/div/form/div/div[1]/div[2]/div[2]/div/div/div/button[2]/span")).sendKeys(Keys.RETURN);
		}
   
	}
   public void chkAvailability() {
		
		btnCheckAvailability.sendKeys(Keys.RETURN);
		
		
	}
   
   public void bookNow() {
	   
	   btnBookNow.sendKeys(Keys.RETURN);
   }
   
   
	
    public void doReservation(){
		
		btnReserveNow.sendKeys(Keys.RETURN);
		
		
	}
    
    
	 
    public void setFirstName(String fname) {
    	
    	txtFirstName.sendKeys(fname);;
    	
    }
	
    public void setLastName(String lname) {
    	
    	txtLastName.sendKeys(lname);;
    }
   
    public void Email(String email) {
	   
    	 txtEmail.sendKeys(email);
	
     }
    
    public void Phone( String phone) {
    	txtPhone.sendKeys(phone);
	
	
     }
	
 public void FinalReservation(){
		
		btnFinalReserveNow.sendKeys(Keys.RETURN);
		
		
	}
 
 
 
 public String chkConfirmationMessage() {
	try {
		return (txtBookingConfirmed.getText());
		
	}catch (Exception e) 
	{
		
		return (e.getMessage());
	}
	
 }

 public String datesBooked() {
	 
	 
	 return txtDateBooked.getText();
	 
	 
 }
 
 public void returnHome() {
	 
	 btnReturnHome.sendKeys(Keys.RETURN);
	 
 }
 
 
 
 
 public void setNameSubmit(String name) {
 	
 	txtNameSubmit.sendKeys(name);
 	
 }
	
 public void setEmailSubmit(String email) {
	 	
	 	txtEmailSubmit.sendKeys(email);
	 	
	 }
 
 
 public void Mobile( String phone) {
 	txtPhoneSubmit.sendKeys(phone);
	
	
  }
 
 public void setSubject( String subject) {
	 	txtSubjectSubmit.sendKeys(subject);
		
		
	  }
 
 public void setMessage( String message) {
	 	txtMessageSubmit.sendKeys(message);
		
		
	  }
 public void submit() {
	 	btnSubmit.sendKeys(Keys.RETURN);
		
		
	  }
 public void MessageConfirmation()  {
	 

		
		 
		 By confirmationLocator = By.xpath("//h3[normalize-space()='Thanks for getting in touch Rahul Ranjan!']");

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement confirmation = wait.until(
		         ExpectedConditions.visibilityOfElementLocated(confirmationLocator));

		 String message = confirmation.getText();
		 System.out.println("Confirmation text: " + message);
		 
		 
	 
 }
 public void Scroll()  {
 
 WebElement focus = driver.findElement(By.xpath("//h3[@class='h4 mb-4 text-center']"));

	new Actions(driver)          // build an Actions chain
	        .scrollToElement(focus)   // wheel‑scroll until `pricing` is visible
	        .perform(); 
 
 
 
 
 }
 
 

 
}
