package first;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Sync {

	public static void main(String[] args) {
		String username="rahulshettyacademy", password="learning";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='user']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		Select sel=new Select(driver.findElement(By.cssSelector("select[data-style='btn-info']")));
		sel.selectByValue("consult");
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));

		List<WebElement> addtocart=driver.findElements(By.cssSelector("button[class='btn btn-info']"));
		for(int i=0;i<addtocart.size();i++) {
			addtocart.get(i).click();
		}
	}

}
