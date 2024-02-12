package Storage;

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

public class PhotosAndVideos_MusicAndAudio_Games_MoviesAndTVApps_OtherApps_Files_System_Tests {

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
		dc.setCapability("deviceId", "");
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
	@Test(priority = 16)
	public void PhotosAndVideos_MusicAndAudio_Games_MoviesAndTVApps_OtherApps_Files_System_Test() throws InterruptedException
	
	{
	
	System.out.println("PhotosAndVideos, MusicAndAudio, Games, MoviesAndTVApps, OtherApps, Files, System Testing Started...");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Storage']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Storage manager']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Use Storage manager']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Use Storage manager']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Photos & videos']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Music & audio']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Games']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Movie & TV apps']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Other apps']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='System']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.Button[@text='OK']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElementByXPath("//android.widget.TextView[@text='Files']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	System.out.println("--------> PhotosAndVideos, MusicAndAudio, Games, MoviesAndTVApps, OtherApps, Files, System Test Executed Successfully on INVi-Tab <--------");
	
	}
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
            
        }
	}
}
