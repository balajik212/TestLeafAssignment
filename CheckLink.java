package week1.day4;

import org.openqa.selenium.chrome.ChromeDriver;

public class CheckLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Link.html");
		
		String link = driver.findElementByPartialLinkText("Find").getAttribute("href");
		
		System.out.println(link);
		
		driver.findElementByPartialLinkText("broken").click();
		String title = driver.getTitle();
				
		if(title.contains("404"))
		{
			System.out.println("Link Broken");
		}
		else
		{
			System.out.println("LInk not broken");
		}
	}

}
