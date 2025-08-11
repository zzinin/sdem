package testCase;



import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*It handles setting up the WebDriver instance (ChromeDriver, FirefoxDriver, etc.) before tests run 
 and closing it afterward. By initialising the driver in BaseClass, other test classes can inherit it,
 avoiding redundant code.Centralizes Common Configurations.Supports Cross-Browser Testing.Enhances
 Code Reusability and Clean Structure
 * */  

public class BaseClass {
	
	protected static ExtentReports extent;
    protected static ExtentTest test;	
public WebDriver driver;
public Properties p;
	


@BeforeSuite
public void beforeSuite() {
    initReport();
}




	@Parameters({"os","browser"})
	@BeforeClass
	void setup(String os, String br) throws IOException {
		
		//Loading Config.properties FILE
		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		
		
		
		//Accommodates any browser
	
		switch(br.toLowerCase()) {
		
		case "chrome" : 
			
			ChromeOptions options = new ChromeOptions();
			
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("autofill.profile_enabled", false);
			prefs.put("autofill.credit_card_enabled", false);
			prefs.put("password_manager_enabled", false);

			options.setExperimentalOption("prefs", prefs);

			options.addArguments("--disable-save-password-bubble");
			options.addArguments("--disable-features=PasswordManagerEnabled");
			options.addArguments("--disable-features=PasswordCheck");
			options.addArguments("--disable-blink-features=PasswordLeakDetection");
			options.addArguments("--safebrowsing-disable-extension-blacklist");
			options.addArguments("--safebrowsing-disable-download-protection");
			options.addArguments("--incognito");
            driver = new ChromeDriver(options);
			break;
		case "firefox" : driver=new FirefoxDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default : System.out.println("Invalid browser name..");return;
		}
		
		


		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(p.getProperty("url")); //Reading the "Automation Testing url" from config file 
		driver.manage().window().maximize();

	    }
	
	
	
	
	
	
  @AfterClass
    void tearDown() {
    	
    	
    	driver.quit();
    	
    }
  
  @AfterSuite
  public void afterSuite() {
      flushReport();
  }
  

     
 
      
  
  
 


  /* JavascriptExecutor interface is used to execute JavaScript code 
  directly within the context of the browser. 
  This can be helpful when native Selenium methods (like .click(), .sendKeys(), or scrolling actions)
  do not work reliably due to certain web application behaviours, complex DOM structures, 
  or dynamic JavaScript rendering.*/
  
	public  void focusOn(WebDriver driver, By locator) {

	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	     WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	    ((JavascriptExecutor) driver).executeScript(
	             "arguments[0].scrollIntoView({behavior:'instant',block:'center',inline:'nearest'});",
	             target);

	  
	     ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", target);

	   
	     new Actions(driver).moveToElement(target).perform();
	     }

	
	/* Date formatter                    */
	 public String makeDate(int daysFromToday) {
	    LocalDate date      = LocalDate.now().plusDays(daysFromToday);   
	    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	    return date.format(f);
	     }
	 
	 /* Method for randomFutureDate     */
	 
	 public  String randomFutureDate(int minDaysFromToday, int maxDaysFromToday) {
	
        if (minDaysFromToday < 0 || maxDaysFromToday < minDaysFromToday) {
            throw new IllegalArgumentException("Check your day‑offset range");
        }

        long randomDays =
                ThreadLocalRandom.current()
                                 .nextLong(minDaysFromToday, maxDaysFromToday + 1);

        LocalDate date = LocalDate.now().plusDays(randomDays);
        final DateTimeFormatter DD_MM_YYYY =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(DD_MM_YYYY);
        }
	
	 /* Method for resize windows    */

	public void resizeWindow(int width, int height) {
	    driver.manage().window().setSize(new Dimension(width, height));
	    }
	
	
	public void slowDown(int seconds) {
	    try {
	        Thread.sleep(seconds * 1000); // Pause for given seconds
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	//init extent report
	public static void initReport() {
	    ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");
	    extent = new ExtentReports();
	    extent.attachReporter(spark);
	}
	  // Flush ExtentReports after all tests finish
	  public static void flushReport() {
	      if (extent != null) {
	          extent.flush();
	      }
	
	  }
}