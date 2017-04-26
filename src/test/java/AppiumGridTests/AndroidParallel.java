package AppiumGridTests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidParallel {
	 static String Appiumurl= "https://dadaccess12qasm.keynote.com:6232/resource/device/appium/wd/hub";
	    private static AppiumDriver driver1;
	    private static AppiumDriver driver2;
	    static String deviceName1="Samsung SM-G920V Galaxy S6";
	    static String deviceName2="Samsung SM-N910A Galaxy Note 4";
	    static String udid2="00b8c26c";
	    static String udid1="03157df3aa1eb43a";
	    String platformVersion;

    	static DesiredCapabilities capabilities = new DesiredCapabilities();

        
	    public static void main(String[]args) throws InterruptedException
	    {
	    
	    	capabilities.setCapability("userName", "aditya@mc.com");
	        capabilities.setCapability("password", "Harmony1");

	        try {
	        	driver1 = setUp1(deviceName1,udid1);
	        } catch(Exception e) {
	        	
	        }
	        
	        try {
	        	driver2 = setUp1(deviceName2,udid2);
	        } catch(Exception e) {
	        	
	        }
	        
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					System.out.println("Starting first thread for first device!");
					try {
						executeScript(driver1,deviceName1,udid1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						tearDown(driver1,deviceName1,udid1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				public void run() {
					System.out.println("Starting second thread for second device!");
					try {
						executeScript(driver2,deviceName2,udid2);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						tearDown(driver2,deviceName2,udid2);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			
			
			t1.start();
			Thread.sleep(1000);
			t2.start();
			Thread.sleep(1000);
			
			
			t1.join();
			t2.join();
			
			
	    }
			
	
    @SuppressWarnings("rawtypes")
	public static AndroidDriver setUp1(String deviceName,String udid) throws Exception {
		
   
        capabilities.setCapability("deviceName",deviceName); //Samsung SM-G920V Galaxy S6
        capabilities.setCapability("Udid", udid);
       // capabilities.setCapability("platformVersion", "5.0.2");
       // capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage", "com.keynote.keynotedemo");
        capabilities.setCapability("appActivity", "com.keynote.keynotedemo.UserInfo");
       
       // capabilities.setCapability("app", "C:\\\\DB\\\\expensemgr.apk");
        
        
        System.out.println(capabilities);

        AndroidDriver driver = new AndroidDriver(new URL(Appiumurl), capabilities);
     
       return driver; 
    }

 
    @SuppressWarnings("rawtypes")
	public static void executeScript(AppiumDriver driver, String deviceName, String udid) throws Exception {
    	
    	
    	System.out.println("Executing Appium script on " + deviceName );
    	
    	
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	
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
    	driver.findElement(By.id("com.keynote.keynotedemo:id/edit_message")).sendKeys("Welcome to Keynote Mobile Tetsing demo");
    	driver.findElement(By.id("com.keynote.keynotedemo:id/send_button")).click();
    	driver.navigate().back();
    	driver.navigate().back();
    }
    
 
    public static void tearDown(AppiumDriver driver, String deviceName, String udid) throws Exception {

        //driver.closeApp();
        if(driver != null)
        	
        	System.out.println("driver is not null hence quiting driver for  " + deviceName);
            driver.quit();
            System.out.println("driver quit for " + deviceName);

    }
}