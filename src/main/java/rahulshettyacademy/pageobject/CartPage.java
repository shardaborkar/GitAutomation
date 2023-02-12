package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponents.Reusable;

public class CartPage extends Reusable{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="div[class='cartSection'] h3")
    List<WebElement> prodAddedtoCart;
	
	By cartsProductBy=By.cssSelector("div[class='cartSection'] h3");
	
	@FindBy(css=".totalRow .btn.btn-primary")
    WebElement checkoutButton;
	
	public boolean cartProductVerification(String productName) {
	
    waitForElement(cartsProductBy);
    boolean b=prodAddedtoCart.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
    return b;
	}
	
	public Checkout checkout() {
		
		checkoutButton.click();
		return new Checkout(driver);
	}
}
