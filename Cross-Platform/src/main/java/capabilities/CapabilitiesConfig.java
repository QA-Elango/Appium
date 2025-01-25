package capabilities;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CapabilitiesConfig {
   
    
  
    public static AppiumDriver driver;
    
    public static AppiumDriver androidDriver() {
    	
        DesiredCapabilities capability = new DesiredCapabilities();
        
        capability.setCapability("deviceName", "deviceID");
		capability.setCapability("automationName", "UiAutomator2");
		capability.setCapability("platformVersion", "10");
		capability.setCapability("platformName", "Android");
		capability.setCapability("autoAcceptAlerts", true);
		capability.setCapability("autoGrantPermissions", true);
		capability.setCapability("noSign", true);
		capability.setCapability("appPackage", "appPackage");
		capability.setCapability("appActivity","AppStartActivity");
		capability.setCapability("NoReset",false);
		capability.setCapability("app","locators");
		capability.setCapability("newCommandTimeout", 300);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capability);
        } catch (MalformedURLException e) {
            System.out.println("Invalid Appium server URL");
        }

        return driver;
    }
    
    
 public static AppiumDriver iOSDriver() {
    	
        DesiredCapabilities capability = new DesiredCapabilities();
        
        capability.setCapability("udid","UDID");
		capability.setCapability("automationName", "XCUITest");
		capability.setCapability("platformVersion", "15.8");
		capability.setCapability("deviceName", "iPhone7");
		capability.setCapability("autoAcceptAlerts", true);
		capability.setCapability("autoGrantPermissions", true);
//		capability.setCapability("noSign", true);
		capability.setCapability("bundlId", "build ID");
//		capability.setCapability("appActivity","AppActivity");
		capability.setCapability("NoReset",true);
		capability.setCapability("app","Location");
		capability.setCapability("newCommandTimeout", 300);
        try {
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), capability);
        } catch (MalformedURLException e) {
            System.out.println("Invalid Appium server URL");
        }

        return driver;
    }
 

 public static void openTerminalAndroid() {
	 try {
         // Open the terminal and run the Appium command
         String command = "appium -a 0.0.0.0 -p 4723";
         Process process = Runtime.getRuntime().exec(command);
         
         // Print the output to console (optional)
         BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
         String line;
         while ((line = reader.readLine()) != null) {
             System.out.println(line);
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
	 
	 
 }
 public static void openTerminaliOS() {
	 try {
         // Create a Robot instance to simulate keyboard events
         Robot robot = new Robot();

         // Step 1: Open the terminal
         // On MacOS, pressing Command (⌘) + Space opens Spotlight search
         robot.keyPress(KeyEvent.VK_META); // Meta key (Command key on Mac)
         robot.keyPress(KeyEvent.VK_SPACE);
         robot.keyRelease(KeyEvent.VK_SPACE);
         robot.keyRelease(KeyEvent.VK_META);
System.out.println("terminal opened");
         // Step 2: Type "Terminal" in Spotlight to open the terminal
         String terminalApp = "Terminal";
         for (char c : terminalApp.toCharArray()) {
             robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
             robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
         }

         // Press Enter to launch Terminal
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);

         // Step 3: Wait for the terminal to open (you can add a delay if needed)
         Thread.sleep(1000); // Sleep for 1 second to ensure the terminal is ready

         // Step 4: Type the Appium start command
         String appiumCommand = "appium -a 0.0.0.0 -p 4724";

         for (char c : appiumCommand.toCharArray()) {
             robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
             robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
         }

         // Press Enter to execute the command
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);

     } catch (Exception e) {
         e.printStackTrace();
     }
 }


}

