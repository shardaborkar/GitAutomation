package airportTDD.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopSection {
   WebDriver driver;
   By topNavigation=By.id("buttons");
   By flights= By.cssSelector("a[title='Flights']");
	public TopSection(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public String getFlightAttribute() {
		WebElement topSection=driver.findElement(topNavigation);
		return topSection.findElement(flights).getAttribute("class");
		
	}

}
