package first;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCookies {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.facebook.com/");
//		Cookie cookie=new Cookie(null, null);
/*	    driver.findElement(By.cssSelector("a[data-action='sign in']")).click();
		driver.findElement(By.name("identifier")).sendKeys("borkar.sharda92@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.name("Passwd")).sendKeys("sharda12");
		driver.findElement(By.id("passwordNext")).click(); */
		driver.manage().deleteCookieNamed("fr");
//		driver.manage().deleteAllCookies();
//		driver.manage().deleteCookie(cookie);
//		driver.findElement(By.cssSelector("div[class='z0'] div[role='button']")).click();
		
		//__Host-GMAIL_SCH		
	
	}

}
