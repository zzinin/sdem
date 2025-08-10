package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	//All the WebElement locators from "Login Page" are placed here from the website SauceDemo 
	
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement nameMainPage;
	
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement txtUserName;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//*[@id=\"login-button\"]")
	WebElement btnLogin;
	
	@FindBy(xpath="//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
	WebElement error;
	
//	Epic sadface: Sorry, this user has been locked out.
	
	/*Below section will contain all the methods and related actions
	 *  on the element of LoginPage to be used in any other classes
	 */
	
	
	public void Userid(String userid) {
		txtUserName.clear();
		txtUserName.sendKeys(userid);
	}
	
    public void Password(String password) {
    	txtUserName.clear();
		txtPassword.sendKeys(password);
	}
	
	 public void Login() {
		   
		   btnLogin.click();
	   }
	
	
	
	
	
}
