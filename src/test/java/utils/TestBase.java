package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;




public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url_properties = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		String url_maven=System.getProperty("QAUrl");
		// result = testCondition ? value1 : value2
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		String url = url_maven!=null ? url_maven : url_properties;
		
		
		
		if(driver == null)
		{
			if(browser.contains("chrome"))
			{
				ChromeOptions options = new ChromeOptions();
				if(browser.contains("headless")) {
				options.addArguments("headless");
				}
				options.addArguments("--remote-allow-origins=*");
				io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);// driver gets the life
			}
			
			if(browser.contains("edge"))
			{
				EdgeOptions options = new EdgeOptions();
				if(browser.contains("headless")) {
					options.addArguments("headless");
					}
				options.addArguments("--remote-allow-origins=*");
				
				io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver(options);// driver gets the life
			}
			
		if(browser.equalsIgnoreCase("phantomjs"))
			{
				
		 DesiredCapabilities caps = new DesiredCapabilities();
  //     caps.setJavascriptEnabled(true);
         caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Users\\Admin\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
 //        ((DesiredCapabilities)caps).setCapability("phantomjs.binary.path", "C:\\Users\\Admin\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
         caps.setCapability("takesScreenshot", true);
 //   	System.setProperty("phantomjs.binary.path", "C:\\Users\\Admin\\Downloads\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
    	driver = new PhantomJSDriver(caps);
		
			}
			
			
			if(browser.contains("firefox"))
			{
				FirefoxOptions options = new FirefoxOptions();
				if(browser.contains("headless")) {
				options.addArguments("--headless");
				}
//				
				io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			driver.manage().window().setSize(new Dimension(1440,900));
		driver.get(url);
		}
		
		return driver;
		
	}
	
	
	
}

