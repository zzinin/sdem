package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//This base page class holds the WebDriver instance, 
//allowing all page objects to operate within the same browser session.
//PageFactory.initElements populates the @FindBy fields automatically.
//stores the driver and initialise web elements

public class BasePage {
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

}
