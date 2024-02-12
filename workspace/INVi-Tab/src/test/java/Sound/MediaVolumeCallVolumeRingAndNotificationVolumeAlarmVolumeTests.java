package Sound;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class MediaVolumeCallVolumeRingAndNotificationVolumeAlarmVolumeTests {

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
	@Test(priority = 14)
	public void MediaVolumeCallVolumeRingAndNotificationVolumeAlarmVolumeTest() throws InterruptedException
	{
	
	System.out.println("MediaVolumeCallVolumeRingAndNotificationVolumeAlarmVolume Testing Started...");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Sound']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Media volume']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement obj = driver.findElement(By.id("android:id/seekbar"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	TouchAction action=new TouchAction ((PerformsTouchActions) driver);
	action.longPress(ElementOption.element(obj)).moveTo(ElementOption.element(obj,500,250)).release().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(10000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Call volume']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement obj1 = driver.findElement(By.id("android:id/seekbar"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	TouchAction action1=new TouchAction ((PerformsTouchActions) driver);
	action1.longPress(ElementOption.element(obj1)).moveTo(ElementOption.element(obj1,500,250)).release().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(10000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Ring & notification volume']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement obj2 = driver.findElement(By.id("android:id/seekbar"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	TouchAction action2=new TouchAction ((PerformsTouchActions) driver);
	action2.longPress(ElementOption.element(obj2)).moveTo(ElementOption.element(obj2,500,250)).release().perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(10000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Alarm volume']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement obj3 = driver.findElement(By.id("android:id/seekbar"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	TouchAction action3=new TouchAction ((PerformsTouchActions) driver);
	action3.longPress(ElementOption.element(obj3)).moveTo(ElementOption.element(obj3,500,250)).release().perform();	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Vibrate for calls']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Always vibrate']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Vibrate first then ring gradually']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Never vibrate']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Back']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	System.out.println("--------> MediaVolume CallVolume RingAndNotificationVolume AlarmVolume Tests Executed Successfully on INVi-Tab <--------");
	
	}
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
            
        }
	}

}
