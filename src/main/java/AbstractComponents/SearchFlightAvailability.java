package AbstractComponents;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class SearchFlightAvailability {
	public abstract void checkAvail();
	public abstract void selectOption() throws InterruptedException;
	
	
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

	

	public void selectCity(String departCity,String arrivalCity) throws InterruptedException {
//		By departureCity=By.cssSelector("a[value=departCity]");
//		By destinationCity=By.cssSelector("a[value=arrivalCity]");
		departureDD.click();
		departureDD.sendKeys(departCity);
		Thread.sleep(3000);
//		driver.findElement(departureCity).click();
		arrivalDD.clear();
		arrivalDD.sendKeys(arrivalCity);
		Thread.sleep(3000);
		
	}

	public void departureDate() throws InterruptedException {
	    Thread.sleep(3000);	
	    departDate.click();
	   }
	

	public void returnDate() throws InterruptedException {
	    Thread.sleep(3000);
		returnDate.click();
	   }

	public void selectJourneyDate(String month,int dateMonth){
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
		


	public void selectPassenger(int adult,int child,int infant) throws InterruptedException {
		Thread.sleep(2000);
//		driver.findElement(passengers).click();;
		Actions a=new Actions(driver);
		a.moveToElement(passengers).click().build().perform();
		Thread.sleep(2000);
		for(int i=1;i<adult;i++) {
		noOfAdults.click();
	}
		for(int i=0;i<child;i++) {
			noOfChilds.click();
		}
		
		for(int i=0;i<infant;i++) {
			noOfInfants.click();
		}
	}

	public void selectPassenger(int adult,int child) throws InterruptedException {
		Thread.sleep(2000);
//		driver.findElement(passengers).click();;
		Actions a=new Actions(driver);
		a.moveToElement(passengers).click().build().perform();
		Thread.sleep(2000);
		for(int i=1;i<adult;i++) {
		noOfAdults.click();
	}
		for(int i=0;i<child;i++) {
			noOfChilds.click();
		}
		
		
	}

	public void selectCurrency(String curr) {
		currency.click();
		Select sel=new Select(currency);
		sel.selectByValue(curr);
		
	}

	public void search() {
		search.click();
	}

	public String getErrorMesg() {
		String alertMesg =driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return alertMesg;
	}

	
	
}
