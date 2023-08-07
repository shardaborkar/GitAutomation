package rahulshettyacademy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
	WebDriver driver;
	public PageObjectManager(WebDriver driver) {
//		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductCatalogue getProductCataloguePage() {
		return new ProductCatalogue(driver);

	}

}
