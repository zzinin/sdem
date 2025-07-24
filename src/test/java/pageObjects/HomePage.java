package pageObjects;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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

/*This class defines common locators and methods that can be accessed by other page classes upon initialisation.
  The HomePage class contains WebElement locators and methods that interact with elements on the homepage.
This provides a clean separation of UI structure from the test logic. */

public class HomePage extends BasePage {
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	//All the WebElement locators are placed here from the website Shady Meadows 
	
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
	
	
	@FindBy(xpath="//*[@id=\"rooms\"]/div/div[2]/div[1]/div/div[3]/a")
	WebElement btnSingleRoom;
	
	@FindBy(xpath="//*[@id=\"rooms\"]/div/div[2]/div[2]/div/div[3]/a")
	WebElement btnDoubleRoom;
	
	@FindBy(xpath="//*[@id=\"rooms\"]/div/div[2]/div[3]/div/div[3]/a")
	WebElement btnSuiteRoom;
	
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
	
	@FindBy(xpath="//*[@id=\"root-container\"]/div/div[2]/div/div[2]/div/div/h2")
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
	
	//Locators for Happy Days test
	
	@FindBy(xpath="//*[@id=\"root-container\"]/div/nav/div/a/span")
	WebElement ShadyM;
	
	
	@FindBy(css = "footer") // or another stable element
	public
    WebElement footer;
	
	
	/*Below section will contain all the methods and related actions
	 *  on the element of Webpage to be used in any other classes
	 */
	
	
	
	 public void bookNow1() {
		   
		   btnBookNow1.click();
	   }
	
	
     public void pickCheckInDate(String checkInDate) {
		
		
              chkInDate.sendKeys(Keys.chord(Keys.CONTROL, "a")); 
			  chkInDate.sendKeys(Keys.DELETE);                   
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
   
   public void roomSelect() {
      
	   
	   Scanner scanner= new Scanner(System.in);
	   
      System.out.print("Enter your room choice (Single, Double, Suite):");
      String choice= scanner.nextLine();
	   
      switch (choice) {
    	  
      case "Single":
    	  System.out.print("You selected Single room.");
    	  btnSingleRoom.sendKeys(Keys.RETURN);
    	  break;
    	  
      case "Double":
    	  System.out.print("You selected Double room.");
    	  btnDoubleRoom.sendKeys(Keys.RETURN);
    	  break;
    	  
      case "Suite":
    	  System.out.print("You selected Suite room.");
    	  btnSuiteRoom.sendKeys(Keys.RETURN);
    	  break;
    	  
      default:
    	  System.out.print("Invalid choice. Please enter Single, Double or Suite.");
           break;    	  
      }
      
      scanner.close();
      }
	   
   
   
	
   public void doReservation(){
		
		btnReserveNow.sendKeys(Keys.RETURN);
		
		}
    
    
	 
   public void setFirstName(String fname) {
    	
    	txtFirstName.sendKeys(fname);
    	
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
		
		return ("Throws exception:" +e.getMessage());
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
	 

		 By confirmationLocator = By.xpath("//*[@id=\"contact\"]/div/div/div/div/div/p[1]");

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement confirmation = wait.until(
		         ExpectedConditions.visibilityOfElementLocated(confirmationLocator));

		 String message = confirmation.getText();
		 System.out.println("Confirmation text: " + message);
		   
          }
 
      public boolean isFooterDisplayed() {
            return footer.isDisplayed();
          }
 
 
 
      public void Scroll()  {
 
         WebElement focus = driver.findElement(By.xpath("//h3[@class='h4 mb-4 text-center']"));

	      new Actions(driver)          // build an Actions chain
	        .scrollToElement(focus)   // wheel‑scroll until `pricing` is visible
	        .perform(); 
            }
 
 

 
     }
