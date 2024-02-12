package ConnectionPreferences2;

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

public class AndroidAuto {

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
	
	@SuppressWarnings({ "unused", "rawtypes" })
	@Test(priority = 8)
	public void AndroidAutoTest() throws InterruptedException
	
	{
	
	System.out.println("Android Auto Testing Started...");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByXPath("//android.widget.TextView[@text='Connected devices']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.TextView[@text='Connection preferences']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Android Auto']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.id("com.google.android.projection.gearhead:id/preference_button")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Connect using wireless Android Auto']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Connect using Bluetooth']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.Button[@text='PAIR A CAR']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElementByXPath("//android.widget.TextView[@text='Pair new device']").click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Back']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Connection help']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Previously connected cars']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Customize launcher']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Day/Night mode for maps']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Day']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Day/Night mode for maps']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Night']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Day/Night mode for maps']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Automatic']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Start Android Auto automatically']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Always']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Start Android Auto automatically']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='If used on the last drive']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Start Android Auto automatically']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Default (set by the car)']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Start Android Auto while locked']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Start Android Auto while locked']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	AndroidElement list=(AndroidElement)driver.findElementById("android:id/title");
	MobileElement listitem = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+"new UiSelector().text(\"Start music automatically\"));"));
	System.out.println(listitem.getLocation());listitem.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Start music automatically']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Taskbar widgets']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Taskbar widgets']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Driver seat location']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Default (set by the car)']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Driver seat location']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Left']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Driver seat location']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Right']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Show first line of conversations']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Show first line of conversations']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Show conversations']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Show conversations']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Show group conversations']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Show group conversations']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Play conversation chime']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Play conversation chime']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Google Analytics']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Google Analytics']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Safety, Data, and Legal Notices']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Safety Information']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Data Notice']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Open Source Licenses']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Version']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	
	System.out.println("--------> Android Auto Test Executed Successfully on INVi-Tab <--------");
	
	}
	
	@AfterMethod
	public void Teardown() {
		if (driver != null) {
            driver.quit();
            
        }
	}

}
