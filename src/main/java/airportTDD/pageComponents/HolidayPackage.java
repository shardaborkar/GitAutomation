package airportTDD.pageComponents;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.SearchFlightAvailability;

public class HolidayPackage {
WebDriver driver;
WebElement ele1;
By holidayPack;
public HolidayPackage(WebDriver driver,By holidayPack) {

this.driver=driver;	
PageFactory.initElements(driver, this);
this.holidayPack=holidayPack;

}


@FindBy(id="ctl00_mainContent_HolidayPackages_DropDownListPackage_CTXT")
WebElement destination;
@FindBy(id="ctl00_mainContent_HolidayPackages_DropDownListFrom_CTXT")
WebElement departureDD;
@FindBy(id="ctl00_mainContent_HolidayPackages_DropDownListTo_CTXT")
WebElement returnDD;
@FindBy(css="div [class='home-date-div'] button[type='button']")
WebElement departDate;
@FindBy(className="ui-datepicker-month")
List<WebElement> monthYear;
@FindBy(css="a[data-handler='next']")
WebElement next;
By dates=By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td");
@FindBy(id="btnFindHolidays")
WebElement search;

public void clickOnHolidayPackage() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(holidayPack).click();
	Thread.sleep(5000);
	
}

public void selectDestination(String desti) throws InterruptedException {
	Thread.sleep(3000);
	destination.click();
	Thread.sleep(2000);
	destination.sendKeys(desti);
}

public void selectDeparture(String departCity,String returnCity) throws InterruptedException {
	Thread.sleep(3000);
	departureDD.click();
	Thread.sleep(2000);
	departureDD.sendKeys(departCity);
	Thread.sleep(3000);
	returnDD.click();
	Thread.sleep(2000);
	returnDD.sendKeys(returnCity);
}


public void selectDepartDate(String month,int dateMonth){
	
	departDate.click();
	List<WebElement> ele=monthYear;
	Iterator<WebElement> itr=ele.iterator();
	ele1=itr.next();

		if(!(ele1.getText().equalsIgnoreCase(month))){
			ele1=itr.next();
			if(!(ele1.getText().equalsIgnoreCase(month)))
			{
			next.click();
		}
			
		
			else
			{
				WebElement monthCal=driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]"));
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
			List<WebElement> date=monthCal.findElements(dates);
			for(WebElement d:date) {
				if(d.getText().equalsIgnoreCase(Integer.toString(dateMonth))) {
					d.click();
					break;
				}
				
			}
			
		}

		
	}
	

public void search() {
	search.click();
}
}


