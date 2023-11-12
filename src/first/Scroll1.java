package first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Scroll1 {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement scrollEle=driver.findElement(By.id("slider"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("document.querySelector(driver.findElement(By.id("slider"))).scrollLeft(500)"); 
		Actions a = new Actions(driver);
		a.moveToElement(scrollEle).clickAndHold().scrollByAmount(500, 0).build().perform();
		a.moveToElement(scrollEle).clickAndHold().moveByOffset(500,0).release().perform();		
	}

}
