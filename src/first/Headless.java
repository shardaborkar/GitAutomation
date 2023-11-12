package first;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Headless {
	public static void main(String[] args) throws InterruptedException {
//	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	Map<String,Object> prefs= new HashMap<String,Object>();
	prefs.put("profile.default_content_setting_values.notifications", 1);
	options.addExtensions(new File("C:\\Users\\Admin\\Downloads\\SelectorsHub.crx"));
	options.setAcceptInsecureCerts(true);
	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	options.setExperimentalOption("prefs", prefs);
//	options.addArguments("headless");
	WebDriver driver= new ChromeDriver(options);
    driver.manage().window().maximize();
	driver.get("https://www.horoscope.com/");
	System.out.println(driver.getTitle());
	
	
    
}}
