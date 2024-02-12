package Dhanvriksha;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dhanvriksha_Web_Portal_Automation  {
	
	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	
	public static void setup() throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver", "/home/invlko-047/Downloads/chromedriver/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.MINUTES);
			
			System.out.println("--------> Dhanvriksha_Web_Automation Test Started Successfully on Chrome Browser <--------");

		 	driver.get("http://122.166.188.93:3001/login");
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("aditya@inevitableinfotech.com");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(decodeString("R1lmdXhR"));
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"mui-1\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/button")).click();
	        Thread.sleep(10000);
	        
	        System.out.println("--->Successfully login to Danvriksha<---");
	        
	
	}   
	        static String decodeString(String password) {
	        {
	         byte[] decodedString = Base64.decodeBase64(password);
	         return(new String(decodedString));
	        }
	        }

	    	@SuppressWarnings("unused")
			@Test
			public void DhanvrikshaAutomation()throws InterruptedException
			{
	        
			System.out.println("--->Dashboard Testing 1st Test Case KYC Approval Request<---");
	        
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[1]/div/div/ul/div[1]/div")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[1]")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[1]/div/div/ul/div[2]/div")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[1]")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[1]/div/div/ul/div[3]/div")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[1]")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[1]/div/div/ul/div[4]/div")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[1]")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[1]/div/div/ul/div[5]/div")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[1]")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[1]/div/div/ul/div[6]/div")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(10000);       
	        
	        System.out.println("--->Dashboard Testing 2nd Test Case Application Approval Request<---");
	        
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[1]")).click();
	        Thread.sleep(5000);
	        JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("window.scrollBy(0,400)");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[2]/div/div/ul/div[1]/div")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[1]/div[2]")).click();
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[2]/div/div/ul/div[2]/div")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("--->Dashboard Testing 3rd Test Case Loan Disbursement Bucket<---");
	        
	        Thread.sleep(5000);        
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[1]/div[2]")).click();
	        Thread.sleep(10000);
	        WebElement flag=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[1]/div/div/ul/div[14]/div/div/span"));
	        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
	        jse1.executeScript("arguments[0].scrollIntoView();",flag);
	        Thread.sleep(10000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[3]/div[3]/div/div/ul/div/div/div/span")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Branch Testing Started <---");
	        
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[2]/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[1]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/a")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"branchName\"]")).sendKeys("Ayodhya");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"mui-26\"]")).sendKeys("Jai Shri Ram");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[3]/div/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"mui-28\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/button")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Area Testing Started <---");
	        
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[3]/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[2]")).click();
	        Thread.sleep(5000);          
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[1]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/a")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@id='areaName']")).sendKeys("Ayodhya");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-select-currency\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-branch\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-32\"]")).sendKeys("Jai Shree Ram");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/form/div/div[4]/div/div[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-34\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Employees Testing Started <---");
	        
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[4]/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/a")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-required\"]")).sendKeys("Aditya");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-37\"]")).sendKeys("aditya@inevitableinfotech.com");
	        Thread.sleep(2000); 
	        String typedText = driver.findElement(By.xpath("//*[@id=\"mui-39\"]")).getAttribute("Dhanvriskha Admin(DNEMP001)");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-39\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-39\"]")).sendKeys("Dhanvriskha Admin(DNEMP001)");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"mui-39\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]/*[1]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/input[1]")).sendKeys("9140768763");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-select-currency\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-roles\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-branch\"]/div[3]/ul/li[7]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-status\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-40\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[2]")).click();
	        Thread.sleep(5000); 
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[1]")).click();
	        Thread.sleep(5000); 
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Loans Testing Started <---");
	        
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[5]/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/a")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/form/div/div/div/div[1]/div/div/div/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[2]/div/div[3]/div[2]/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"newMember\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-newMember\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-57\"]")).sendKeys("Muskan(DNEMP003)");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-57\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc1Num\"]")).sendKeys("297328545501");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"applicantName\"]")).sendKeys("9648349567");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"center\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-branch\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-area\"]/div[3]/ul/li")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"father\"]")).sendKeys("H.S.Mishra");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"familyAnnualIncome\"]")).sendKeys("500000");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"menu-kyc2\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);   
	        driver.findElement(By.xpath("//*[@id=\"mui-55\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-55\"]")).sendKeys("17/11/1998");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"pendingmfic\"]")).sendKeys("None");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2Num\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2Num\"]")).sendKeys("ANMRM0011223");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"MaritalStatus\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-MaritalStatus\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"pendingmficAmount\"]")).sendKeys("200000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-required\"]")).sendKeys("9140768763");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"resident\"]")).sendKeys("Sahabganj,Ayodhya");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"loanPurpose\"]")).sendKeys("Farming");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"loanAmount\"]")).sendKeys("500000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"totalInterestAmount\"]")).sendKeys("10000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"tenure\"]")).sendKeys("52");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-53\"]")).click();
	        Thread.sleep(2000); 
	        driver.findElement(By.xpath("//*[@id=\"mui-52\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[1]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Fixed Deposit Testing Started <---");
	        
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[6]/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/a")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/form/div/div/div/div[1]/div/div/div/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[2]/div/div[3]/div[2]/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"newMember\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-newMember\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-73\"]")).sendKeys("Muskan(DNEMP003)");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-73\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc1Num\"]")).sendKeys("297328545501");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"applicantName\"]")).sendKeys("9648349567");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-select-currency\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-branch\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-area\"]/div[3]/ul/li")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"father\"]")).sendKeys("H.S.Mishra");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"familyAnnualIncome\"]")).sendKeys("500000");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"menu-kyc2\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);   
	        driver.findElement(By.xpath("//*[@id=\"mui-71\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-71\"]")).sendKeys("17/11/1998");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"pendingmfic\"]")).sendKeys("None");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2Num\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2Num\"]")).sendKeys("ANMRM0011223");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"MaritalStatus\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-MaritalStatus\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"pendingmficAmount\"]")).sendKeys("200000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-required\"]")).sendKeys("9140768763");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"resident\"]")).sendKeys("Sahabganj,Ayodhya");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"FD Amount\"]")).sendKeys("500000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"tenure\"]")).sendKeys("8");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"yearlyInterestRate\"]")).sendKeys("10%");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-69\"]")).click();
	        Thread.sleep(2000); 
	        driver.findElement(By.xpath("//*[@id=\"mui-68\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[1]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Recurring Deposit Testing Started <---");
	        
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[7]/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/a")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div/form/div/div/div/div[1]/div/div/div/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[2]/div/div[3]/div[2]/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"newMember\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-newMember\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-89\"]")).sendKeys("Muskan(DNEMP003)");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-89\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc1Num\"]")).sendKeys("297328545501");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"applicantName\"]")).sendKeys("9648349567");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-select-currency\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-branch\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[10]/div[1]/div[1]/div[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-area\"]/div[3]/ul/li")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"father\"]")).sendKeys("H.S.Mishra");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"familyAnnualIncome\"]")).sendKeys("500000");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"menu-kyc2\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);   
	        driver.findElement(By.xpath("//*[@id=\"mui-87\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-87\"]")).sendKeys("17/11/1998");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"pendingmfic\"]")).sendKeys("None");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2Num\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2Num\"]")).sendKeys("ANMRM0011223");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"MaritalStatus\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-MaritalStatus\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"pendingmficAmount\"]")).sendKeys("200000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-required\"]")).sendKeys("9140768763");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"resident\"]")).sendKeys("Sahabganj,Ayodhya");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"RD Amount\"]")).sendKeys("500000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"rdTenure\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-rdTenure\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"dailyTenure\"]")).sendKeys("2000");
	        Thread.sleep(2000); 
	        driver.findElement(By.xpath("//*[@id=\"yearlyInterestRate\"]")).sendKeys("10%");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"mui-85\"]")).click();
	        Thread.sleep(2000); 
	        driver.findElement(By.xpath("//*[@id=\"mui-84\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[1]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Members Testing Started <---");
	        
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[8]/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/a")).click();
	        Thread.sleep(2000);
	       // driver.findElement(By.xpath("//*[@id="mui-102"]")).sendKeys("Muskan(DNEMP003)");
	        Thread.sleep(2000);
	      //  driver.findElement(By.xpath("//*[@id="mui-102"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc1Num\"]")).sendKeys("297328545501");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"applicantName\"]")).sendKeys("9648349567");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-select-currency\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-branch\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"center\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-area\"]/div[3]/ul/li")).click();
	        Thread.sleep(2000);        
	        driver.findElement(By.xpath("//*[@id=\"father\"]")).sendKeys("H.S.Mishra");
	        Thread.sleep(2000);  
	        driver.findElement(By.xpath("//*[@id=\"mui-100\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-100\"]")).sendKeys("17/11/1998");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"pendingmfic\"]")).sendKeys("None");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2Num\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"kyc2Num\"]")).sendKeys("ANMRM0011223");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[14]/div[1]/div[1]/div[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-MaritalStatus\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"pendingmficAmount\"]")).sendKeys("200000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-required\"]")).sendKeys("9140768763");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"resident\"]")).sendKeys("Sahabganj,Ayodhya");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-99\"]")).click();
	        Thread.sleep(2000); 
	        driver.findElement(By.xpath("//*[@id=\"mui-98\"]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[3]/div/div[3]/button[1]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Collection Entry Testing Started <---");
	        
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[9]/div[2]")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"mui-106\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-106\"]")).sendKeys("R362190001");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"paymentMethod\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-paymentMethod\"]/div[3]/ul/li[1]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"collectionAmount\"]")).sendKeys("10000");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"form1\"]/div/div[2]/div/div/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Collection Sheet Testing Started <---");
	        
	        Thread.sleep(5000);
	        JavascriptExecutor executor = (JavascriptExecutor)driver;
	        executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[10]/div[2]")));
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"branch\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-branch\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"center\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-area\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"outlined-select-currency\"]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"menu-serviceType\"]/div[3]/ul/li[2]")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-112\"]")).sendKeys("14/11/2022");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/form/div/div/div[1]/div/div[5]/button")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/button")).click();
	        Thread.sleep(5000);
	        
	        System.out.println("---> Reports Testing Started <---");
	        
	        Thread.sleep(5000);
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/a[11]/div[2]"))).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//*[@id=\"mui-115\"]")).sendKeys("17/11/2022");
	        Thread.sleep(2000);
	        
	        System.out.println("---> LogOut Testing Started <---");

	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[2]/button/div/img")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/li")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/div[2]/button")).click();
	        Thread.sleep(2000);
	        
			System.out.println("--------> Dhanvriksha_Web_Automation Test Executed Successfully on Chrome Browser <--------");
		    		
			}
	
	@AfterTest
	public void Teardown() {
		if (driver != null) {
			driver.quit();
        }
    }

}
