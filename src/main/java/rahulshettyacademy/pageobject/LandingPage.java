package rahulshettyacademy.pageobject;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;

import AbstractComponents.Reusable;

public class LandingPage extends Reusable {
	WebDriver driver;
	static int count=1;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
     WebElement userid;
	@FindBy(id="userPassword")
    WebElement password;
	@FindBy(id="login")
    WebElement submit;
	@FindBy(css="div[aria-live=polite]")
    WebElement errorMesg;
	
	By errorBy=By.cssSelector("div[aria-live=polite]");
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	public ProductCatalogue login(String uname,String pname) throws IOException, InvalidFormatException {
		userid.sendKeys(uname);
		password.sendKeys(pname);
		
		
		submit.click();
		return new ProductCatalogue(driver);
		
		}
	
	public String getErrorMesg() throws InvalidFormatException, IOException {
		waitForElement(errorBy);
		getScreenshot("getErrorMesg",driver,count);
		//copyScreenshotsIntoWord();
		count++;
		return errorMesg.getText();
	}
}
