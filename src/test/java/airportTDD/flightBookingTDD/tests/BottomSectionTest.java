package airportTDD.flightBookingTDD.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airportTDD.flightBookingTDD.testcomponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import mainPageObject.TravelHomePage;

public class BottomSectionTest extends BaseTest {
	
	@Test()
	public void User_selects_more_than_9_Passanger() throws InterruptedException, IOException {
		System.out.println(travelHomePage.bottomSection().getFlightAttribute());
		System.out.println("You are in BottomSection");
	}
	
	
	
}
