package airportTDD.pageComponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.SearchFlightAvailability;

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
	
	public void selectOption() throws InterruptedException {
		Thread.sleep(3000);	
    	driver.findElement(roundTrip).click();
	}

}
