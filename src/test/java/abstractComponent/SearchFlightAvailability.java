package abstractComponent;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utils.TestContextSetup;

public abstract class SearchFlightAvailability {
	public abstract void checkAvail();
	public abstract void selectOption(TestContextSetup testContextSetup) throws InterruptedException;
	
	
	WebDriver driver;
	By multiCity,oneWay,roundTrip;
	public SearchFlightAvailability(WebDriver driver) {
	this.driver=driver;	
	PageFactory.initElements(driver, this);
	
	}

	WebElement ele1;


	@FindBy(name="ctl00_mainContent_ddl_originStation1_CTXT")
	WebElement departureDD;
	@FindBy(id="ctl00_mainContent_ddl_destinationStation1_CTXT")
	WebElement arrivalDD;
	@FindBy(id="ctl00_mainContent_view_date1")
	WebElement departDate;
	
	@FindBy(name="ctl00$mainContent$view_date2")
	WebElement returnDate;
	@FindBy(className="ui-datepicker-month")
	List<WebElement> monthYear;
	By dates=By.cssSelector("td[data-handler='selectDay']");

	@FindBy(id="divpaxinfo")
	WebElement passengers;
	@FindBy(id="hrefIncAdt")
	WebElement noOfAdults;
	@FindBy(id="hrefIncChd")
	WebElement noOfChilds;
	@FindBy(id="hrefIncInf")
	WebElement noOfInfants;
	@FindBy(id="ctl00_mainContent_DropDownListCurrency")
	WebElement currency;
	@FindBy(name="ctl00$mainContent$btn_FindFlights")
	WebElement search;
	
	@FindBy(css="a[data-event='click']")
	WebElement next;
	@FindBy(id="hlnkholidaypacks")
	WebElement holidayPack;

	
	

	public void selectCity(String departCity,String arrivalCity,TestContextSetup testContextSetup) throws InterruptedException {
//		By departureCity=By.cssSelector("a[value=departCity]");
//		By destinationCity=By.cssSelector("a[value=arrivalCity]");
		testContextSetup.genericUtils.highlightElement(departureDD);
		departureDD.click();
		
		departureDD.sendKeys(departCity);
		Thread.sleep(3000);
//		driver.findElement(departureCity).click();
		testContextSetup.genericUtils.highlightElement(arrivalDD);
		arrivalDD.clear();
		arrivalDD.sendKeys(arrivalCity);
		Thread.sleep(3000);
		
	}

	public void departureDate(TestContextSetup testContextSetup) throws InterruptedException {
	    Thread.sleep(3000);	
    testContextSetup.genericUtils.highlightElement(departDate);
	    departDate.click();
	   }
	

	public void returnDate(TestContextSetup testContextSetup) throws InterruptedException {
	    Thread.sleep(3000);
	    testContextSetup.genericUtils.highlightElement(returnDate);
		returnDate.click();
	   }

	public void selectJourneyDate(String month,int dateMonth,TestContextSetup testContextSetup) throws InterruptedException{
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
							testContextSetup.genericUtils.highlightElement(d);
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
						testContextSetup.genericUtils.highlightElement(d);
						d.click();
						break;
					}
					
				}
				
			}

			
		}
		


	public void selectPassenger(int adult,int child,int infant,TestContextSetup testContextSetup) throws InterruptedException {
		Thread.sleep(2000);
//		driver.findElement(passengers).click();;
		Actions a=new Actions(driver);
		a.moveToElement(passengers).click().build().perform();
		Thread.sleep(2000);
		for(int i=1;i<adult;i++) {
			testContextSetup.genericUtils.highlightElement(noOfAdults);
		noOfAdults.click();
	}
		for(int i=0;i<child;i++) {
			testContextSetup.genericUtils.highlightElement(noOfChilds);
			noOfChilds.click();
		}
		
		for(int i=0;i<infant;i++) {
			testContextSetup.genericUtils.highlightElement(noOfInfants);
			noOfInfants.click();
		}
	}

	public void selectPassenger(int adult,int child,TestContextSetup testContextSetup) throws InterruptedException {
		Thread.sleep(2000);
//		driver.findElement(passengers).click();;
		Actions a=new Actions(driver);
		a.moveToElement(passengers).click().build().perform();
		Thread.sleep(2000);
		for(int i=1;i<adult;i++) {
			testContextSetup.genericUtils.highlightElement(noOfAdults);
		noOfAdults.click();
	}
		for(int i=0;i<child;i++) {
			testContextSetup.genericUtils.highlightElement(noOfChilds);
			noOfChilds.click();
		}
		
		
	}

	public void selectCurrency(String curr,TestContextSetup testContextSetup) throws InterruptedException {
		testContextSetup.genericUtils.highlightElement(currency);
		currency.click();
		Select sel=new Select(currency);
		sel.selectByValue(curr);
		
	}

	public void search(TestContextSetup testContextSetup) throws InterruptedException {
		testContextSetup.genericUtils.highlightElement(search);
		search.click();
	}

	public String getErrorMesg() {
		String alertMesg =driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertMesg;
	}

	
	
}
