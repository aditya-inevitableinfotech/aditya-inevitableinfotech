package I2C;

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

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import I2C.I2CAutomation.DeviceInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class I2CAutomation {

    AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setup() {

        try {
            DesiredCapabilities dc = new DesiredCapabilities();

            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "APPIUM");
            dc.setCapability("appium-version", "1.22.3");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "sb52");
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            
            DeviceInfo deviceInfo = getConnectedDeviceInfo();
            if (deviceInfo != null) {
                System.out.println("Connected device UDID: " + deviceInfo.getDeviceUDID());
                System.out.println("Connected device Name: " + deviceInfo.getDeviceName());
            } else {
            	System.out.println("No devices connected. Please Check your Connectivity!");
                System.exit(0);
            }        
        
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            dc.setCapability(MobileCapabilityType.NO_RESET, "true");
            dc.setCapability(MobileCapabilityType.FULL_RESET, "false");
            dc.setCapability("uiautomator2ServerInstallTimeout", 9000);
            dc.setCapability("uiautomator2ServerLaunchTimeout", 9000);
            dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 2000);
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

        } catch (Exception exp) {
            System.out.println("Cause is : " + exp.getCause());
            System.out.println("Message is : " + exp.getMessage());
            exp.printStackTrace();
        }
    }

    public static DeviceInfo getConnectedDeviceInfo() {
        try {
            Process process = Runtime.getRuntime().exec("adb devices");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.endsWith("device")) {
                    String[] deviceInfo = line.split("\\s+");
                    String deviceName = deviceInfo[0];

                    // Execute adb shell getprop ro.product.model command
                    Process Process1 = Runtime.getRuntime().exec("adb -s " + deviceName + " shell getprop ro.product.model");
                    BufferedReader Reader1 = new BufferedReader(new InputStreamReader(Process1.getInputStream()));
                    String modelName = Reader1.readLine();
                    Reader1.close();

                    reader.close();
                    return new DeviceInfo(deviceName, modelName);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

	static class DeviceInfo {
	    private final String deviceUDID;
	    private final String deviceName;
	
	    public DeviceInfo(String deviceName, String deviceUDID) {
	        this.deviceUDID = deviceUDID;
	        this.deviceName = deviceName;
	    }
	
	    public String getDeviceUDID() {
	        return deviceName;
	    }
	
	    public String getDeviceName() {
	        return deviceUDID;
	    }
	}

    @Test(invocationCount = 1)
    public void ControllerI2CTesting() throws InterruptedException, IOException {
        try {
            System.out.println("-----> Controller I2C Testing is Started <-----");
            
            // Unlock device
            ((AndroidDriver<MobileElement>) driver).lockDevice();
            ((AndroidDriver<MobileElement>) driver).unlockDevice();

            // Swipe up
            Swipeup();

            // Enter PIN
            driver.findElement(By.id("com.android.systemui:id/pinEntry")).click();
            enterPin("2023"); // Replace with your PIN
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Start the app
            ((StartsActivity) driver).startActivity(new Activity("com.inevitable.controller", "com.inevitable.controller.MainActivity"));
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to I2C settings
            driver.findElement(By.id("com.inevitable.controller:id/setting_button_i2c")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
            
            // Navigate I2C Bus
            driver.findElement(By.id("com.inevitable.controller:id/i2c_bus")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Export to I2C pins
            List<MobileElement> dropdownItems = driver.findElements(By.xpath("//android.widget.TextView"));
            Random rand = new Random();
            int randomIndex = rand.nextInt(dropdownItems.size());
            dropdownItems.get(randomIndex).click();

            // Navigate Device Address
            driver.findElement(By.id("com.inevitable.controller:id/device_address")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Handle GPIO values based on random selection
            handleGPIOValues2();

            // Input random string
            inputRandomString();

            // Navigate back
            navigateBack();
            navigateBack();
            navigateBack();
            
            // Confirm action
            driver.findElement(By.id("android:id/button1")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Lock device
            ((AndroidDriver<MobileElement>) driver).lockDevice();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

	@SuppressWarnings("rawtypes")
	private void Swipeup() throws InterruptedException {
		// TODO Auto-generated method stub
		TouchAction action = new TouchAction(driver);
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int startYCoordinate = (int) (height * 0.80);
        int endYCoordinate = (int) (height * 0.20);
        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
	}

	private void enterPin(String pin) {
		// TODO Auto-generated method stub
		for (char digit : pin.toCharArray()) {
            driver.findElement(By.id("com.android.systemui:id/key" + digit)).click();
        }
        driver.findElement(By.id("com.android.systemui:id/key_enter")).click();
	}

	private void handleGPIOValues2() throws InterruptedException {
        // TODO: Implement GPIO handling logic
    	Random random = new Random();
        List<MobileElement> dropdownItems3 = driver.findElements(By.xpath("//android.widget.TextView"));

        // Randomly select an item
        int randomIndex3 = random.nextInt(dropdownItems3.size());
        dropdownItems3.get(randomIndex3).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Check if the selected item is the second item
        if (randomIndex3 == 1) {
            // Execute code for the second item
            
            driver.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();

            // Update the dropdownItems list after clicking on gpio_values
            dropdownItems3 = driver.findElements(By.xpath("//android.widget.TextView"));

            Random random1 = new Random();
            int randomIndex4 = random1.nextInt(dropdownItems3.size());
            dropdownItems3.get(randomIndex4).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        }
    }

    private void inputRandomString() throws InterruptedException {
    	
        String randomString = generateRandomString();
        driver.findElement(By.id("com.inevitable.controller:id/input_string")).sendKeys(randomString);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.Button[@text='SUBMIT']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='SCAN']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        scrollDown();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(10000);
        
        System.out.println("--------> Controller I2C Testing is Executed Successfully on ORCA <--------");
        
    }

    @SuppressWarnings("rawtypes")
    
	private void scrollDown() throws InterruptedException {
		// TODO Auto-generated method stub
        TouchAction action = new TouchAction(driver);
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int startYCoordinate = (int) (height * 0.20);
        int endYCoordinate = (int) (height * 0.80);
        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
	}

	private String generateRandomString() {
        // Define the characters that can be part of the random string
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890+\\{}[]-!@#$%^&*()~`;:'.,?/|";

        // Set the length of the random string
        int length = 10;

        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        // Generate a random string by selecting characters randomly from the allowed characters
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allowedCharacters.length());
            randomString.append(allowedCharacters.charAt(randomIndex));
        }

        return randomString.toString();
    }

    @SuppressWarnings({ "rawtypes" })
   	private void navigateBack() throws InterruptedException {
           ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
       }
    
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
