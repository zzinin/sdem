package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class ProductPage extends BasePage{

	 
	public ProductPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	//All the WebElement locators from "Login Page" are placed here from the website SauceDemo 
	
	
		@FindBy(xpath="//div[@class='app_logo']")
		WebElement appLogo;
		
		@FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']")
		WebElement productSelected;
		
		
		@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
		WebElement btnAddToCart;
		
		@FindBy(xpath="//a[@class='shopping_cart_link']")
		WebElement btnCartLink;
		
		@FindBy(xpath="//button[@id='checkout']")
		WebElement btnCheckOut;


		@FindBy(xpath="//input[@id='first-name']")
		WebElement txtFirstName;
		
		@FindBy(xpath="//input[@id='last-name']")
		WebElement txtLastName;
		
		@FindBy(xpath="//input[@id='postal-code']")
		WebElement txtpostalCode;
		
		@FindBy(xpath="//input[@id='continue']")
		WebElement btnContinue;
		
		@FindBy(xpath="//span[@class='title']")
		WebElement txtCheckoutOverview;
		
		@FindBy(xpath="//button[@id='finish']")
		WebElement btnFinish;
	
		@FindBy(xpath="//h2[normalize-space()='Thank you for your order!']")
		WebElement txtThankYou;
		
		@FindBy(xpath="//button[@id='back-to-products']")
		WebElement btnBackToHome;
		
		@FindBy(xpath="//button[@id='react-burger-menu-btn']")
		WebElement btnBurger;
		
		@FindBy(xpath="//a[@id='logout_sidebar_link']")
		WebElement btnLogOut;
		
		/*Below section will contain all the methods and related actions
		 *  on the element of LoginPage to be used in any other classes
		 */
		
		
		public void   Logo() {
			
		  appLogo.getText();
		
		
		}
		
		
		public void productSelected() {
			
			productSelected.click();
			
		}
		
		public void addToCart() {
			
			btnAddToCart.click();
			
		}
		
       public void clickToCart() {
			
    	   btnCartLink.click();
			
		}
	
	  public void checkOut() {
		  
		  btnCheckOut.click();
		  
		  
	  }
	  
	  public void firstName(String firstname) {
			txtFirstName.clear();
			txtFirstName.sendKeys(firstname);
		}
		
	  
	  public void lastName(String lastname) {
			txtLastName.clear();
			txtLastName.sendKeys(lastname);
		}
	  
	  public void postCode(String postcode) {
			txtpostalCode.clear();
			txtpostalCode.sendKeys(postcode);
		}
	  
      public void checkContinue() {
		  
    	  btnContinue.click();
		  
		  
	  }
	
      public void   checkoutOverview() {
			
    	  txtCheckoutOverview.getText();
		
		
		}
      
        public void finish() {
		  
        	btnFinish.click();
		  
		  
	  }
      
      
        public void   thankYou() {
			
        	txtThankYou.getText();
  		
  		
  		}
     
        
        public void backToHome() {
  		  
        	btnBackToHome.click();
		  
		  
	  }
	  
        public void btnBurger() {
    		  
        	btnBurger.click();
		  
		  
	  } 
        
        
        public void btnLogout() {
  		  
        	btnLogOut.click();
		  
		  
	  } 
        
 
        
        
}
