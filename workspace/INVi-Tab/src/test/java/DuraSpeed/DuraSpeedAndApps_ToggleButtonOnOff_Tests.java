package DuraSpeed;

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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class DuraSpeedAndApps_ToggleButtonOnOff_Tests {

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		
		}
		catch (Exception exp) 
		{
			System.out.println("Cause is : "+exp.getCause());
			System.out.println("Message is : "+exp.getMessage());
			exp.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unused", "rawtypes" })
	@Test(priority = 1)
	public void DuraSpeedAndApps_ToggleButtonOnOff_Test() throws InterruptedException
	
	{
	
	System.out.println("DuraSpeedAndApps_ToggleButtonOnOff_Testing Started...");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	AndroidElement list=(AndroidElement)driver.findElementById("android:id/title");
	MobileElement listitem = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"DuraSpeed\"));"));
	System.out.println(listitem.getLocation());listitem.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.TextView[@text='Turn all on']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='More options']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.TextView[@text='Turn all off']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.id("com.mediatek.duraspeed:id/status")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.id("com.mediatek.duraspeed:id/status")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	
	System.out.println("--------> DuraSpeedAndApps_ToggleButtonOnOff_Test Executed Successfully on INVi-Tab <--------");
	
	}
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
            
        }
	}

}