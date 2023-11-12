package first;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Visa {

	public static void main(String[] args) throws InterruptedException{
		    String month="August", date="30",year="2023 ";
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.path2usa.com/travel-companion/");
		    JavascriptExecutor js=(JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,900)");
		   
			Thread.sleep(3000);
			driver.findElement(By.id("form-field-travel_comp_date")).click();
			
			
//		while(!(driver.findElement(By.cssSelector("input[class='numInput cur-year']")).getText().split(" ")[0].contains(year))) 
//		{
//			driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();
//			Thread.sleep(2000);
//			}
			for(int i=0;i<12;i++) {
				
			if(!(driver.findElement(By.cssSelector("span[class='cur-month']")).getText().contains(month)))
			{
				driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();
				Thread.sleep(2000);
			}
			else {
				break;
			}
	}
			List<WebElement> dates=driver.findElements(By.cssSelector("span[class='flatpickr-day ']"));
			for(WebElement d:dates) {
				if(d.getText().equalsIgnoreCase(date)) {
					d.click();
					break;
				}
			}
			
	}

}
