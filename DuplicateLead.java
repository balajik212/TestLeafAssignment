package week1.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.clear();
		eleUserName.sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Leads").click();
		
		
		
		driver.findElementByLinkText("Find Leads").click();
		
		Thread.sleep(3000);
		
		driver.findElementByLinkText("Email").click();
		
		driver.findElementByName("emailAddress").sendKeys("babu@testleaf.com");
				
		driver.findElementByXPath("//table[@id='ext-gen242']").click();
		
		Thread.sleep(3000);
		
		String firstName = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]").getText();
		System.out.println(firstName);
		firstName.trim();
		
		
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();
		
		driver.findElementByLinkText("Duplicate Lead").click();
		
		 boolean contains = driver.getTitle().contains("Duplicate Lead");
		if(contains == true)
		{
			System.out.println("In duplicate title page");
		}
		else
		{
			System.out.println("Not In duplicate title page");
		}
		
		driver.findElementByClassName("smallSubmit").click();
		
		boolean containsCreateLeadPage = driver.getTitle().contains("View Lead");
		
		if(containsCreateLeadPage == true)
		{
			String dupFirstName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			dupFirstName.trim();
			System.out.println(dupFirstName);
			
			if(firstName.contains(dupFirstName))
			{
				System.out.println("Both names are same");
				
			}
			
			else {
				System.out.println("Not same");
			}
		}
		else
		{
			System.out.println("Not in Lead page");
		}
		
	}

}
