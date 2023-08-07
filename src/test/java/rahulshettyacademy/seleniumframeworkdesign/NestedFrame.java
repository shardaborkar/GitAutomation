package rahulshettyacademy.seleniumframeworkdesign;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class NestedFrame {
    @Test
	public void nestedFrame() throws MalformedURLException {
		
    	/*EdgeOptions options=new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver =new EdgeDriver(options);
		ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
    	DesiredCapabilities caps=new DesiredCapabilities();
//		caps.setBrowserName("edge");
        caps.setCapability("Platform", Platform.WIN10);
        caps.setCapability("Browser", Browser.EDGE);
		WebDriver driver=new RemoteWebDriver(caps);
		driver.manage().window().maximize(); */
    	DesiredCapabilities caps=new DesiredCapabilities();
    	WebDriver driver=new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),caps);
		driver.manage().window().maximize();
		System.out.println("It's framework branch");
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
		driver.close();

	}

}
