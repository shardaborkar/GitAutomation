package first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locator3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
			driver.findElement(By.xpath("//div[@style='text-align: right;margin-top: -30px;']/a")).click();
			Thread.sleep(10000);
			driver.navigate().back();
			driver.navigate().forward();
			driver.navigate().to("https://google.com");
	}

}
