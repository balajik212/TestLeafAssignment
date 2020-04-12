package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Navigate to Leafground url
		driver.get("http://www.leafground.com/pages/table.html");
		
		//Get the table and store it in a variable
		WebElement table = driver.findElementByXPath("//table[@id='table_id']");
		
		//Find Total Rows
		List<WebElement> totalRow = table.findElements(By.tagName("tr"));
		System.out.println("Total number of rows"+totalRow.size());
		
		//Find Total Columns
		List<WebElement> totalCol = table.findElements(By.tagName("td") );
		int colCount = totalCol.size();
		System.out.println("Total number of Columns"+ colCount);
		
		//Print 'Learn to interact with Elements' and its percentage
		WebElement secondRow = totalRow.get(2);
		List<WebElement> allCol = secondRow.findElements(By.tagName("td"));
		WebElement selLearningDetails = allCol.get(0);
		WebElement progressValue1 = allCol.get(1);
		System.out.println(selLearningDetails.getText()+ " " +progressValue1.getText());
		
		
		//Find the least percentage and checkbox
		int minValue = 100;
		
		for (int i = 1; i < totalRow.size(); i++) {
			
			WebElement row = totalRow.get(i);
			List<WebElement> allCol2 = row.findElements(By.tagName("td"));
			String percentage = allCol2.get(1).getText();
			
			percentage = percentage.replaceAll("[^a-zA-Z0-9]", " ");
			int j = Integer.parseInt(percentage.trim());
			
			
			if(j < minValue)
			{
				minValue = j;
			}
			
		}
		System.out.println(minValue);
		
		driver.findElementByXPath("//td[contains(text(),'"+minValue+"')]/following::input").click();
		
		
	}

}
