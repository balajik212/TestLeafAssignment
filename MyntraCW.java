package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MyntraCW {

	private static String text;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Navigate to Myntra url
		driver.get("https://www.myntra.com/");
		//driver.findElementByXPath("//button[text()='✕']").click();
	
		//Create builder class
		Actions builder = new Actions(driver);
	
		//Mouse over on 'Women' 
		WebElement hover = driver.findElementByXPath("//div[@class='desktop-navLink'][1]/a[text()='Women']");
		builder.moveToElement(hover).perform();
		Thread.sleep(2000);
	
		//Click on "Jackets & Coats"
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
		
		//Get the total number of results searched
		String totalSearchString = driver.findElementByXPath("//span[@class='title-count']").getText();
		
		totalSearchString = totalSearchString.replaceAll("\\D","");
	
		int totalSearchInt = Integer.parseInt(totalSearchString);
		System.out.println("Total Searched result for Women Jacket and Coats"+ " " +totalSearchInt);
		
		//Get the total number of results under Jackets
		String totalJacketString = driver.findElementByXPath("//input[@value='Jackets']/following-sibling::span").getText();
		
		totalJacketString = totalJacketString.replaceAll("\\D","");
	
		int totalJacketInt = Integer.parseInt(totalJacketString);
		System.out.println("Total Searched result for Women Jacket only"+ " " +totalJacketInt);
		
		//Get the total number of results under Coats
		String totalCoatsString = driver.findElementByXPath("//input[@value='Coats']/following-sibling::span").getText();
		
		totalCoatsString = totalCoatsString.replaceAll("\\D","");
	
		int totalCoatsInt = Integer.parseInt(totalCoatsString);
		System.out.println("Total Searched result for Women Coats only"+ " " +totalCoatsInt);
		
		
		//Compare the total result with the sum of Jacket and coats results
		if(totalSearchInt == (totalJacketInt+totalCoatsInt))
		{
			System.out.println("Total result Rs"+totalSearchInt+ " and sum of Jacket and coats Rs"+ (totalJacketInt+totalCoatsInt) +" results are matching");
		}
		else
		{
			System.out.println("Total result and sum of Jacket and coats results are not matching");
		}
		
		//Filter only Coats
		driver.findElementByXPath("//input[@value='Coats']/following-sibling::div").click();
		
		//Click on + more
		driver.findElementByXPath("//span[text()='Brand']/following-sibling::div[@class='brand-more']").click();
		
		//Enter Mango in search box
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("Mango");
		Thread.sleep(2000);
		
		//Click on the Mango Checkbox
		WebElement mangoCheckBox = driver.findElementByXPath("//div[@class='FilterDirectory-panel FilterDirectory-expanded']/div[2]/ul/li[2]/label/div");
		mangoCheckBox.click();
		
		//Close the window
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		Thread.sleep(3000);
		
		//Get all brands name which are filtered
		List<WebElement> allBrand = driver.findElementsByXPath("//ul[@class='results-base']/li/a/div[2]/h3");
		
		//Get individual results brand name and verify if it is MANGO
		for (WebElement eachBrand : allBrand) {
			text = eachBrand.getText();
			if(!text.contains("MANGO"))
			{
				System.out.println("Matching results are not returned-check the filter");
			}
	
		}
		System.out.println(" All filtered results are of the brand MANGO");
		
		//Select by Better Discount
		WebElement hover2 = driver.findElementByXPath("//div[text()='Sort by : ']");
		builder.moveToElement(hover2).perform();
		Thread.sleep(2000);
		
		
		
		driver.findElementByXPath("//label[text()='Better Discount']").click();
		
		
		String firstPrice = driver.findElementByXPath("//li[@class='product-base'][1]/a/div/following-sibling::div/div/span/span[1]").getText();
		System.out.println("Find the price of first displayed item"+ " " +firstPrice);
		
		
		WebElement hover3 = driver.findElementByXPath("//li[@class='product-base'][1]/a/div/following-sibling::div");
		builder.moveToElement(hover3).perform();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//li[@class='product-base'][1]/a/following-sibling::div[2]/span").click();
		
		driver.close();
		
	}

}
