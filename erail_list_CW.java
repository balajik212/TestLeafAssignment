package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class erail_list_CW {

	public static void main(String[] args) throws InterruptedException {
		
		//Get Chrome Options
		ChromeOptions options = new ChromeOptions();
				
		//Disable Notifications
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		//Implement Implicitly wait for 10 secs
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//Maximize window
		driver.manage().window().maximize();
		
		//Create a List to store all the train names
		List<String> trainList= new ArrayList<String>();
		
		//Navigate to Erail url
		driver.get("https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC");
		Thread.sleep(2000);
		
		//Uncheck SortByDate Checkbox
		driver.findElementById("chkSelectDateOnly").click();
		
		//Get the list of train names from the webtable by XPath
		List<WebElement> listOfTrain = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
		
		//Get each train name and store it to the list created
		for (WebElement eachTrain : listOfTrain) {
			String trainName = eachTrain.getText();
			System.out.println(trainName);
			trainList.add(trainName);
		}
		
		//Sort the train list
		Collections.sort(trainList);
		
		System.out.println("---------------------------------");
		System.out.println("LIST OF TRAIN NAMES AFTER SORTING");
		System.out.println("---------------------------------");
		
		
		//Print the list of train names after sorting from the list created
		for (int i = 0; i < trainList.size(); i++) {
			System.out.println(trainList.get(i));
			
		}
	}
	

}
