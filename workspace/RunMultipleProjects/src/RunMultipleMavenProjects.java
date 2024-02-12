import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

class Device {
    private String name;
    private String testngXmlPath;

    public Device(String name, String testngXmlPath) {
        this.name = name;
        this.testngXmlPath = testngXmlPath;
    }

    public String getName() {
        return name;
    }

    public String getTestngXmlPath() {
        return testngXmlPath;
    }
}

public class RunMultipleMavenProjects {

    @SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, InterruptedException {
        try {

            Process process = Runtime.getRuntime().exec("adb devices");

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder connectedDevices = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.endsWith("device")) {
                    String[] deviceInfo = line.split("\\s+");
                    String deviceId = deviceInfo[0];
                    String deviceName = deviceInfo[0];
                    connectedDevices.append(deviceId).append(" ");
                    
                    // Execute adb shell getprop ro.product.model command
                    Process Process1 = Runtime.getRuntime().exec("adb -s " + deviceName + " shell getprop ro.product.model");
                    BufferedReader Reader1 = new BufferedReader(new InputStreamReader(Process1.getInputStream()));
                    String modelName = Reader1.readLine();
                    Reader1.close();
                  
                }
            }
            reader.close();
            if (connectedDevices.length() > 0) {
                String[] devices = connectedDevices.toString().split("\\s+");
                for (String deviceId : devices) {
                    runTestNGWithMaven(deviceId);
                }
            } else {
            	System.out.println("No devices connected. Please Check your Connectivity!");
                System.exit(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runTestNGWithMaven(String deviceId) throws IOException, InterruptedException {
    	
        String projectPath = "/home/invlko-047/workspace/ORCA_board_Features_Automation";
        System.out.println("Welcome to Automation on Orca Device");
        Device device = new Device("" + deviceId, projectPath);
        System.out.println("Connected device: " + device.getName());
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", "mvn clean test");
        processBuilder.directory(new File(projectPath));
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("TestNG executed successfully for " + device.getName());
        } else {
            System.err.println("Error executing TestNG for Connected device:" + device.getName());
        }
    }
}
