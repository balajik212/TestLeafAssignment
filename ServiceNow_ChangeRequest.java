package week4.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServiceNow_ChangeRequest {

	public static void main(String[] args) throws InterruptedException {
		
		//Get Chrome Options
		ChromeOptions options = new ChromeOptions();
				
		//Disable Notifications
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		//Create driver object
		ChromeDriver driver = new ChromeDriver(options);
		
		//Create wait object to wait for 30 seconds on the expected condition
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//Implement Implicitly wait for 30 secs
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		//Maximize window
		driver.manage().window().maximize();
				
		//Navigate to ServiceNow url
		driver.get("https://dev93146.service-now.com/");
		
		//Switch to Login frame
		driver.switchTo().frame(0);
		
		//Login to service now using credentials
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("Chennai@1");
		driver.findElementById("sysverb_login").click();
		
		//Enter text in the Filter Navigation
		driver.findElementByXPath("//input[@id='filter']").sendKeys("Change");
		Thread.sleep(3000);

		//Click on the Create New in the left menu
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sn-widget-list-content']/div[text()='Create New'])[3]"))).click();
		
		//Switch to frame
		driver.switchTo().frame("gsft_main");
		
		Thread.sleep(3000);
		
		//Click on Normal CR			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Normal: Changes without predefined plans require approval and/or CAB authorization."))).click();;
		
		//Fetch Change request number
		String chNumber = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println(chNumber);
				
		//Enter short desc
		driver.findElementById("change_request.short_description").sendKeys("Creating CR");
		
		//Click on Submit
		driver.findElementByXPath("(//button[text()='Submit'])[1]").click();
	
		
		//Enter incident number and search
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form-control'])[1]"))).sendKeys(chNumber + Keys.ENTER);
		String chNumber2 = driver.findElementByXPath("//table[@id='change_request_table']/tbody/tr/td[3]/a").getAttribute("aria-label");
		String[] split = chNumber2.split(" ");
		
		//Check if the fetched CR number and created CR are same
		if(chNumber.equals(split[2])) {
		System.out.println("CR Number is correct");
		}
		else
		{
		System.out.println("CR Number is not correct");
		}

	}	

}
