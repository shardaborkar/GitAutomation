package airportTDD.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponent;

public class TopSection extends AbstractComponent{
   WebDriver driver;
  
   By flights= By.cssSelector("a[title='Flights']");
	public TopSection(WebDriver driver,By topNavigation) {
		super(driver, topNavigation);
	}
	
	public String getFlightAttribute() {
		return findEle(flights).getAttribute("class");
		

	}
}
