package ConnectionPreferences;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class NearbyShare {

AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setup() {
		
		try {
			
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"APPIUM");
		dc.setCapability("appium-version", "1.22.3");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"along_8765");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
		dc.setCapability("deviceId", "0123456789ABCDEF");
		dc.setCapability(MobileCapabilityType.UDID,"472cec8");	
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.NO_RESET,"true");
		dc.setCapability(MobileCapabilityType.FULL_RESET,"false");
		dc.setCapability("suppressKillServer", true);
		dc.setCapability("appPackage", "com.android.settings");
		dc.setCapability("appActivity", "com.android.settings.Settings");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
		catch (Exception exp) 
		{
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Test(priority = 7)
	public void NearbyShareTest() throws InterruptedException
	
	{
	
	System.out.println("Nearby Share Testing Started...");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Connected devices']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Connection preferences']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Nearby Share']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Use Nearby Share']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Use Nearby Share']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Data']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Data']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Data']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Wi-Fi only']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.Button[@text='UPDATE']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Wi-Fi only']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Without internet']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.Button[@text='UPDATE']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Without internet']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Data']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.Button[@text='UPDATE']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Show notification']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Show notification']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	System.out.println("--------> Nearby Share Test Executed Successfully on INVi-Tab <--------");
	
	}
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
            
        }
	}

}
