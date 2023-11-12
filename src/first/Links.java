package first;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) throws MalformedURLException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a=new SoftAssert();
		List<WebElement> urls=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(int i=0;i<urls.size();i++) {
			String url=urls.get(i).getAttribute("href");
//			String url=urls.get(i).getText();It will just grab the text of link and wont be treated as link
			HttpURLConnection conn=(HttpURLConnection) (new URL(url).openConnection());
			conn.setRequestMethod("HEAD");
			conn.connect();
			a.assertTrue(conn.getResponseCode()<400, urls.get(i).getText() + " Link is broken with response code " + conn.getResponseCode());
			

		}

		a.assertAll();
	}

}
