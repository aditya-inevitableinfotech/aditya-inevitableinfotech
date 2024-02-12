package Dialer;

import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialANumber {
	
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
		
		dc.setCapability("appPackage", "com.google.android.dialer");
		dc.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		
		}
		catch (Exception exp) 
		{
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	
	@Test(priority = 16)
	public void DialerTest() throws InterruptedException
	
	{
		
		System.out.println("Dialler Testing is Started...");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/tab_contacts")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/six")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/four")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/three")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/four")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/five")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/six")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/seven")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.Button[@text='Cancel']").click();
		
		System.out.println("--------> Dialler Test Executed Successfully on INVi-Tab <--------");
		
	}
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
        }
	}
	
}
