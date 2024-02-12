package Accessibility2;

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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class AcessibilityMenu_SwitchAccess_Autoclick_PowerButtonsEndsCall_AutoRotateScreen_TouchAndHoldDelayTimeToTakeAction_VibrationAndHapticStrength_SystemNavigation_Tests {

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
	
	@SuppressWarnings({ "rawtypes" })
	@Test(priority = 1)
	public void AcessibilityMenu_SwitchAccess_Autoclick_PowerButtonsEndsCall_AutoRotateScreen_TouchAndHoldDelayTimeToTakeAction_VibrationAndHapticStrength_SystemNavigation_Test() throws InterruptedException
	{
	
	System.out.println("AcessibilityMenu_SwitchAccess_Autoclick_PowerButtonsEndsCall_AutoRotateScreen_TouchAndHoldDelayTimeToTakeAction_VibrationAndHapticStrength_SystemNavigation_Testing Started...");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Accessibility']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +".scrollIntoView(new UiSelector()" +".textMatches(\"" + "Accessibility Menu" + "\").instance(0))"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility Menu']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementById("com.android.settings:id/switchWidget").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("com.android.settings:id/permission_enable_allow_button").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.Button[@text='GOT IT']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("com.android.settings:id/switchWidget").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Settings']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("android:id/switch_widget").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("android:id/switch_widget").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElementByXPath("//android.widget.TextView[@text='Switch Access']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElementById("android:id/switch_widget").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("com.android.settings:id/permission_enable_allow_button").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("android:id/switch_widget").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.Button[@text='STOP']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("com.android.settings:id/switchWidget").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("com.android.settings:id/permission_enable_allow_button").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.Button[@text='GOT IT']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementById("com.android.settings:id/switchWidget").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Autoclick (dwell timing)']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.TextView[@text='Short']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Medium']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Long']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Custom']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Off']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.TextView[@text='Power button ends call']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Power button ends call']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Auto-rotate screen']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Auto-rotate screen']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Touch & hold delay']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.CheckedTextView[@text='Medium']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Touch & hold delay']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.CheckedTextView[@text='Long']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Touch & hold delay']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.CheckedTextView[@text='Short']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Time to take action (Accessibility timeout)']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='10 seconds']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='30 seconds']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='1 minute']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='2 minutes']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Default']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Vibration & haptic strength']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Ring vibration']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElementByXPath("//android.widget.TextView[@text='On']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Off']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Notification vibration']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElementByXPath("//android.widget.TextView[@text='Off']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='On']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Touch feedback']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElementByXPath("//android.widget.TextView[@text='Off']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='On']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='System navigation']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Gesture navigation']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.Button[@text='GOT IT']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='3-button navigation']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	System.out.println("--------> AcessibilityMenu_SwitchAccess_Autoclick_PowerButtonsEndsCall_AutoRotateScreen_TouchAndHoldDelayTimeToTakeAction_VibrationAndHapticStrength_SystemNavigation_Tests Executed Successfully on INVi-Tab <--------");
	
	}
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
            
        }
	}
}
