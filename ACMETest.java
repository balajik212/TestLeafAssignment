package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ACMETest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		//Navigate to ACME URL
		driver.get("https://acme-test.uipath.com/account/login");
		
		//Enter Email
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com");
		
		//Enter password
		driver.findElementById("password").sendKeys("leaf@12");
		
		//click on Login button
		driver.findElementById("buttonLogin").click();
		
		//Mouseover vendor button

		WebElement vendorButton = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder= new Actions(driver);
		builder.moveToElement(vendorButton).perform();
		
		//Click on Search for vendor
		driver.findElementByLinkText("Search for Vendor").click();
		
		//Enter Vendor Name "Blue Lagoon"
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		
		//Click on Search vendor
		driver.findElementById("buttonSearch").click();
		
		//Get Country name of the BlueLagoon vendor
		String countryName = driver.findElementByXPath("(//table[@class='table']//td)[5]").getText();
		System.out.println(countryName);
		
		//Logout of the application
		driver.findElementByLinkText("Log Out").click();
		System.out.println("Logged out successfuly");
		
		//Close the browser
		driver.close();
	}

}
