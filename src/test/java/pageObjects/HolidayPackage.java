
package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import abstractComponent.SearchFlightAvailability;
import utils.TestContextSetup;


public class HolidayPackage extends SearchFlightAvailability{
	WebDriver driver;
	WebElement ele1;
	By holidayPack;
public HolidayPackage(WebDriver driver,By holidayPack) {
	super(driver);
	this.driver=driver;	
	this.holidayPack=holidayPack;

}

By destination=By.id("ctl00_mainContent_HolidayPackages_DropDownListPackage_CTXT");
By departureDD= By.id("ctl00_mainContent_HolidayPackages_DropDownListFrom_CTXT");
By returnDD= By.id("ctl00_mainContent_HolidayPackages_DropDownListTo_CTXT");
By departDate= By.cssSelector("div [class='home-date-div'] button[type='button']");
By monthYear=By.className("ui-datepicker-month");
By next=By.cssSelector("a[data-handler='next']");
By dates=By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td");
By search=By.id("btnFindHolidays");

public void clickOnHolidayPackage(TestContextSetup testContextSetup) throws InterruptedException {
	Thread.sleep(3000);
	testContextSetup.genericUtils.highlightElement(driver.findElement(holidayPack));
	driver.findElement(holidayPack).click();
}



public void selectDestination(String desti,TestContextSetup testContextSetup) throws InterruptedException {
	Thread.sleep(3000);
	 testContextSetup.genericUtils.highlightElement(driver.findElement(destination));
	driver.findElement(destination).sendKeys(desti);
}

public void selectDeparture(String departCity,String returnCity,TestContextSetup testContextSetup) throws InterruptedException {
	Thread.sleep(3000);
	 testContextSetup.genericUtils.highlightElement(driver.findElement(departureDD));
	driver.findElement(departureDD).click();
	Thread.sleep(2000);
	driver.findElement(departureDD).sendKeys(departCity);
	Thread.sleep(3000);
	 testContextSetup.genericUtils.highlightElement(driver.findElement(returnDD));
	driver.findElement(returnDD).click();
	Thread.sleep(2000);
	driver.findElement(returnDD).sendKeys(returnCity);
}


public void selectDepartDate(String month,int dateMonth,TestContextSetup testContextSetup) throws InterruptedException{
	testContextSetup.genericUtils.highlightElement(driver.findElement(departDate));
	driver.findElement(departDate).click();
	List<WebElement> ele=driver.findElements(monthYear);
	Iterator<WebElement> itr=ele.iterator();
	ele1=itr.next();

		if(!(ele1.getText().equalsIgnoreCase(month))){
			ele1=itr.next();
			if(!(ele1.getText().equalsIgnoreCase(month)))
			{
			driver.findElement(next).click();
		}
			
		
			else
			{
				WebElement monthCal=driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]"));
				testContextSetup.genericUtils.highlightElement(monthCal);
					List<WebElement> date=monthCal.findElements(dates);
				for(WebElement d:date) {
					if(d.getText().equalsIgnoreCase(Integer.toString(dateMonth))) {
						d.click();
						break;
					}
					
				}
				
			}

		}
		
		else
		{
			WebElement monthCal=driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]"));
			testContextSetup.genericUtils.highlightElement(monthCal);
			List<WebElement> date=monthCal.findElements(dates);
			for(WebElement d:date) {
				if(d.getText().equalsIgnoreCase(Integer.toString(dateMonth))) {
					d.click();
					break;
				}
				
			}
			
		}

		
	}
	

public void search(TestContextSetup testContextSetup) throws InterruptedException {
	testContextSetup.genericUtils.highlightElement(driver.findElement(search));
	driver.findElement(search).click();
	Thread.sleep(3000);
}



@Override
public void checkAvail() {
	// TODO Auto-generated method stub
	
}







@Override
public void selectOption(TestContextSetup testContextSetup) throws InterruptedException {
	// TODO Auto-generated method stub
	
}
}


