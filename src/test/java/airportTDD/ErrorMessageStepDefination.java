package airportTDD;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airportTDD.testcomponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ErrorMessageStepDefination extends BaseTest{
	

	@Test(dataProvider="errorTestData")
	public void User_selects_more_than_9_Passanger(String journeyType,String departCity,String arrivalCity,String month,int dateMonth,int adults,int childs,String errorMesg) throws InterruptedException {
		searchflight.selectOption(journeyType);
        searchflight.selectCity(departCity, arrivalCity);
        searchflight.departureDate();
        searchflight.selectJourneyDate(month, dateMonth);
        searchflight.selectPassenger(adults,childs);
		String alertMesg=searchflight.getErrorMesg();
		Assert.assertEquals(alertMesg, errorMesg);
		System.out.println(alertMesg);
	}
	
	@DataProvider(name="errorTestData")
	 
	 public Object[][] getData() throws IOException{
    Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//airportTDDTestdata//TestsData.xlsx","ErrorTestData");	 
	 return d;
	 }
	
}
