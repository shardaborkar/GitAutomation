package airportTDD.flightBookingTDD.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airportTDD.flightBookingTDD.testcomponent.BaseTest;

public class SearchFlightTest1 extends BaseTest {
	
	@Test(dataProvider="MulitiCity")
	public void searchWithMulticity(String departCity,String arrivalCity, String month,String dateMonth,String adults,String childs,String infants,String curr) throws InterruptedException, IOException {
		
	//	System.out.println(travelHomePage.topSection().getFlightAttribute());
		travelHomePage.setBookingStrategy(travelHomePage.multiTrip());
		travelHomePage.checkAvailability();
		travelHomePage.selectOption();
		travelHomePage.selectCity(departCity, arrivalCity);
		travelHomePage.departureDate();
		travelHomePage.journeyDate(month, Integer.parseInt(dateMonth));
		travelHomePage.selectPassenger(Integer.parseInt(adults), Integer.parseInt(childs), Integer.parseInt(infants));
		travelHomePage.selectCurrency(curr);
		travelHomePage.search();
		
	}
	@Test(dataProvider="OneWay")
	public void searchWithoneWay(String departCity,String arrivalCity, String month,String dateMonth,String adults,String childs,String infants,String curr) throws InterruptedException, IOException
	{
		
		travelHomePage.setBookingStrategy(travelHomePage.oNEWay());
		travelHomePage.checkAvailability();
		travelHomePage.selectOption();
		travelHomePage.selectCity(departCity, arrivalCity);
        travelHomePage.journeyDate(month, Integer.parseInt(dateMonth));
		travelHomePage.selectPassenger(Integer.parseInt(adults), Integer.parseInt(childs), Integer.parseInt(infants));
		travelHomePage.selectCurrency(curr);
		travelHomePage.search();
	}
	
	@Test(dataProvider="RoundTrip")
	public void searchWithroundTrip(String departCity,String arrivalCity, String month,String dateMonth,String rmonth,String rdateMonth,String adults,String childs,String infants,String curr) throws InterruptedException, IOException
	{
		
		travelHomePage.setBookingStrategy(travelHomePage.roundTrip());
		travelHomePage.checkAvailability();
		travelHomePage.selectOption();
		travelHomePage.selectCity(departCity, arrivalCity);
        travelHomePage.journeyDate(month, Integer.parseInt(dateMonth));
        travelHomePage.returnDate();
        travelHomePage.journeyDate(rmonth, Integer.parseInt(rdateMonth));
		travelHomePage.selectPassenger(Integer.parseInt(adults), Integer.parseInt(childs), Integer.parseInt(infants));
		travelHomePage.selectCurrency(curr);
		travelHomePage.search();
	}
	
 @DataProvider(name="MulitiCity")
 
	
	 public Object[][] getMulitiCityperty() throws IOException{
		 Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//airportTDD//flightBookingTDD//testdata//TestData.xlsx","MultiCity");	 
		  return d;
	 }
	 
	 
 
 @DataProvider(name="OneWay")
 
 public Object[][] getOnewayData() throws IOException{
Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//airportTDD//flightBookingTDD//testdata//TestData.xlsx","OneWay");	 
 return d;
 }
 
@DataProvider(name="RoundTrip")
 
 public Object[][] getRoundTripData() throws IOException{
Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//airportTDD//flightBookingTDD//testdata//TestData.xlsx","RoundTrip");	 
 return d;
 }
	
	
	
}
	

