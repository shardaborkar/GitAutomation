package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import abstractComponent.SearchFlightAvailability;
import utils.TestContextSetup;




public class MultiTrip extends SearchFlightAvailability {
    WebDriver driver;
    By multiCity;
    By popUp=By.id("MultiCityModelAlert");
	
	public MultiTrip(WebDriver driver, By multiCity) {
		super(driver);
		this.driver=driver;
		this.multiCity=multiCity;
		
	}

	@Override
	public void checkAvail() {
		System.out.println("I am in multitrip");
	}
	public void selectOption(TestContextSetup testContextSetup) throws InterruptedException {
	   
	    Thread.sleep(3000);	
	    testContextSetup.genericUtils.highlightElement(driver.findElement(multiCity));
		driver.findElement(multiCity).click();
		 testContextSetup.genericUtils.highlightElement(driver.findElement(popUp));
		driver.findElement(popUp).click();
	}

	
	

	    
	    
	   
	}
	
