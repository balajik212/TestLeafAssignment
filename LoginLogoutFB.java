package week1.day2;

import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogoutFB {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElementById("email").sendKeys("balaji.212@gmail.com");
		
		driver.findElementById("pass").sendKeys("tuticorin.212");
		
		driver.findElementById("loginbutton").click();
		
		Thread.sleep(3000);
		
		driver.findElementById("userNavigationLabel").click();
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//span[text()='Log Out']").click();
	}

}
