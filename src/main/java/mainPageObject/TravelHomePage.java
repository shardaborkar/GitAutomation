package mainPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import AbstractComponents.SearchFlightAvailability;
import airportTDD.pageComponents.BottomSection;
import airportTDD.pageComponents.HolidayPackage;
import airportTDD.pageComponents.MultiTrip;
import airportTDD.pageComponents.OneWAY;
import airportTDD.pageComponents.RoundTrip;

import airportTDD.pageComponents.TopSection;

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

	public TopSection topSection() {
		return new TopSection(driver,topNavigation);
	}
	
	public BottomSection bottomSection() {
		return new BottomSection(driver,bottomNavigation);
	}
    
	public HolidayPackage holidayPackage() {
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
	
	public void selectOption() throws InterruptedException {
		searchFlightAvail.selectOption();
	}
	
	public void selectCity(String departureCity,String arrivalCity) throws InterruptedException {
		searchFlightAvail.selectCity(departureCity,arrivalCity);
	}
	
	public void departureDate() throws InterruptedException {
		searchFlightAvail.departureDate();
	}
	
	public void returnDate() throws InterruptedException {
		searchFlightAvail.returnDate();;
	}
	
	
	public void journeyDate(String month, int dateMonth) {
		searchFlightAvail.selectJourneyDate(month, dateMonth);
	}
	
	public void  selectPassenger(int adult, int child, int infant) throws InterruptedException {
		searchFlightAvail.selectPassenger(adult, child,infant);
	}
	
	public void  selectPassenger(int adult, int child) throws InterruptedException {
		searchFlightAvail.selectPassenger(adult, child);
	}
	
	public String  getErrorMesg() {
		return searchFlightAvail.getErrorMesg();
	}
	
	public void  selectCurrency(String curr) {
		searchFlightAvail.selectCurrency(curr);
	}
	
	public void  search() {
		searchFlightAvail.search();
	}
	
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		}

	

}
