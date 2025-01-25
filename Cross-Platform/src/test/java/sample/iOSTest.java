package sample;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import capabilities.CapabilitiesConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class iOSTest {
	
	AppiumDriver driver ;
	
	
	@iOSXCUITFindBy(xpath="//*[@name='OrgLookUpTextField']")
	private WebElement  orgfield;
	
	
	@BeforeTest
	public void openTeraminal() {
		CapabilitiesConfig.openTerminaliOS();
		
	}
	
	 @BeforeClass
	    public void setup() throws Exception {
		 Thread.sleep(5000);
	        driver = CapabilitiesConfig.iOSDriver();
	        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	    }

	    @Test
	    public void testLogin() throws InterruptedException {
	       
	    	Thread.sleep(2000);
	       orgfield.click();
	    	orgfield.sendKeys("testuser");

	     
	    }

	   
		@AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
