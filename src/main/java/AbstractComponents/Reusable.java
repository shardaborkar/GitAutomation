package AbstractComponents;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.OrderPage;


public class Reusable {
	WebDriver driver;
	public Reusable(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(css="button[routerlink='/dashboard/cart']")
    WebElement addtoCartButton;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
    WebElement orderButton;
	By orderButtonBy=By.cssSelector("button[routerlink='/dashboard/myorders']");
	
	
	public void waitForElement(By findBy){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitForElementToDisappear(By findBy){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public CartPage addtoCart() throws InterruptedException {
		Thread.sleep(3000);
		addtoCartButton.click();
		return new CartPage(driver);
	}
	
	public OrderPage verifyOrderinOrdersPage() {
		waitForElement(orderButtonBy);
		orderButton.click();
		return new OrderPage(driver);
	}


}
