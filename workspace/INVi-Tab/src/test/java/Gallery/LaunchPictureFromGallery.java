package Gallery;

import org.testng.annotations.Test;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class LaunchPictureFromGallery {
	
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
		
		dc.setCapability("appPackage", "com.google.android.apps.photosgo");
		dc.setCapability("appActivity", "com.google.android.apps.photosgo.home.HomeActivity");
		
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
	
	@SuppressWarnings("rawtypes")
	@Test(priority = 17)
	public void GalleryTest() throws InterruptedException
	
	{
		
		System.out.println("Gallery Testing is Started...");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		driver.findElement(By.id("com.google.android.apps.photosgo:id/single_photo")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		MobileElement holdElement1= driver.findElementById("com.google.android.apps.photosgo:id/single_photo");
		AndroidTouchAction t1 = new AndroidTouchAction(driver);   
		t1.longPress(LongPressOptions.longPressOptions()
		.withElement(ElementOption.element(holdElement1))
		.withDuration(Duration.ofMillis(5000))).release().perform();
		driver.findElementByXPath("//android.widget.Button[@content-desc='Move to trash']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.Button[@text='ALLOW']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("--------> Gallery Test Executed Successfully on Invi-Tab <--------");
		
	}
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
        }
	}

}

