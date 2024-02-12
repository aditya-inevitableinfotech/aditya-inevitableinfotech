package ORCA;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


	public class koshexAppTest {
		

	AndroidDriver<MobileElement> driver;
		
		@BeforeMethod
		public void setup() {
//			String apkPath = "/home/invlko-047/Downloads/koshex_uat.apk";
			try {
				
			DesiredCapabilities dc = new DesiredCapabilities();
			
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"APPIUM");
			dc.setCapability("appium-version", "1.22.3");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME,"sb52");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12");
			dc.setCapability(MobileCapabilityType.UDID, "472cec8");
//			dc.setCapability(MobileCapabilityType.APP, "/home/invlko-047/Downloads/koshex_uat.apk");
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
			dc.setCapability("autoGrantPermissions", "true");
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
		
		
		@SuppressWarnings({ "rawtypes" })
		@Test(invocationCount = 1)
		public void koshexAppTesting() throws InterruptedException, IOException
		
		{
			
			System.out.println("Network_Testing is Started...");
			
			((AndroidDriver<MobileElement>)driver).lockDevice();
			((AndroidDriver<MobileElement>)driver).unlockDevice();
			TouchAction  action = new TouchAction(driver);	
			org.openqa.selenium.Dimension size	=driver.manage().window().getSize();
			int width=size.width;
			int height=size.height;		
			int middleOfX=width/2;
			int startYCoordinate= (int)(height*.80);
			int endYCoordinate= (int)(height*.20);	
			action.press(PointOption.point(middleOfX, startYCoordinate))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			driver.findElement(By.id("com.android.systemui:id/pinEntry")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			driver.findElement(By.id("com.android.systemui:id/key2")).click();
			driver.findElement(By.id("com.android.systemui:id/key0")).click();
			driver.findElement(By.id("com.android.systemui:id/key2")).click();
			driver.findElement(By.id("com.android.systemui:id/key3")).click();
			driver.findElement(By.id("com.android.systemui:id/key_enter")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			((StartsActivity) driver).startActivity(new Activity("org.codeaurora.dialer","com.android.dialer.main.impl.MainActivity"));
//			com.android.dialer", "com.android.dialer.main.impl.MainActivity
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(4000);
			driver.findElement(By.id("com.android.dialer:id/fab")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='9']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='4']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='7']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='5']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='9']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='6']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='6']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='8']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(40000);
			driver.findElement(By.id("com.android.dialer:id/fab")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='*']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='#']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='*']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='#']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='4']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='6']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='3']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='6']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='#']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='*']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='#']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='*']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(100);
			driver.findElement(By.xpath("//android.widget.TextView[@text='Phone information']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			driver.findElement(By.id("com.android.settings:id/ping_test")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(1000);
			driver.findElement(By.id("com.android.settings:id/ping_test")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(1000);
			driver.findElement(By.id("com.android.settings:id/ping_test")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(1000);
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			((AndroidDriver<MobileElement>)driver).lockDevice();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			System.out.println("--------> Network_Testing is Executed Successfully on ORCA <--------");
			
			
		}

		@AfterMethod
		public void Teardown() {
			if (driver != null) {
	            driver.quit();
	        }
		}

	}

