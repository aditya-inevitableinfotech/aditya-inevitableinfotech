package AutomationTestKoshexApp;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class Data_performance_tests {
	
	
AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setup() {
		
		try {
			
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"APPIUM");
		dc.setCapability("appium-version", "1.22.3");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Bengal for arm");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
		dc.setCapability(MobileCapabilityType.UDID, "472cec8");	
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
		dc.setCapability(MobileCapabilityType.NO_RESET, "true");
		dc.setCapability(MobileCapabilityType.FULL_RESET, "false");
		dc.setCapability("uiautomator2ServerInstallTimeout", 9000); 
		dc.setCapability("uiautomator2ServerLaunchTimeout", 9000);
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,2000);
	    dc.setCapability("automationName", "uiautomator2");
		dc.setCapability("skipServerInstallation", false);
		dc.setCapability("adbExecTimeout", 5000);
		dc.setCapability("clearSystemFiles", true);
		dc.setCapability("appWaitForLaunch", false);
		dc.setCapability("suppressKillServer", true);
		dc.setCapability("appWaitPackage", "io.appium.settings");
        dc.setCapability("appWaitActivity", "io.appium.settings.Settings");
		dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
	    dc.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, dc);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		}
		catch (Exception exp) 
		{
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("rawtypes")
	@Test(invocationCount = 10)
	public void Data_performance_test() throws InterruptedException 
	{
		System.out.println("Data_performance_Testing is Started...");
		
		((StartsActivity) driver).startActivity(new Activity("com.whatsapp", "com.whatsapp.HomeActivity"));
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='New chat']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +".scrollIntoView(new UiSelector()" +".textMatches(\"" + "Prasad sir" + "\").instance(0))"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Prasad sir']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Attach']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.whatsapp:id/thumbnail")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Photo']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Send']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		((StartsActivity) driver).startActivity(new Activity("org.thoughtcrime.securesms", "org.thoughtcrime.securesms.RoutingActivity"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Prasad sir']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Add attachment']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("org.thoughtcrime.securesms:id/media_gallery_image")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("org.thoughtcrime.securesms:id/media_gallery_image")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("org.thoughtcrime.securesms:id/media_selection_image")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("org.thoughtcrime.securesms:id/send")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		
		
		System.out.println("--------> Data_performance_tests Executed Successfully on ORCA Board <--------");
	}
	
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
        }
	}

}