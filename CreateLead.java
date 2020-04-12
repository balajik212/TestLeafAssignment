package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		WebElement eleUserName = driver.findElementById("username");
		eleUserName.clear();
		eleUserName.sendKeys("DemoSalesManager");
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		
		driver.findElementByLinkText("Create Lead").click();
		
		//Select Dropdown
		WebElement dropdown1 = driver.findElementById("createLeadForm_dataSourceId");
		
		Select dd1 = new Select(dropdown1);
		
		//Select dropdown by Text
		dd1.selectByVisibleText("Employee");
		
		//Selecting second dropdown
		WebElement dropdown2 = driver.findElementById("createLeadForm_industryEnumId");
		
		Select dd2 = new Select(dropdown2);
		
		List<WebElement> options = dd2.getOptions();
		int count = options.size();
		
		dd2.selectByIndex(count-1);
		
	
	}

}
