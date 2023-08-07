package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.TestContextSetup;

public class SearchFlightStepDefinitin {
	TestContextSetup testContextSetup;
	
	public SearchFlightStepDefinitin(TestContextSetup testContextSetup ) {
		this.testContextSetup=testContextSetup;
		
	}

	@Given("^User clicks on journeyType option (.+)$")
	public void User_clicks_on_journeyType_option(String journeyType) throws InterruptedException {
		if (journeyType.contains("multicity")) {
		testContextSetup.travelHomePage.setBookingStrategy(testContextSetup.travelHomePage.multiTrip());
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","multicity booking strategy is set");
		}
		if (journeyType.contains("roundtrip")) {
			testContextSetup.travelHomePage.setBookingStrategy(testContextSetup.travelHomePage.roundTrip());
			testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","roundtrip booking strategy is set");
			}
		if (journeyType.contains("oneway")) {
			testContextSetup.travelHomePage.setBookingStrategy(testContextSetup.travelHomePage.oNEWay());
			testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","oneway booking strategy is set");
			}
		testContextSetup.travelHomePage.checkAvailability();
		testContextSetup.travelHomePage.selectOption(testContextSetup);
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","flight option is selected");
	}
	
	@When ("^User enters departure city (.+) and arrival city (.+)$")
	public void user_enters_departure_city_and_arrival_city(String departCity,String arrivalCity) throws InterruptedException
	{
		testContextSetup.travelHomePage.selectCity(departCity, arrivalCity,testContextSetup);
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","Origin and Destination is selected");
	}
	
	@And("User clicks on departDate")
	public void user_clicks_on_departDate() throws InterruptedException{
		testContextSetup.travelHomePage.departureDate(testContextSetup);
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","Clicked on depart date");
	}
	
	@And("^User selects depart date with month (.+) and date (.+)$")
	public void User_selects_depart_date_with_month(String month,int dateMonth) throws InterruptedException {
		
		testContextSetup.travelHomePage.journeyDate(month, dateMonth,testContextSetup);
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","journey date is selected");
	}
	
	@When("^User selects passengers with adults (.+) childs (.+) infants (.+)$")
	public void user_selects_passengers(int adults,int childs,int infants) throws InterruptedException {
		testContextSetup.travelHomePage.selectPassenger(adults, childs, infants,testContextSetup);
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","Added passengers");
	}
	@When("^User selects currency as (.+)$")
	public void user_selects_currency(String curr) throws InterruptedException {
		testContextSetup.travelHomePage.selectCurrency(curr,testContextSetup);
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","Currency is selected");
	}
	@When("User clicks on search") 
	public void user_clicks_on_search() throws InterruptedException {
		testContextSetup.travelHomePage.search(testContextSetup); 
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","Clicked on search button");
	}
	@Then("Available flights for the given search criteria should be displayed")
	public void available_flights_for_the_given_search_criteria_should_be_displayed() {
	    
	}
	
	@Given("^User clicks on returndate option with month (.+) and date (.+)$")
	public void user_clicks_on_returndate_option_with_month_and_date(String month,int dateMonth) throws InterruptedException {
		testContextSetup.travelHomePage.returnDate(testContextSetup);
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","return date is selected");
		testContextSetup.travelHomePage.journeyDate(month, dateMonth, testContextSetup);
		testContextSetup.genericUtils.createLogs("SearchFlightStepDefinitin.class","return journey date is selected");
	}
	



}
