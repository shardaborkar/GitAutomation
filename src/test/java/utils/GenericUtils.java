package utils;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;


public class GenericUtils {
	public WebDriver driver;
	JavascriptExecutor js;
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void highlightElement(WebElement ele) throws InterruptedException {
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.background= 'yellow'; arguments[0].style.border= '2 px solid black'",ele);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.background= 'white'",ele);
		
	}
	
	public void createLogs(String className,String logs) {
 //       PropertyConfigurator.configure("C:\\Users\\Admin\\eclipse-workspace\\FlightBooking2\\log4j.properties");
		Logger log=Logger.getLogger(className.getClass());
		log.info(logs);
	}
	
	
}
