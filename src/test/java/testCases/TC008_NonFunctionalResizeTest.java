package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;


/*Non Functional test to check if resize of windo works for dektop and mobile devices */
public class TC008_NonFunctionalResizeTest extends BaseClass {
	@Test
    public void testHomePageResponsiveLayout() throws InterruptedException {
		
		
		driver.get(p.getProperty("url"));
     //   driver.get("https://automationintesting.online/");
        HomePage hp = new HomePage(driver);

        // Desktop view
        resizeWindow(1920, 1080);
        Assert.assertTrue(hp.isFooterDisplayed(), "Footer not visible on desktop view");
        Thread.sleep(3000);

        // Mobile view
        resizeWindow(375, 667);
        Assert.assertTrue(hp.isFooterDisplayed(), "Footer not visible on mobile view");
        Thread.sleep(3000);
    }
	
	

}
