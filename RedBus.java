package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		//Navigate to Redbus site
		driver.get("https://www.redbus.in/");
	
		//Enter From city
		WebElement fromCity = driver.findElementById("src");
		fromCity.sendKeys("Chennai");
		Thread.sleep(2000);
		fromCity.sendKeys(Keys.TAB);
	
		//Enter To City
		WebElement toCity = driver.findElementById("dest");
		toCity.sendKeys("Bangalore");
		Thread.sleep(2000);
		toCity.sendKeys(Keys.TAB);
		
		//Selecting onward date
		driver.findElementByXPath("(//td[text()='30'])[2]").click();
		
		//Click on search button
		driver.findElementById("search_btn").click();
	
		//Select "After 6 pm" Departure Time filter
		driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[2]").click();
		System.out.println(" The results are filtered by Departure time 'After 6 pm' ");
		
		//Select "Sleeper" in Bus type
		driver.findElementByXPath("(//label[@for='bt_SLEEPER'])[2]").click();
		System.out.println(" The results are filtered by Bus type as 'Sleeper' ");
		
		//Sortby Seats Available
		driver.findElementByXPath("(//div[contains(@class,'w-15 fl')]//a)[2]").click();
		System.out.println(" The results are sorted by Seat availability");
		
	}

}
