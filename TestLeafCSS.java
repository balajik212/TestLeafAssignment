package week1.day4;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestLeafCSS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		String bgColor = driver.findElementByTagName("h2").getCssValue("background-color");
		System.out.println(bgColor);
		
		String fontSize = driver.findElementByXPath("//label[@for='username']").getCssValue("font-size");
		System.out.println(fontSize);
		
		int width = driver.findElementByClassName("decorativeSubmit").getSize().getWidth();
		System.out.println(width);
		
		int x = driver.findElementById("username").getLocation().getX();
	
		System.out.println(x);
		
		int y = driver.findElementById("username").getLocation().getY();
		System.out.println(y);
	}


}
