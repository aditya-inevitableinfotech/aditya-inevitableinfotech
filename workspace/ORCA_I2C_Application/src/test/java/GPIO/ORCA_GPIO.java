package GPIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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

public class ORCA_GPIO {

    static AndroidDriver<MobileElement> driver;

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

	
    @SuppressWarnings({ "resource" })
	@Test(invocationCount = 1)
    public void ControllerGPIOTesting() throws InterruptedException, IOException {

        System.out.println("Controller GPIO Testing is Started...");

        // Unlock device
        ((AndroidDriver<MobileElement>) driver).lockDevice();
        ((AndroidDriver<MobileElement>) driver).unlockDevice();

        // Swipe up
        Swipeup();

        // Enter PIN
        driver.findElement(By.id("com.android.systemui:id/pinEntry")).click();
        enterPin("2024"); // Replace with your PIN
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Start the app
        ((StartsActivity) driver).startActivity(new Activity("com.inevitable.controller", "com.inevitable.controller.MainActivity"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Navigate to GPIO settings
        driver.findElement(By.id("com.inevitable.controller:id/setting_button_gpio")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
        // Navigate to GPIO pins
        driver.findElement(By.id("com.inevitable.controller:id/gpio_pins")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Find all the dropdown items
        List<MobileElement> dropdownItems = driver.findElements(By.xpath("//android.widget.TextView"));

        // Display the list to the user
        System.out.println("Choose a GPIO pin to connect:");
        int displayedIndex = 1;
        for (int i = 0; i < dropdownItems.size(); i++) {
            String pinText = dropdownItems.get(i).getText();
            if (!pinText.equals("None")&&!pinText.equals("GPIO 17") && !pinText.equals("GPIO 58")) {
                System.out.println((displayedIndex) + ". " + pinText);
                displayedIndex++;
            }
        }

        // Ask the user to connect a pin
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose 0 To EXIT From The App!");
        System.out.print("Enter the number of the pin to connect: ");
        int selectedPinNumber = scanner.nextInt();

        // Map for mapping selected pin number to new pin number
        Map<Integer, Integer> pinNumberMapping = new HashMap<>();
        pinNumberMapping.put(1, 1);
        pinNumberMapping.put(2, 3);
        pinNumberMapping.put(3, 4);
        pinNumberMapping.put(4, 5);
        pinNumberMapping.put(5, 6);
        pinNumberMapping.put(6, 8);

        // Validate and map the user input
        if (pinNumberMapping.containsKey(selectedPinNumber)) {
            selectedPinNumber = pinNumberMapping.get(selectedPinNumber);
        } else if (selectedPinNumber == 0) {
         
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
            System.exit(0);
            
	        } else {
	            System.out.println("Invalid pin number. Please choose a valid pin number.");
	            scanner.close();
	            return; // Exit the program or return to the calling method
	        }

        // Click on the selected item
        MobileElement selectedPin = dropdownItems.get(selectedPinNumber);
        String pinText = selectedPin.getText();
        System.out.println("Selected Pin is:" + pinText);
        selectedPin.click();

	     // Handle specific actions based on the selected pin and return the toggled GPIO pin number
	     int toggledGPIOPin = 0; // Default value
	     switch (pinText) {
	     
         case "GPIO 16":
             System.out.println("Toggle GPIO to pin 35 and press Enter when done.");
             scanner.nextLine(); // Consume newline
             scanner.nextLine(); // Wait for user input (Enter key)
             toggledGPIOPin = 35;
             break;
             
         case "GPIO 31":
             System.out.println("Toggle GPIO to pin 7 and press Enter when done.");
             scanner.nextLine(); // Consume newline
             scanner.nextLine(); // Wait for user input (Enter key)
             toggledGPIOPin = 7;
             break;
             
         case "GPIO 55":
             System.out.println("Toggle GPIO to pin 11 and press Enter when done.");
             scanner.nextLine(); // Consume newline
             scanner.nextLine(); // Wait for user input (Enter key)
             toggledGPIOPin = 11;
             break;
             
         case "GPIO 56":
             System.out.println("Toggle GPIO to pin 13 and press Enter when done.");
             scanner.nextLine(); // Consume newline
             scanner.nextLine(); // Wait for user input (Enter key)
             toggledGPIOPin = 13;
             break;
         case "GPIO 57":
             System.out.println("Toggle GPIO to pin 29 and press Enter when done.");
             scanner.nextLine(); // Consume newline
             scanner.nextLine(); // Wait for user input (Enter key)
             toggledGPIOPin = 29;
             break;
             
         case "GPIO 86":
             System.out.println("Toggle GPIO to pin 37 and press Enter when done.");
             scanner.nextLine(); // Consume newline
             scanner.nextLine(); // Wait for user input (Enter key)
             toggledGPIOPin = 37;
             break;

         default:
             System.out.println("Pin connected successfully!");
	     }
	
	     // Output the toggled GPIO pin number
	     if (toggledGPIOPin != 0) {
	         System.out.println("Toggled GPIO pin number: " + toggledGPIOPin);
	     } else {
	         System.out.println("Pin connected successfully!");
	     }


        // Export GPIO pin
        driver.findElement(By.id("com.inevitable.controller:id/gpioexport_button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Navigate to GPIO directions
        driver.findElement(By.id("com.inevitable.controller:id/gpio_directions")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Navigate to OUT directions
        driver.findElement(By.xpath("//android.widget.TextView[@text='out']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
        // Navigate to GPIO values
        driver.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
        // Navigate to GPIO value 1
        driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Submit GPIO changes
        driver.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // For High Value
        // Ask the user a question
        System.out.println("Did you see the LED glowing? [Y/n]");

        // Read user input
        String userInput = scanner.nextLine();

        // Check the user's response
        if (userInput.equalsIgnoreCase("Y")) {
            System.out.println("Great! The LED is glowing.");
        } else if (userInput.equalsIgnoreCase("n")) {
            System.out.println("Please check your connection (physical pin mapping on the board) and press Enter when done.");
            scanner.nextLine(); // Wait for user input (Enter key)

            System.out.println("I am trying again.. Please wait!");
            // Navigate to GPIO pins
            driver.findElement(By.id("com.inevitable.controller:id/gpio_pins")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
            handleGPIOValues(selectedPinNumber);

            // Export GPIO pin
            driver.findElement(By.id("com.inevitable.controller:id/gpioexport_button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to GPIO directions
            driver.findElement(By.id("com.inevitable.controller:id/gpio_directions")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to OUT directions
            driver.findElement(By.xpath("//android.widget.TextView[@text='out']")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to GPIO values
            driver.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to GPIO value 1
            driver.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Submit GPIO changes
            driver.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Ask Again
            System.out.println("Did you see the LED glowing [Y/n]");

            // Read user input
            String userInputs = scanner.nextLine();

            // Check the user's response
            if (userInputs.equalsIgnoreCase("Y")) {
                System.out.println("Great! The LED is glowing.");
            } else if (userInputs.equalsIgnoreCase("n")) {
                System.out.println("It seems there is some critical issue. Exiting!");

                // Navigate back
                navigateBack();
                navigateBack();

                // Confirm action
                driver.findElement(By.id("android:id/button1")).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

                // Lock device
                ((AndroidDriver<MobileElement>) driver).lockDevice();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
                System.exit(0);
                
            } else {
                while (!userInputs.equalsIgnoreCase("Y") && !userInputs.equalsIgnoreCase("n")) {
                    System.out.println("Invalid input. Please enter 'Y' or 'n'.");
                    System.out.print("Enter your choice [Y/n]: ");
                    userInputs = scanner.nextLine();
                }
            }
        } else {
            while (!userInput.equalsIgnoreCase("Y") && !userInput.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter 'Y' or 'n'.");
                System.out.print("Enter your choice [Y/n]: ");
                userInput = scanner.nextLine();
            }
        }
        
        // Read GPIO pins
        driver.findElementByXPath("//android.widget.TextView[@text='Read']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Handling GPIO values based on the selected GPIO pin.
        driver.findElement(By.id("com.inevitable.controller:id/readpins_spinner")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Handle GPIO values based on the previously selected GPIO pin
        handleGPIOValues(selectedPinNumber);
        
        // Read Output
        driver.findElementByXPath("//android.widget.Button[@text='READ']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
        // For Low Value
        // Navigate to GPIO settings
        driver.findElementByXPath("//android.widget.TextView[@text='Write']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
        // Navigate to GPIO values
        driver.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
        // Navigate to GPIO value 0
        driver.findElement(By.xpath("//android.widget.TextView[@text='0']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000); 
        
        // Submit GPIO changes
        driver.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
        // Ask the user a question
        System.out.println("Did you see the LED glowing off? [Y/n]");
        
        // Read user input
        String userInput1 = scanner.nextLine();

        // Check the user's response
        if (userInput1.equalsIgnoreCase("Y")) {
            System.out.println("Great! The LED is glowing off.");
        } else if (userInput1.equalsIgnoreCase("n")) {
            System.out.println("Please check your connection (physical pin mapping on the board) and press Enter when done.");
            scanner.nextLine(); // Wait for user input (Enter key)

            System.out.println("I am trying again.. Please wait!");
            // Navigate to GPIO pins
            driver.findElement(By.id("com.inevitable.controller:id/gpio_pins")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
            handleGPIOValues(selectedPinNumber);

            // Export GPIO pin
            driver.findElement(By.id("com.inevitable.controller:id/gpioexport_button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to GPIO directions
            driver.findElement(By.id("com.inevitable.controller:id/gpio_directions")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to OUT directions
            driver.findElement(By.xpath("//android.widget.TextView[@text='out']")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to GPIO values
            driver.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Navigate to GPIO value 1
            driver.findElement(By.xpath("//android.widget.TextView[@text='0']")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Submit GPIO changes
            driver.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

            // Ask Again
            System.out.println("Did you see the LED glowing off? [Y/n]");

            // Read user input
            String userInputs = scanner.nextLine();

            // Check the user's response
            if (userInputs.equalsIgnoreCase("Y")) {
                System.out.println("Great! The LED is not glowing.");
            } else if (userInputs.equalsIgnoreCase("n")) {
                System.out.println("It seems there is some critical issue. Exiting!");

                // Navigate back
                navigateBack();
                navigateBack();

                // Confirm action
                driver.findElement(By.id("android:id/button1")).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

                // Lock device
                ((AndroidDriver<MobileElement>) driver).lockDevice();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
                System.exit(0);
                
            } else {
                while (!userInputs.equalsIgnoreCase("Y") && !userInputs.equalsIgnoreCase("n")) {
                    System.out.println("Invalid input. Please enter 'Y' or 'n'.");
                    System.out.print("Enter your choice [Y/n]: ");
                    userInputs = scanner.nextLine();
                }
            }
        } else {
            while (!userInput1.equalsIgnoreCase("Y") && !userInput1.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter 'Y' or 'n'.");
                System.out.print("Enter your choice [Y/n]: ");
                userInput1 = scanner.nextLine();
            }
        }
        
        // Read GPIO pins
        driver.findElementByXPath("//android.widget.TextView[@text='Read']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Handling GPIO values based on the selected GPIO pin.
        driver.findElement(By.id("com.inevitable.controller:id/readpins_spinner")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Handle GPIO values based on the previously selected GPIO pin
        handleGPIOValues(selectedPinNumber);
        
        // Read Output
        driver.findElementByXPath("//android.widget.Button[@text='READ']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
        
        // Navigate back
        navigateBack();
        navigateBack();

        // Confirm action
        driver.findElement(By.id("android:id/button1")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        // Lock device
        ((AndroidDriver<MobileElement>) driver).lockDevice();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

        System.out.println("--------> Controller GPIO Testing is Executed Successfully on ORCA <--------");
        
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
        for (char digit : pin.toCharArray()) {
            driver.findElement(By.id("com.android.systemui:id/key" + digit)).click();
        }
        driver.findElement(By.id("com.android.systemui:id/key_enter")).click();
    }

	private static void handleGPIOValues(int selectedPinNumber) {
	    // Find the menu item based on the previously selected GPIO pin text
	    MobileElement menuItem = driver.findElement(By.xpath("//android.widget.TextView[@index='" + selectedPinNumber + "']"));
	    // Get the selected pin number to a String and print it
	    List<MobileElement> dropdownItems = driver.findElements(By.xpath("//android.widget.TextView"));
	    String pinText = dropdownItems.get(selectedPinNumber).getText();
	    System.out.println("Selected Pin is: " + pinText);
	    toggleMenuItem(menuItem);
	}

	private static void toggleMenuItem(MobileElement menuItem) {
	    if (menuItem != null) {
	        if (!menuItem.getAttribute("checked").equals("true")) {
	            menuItem.click();
	            System.out.println("Toggled on.");
	        } else {
	            menuItem.click();
	            System.out.println("Toggled off.");
	        }
	    } else {
	        System.out.println("Menu item not found.");
	    }
	}

    @SuppressWarnings("rawtypes")
	private void navigateBack() throws InterruptedException {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
    }

    @AfterMethod
    public void Teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
