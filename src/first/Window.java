package first;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String>itr=windows.iterator();
		String parentWindow=itr.next();
		String childWindow=itr.next();
		driver.switchTo().window(childWindow);
		String username=driver.findElement(By.cssSelector("[href*='mailto']")).getText();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(username);
	}

}
