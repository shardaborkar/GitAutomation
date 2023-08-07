package airportTDD.flightBookingTDD.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import airportTDD.flightBookingTDD.testcomponent.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ErrorMessageTest extends BaseTest {
	
	@Test(dataProvider="errorTestData")
	public void User_selects_more_than_9_Passanger(String journeyType,String departCity,String arrivalCity,String month,String dateMonth,String adults,String childs,String errorMesg) throws InterruptedException, IOException {

		travelHomePage.setBookingStrategy(travelHomePage.multiTrip());
		createLogs("ErrorMessageTest.class","Booking strategy is set");
		travelHomePage.selectOption();
		createLogs("ErrorMessageTest.class","selected flight option");
		travelHomePage.selectCity(departCity, arrivalCity);
		createLogs("ErrorMessageTest.class","selected origin and destination");
		travelHomePage.departureDate();
		createLogs("ErrorMessageTest.class","Click on depart date option");
		travelHomePage.journeyDate(month, Integer.parseInt(dateMonth));
		createLogs("ErrorMessageTest.class","selected journey date");
		travelHomePage.selectPassenger(Integer.parseInt(adults), Integer.parseInt(childs));
		createLogs("ErrorMessageTest.class","Added passengers more than allowed capacity");
		String alertMesg=travelHomePage.getErrorMesg();
		Assert.assertEquals(alertMesg, errorMesg);
		createLogs("ErrorMessageTest.class","Error message is displyed");
		System.out.println(alertMesg);
	}
	
	
	

	@DataProvider(name="errorTestData")
	 
	 public Object[][] getData() throws IOException{
    Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//airportTDD//flightBookingTDD//testdata//TestData.xlsx","ErrorTestData");	 
	 return d;
	 }
	
	
	
	
}
