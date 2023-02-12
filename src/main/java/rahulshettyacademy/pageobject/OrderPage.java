package rahulshettyacademy.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import AbstractComponents.Reusable;

public class OrderPage extends Reusable{
	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//tr/td[2]")
    List<WebElement> prodAddedtoOrder;
	
	By ordersBy=By.xpath("//tr/td[2]");
	
	public boolean orderValidation(String productName) {
	waitForElement(ordersBy);
    boolean b=prodAddedtoOrder.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
    return b;
	}
	
}
