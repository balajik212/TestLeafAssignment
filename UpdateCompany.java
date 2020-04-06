package weekend1.assignments;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateCompany {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		
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
		
		//Enter the first name
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Babu");
		
		//Search by the entered first name
		driver.findElementByXPath("//button[text()='Find Leads']").click();		
		Thread.sleep(3000);
		
		//Click on the first available result
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();
		
		//Get title of the page and print
		String title = driver.getTitle();
		System.out.println(title);
		
		//Click on Edit button
		driver.findElementByLinkText("Edit").click();
		
		//Update company name
		String newCompName = "Test company Updated";
		WebElement companyName = driver.findElementById("updateLeadForm_companyName");
		companyName.clear();
		companyName.sendKeys(newCompName);	
		
		//Click on submit
		driver.findElementByXPath("(//input[@name='submitButton'])[1]").click();
		
		//Get title page
		String updatedPageTitle = driver.getTitle();
		System.out.println(updatedPageTitle);
		
		//Get the updated company name
		String updatedCompName = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(updatedCompName);
		
		//Verify if the company name is updated correctly
		boolean contains = updatedCompName.contains(newCompName);
		
		if(contains == true)
		{
			System.out.println("Updated company name is reflected correctly");
		}
		else
		{
			System.out.println("Updated company name is not reflected correctly");
		}
		
	    //Close the browser without logout
		driver.close();
	}
}
