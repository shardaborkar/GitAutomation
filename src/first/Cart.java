package first;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] vegetable = {"Cucumber","Brocolli","Tomato","Carrot"};
    	additems(driver,vegetable);
    	
    	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div/button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Enter promo code']")));
		driver.findElement(By.cssSelector("input[placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
        System.out.println(driver.findElement(By.className("promoInfo")).getText());
	}
	
	public static void additems(WebDriver driver,String[]vegetable) {
       
		List groceryList=Arrays.asList(vegetable);
		int j=0;
		List<WebElement> veggies=driver.findElements(By.cssSelector("h4[class='product-name']"));
		for(int i=0;i<veggies.size();i++) {
			String name=veggies.get(i).getText();
			String actualname=name.split(" ")[0];
			if(groceryList.contains(actualname)) {
				
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if(j==groceryList.size())
					break;
			}
		}

	}

}
