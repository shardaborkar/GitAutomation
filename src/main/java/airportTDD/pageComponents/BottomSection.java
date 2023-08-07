package airportTDD.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents.AbstractComponent;

public class BottomSection extends AbstractComponent{
	WebDriver driver;
	By flights= By.cssSelector("a[title='Flights']");
	public BottomSection(WebDriver driver,By bottomNavigation) {
		super(driver,bottomNavigation);
		}
	 
		public String getFlightAttribute() {
			return findEle(flights).getAttribute("class");
			

		}

}
