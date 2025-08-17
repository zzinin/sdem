package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object class representing the SauceDemo Login Page.
 * Contains WebElements and related actions that can be performed on the login page.
 * Extends {@link BasePage} to inherit the WebDriver instance and element initialization.
 */

public class LoginPage extends BasePage {

    /**
     * Constructor to initialize the WebDriver and web elements.
     *
     * @param driver the WebDriver instance passed from the test
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // WebElement Locators
    // =========================

    /** SauceDemo logo on the login page. */
    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement nameMainPage;

    /** Username input field. */
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement txtUserName;

    /** Password input field. */
    @FindBy(xpath = "//input[@id='password']")
    private WebElement txtPassword;

    /** Login button. */
    @FindBy(xpath = "//*[@id='login-button']")
    private WebElement btnLogin;

    /** Error message displayed on invalid login. */
    @FindBy(xpath = "//*[@id='login_button_container']/div/form/div[3]/h3")
    private WebElement error;

    // =========================
    // Page Actions
    // =========================

    /**
     * Enters the given username into the username field.
     *
     * @param userid the username to enter
     */
    public void Userid(String userid) {
        txtUserName.clear();
        txtUserName.sendKeys(userid);
    }

    /**
     * Enters the given password into the password field.
     *
     * @param password the password to enter
     */
    public void Password(String password) {
        txtPassword.clear(); // FIX: clear password field instead of username field
        txtPassword.sendKeys(password);
    }

    /**
     * Clicks the login button.
     */
    public void Login() {
        btnLogin.click();
    }
}
