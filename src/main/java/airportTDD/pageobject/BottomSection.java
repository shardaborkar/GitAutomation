package airportTDD.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BottomSection {
	WebDriver driver;
	By bottomNavigation=By.id("traveller-home");
	By flights= By.cssSelector("a[title='Flights']");
	public BottomSection(WebDriver driver) {
		this.driver=driver;
		
	}
	 
		public String getFlightAttribute() {
			WebElement bottomSection=driver.findElement(bottomNavigation);
			return bottomSection.findElement(flights).getAttribute("class");
			
		}

}
