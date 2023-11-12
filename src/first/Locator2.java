package first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator2 {

	public static void main(String[] args) throws InterruptedException {
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
	//	WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("sharda");
		driver.findElement(By.name("inputPassword")).sendKeys("abc@123");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.tagName("a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Sharda");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc@email.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("0987654321");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	String message=driver.findElement(By.cssSelector(".infoMsg")).getText();
	String[] a=message.split("'");
    String password=a[1].split("'")[0];
    driver.findElement(By.cssSelector(".go-to-login-btn")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("inputUsername")).sendKeys("sharda");
	driver.findElement(By.name("inputPassword")).sendKeys(password);
	driver.findElement(By.className("signInBtn")).click();
	driver.quit();
	}

}
