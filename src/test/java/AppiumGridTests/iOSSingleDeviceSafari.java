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

public class iOSSingleDeviceSafari {
    String Appiumurl= null;
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        System.out.println("Starting iOS Driver");

        //Device anywhere
        Appiumurl = "http://10.120.21.44:80/da/ensemble/device/192c80d8-2ef6-475b-9f54-b59e21c43eeb/9217/web/appium/wd/hub/";

        startDriver(Appiumurl);
        System.out.println("Started Android Driver");

    }

    private void startDriver(String appiumURL) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName","Apple iPhone 6");
		//capabilities.setCapability("platformVersion", "9.3.1");
		//capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("browserName", "safari");
        capabilities.setCapability("udid", "800b605811322465e5a1f2bba4d7066d08305e92");

		System.out.println(capabilities);

        capabilities.setCapability("userName", "aditya@mc.com");
        capabilities.setCapability("password", "Harmony1");

        driver = new IOSDriver(new URL(Appiumurl), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void executeScript() throws Exception {
    	System.out.println("Executing Appium script");

    	for( int i=1;i<=3;i++)
    	{

    	//driver.get("http://www.google.com");

		//driver.get("http://www.yahoo.com");

		driver.get("http://www.bing.com");

       }
    }
    @After
    public void tearDown() throws Exception {

        //driver.closeApp();
        if(driver != null)

        	System.out.println("Releasing device");
            driver.quit();

    }
}
