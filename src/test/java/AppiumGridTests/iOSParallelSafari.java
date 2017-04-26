package AppiumGridTests;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
		
public class iOSParallelSafari  
		
		{
		static String Appiumurl= "https://dadaccess12qasm.keynote.com:6232/resource/device/appium/wd/hub";
		private static AppiumDriver driver1;
		private static AppiumDriver driver2;
		static String deviceName1="Apple iPad Air";
		static String deviceName2="Apple iPhone6";
		String platformVersion;
		
		static DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		public static void main(String[]args) throws InterruptedException
		{
		
			capabilities.setCapability("userName", "aditya@mc.com");
		    capabilities.setCapability("password", "Harmony1");
		
		    try {
		    	driver1 = setUp1(deviceName1);
		    } catch(Exception e) {
		    	
		    }
		    
		    try {
		    	driver2 = setUp1(deviceName2);
		    } catch(Exception e) {
		    	
		    }
		    
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					System.out.println("Starting first thread for first device!" + deviceName1);
					try {
						executeScript(driver1,deviceName1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						tearDown(driver1,deviceName1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				public void run() {
					System.out.println("Starting second thread for second device!" + deviceName2);
					try {
						executeScript(driver2,deviceName2);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						tearDown(driver2,deviceName2);
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
		public static IOSDriver setUp1(String deviceName) throws Exception {
		
		
		capabilities.setCapability("deviceName",deviceName); 
		capabilities.setCapability("platformVersion", "9.3.1");
		capabilities.setCapability("platformName","iOS");
        capabilities.setCapability("browserName", "safari");
		System.out.println(capabilities);
		
		IOSDriver driver = new IOSDriver(new URL(Appiumurl), capabilities);
		
		return driver; 
		}
		
		
		public static void executeScript(AppiumDriver driver, String deviceName) throws Exception {
		
		
		System.out.println("Executing Appium script on " + deviceName );
		
		driver.get("http://www.google.com");
		
		driver.get("http://www.yahoo.com");
		
		driver.get("http://www.bing.com");
		
		}
		
		
		public static void tearDown(AppiumDriver driver, String deviceName) throws Exception {
		
		//driver.closeApp();
		if(driver != null)
			
			System.out.println("driver is not null hence quiting driver for  " + deviceName);
		    driver.quit();
		    System.out.println("driver quit for " + deviceName);
		
		}
		}