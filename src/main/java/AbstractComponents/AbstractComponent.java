package AbstractComponents;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractComponent {
  WebDriver driver;
  WebElement sectionElement;
	public AbstractComponent(WebDriver driver,By sectionElement) {
		
		this.sectionElement=driver.findElement(sectionElement);
	}
	
	public WebElement findEle(By flights) {
		return sectionElement.findElement(flights);
		
	}
}
