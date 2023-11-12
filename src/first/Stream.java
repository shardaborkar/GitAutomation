package first;



import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Stream {

	public static void main(String[] args) {
		
	        
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--remote-allow-origins=*");
		        WebDriverManager.chromedriver().setup();
		        WebDriver driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
				
				driver.findElement(By.cssSelector("span[class='sort-icon sort-descending']")).click();
			    List<WebElement> original=driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
			    List<String> veggies=original.stream().map(s->s.getText()).collect(Collectors.toList());
List<String> sortedVeggies=veggies.stream().sorted().collect(Collectors.toList());
Assert.assertEquals(veggies, sortedVeggies);
List<String> price;
do {
List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggies(s)).collect(Collectors.toList());
price.forEach(a->System.out.println(a));

if(price.size()<1) {
	driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
}
	}while(price.size()<1);
	}
public static String getPriceVeggies(WebElement s) {
	String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
return pricevalue;

}

}
