package AppiumGridTests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;



public class AppiumIOSDAtest {
	
	String Appiumurl = null;
	private AppiumDriver driver;
	
	@Before
	public void setup() throws Exception {
		
		
		System.out.println("Starting iOS Driver");

        //Device anywhere
        //Appiumurl = "https://dadaccess12qasm.keynote.com:6232/resource/device/appium/wd/hub";
        Appiumurl = "http://10.120.21.44:80/da/ensemble/device/192c80d8-2ef6-475b-9f54-b59e21c43eeb/9217/web/appium/wd/hub/";
        
        //Appiumurl = "http://10.119.4.108:9090/wd/hub";


        startDriver(Appiumurl);

        System.out.println("Started iOS Driver");

    }

    @SuppressWarnings("rawtypes")
    private void startDriver(String appiumURL) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","Apple iPhone 6");
        capabilities.setCapability("platformVersion", "9.3.2");
        capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("bundleId", "com.kone.KitchenSink");
        //capabilities.setCapability("app", "http://tceproofcenter.deviceanywhere.com/app/21331.ipa");

//        capabilities.setCapability("deviceName","Apple iPad Air");
//        capabilities.setCapability("platformVersion", "9.3.2");
//        capabilities.setCapability("platformName","iOS");
//        capabilities.setCapability("bundleId", "com.kone.KitchenSink");
//        // capabilities.setCapability("app", "C:\\\\DB\\\\expensemgr.apk");
        capabilities.setCapability("userName", "rizwan@appiumtest.com");
        capabilities.setCapability("password", "Harmony1");
        // capabilities.setCapability("browserName", "safari");

        driver =  new IOSDriver(new URL(Appiumurl), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void executeScript() throws Exception {
        System.out.println("Executing Appium script");

    	/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.get("http://www.google.com");
		//screenshot("screenshot" + System.currentTimeMillis());
		driver.get("http://www.yahoo.com");
		//screenshot("screenshot" + System.currentTimeMillis());
		driver.get("http://www.bing.com");
		//screenshot("screenshot" + System.currentTimeMillis());
		 */
        
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAButton[2]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIATextField[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[1]/UIATextField[1]")).sendKeys("Keynote Systems");
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIAScrollView[2]/UIASecureTextField[1]")).sendKeys("Keynote Systems");
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAScrollView[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")).click();
       // driver.findElement(By.name("Accelerometer")).click();
       // driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();
       // driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[1]")).click();


    }

    @After
    public void tearDown() throws Exception {

        //driver.closeApp();
        if(driver != null)

            System.out.println("Now quiting");
        driver.quit();

    }
	

}
