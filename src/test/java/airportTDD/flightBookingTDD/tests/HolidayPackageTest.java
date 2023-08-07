package airportTDD.flightBookingTDD.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airportTDD.flightBookingTDD.testcomponent.BaseTest;
import airportTDD.pageComponents.HolidayPackage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

//
public class HolidayPackageTest extends BaseTest {
	
	
	
	@Test(dataProvider="HolidayTestData")
	public void bookHolidayPackage(String desti,String departureCity,String returnCity, String month,String dateMonth ) throws InterruptedException {
//	HolidayPackage holidayPackage=searchflight.clickOnHolidayPackage();
	HolidayPackage holidayPackage= travelHomePage.holidayPackage();
	holidayPackage.clickOnHolidayPackage();
	holidayPackage.selectDestination(desti);
	holidayPackage.selectDeparture(departureCity,returnCity);
	holidayPackage.selectDepartDate(month, Integer.parseInt(dateMonth));
	holidayPackage.search();
}
	@DataProvider(name="HolidayTestData")
	 
	 public Object[][] getData() throws IOException{
    Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//airportTDD//flightBookingTDD//testdata//TestData.xlsx","HolidayTestData");	 
	 return d;
	 }
}
