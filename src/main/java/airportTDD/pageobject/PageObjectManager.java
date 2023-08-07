package airportTDD.pageobject;

import org.openqa.selenium.WebDriver;

import stepDefinitions.ErrorMessageStepDefination;

public class PageObjectManager {
	
	public SearchFlight searchflight;
	public HolidayPackage holidayPackage;
	
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	
	
	public SearchFlight getSearchFlight()
	{
	
	 searchflight= new SearchFlight(driver);
	 return searchflight;
	}



	public HolidayPackage getHolidayPackage() {
		holidayPackage= new HolidayPackage(driver);
		 return holidayPackage;
		}



	
	
}
