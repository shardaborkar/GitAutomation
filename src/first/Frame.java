package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		Actions a =new Actions(driver);
		a.dragAndDrop((driver.findElement(By.id("draggable"))), (driver.findElement(By.id("droppable")))).build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[href*='accordion']")).click();
	}

}
