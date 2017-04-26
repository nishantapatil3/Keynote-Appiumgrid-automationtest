package AppiumGridTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidSingleDevice {
    String Appiumurl= null;
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        System.out.println("Starting Android Driver");

        //Device anywhere
        Appiumurl = "http://SFO-AMP-TCE-018.deviceanywhere.com:80/da/ensemble/device/b1qUEQrZfggBLB07b4nmBw/appium/wd/hub/";

        startDriver(Appiumurl);

        System.out.println("Started Android Driver");

    }

    @SuppressWarnings("rawtypes")
	private void startDriver(String Appiumurl) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","Samsung SM-N910A Galaxy S7");
        //capabilities.setCapability("platformVersion", "5.0.2");
        //capabilities.setCapability("platformName","Android");
        //capabilities.setCapability("udid", "03157df3aa1eb43a");
        capabilities.setCapability("appPackage", "com.keynote.keynotedemo");
        capabilities.setCapability("appActivity", "com.keynote.keynotedemo.UserInfo");
        //capabilities.setCapability("app", "C:\\test\\KeynoteDemo-debug.apk");

        System.out.println(capabilities);
        
        
        driver = new AndroidDriver(new URL(Appiumurl), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void executeScript() throws Exception {
    	
    	for ( int i=1;i<=1;i++)
    	{
    	System.out.println("Executing Appium script # " + i );
    	
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.id("com.keynote.keynotedemo:id/title"));
    	driver.findElement(By.id("com.keynote.keynotedemo:id/edit_first_name")).sendKeys("Jack ");
    	driver.findElement(By.id("com.keynote.keynotedemo:id/edit_last_name")).sendKeys("Turner");
    	driver.findElement(By.id("com.keynote.keynotedemo:id/edit_phone")).sendKeys("777-777-777");
    	driver.findElement(By.id("com.keynote.keynotedemo:id/radioMale")).click();
    	driver.findElement(By.id("com.keynote.keynotedemo:id/edit_email")).sendKeys("Jack@mobiletest.com");
    	driver.navigate().back();
    	driver.findElement(By.id("com.keynote.keynotedemo:id/spinner1")).click();
    	driver.findElement(By.name("Spanish")).click();
    	driver.findElement(By.id("com.keynote.keynotedemo:id/next_button")).click();
    	Thread.sleep(2000);
    	driver.findElement(By.id("com.keynote.keynotedemo:id/edit_recipients")).sendKeys("test@demo.com");
    	driver.findElement(By.id("com.keynote.keynotedemo:id/edit_message")).sendKeys("Welcome to Mobile Testing demo");
    	driver.findElement(By.id("com.keynote.keynotedemo:id/send_button")).click();
    	driver.navigate().back();
    	driver.navigate().back();
    }
    }
    @After
    public void tearDown() throws Exception {

        //driver.closeApp();
        if(driver != null)
        	
        	System.out.println("Test");
            driver.quit();

    }
}