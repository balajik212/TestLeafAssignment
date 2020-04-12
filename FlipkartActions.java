package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartActions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Navigate to Leafground url
		driver.get("https://www.flipkart.com/");
		driver.findElementByXPath("//button[text()='✕']").click();
	
		Actions builder = new Actions(driver);
	
		WebElement hover = driver.findElementByXPath("//span[text()='TVs & Appliances']");
		builder.moveToElement(hover).perform();
		Thread.sleep(3000);
	
		driver.findElementByXPath("//li[text()='Top Brands'][1]/following-sibling::li[7]/a[text()='LG']").click();
		
		
	}

}
