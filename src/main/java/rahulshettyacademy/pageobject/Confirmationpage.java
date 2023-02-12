package rahulshettyacademy.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.Reusable;

public class Confirmationpage extends Reusable {
	WebDriver driver;
	public Confirmationpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="label[class='ng-star-inserted']")
     WebElement orderId;
	public String getOrderID(){
	 	 return (orderId.getText());
}}
