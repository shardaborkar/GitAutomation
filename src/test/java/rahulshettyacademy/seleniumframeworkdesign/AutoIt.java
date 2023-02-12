package rahulshettyacademy.seleniumframeworkdesign;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoIt {
	WebDriver driver;

		@Test
		public void homepage() throws IOException, InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
/*			driver.get("https://www.ilovepdf.com/");
			WebElement eleExceltoPDF=driver.findElement(By.cssSelector("a[title='Excel to PDF']"));
			fileUpload(driver,eleExceltoPDF,"C:\\Users\\Admin\\Downloads\\fileupload.exe");
			driver.navigate().to("https://www.ilovepdf.com/");
			WebElement elePDFtoJPG=driver.findElement(By.cssSelector("a[title='PDF to JPG']"));
			fileUpload(driver,elePDFtoJPG,"C:\\Users\\Admin\\Downloads\\fileuploadpdf.exe"); */
			driver.get("http://admin:admin@the-internet.herokuapp.com/");
			driver.findElement(By.linkText("Basic Auth")).click();
	}
		
		public static void fileUpload(WebDriver driver,WebElement ele, String filePath) throws InterruptedException, IOException {
			
			
			Thread.sleep(3000);
			ele.click();
			driver.findElement(By.id("pickfiles")).click();
			Thread.sleep(10000);
			Runtime.getRuntime().exec(filePath);
			Thread.sleep(5000);
			driver.findElement(By.id("processTaskTextBtn")).click();
			Thread.sleep(15000);
			File f=new File(System.getProperty("user.dir")+ "\\EXcelTestData.pdf");
			if(f.exists()){
				System.out.println("File is found");
				if(f.delete());{
					System.out.println("File is deleted");
				}
			}
			else {
				System.out.println("File is not found");
		
			}
		}}


