package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponents.Reusable;

public class Checkout extends Reusable {
	WebDriver driver;
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
    WebElement selectCountryDD;
	
	By selectCountryBy=By.cssSelector("section[class*=group] button");
	@FindBy(css="section[class*=group] button")
    List<WebElement> selectCountry;
	
	@FindBy(css="a[class*='submit']")
    WebElement submitButton;

	public void checkoutOrder() throws InterruptedException {
//	 Thread.sleep(3000);
     selectCountryDD.sendKeys("ind");
     waitForElement(selectCountryBy);
     
     for(WebElement e:selectCountry) {
  	  if(e.getText().equalsIgnoreCase("india")) {
  		  e.click();
  		  break;
     }}
   JavascriptExecutor js=(JavascriptExecutor)driver;
   js.executeScript("window.scrollBy(0,100)");
   Thread.sleep(3000);
	}
	
	public Confirmationpage confirmOrder() {
   submitButton.click();
   return new Confirmationpage(driver);
}}
