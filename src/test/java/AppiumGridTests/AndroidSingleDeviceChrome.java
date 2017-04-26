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

import static org.junit.Assert.*;

public class AndroidSingleDeviceChrome {
    String Appiumurl= null;
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        System.out.println("Starting Android Driver");

        //Device anywhere
        Appiumurl = "https://dadaccess12qasm.keynote.com:6232/resource/device/appium/wd/hub";


        startDriver(Appiumurl);

        System.out.println("Started Android Driver");

    }

    @SuppressWarnings("rawtypes")
	private void startDriver(String appiumURL) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","Samsung SM-N910A Galaxy Note 4"); //Samsung Galaxy S6 ,Samsung SM-N910A Galaxy Note 4
      //  capabilities.setCapability("platformVersion", "5.0.1");
       // capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.ChromeTabbedActivity");
       // capabilities.setCapability("app", "C:\\\\DB\\\\expensemgr.apk");
        capabilities.setCapability("userName", "aditya@mc.com");
        capabilities.setCapability("password", "Harmony1");
        capabilities.setCapability("udid", "03157df3aa1eb43a");

        driver = new AndroidDriver(new URL(Appiumurl), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void executeScript() throws Exception {
    	System.out.println("Executing Appium script");

    	System.out.println("*************************************Launching Chrome********************************");
      	 driver.get("https://www.att.com/olam/loginAction.olamexecute?source=IC4425j4900s2000");
      	// driver.get(System.getenv("WEB_APP_URL"));

       //System.out.println("***********************************" + System.getenv("WEB_APP_URL")+ " **********************************");

       Thread.sleep(5000);
       driver.findElement(By.id("userId")).sendKeys("test@hellotest.com");

       Thread.sleep(5000);
       driver.findElement(By.id("password")).sendKeys("test");
       }

    @After
    public void tearDown() throws Exception {


        if(driver != null)

        	System.out.println("Test");
            driver.quit();

    }
}
