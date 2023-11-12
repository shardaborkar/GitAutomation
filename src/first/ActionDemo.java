package first;




import java.io.File;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;




public class ActionDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
	/*	ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
/*		driver.get("https://www.amazon.com/");
		Actions a=new Actions(driver);
		
		a.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList"))).contextClick().build().perform();
		
		a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src,new File("Desktop"));
		driver.get("https://www.ganeshaspeaks.com/");
		Thread.sleep(10000);
		System.out.println(driver.findElement(By.id("moe-dontallow_button")).getText());*/
		
	/*	DesiredCapabilities caps=new DesiredCapabilities();
		caps.setBrowserName("edge");
		caps.setPlatform(Platform.ANDROID);
		System.out.println(caps.getPlatformName());*/
	}

}
