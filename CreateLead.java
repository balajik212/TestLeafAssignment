package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.clear();
		eleUserName.sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys("Test");
		
		driver.findElementById("createLeadForm_firstName").sendKeys("First");
		
		driver.findElementById("createLeadForm_lastName").sendKeys("Last");
		
		driver.findElementByClassName("smallSubmit").click();		
		
		String title = driver.getTitle();
		
		if(title.equalsIgnoreCase("View Lead"))
		{
			System.out.println("Lead created");
		}
		
		
		//driver.close();
		
		
	}

}
