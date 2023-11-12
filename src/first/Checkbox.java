package first;

import java.io.File;
import java.io.IOException;
import java.util.List;


//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;





public class Checkbox {
	public static void main(String[] args) throws IOException {
	
   /* 	 DesiredCapabilities caps = new DesiredCapabilities();
       
         caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\Admin\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
 //        ((DesiredCapabilities)caps).setCapability("phantomjs.binary.path", "C:\\Users\\Admin\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
         caps.setCapability("takesScreenshot", true);
 //   	System.setProperty("phantomjs.binary.path", "C:\\Users\\Admin\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
    	WebDriver driver = new PhantomJSDriver(caps);
         driver.get("https://www.spicejet.com/");
        
         System.out.println(driver.getTitle());
  
      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//       FileUtils.copyFile(scrFile, new File("C:\\Users\\Admin\\Desktop\\screenshotAfterLaunchingspicejet.jpeg"),true);
      */
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.
		WebDriver driver = new HtmlUnitDriver();
        driver.get("https://www.spicejet.com/");
       
        System.out.println(driver.getTitle());
		
		
		
		/*
		System.out.println(driver.findElement(By.xpath("(//div[@style='position: relative; z-index: 1;'])[2]")).isSelected());
		driver.findElement(By.xpath("(//div[@style='position: relative; z-index: 1;'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("(//div[@style='position: relative; z-index: 1;'])[2]")).isSelected());
		WebElement ele1=driver.findElement(By.xpath("(//div[@style='position: relative; z-index: 1;'])[3]"));
		Actions a=new Actions(driver);
	    a.moveToElement(ele1).build().perform();
		System.out.println(driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-jwli3a r-1enofrn'])[3]")).getText());
		
		List<WebElement> web=driver.findElements(By.xpath("//div[@style='position: relative; z-index: 1;']"));
		for(WebElement ele:web){
			
			System.out.println(ele.getText());
			
		}
		
		System.out.println(web.size());
		*/

	}
}

