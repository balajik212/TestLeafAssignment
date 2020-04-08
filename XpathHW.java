package week2.day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathHW {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://www.leafground.com/home.html");
		
		//Click on Image in the home page
		driver.findElementByXPath("//h5[text()='Image']").click();
		
		//Find the total no of image in the page
		List<WebElement> totalImages = driver.findElementsByTagName("img");
		System.out.println("Total no of Images - "+totalImages.size());
		Thread.sleep(2000);
		
		//Click on the last keyboard based on the title of it
		driver.findElementByXPath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img").click();
		System.out.println("Keyboard Image is clicked");
		
		
		//Click on the Radio button image in the home page
		driver.findElementByXPath("//h5[text()='Radio Button']").click();
		
		
		//Find total radio buttons in the page
		List<WebElement> totalRadioButton = driver.findElementsByXPath("//input[@type='radio']");
		System.out.println("Total no of Radio Button - "+totalRadioButton.size()); 
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		//Click on Checkbox	
		driver.findElementByXPath("//h5[text()='Checkbox']").click();
		Thread.sleep(3000);
		
		List<WebElement> radBut = driver.findElementsByXPath("//label[contains(text(),'Select all below checkboxes ')]//following-sibling::div//input[@type='checkbox']");
		for (int i = 0; i < radBut.size(); i++) {
			radBut.get(i).click();
		}
	}

}
