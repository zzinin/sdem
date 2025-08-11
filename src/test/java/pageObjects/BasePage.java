package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Base page class for all Page Object classes.
 * <p>
 * Holds a shared {@link WebDriver} instance, allowing all page objects
 * to operate within the same browser session.
 * Uses {@link PageFactory#initElements(WebDriver, Object)} to automatically
 * initialize all WebElements annotated with {@code @FindBy}.
 * </p>
 */
public class BasePage {

    protected WebDriver driver;

    /**
     * Constructor to store the WebDriver instance and initialize page elements.
     *
     * @param driver the WebDriver instance to be used by the page object
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
