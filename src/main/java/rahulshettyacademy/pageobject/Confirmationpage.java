package rahulshettyacademy.pageobject;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;

import AbstractComponents.Reusable;
 
public class Confirmationpage extends Reusable {
	WebDriver driver;
	static int count=1;
	
	
	public Confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="label[class='ng-star-inserted']")
     WebElement orderId;
	
	By waitOrderId=By.cssSelector("label[class='ng-star-inserted']");
	
	public String getOrderID(String testCaseName) throws IOException, InvalidFormatException{
		
		waitForElement(waitOrderId);
		getScreenshot(testCaseName, driver,count);
		count++;
	//	copyScreenshotsIntoWord();
	 	 return (orderId.getText());
}
	
	
	
	

}
