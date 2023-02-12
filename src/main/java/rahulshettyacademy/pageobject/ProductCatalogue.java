package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponents.Reusable;

public class ProductCatalogue extends Reusable{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".card-body")
    List<WebElement> products;
	
	By productsBy=By.cssSelector(".card-body");
	By addtoCartby=By.id("toast-container");
	By addtoCartby1=By.cssSelector(".ng-animating");
	
	public List<WebElement> getProducts() {
		waitForElement(productsBy);
		return products;
	}
	
	public void selectAndAddProducttoCart(String productName) {
	 WebElement ele=getProducts().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
     ele.findElement(By.cssSelector(".btn.w-10.rounded")).click();
     waitForElement(addtoCartby);
     waitForElementToDisappear(addtoCartby1);
    
	}
	
	
}
