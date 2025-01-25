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

import capabilities.CapabilitiesConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidTest {
	
	AppiumDriver driver ;
	

	@AndroidFindBy(id="org_id")
	private WebElement  orgfield;
	
	
	@BeforeTest
	public void openTeraminal() {
		 CapabilitiesConfig.openTerminalAndroid();
	}
	
	 @BeforeClass
	    public void setup() {
		
	        driver = CapabilitiesConfig.androidDriver();
	        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	    }

	    @Test
	    public void testLogin() {
	        // Locate username field
	  
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
