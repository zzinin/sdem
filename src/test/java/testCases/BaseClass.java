package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
public WebDriver driver;
public Properties p;
	
	
	@Parameters({"os","browser"})
	@BeforeClass
	void setup(String os, String br) throws IOException {
		
		//Loading Config.properties FILE
		FileReader file=new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(file);
		
		
		
		
		
	
		switch(br.toLowerCase()) {
		
		case "chrome" : driver=new ChromeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default : System.out.println("Invalid browser name..");return;
		}
		
		
		//	driver = new ChromeDriver();
	//	driver= new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(p.getProperty("url")); //Reading the Automation Testing url from config file 
		driver.manage().window().maximize();
	//	driver.switchTo().frame(0);
	
	
	
	
	}
/*   @AfterClass
    void tearDown() {
    	
    	
    	driver.quit();
    	
    }
*/
   
	
	

}
