package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Spicejet {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[data-testid='one-way-radio-button'] g")).getAttribute("fill"), "none");
		System.out.println("One way is selected by default");
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div[style='font-family: inherit; opacity: 0.5;']")).getAttribute("style").contains("0.5"));
		System.out.println("Return date is disabled when round trip button is not selected ");
		driver.findElement(By.cssSelector("div[data-testid='round-trip-radio-button']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("div[style='font-family: inherit; opacity: 1;']")).getAttribute("style").contains("1"));
		System.out.println("Return date is enabled when round trip button is selected ");
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@style='position: relative; z-index: 1;'])[2]")).isSelected());
		driver.findElement(By.xpath("(//div[@style='position: relative; z-index: 1;'])[2]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@style='position: relative; z-index: 1;'])[2]")).isSelected());
		
	}

}
