package first;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDD {
    @Test
	public void browserStack() throws InterruptedException, MalformedURLException {

		WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

        String countryName="United";
		driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	
		driver.findElement(By.id("autocomplete")).sendKeys(countryName);
		Thread.sleep(3000);
		List<WebElement> ele=driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		for(int i=0;i<ele.size();i++) {
			if(ele.get(i).getText().equalsIgnoreCase("United States (USA)")) {
				
		ele.get(i).click();
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		System.out.println(driver.findElement(By.id("autocomplete")).getText()); //this wont give any result hence we have to use getattribut only
			break;
		}} 
		
		
		
		System.out.println(driver.getTitle());
		/*
		driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
		driver.findElement(By.id("RESULT_RadioButton-9")).click();
		Select sel=new Select(driver.findElement(By.id("RESULT_RadioButton-9")));
		sel.selectByIndex(2);*/
		
	}
    
 

}
