package week3.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Navigate to Leaftaps URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Login to leaftaps using credentials
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.clear();
		eleUserName.sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click on the CRM/SFA button		
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Click Lead tab
		driver.findElementByLinkText("Leads").click();
		
		//Click on Merge leads			
		driver.findElementByLinkText("Merge Leads").click();
		Thread.sleep(3000);
		
		//Select From lead button
		driver.findElementByXPath("(//a)[37]").click();
		
		//Switch to new tab
		Set<String> windowSet1 = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowSet1);
		driver.switchTo().window(windowList.get(1));
		
		//Enter first name 
		driver.findElementByName("firstName").sendKeys("Balaji");
		
		//Click on Find leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		//Get the first result
		WebElement result1 = driver.findElementByXPath("(//tr)[4]/td[1]/div/a");
		String result1Id = result1.getText();
		System.out.println("First result1 id is "+ result1Id );
		result1.click();
		
		//switch to 1st window
		driver.switchTo().window(windowList.get(0));
		
		//Select To lead button
		driver.findElementByXPath("(//a)[38]").click();
				
		//Switch to new tab
		Set<String> windowSet2 = driver.getWindowHandles();
		List<String> windowList2 = new ArrayList<String>(windowSet2);
		driver.switchTo().window(windowList2.get(1));
				
		//Enter first name 
		driver.findElementByName("firstName").sendKeys("Balaji");
				
		//Click on Find leads
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
				
		//Get the first result
		WebElement result2 = driver.findElementByXPath("(//tr)[6]/td[1]/div/a");
		String result2Id = result2.getText();
		System.out.println("First result2 id is "+ result2Id );
		result2.click();
		
		//Switch to 1st Window
		driver.switchTo().window(windowList2.get(0));
		
		//Click on Merge lead button
		driver.findElementByClassName("buttonDangerous").click();
		
		//Switch to alerts window
		driver.switchTo().alert().accept();
		
		//Get title
		String title = driver.getTitle();
		System.out.println(title);
		
		//Get company name
		String mergedCompanyName = driver.findElementById("viewLead_companyName_sp").getText();
		
		if(mergedCompanyName.contains(result2Id))
		{
			System.out.println("From Lead is mereged to To Lead correctly");
		}
		else
		{
			System.out.println("From Lead is not mereged to To Lead correctly");
		}
		
		//Click on Find leads
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		//Enter the first lead id
		driver.findElementByXPath("//input[@name='id']").sendKeys(result1Id);
		
		//Click on Find Lead button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(3000);
		
		//Get the error message
		String errorMessage = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
		
		if(errorMessage.contains("No records"))
		{
			System.out.println("Correct");
		}
		else
		{
			System.out.println("Not correct");
		}
		
		//Close all windows
		driver.quit();
		
		
	}

}
