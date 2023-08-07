package airportTDD.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents.SearchFlightAvailability;

public class OneWAY extends SearchFlightAvailability{
	WebDriver driver;
    By oneWay;
	public OneWAY(WebDriver driver,By oneWay) {
		super(driver);
		this.driver=driver;
		this.oneWay=oneWay;
	}

	@Override
	public void checkAvail() {
		System.out.println("I am in oneway");
	}
	
	public void selectOption() throws InterruptedException {
	if(!(driver.findElement(oneWay).isSelected())) {
	        Thread.sleep(3000);	
	    	driver.findElement(oneWay).click();
	    	}
}}
