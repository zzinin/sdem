package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object class representing the SauceDemo Product Page.
 * <p>
 * Contains WebElements and related actions that can be performed on the product page.
 * Extends {@link BasePage} to inherit WebDriver instance and element initialization.
 * </p>
 */
public class ProductPage extends BasePage {

    /**
     * Constructor to initialize WebDriver and web elements.
     *
     * @param driver the WebDriver instance passed from the test
     */
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // WebElement Locators
    // =========================

    /** Application logo displayed on the product page. */
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement appLogo;

    /** Specific product (Sauce Labs Backpack) displayed on the product page. */
    @FindBy(xpath = "//div[normalize-space()='Sauce Labs Backpack']")
    private WebElement productSelected;

    /** Button to add the product to the cart. */
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement btnAddToCart;

    /** Shopping cart link/button. */
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement btnCartLink;

    /** Checkout button on the cart page. */
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement btnCheckOut;

    /** Input field for first name on checkout page. */
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement txtFirstName;

    /** Input field for last name on checkout page. */
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement txtLastName;

    /** Input field for postal code on checkout page. */
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement txtPostalCode;

    /** Continue button on the checkout page. */
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement btnContinue;

    /** Text element displaying checkout overview title. */
    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtCheckoutOverview;

    /** Finish button on the checkout overview page. */
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement btnFinish;

    /** Thank you message displayed after order completion. */
    @FindBy(xpath = "//h2[normalize-space()='Thank you for your order!']")
	private  WebElement txtThankYou;

    /** Button to go back to products after order completion. */
    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement btnBackToHome;

    /** Burger menu button for navigation. */
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement btnBurger;

    /** Logout button in the sidebar menu. */
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogOut;

    // =========================
    // Page Actions
    // =========================

    /** 
     * Returns the app logo text.
     *
     * @return the text of the application logo
     */
    public String getLogoText() {
        return appLogo.getText();
    }

    /** Clicks the product to select it. */
    public void selectProduct() {
        productSelected.click();
    }

    /** Clicks the 'Add to Cart' button for the product. */
    public void addToCart() {
        btnAddToCart.click();
    }

    /** Clicks on the cart icon/link to navigate to the cart page. */
    public void clickToCart() {
        btnCartLink.click();
    }

    /** Clicks the 'Checkout' button in the cart page. */
    public void checkOut() {
        btnCheckOut.click();
    }

    /**
     * Enters the first name on the checkout form.
     *
     * @param firstname the first name to enter
     */
    public void enterFirstName(String firstname) {
        txtFirstName.clear();
        txtFirstName.sendKeys(firstname);
    }

    /**
     * Enters the last name on the checkout form.
     *
     * @param lastname the last name to enter
     */
    public void enterLastName(String lastname) {
        txtLastName.clear();
        txtLastName.sendKeys(lastname);
    }

    /**
     * Enters the postal code on the checkout form.
     *
     * @param postcode the postal code to enter
     */
    public void enterPostalCode(String postcode) {
        txtPostalCode.clear();
        txtPostalCode.sendKeys(postcode);
    }

    /** Clicks the 'Continue' button on the checkout form. */
    public void clickContinue() {
        btnContinue.click();
    }

    /** Returns the text of the checkout overview title. */
    public String getCheckoutOverviewText() {
        return txtCheckoutOverview.getText();
    }

    /** Clicks the 'Finish' button to complete the order. */
    public void finishOrder() {
        btnFinish.click();
    }

    /** Returns the thank you message text after order completion. */
    public String getThankYouText() {
        return txtThankYou.getText();
    }
    
    /** Returns WebElement to be used further while getting inherited*/
    public WebElement getThankYouElement() {
        return txtThankYou;
    } 
    /** Clicks the button to go back to the home/products page after order. */
    public void backToHome() {
        btnBackToHome.click();
    }

    /** Clicks the burger menu button to open navigation sidebar. */
    public void openBurgerMenu() {
        btnBurger.click();
    }

    /** Clicks the logout button in the sidebar menu. */
    public void logout() {
        btnLogOut.click();
    }
}
