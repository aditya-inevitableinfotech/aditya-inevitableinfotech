package selauto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import selauto.ActivityCls.DeviceInfo;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("unused")
public class ActivityCls {

	AndroidDriver<MobileElement> AD;
	Activity sett;

	@BeforeTest
	public void setup() throws MalformedURLException {
				
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
            AD = new AndroidDriver<MobileElement>(url, dc);
            AD.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

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
	
			@SuppressWarnings({ "rawtypes" })
			@Test(invocationCount = 1)
			public class TestClass {
			@SuppressWarnings("resource")
			public void main() throws InterruptedException {
			Scanner scanner = new Scanner(System.in);

		        while (true) {
		        	
		            System.out.println("-----Controller App MENU-----");
		            System.out.println("1. Launch GPIO");
		            System.out.println("2. Launch I2C");
		            System.out.println("3. Exit");
		            System.out.print("ENTER YOUR CHOICE: ");

		            int choice = scanner.nextInt();

		            switch (choice) {
		                
		            case 1:
		            	ControllerGPIOTesting();
		            break;
		            
		            
		            case 2:
		            	ControllerI2CTesting();
		            break;

		            	
		                case 3:
		                	
		                System.out.println("Exiting...");
		                System.exit(0);
		                    
		                break;

		                default:
		                	
		                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
		                    
		                break;
		            }

		            System.out.println();
		        }
		    }

			@SuppressWarnings("resource")
			private void ControllerGPIOTesting() throws InterruptedException {
				try
				{
					// TODO Auto-generated method stub
					System.out.println("Controller GPIO Testing is Started...");

			        // Unlock device
			        ((AndroidDriver<MobileElement>) AD).lockDevice();
			        ((AndroidDriver<MobileElement>) AD).unlockDevice();

			        // Swipe up
			        Swipeup();

			        // Enter PIN
			        AD.findElement(By.id("com.android.systemui:id/pinEntry")).click();
			        enterPin("2024"); // Replace with your PIN
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Start the app
			        ((StartsActivity) AD).startActivity(new Activity("com.inevitable.controller", "com.inevitable.controller.MainActivity"));
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Navigate to GPIO settings
			        AD.findElement(By.id("com.inevitable.controller:id/setting_button_gpio")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			        
			        // Navigate to GPIO pins
			        AD.findElement(By.id("com.inevitable.controller:id/gpio_pins")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Find all the dropdown items
			        List<MobileElement> dropdownItems = AD.findElements(By.xpath("//android.widget.TextView"));

			        // Display the list to the user
			        System.out.println("Choose a GPIO pin to connect:");
			        int displayedIndex = 1;
			        for (int i = 0; i < dropdownItems.size(); i++) {
			            String pinText = dropdownItems.get(i).getText();
			            if (!pinText.equals("None") && !pinText.equals("GPIO 17") && !pinText.equals("GPIO 58")) {
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
			            AD.findElement(By.id("android:id/button1")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Lock device
			            ((AndroidDriver<MobileElement>) AD).lockDevice();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
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
			        AD.findElement(By.id("com.inevitable.controller:id/gpioexport_button")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Navigate to GPIO directions
			        AD.findElement(By.id("com.inevitable.controller:id/gpio_directions")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Navigate to OUT directions
			        AD.findElement(By.xpath("//android.widget.TextView[@text='out']")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			        
			        // Navigate to GPIO values
			        AD.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			        
			        // Navigate to GPIO value 1
			        AD.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Submit GPIO changes
			        AD.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

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
			            AD.findElement(By.id("com.inevitable.controller:id/gpio_pins")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			            handleGPIOValues(selectedPinNumber);

			            // Export GPIO pin
			            AD.findElement(By.id("com.inevitable.controller:id/gpioexport_button")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Navigate to GPIO directions
			            AD.findElement(By.id("com.inevitable.controller:id/gpio_directions")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Navigate to OUT directions
			            AD.findElement(By.xpath("//android.widget.TextView[@text='out']")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Navigate to GPIO values
			            AD.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Navigate to GPIO value 1
			            AD.findElement(By.xpath("//android.widget.TextView[@text='1']")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Submit GPIO changes
			            AD.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

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
			                AD.findElement(By.id("android:id/button1")).click();
			                AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			                // Lock device
			                ((AndroidDriver<MobileElement>) AD).lockDevice();
			                AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
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
			        AD.findElementByXPath("//android.widget.TextView[@text='Read']").click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Handling GPIO values based on the selected GPIO pin.
			        AD.findElement(By.id("com.inevitable.controller:id/readpins_spinner")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Handle GPIO values based on the previously selected GPIO pin
			        handleGPIOValues(selectedPinNumber);
			        
			        // Read Output
			        AD.findElementByXPath("//android.widget.Button[@text='READ']").click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			        
			        // For Low Value
			        // Navigate to GPIO settings
			        AD.findElementByXPath("//android.widget.TextView[@text='Write']").click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			        
			        // Navigate to GPIO values
			        AD.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			        
			        // Navigate to GPIO value 0
			        AD.findElement(By.xpath("//android.widget.TextView[@text='0']")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000); 
			        
			        // Submit GPIO changes
			        AD.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			        
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
			            AD.findElement(By.id("com.inevitable.controller:id/gpio_pins")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			            handleGPIOValues(selectedPinNumber);

			            // Export GPIO pin
			            AD.findElement(By.id("com.inevitable.controller:id/gpioexport_button")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Navigate to GPIO directions
			            AD.findElement(By.id("com.inevitable.controller:id/gpio_directions")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Navigate to OUT directions
			            AD.findElement(By.xpath("//android.widget.TextView[@text='out']")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Navigate to GPIO values
			            AD.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Navigate to GPIO value 1
			            AD.findElement(By.xpath("//android.widget.TextView[@text='0']")).click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			            // Submit GPIO changes
			            AD.findElementByXPath("//android.widget.Button[@text='SUBMIT']").click();
			            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

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
			                AD.findElement(By.id("android:id/button1")).click();
			                AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			                // Lock device
			                ((AndroidDriver<MobileElement>) AD).lockDevice();
			                AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
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
			        AD.findElementByXPath("//android.widget.TextView[@text='Read']").click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Handling GPIO values based on the selected GPIO pin.
			        AD.findElement(By.id("com.inevitable.controller:id/readpins_spinner")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Handle GPIO values based on the previously selected GPIO pin
			        handleGPIOValues(selectedPinNumber);
			        
			        // Read Output
			        AD.findElementByXPath("//android.widget.Button[@text='READ']").click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			        
			        // Navigate back
			        navigateBack();
			        navigateBack();

			        // Confirm action
			        AD.findElement(By.id("android:id/button1")).click();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        // Lock device
			        ((AndroidDriver<MobileElement>) AD).lockDevice();
			        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

			        System.out.println("--------> Controller GPIO Testing is Executed Successfully on ORCA <--------");
				} catch (NoSuchElementException e) {
				    e.printStackTrace();
				}
		    }

		    private void Swipeup() throws InterruptedException {
				// TODO Auto-generated method stub
		    	TouchAction action = new TouchAction(AD);
		        org.openqa.selenium.Dimension size = AD.manage().window().getSize();
		        int width = size.width;
		        int height = size.height;
		        int middleOfX = width / 2;
		        int startYCoordinate = (int) (height * 0.80);
		        int endYCoordinate = (int) (height * 0.20);
		        action.press(PointOption.point(middleOfX, startYCoordinate))
		                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
		                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			}

		    private void handleGPIOValues(int selectedPinNumber) {
			    // Find the menu item based on the previously selected GPIO pin text
			    MobileElement menuItem = AD.findElement(By.xpath("//android.widget.TextView[@index='" + selectedPinNumber + "']"));
			    // Get the selected pin number to a String and print it
			    List<MobileElement> dropdownItems = AD.findElements(By.xpath("//android.widget.TextView"));
			    String pinText = dropdownItems.get(selectedPinNumber).getText();
			    System.out.println("Selected Pin is: " + pinText);
			    toggleMenuItem(menuItem);
			}

			private void toggleMenuItem(MobileElement menuItem) {
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

			private void enterPin(String pin) {
		        for (char digit : pin.toCharArray()) {
		            AD.findElement(By.id("com.android.systemui:id/key" + digit)).click();
		        }
		        AD.findElement(By.id("com.android.systemui:id/key_enter")).click();
		    }

		    private void handleGPIOValues() throws InterruptedException {
		        Random random = new Random();
		        List<MobileElement> dropdownItems3 = AD.findElements(By.xpath("//android.widget.TextView"));

		        // Randomly select an item
		        int randomIndex3 = random.nextInt(dropdownItems3.size());
		        dropdownItems3.get(randomIndex3).click();
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

		        // Check if the selected item is the second item
		        if (randomIndex3 == 1) {
		            // Execute code for the second item
		            
		            AD.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();

		            // Update the dropdownItems list after clicking on gpio_values
		            dropdownItems3 = AD.findElements(By.xpath("//android.widget.TextView"));

		            Random random1 = new Random();
		            int randomIndex4 = random1.nextInt(dropdownItems3.size());
		            dropdownItems3.get(randomIndex4).click();
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		        }
		    }

		    private void navigateBack() throws InterruptedException {
		        ((AndroidDriver) AD).pressKey(new KeyEvent(AndroidKey.BACK));
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		    }
			}

			private void ControllerI2CTesting() {
				// TODO Auto-generated method stub
				try {
					// Unlock device
		            ((AndroidDriver<MobileElement>) AD).lockDevice();
		            ((AndroidDriver<MobileElement>) AD).unlockDevice();

		            // Swipe up
		            Swipeup();

		            // Enter PIN
		            AD.findElement(By.id("com.android.systemui:id/pinEntry")).click();
		            enterPin("2024"); // Replace with your PIN
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

		            // Start the app
		            ((StartsActivity) AD).startActivity(new Activity("com.inevitable.controller", "com.inevitable.controller.MainActivity"));
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

		            // Navigate to I2C settings
		            AD.findElement(By.id("com.inevitable.controller:id/setting_button_i2c")).click();
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		            
		            // Navigate I2C Bus
		            AD.findElement(By.id("com.inevitable.controller:id/i2c_bus")).click();
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

		            // Export to I2C pins
		            List<MobileElement> dropdownItems = AD.findElements(By.xpath("//android.widget.TextView"));
		            Random rand = new Random();
		            int randomIndex = rand.nextInt(dropdownItems.size());
		            dropdownItems.get(randomIndex).click();

		            // Navigate Device Address
		            AD.findElement(By.id("com.inevitable.controller:id/device_address")).click();
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

		            // Handle GPIO values based on random selection
		            handleGPIOValues2();

		            // Input random string
		            inputRandomString();

		            // Navigate back
		            navigateBack();
		            navigateBack();
		            navigateBack();
		            
		            // Confirm action
		            AD.findElement(By.id("android:id/button1")).click();
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

		            // Lock device
		            ((AndroidDriver<MobileElement>) AD).lockDevice();
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

		        } catch (Exception exp) {
		            exp.printStackTrace();
		        }
		    }

			@SuppressWarnings("rawtypes")
			private void Swipeup() throws InterruptedException {
				// TODO Auto-generated method stub
				TouchAction action = new TouchAction(AD);
	            org.openqa.selenium.Dimension size = AD.manage().window().getSize();
	            int width = size.width;
	            int height = size.height;
	            int middleOfX = width / 2;
	            int startYCoordinate = (int) (height * 0.80);
	            int endYCoordinate = (int) (height * 0.20);
	            action.press(PointOption.point(middleOfX, startYCoordinate))
	                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                    .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
	            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			}

			private void enterPin(String pin) {
				// TODO Auto-generated method stub
				for (char digit : pin.toCharArray()) {
		            AD.findElement(By.id("com.android.systemui:id/key" + digit)).click();
		        }
		        AD.findElement(By.id("com.android.systemui:id/key_enter")).click();
			}

			private void handleGPIOValues2() throws InterruptedException {
		        // TODO: Implement GPIO handling logic
		    	Random random = new Random();
		        List<MobileElement> dropdownItems3 = AD.findElements(By.xpath("//android.widget.TextView"));

		        // Randomly select an item
		        int randomIndex3 = random.nextInt(dropdownItems3.size());
		        dropdownItems3.get(randomIndex3).click();
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);

		        // Check if the selected item is the second item
		        if (randomIndex3 == 1) {
		            // Execute code for the second item
		            
		            AD.findElement(By.id("com.inevitable.controller:id/gpio_values")).click();

		            // Update the dropdownItems list after clicking on gpio_values
		            dropdownItems3 = AD.findElements(By.xpath("//android.widget.TextView"));

		            Random random1 = new Random();
		            int randomIndex4 = random1.nextInt(dropdownItems3.size());
		            dropdownItems3.get(randomIndex4).click();
		            AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		        }
		    }

		    private void inputRandomString() throws InterruptedException {
		        String randomString = generateRandomString();
		        AD.findElement(By.id("com.inevitable.controller:id/input_string")).sendKeys(randomString);
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		        AD.findElement(By.xpath("//android.widget.Button[@text='SUBMIT']")).click();
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		        AD.findElement(By.xpath("//android.widget.FrameLayout[@content-desc='SCAN']")).click();
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		        scrollDown();
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(10000);
		        
		        System.out.println("--------> Controller I2C Testing is Executed Successfully on ORCA <--------");
		    }

		    @SuppressWarnings("rawtypes")
			private void scrollDown() throws InterruptedException {
				// TODO Auto-generated method stub
		    	TouchAction action = new TouchAction(AD);
		        org.openqa.selenium.Dimension size = AD.manage().window().getSize();
		        int width = size.width;
		        int height = size.height;
		        int middleOfX = width / 2;
		        int startYCoordinate = (int) (height * 0.20);
		        int endYCoordinate = (int) (height * 0.80);
		        action.press(PointOption.point(middleOfX, startYCoordinate))
		                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
		                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
		        AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
			}

			private String generateRandomString() {
		        // Define the characters that can be part of the random string
		        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890+\\{}[]-!@#$%^&*()~`;:'.,?/|";

		        // Set the length of the random string
		        int length = 15;

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
		           ((AndroidDriver) AD).pressKey(new KeyEvent(AndroidKey.BACK));
		           AD.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);Thread.sleep(2000);
		       }
		
		
		@AfterTest
		private void Teardown() {
			if (AD != null) 
			{
	            AD.quit();
			}
		}		
	}
