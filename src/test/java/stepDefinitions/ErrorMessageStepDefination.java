package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import mainPageObject.TravelHomePage;
import pageObjects.HolidayPackage;
import utils.GenericUtils;
import utils.TestContextSetup;

public class ErrorMessageStepDefination {
	TestContextSetup testContextSetup;
	TravelHomePage travelHomePage;
	
	public ErrorMessageStepDefination(TestContextSetup testContextSetup ) {
		this.testContextSetup=testContextSetup;
		
	}

	@Then("^User selects passengers with adults (.+) childs (.+) then Error message (.+) should be displayed$")
	public void User_selects_more_than_allowed_passengers(int adults,int childs,String errorMesg) throws InterruptedException {
		testContextSetup.travelHomePage.selectPassenger(adults,childs, testContextSetup);
		testContextSetup.genericUtils.createLogs("ErrorMessageStepDefination.class","Passengers are added with more than allowed capacity");
		String alertMesg=testContextSetup.travelHomePage.getErrorMesg();
		testContextSetup.genericUtils.createLogs("ErrorMessageStepDefination.class","Error message is displyed");
		Assert.assertEquals(alertMesg, errorMesg);
		System.out.println(alertMesg);
	}
}
