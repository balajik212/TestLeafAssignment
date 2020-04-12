package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsCW {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Navigate to Leafground url
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		WebElement item7 = driver.findElementByXPath("//ol[@id='selectable']/li[last()]");
		WebElement item6 = driver.findElementByXPath("//ol[@id='selectable']/li[last()-1]");
		WebElement item5 = driver.findElementByXPath("//ol[@id='selectable']/li[last()-2]");
		WebElement item4 = driver.findElementByXPath("//ol[@id='selectable']/li[last()-3]");
		
		Actions builder = new Actions(driver);
	
		builder.keyDown(Keys.COMMAND).click(item4).click(item5).click(item6).click(item7).perform();
		
	}

}
