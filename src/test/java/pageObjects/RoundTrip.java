package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponent.SearchFlightAvailability;
import utils.TestContextSetup;



public class RoundTrip extends SearchFlightAvailability{
	WebDriver driver;
    By roundTrip;
	public RoundTrip(WebDriver driver, By roundTrip) {
		super(driver);
		this.driver=driver;
		this.roundTrip=roundTrip;
	}

	@Override
	public void checkAvail() {
		System.out.println("I am in roundtrip");
	}
	
	public void selectOption(TestContextSetup testContextSetup) throws InterruptedException {
		Thread.sleep(3000);	
		 testContextSetup.genericUtils.highlightElement(driver.findElement(roundTrip));
    	driver.findElement(roundTrip).click();
	}

}
