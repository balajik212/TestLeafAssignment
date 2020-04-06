package weekend1.assignments;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		//Enter Leaftaps URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Login to Leaftaps
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.clear();
		eleUserName.sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		//Click on CRM/SFA link	
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Click on Leads		
		driver.findElementByLinkText("Leads").click();
		
		//Click on Find Leads
		driver.findElementByLinkText("Find Leads").click();
		Thread.sleep(3000);
		
		//Switch to Phone tab
		driver.findElementByLinkText("Phone").click();
		
		//Enter phone number with area and country code		
		WebElement phoneCountryCode = driver.findElementByName("phoneCountryCode");
		phoneCountryCode.clear();
		phoneCountryCode.sendKeys("1" + Keys.TAB);
		
		driver.findElementByName("phoneAreaCode").sendKeys("1" + Keys.TAB);
		
		driver.findElementByName("phoneNumber").sendKeys("9123456789" + Keys.ENTER);
		Thread.sleep(2000);
		
		//Click on the first available result
		WebElement firstResult = driver.findElementByXPath("(//a[@class='linktext'])[4]");
		System.out.println(firstResult.getText());
		firstResult.click();
		Thread.sleep(2000);
	
		//Click on delete to delete the result
		driver.findElementByLinkText("Delete").click();
		
		
		//Searching again to confirm if the id is deleted
		driver.findElementByLinkText("Find Leads").click();
		
		Thread.sleep(2000);
		
		driver.findElementByLinkText("Phone").click();
		
		Thread.sleep(2000);
		
		WebElement phoneCountryCode2 = driver.findElementByName("phoneCountryCode");
		phoneCountryCode2.clear();
		phoneCountryCode2.sendKeys("1" + Keys.TAB);
		
		driver.findElementByName("phoneAreaCode").sendKeys("1" + Keys.TAB);
		
		driver.findElementByName("phoneNumber").sendKeys("9123456789" + Keys.ENTER);
		Thread.sleep(2000);
		
		//Get the No record to display text
		String noRecord = driver.findElementByClassName("x-paging-info").getText();
		
		//Print the result to confirm if the id was deleted successfully
		if(noRecord.contains("No records to display"))
		{
			System.out.println(noRecord);
		}
		else
		{
			System.out.println("Record not deleted");
		}
		
		//Close the browser without logout
		driver.close();	
		
		
	}

}
