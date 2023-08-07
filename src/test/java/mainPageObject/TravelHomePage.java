package mainPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponent.SearchFlightAvailability;
import pageObjects.HolidayPackage;
import pageObjects.MultiTrip;
import pageObjects.OneWAY;
import pageObjects.RoundTrip;
import utils.TestContextSetup;




public class TravelHomePage {

	
	WebDriver driver;
	By bottomNavigation=By.id("traveller-home");
	By topNavigation=By.id("buttons");
	By holidayPack=By.id("hlnkholidaypacks");
	By multicityOption=By.id("ctl00_mainContent_rbtnl_Trip_2");
	By onewayOption=By.id("ctl00_mainContent_rbtnl_Trip_0");
	By roundtripOption=By.id("ctl00_mainContent_rbtnl_Trip_1");
    SearchFlightAvailability searchFlightAvail;
    
    
	
    public TravelHomePage(WebDriver driver) {
		this.driver=driver;
	}

	public HolidayPackage getHolidayPackage() {
		return new HolidayPackage(driver,holidayPack);
	}
	
	
	
	public MultiTrip multiTrip() {
		return new MultiTrip(driver,multicityOption);
	}
	
	public RoundTrip roundTrip() {
		return new RoundTrip(driver,roundtripOption);
	}
	
	public OneWAY oNEWay() {
		return new OneWAY(driver,onewayOption);
	}
	
	
	public void setBookingStrategy(SearchFlightAvailability searchFlightAvail)
	{
		this.searchFlightAvail=searchFlightAvail;
	}
	
	public void checkAvailability() {
		searchFlightAvail.checkAvail();
	}
	
	public void selectOption(TestContextSetup testContextSetup) throws InterruptedException {
		searchFlightAvail.selectOption(testContextSetup);
	}
	
	public void selectCity(String departureCity,String arrivalCity,TestContextSetup testContextSetup) throws InterruptedException {
		searchFlightAvail.selectCity(departureCity,arrivalCity,testContextSetup);
	}
	
	public void departureDate(TestContextSetup testContextSetup) throws InterruptedException {
		searchFlightAvail.departureDate(testContextSetup);
	}
	
	public void returnDate(TestContextSetup testContextSetup) throws InterruptedException {
		searchFlightAvail.returnDate(testContextSetup);;
	}
	
	
	public void journeyDate(String month, int dateMonth,TestContextSetup testContextSetup) throws InterruptedException {
		searchFlightAvail.selectJourneyDate(month, dateMonth,testContextSetup);
	}
	
	public void  selectPassenger(int adult, int child, int infant,TestContextSetup testContextSetup) throws InterruptedException {
		searchFlightAvail.selectPassenger(adult, child,infant,testContextSetup);
	}
	
	public void  selectPassenger(int adult, int child,TestContextSetup testContextSetup) throws InterruptedException {
		searchFlightAvail.selectPassenger(adult, child,testContextSetup);
	}
	
	public String  getErrorMesg() {
		return searchFlightAvail.getErrorMesg();
	}
	
	public void  selectCurrency(String curr,TestContextSetup testContextSetup) throws InterruptedException {
		
		searchFlightAvail.selectCurrency(curr,testContextSetup);
	}
	
	public void  search(TestContextSetup testContextSetup) throws InterruptedException {
		searchFlightAvail.search(testContextSetup);
	}
	
	
	

	

}
