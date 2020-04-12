package week2.day2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalNoOfLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Link.html");
		
		List<WebElement> link = driver.findElementsByTagName("a");
		int linkTotal = link.size();
		
		System.out.println(linkTotal);
		
		link.get(1).click();
		
		driver.navigate().back();
		
		
	
	}

}
