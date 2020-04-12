package week1.day3;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafgroundEditPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Edit.html");
		
		driver.findElementById("email").sendKeys("Balaji");
		
		driver.findElementByXPath("//input[@value='Append ']").sendKeys("Edited",Keys.TAB);
		
		String attri = driver.findElementByName("username").getAttribute("Value");
		System.out.println(attri);
		
		driver.findElementByXPath("(//input[@name='username'])[2]").clear();
		
		boolean enabled = driver.findElementByXPath("//input[@disabled='true']").isEnabled();
		
		System.out.println(enabled);
		
				
	}

}
