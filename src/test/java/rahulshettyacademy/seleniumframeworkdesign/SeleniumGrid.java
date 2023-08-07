package rahulshettyacademy.seleniumframeworkdesign;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;



public class SeleniumGrid {

	@Test
	public void homepage() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setBrowserName("chrome");
		caps.setCapability("Platform", Platform.WIN10);
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.37:4444/wd/hub"),caps);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("rahul shetty");
		driver.close();
	}
}
