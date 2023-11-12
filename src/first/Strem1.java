package first;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.TakesScreenshot;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Strem1 {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		/*
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> search=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		if(search.size()>=1 && !(search.get(0).getText().contains("No data")) ) {
		List<WebElement> searchresult=search.stream().filter(s->s.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(search, searchresult);
		
	}
	else
	{
		System.out.println("No data is found ");
	}
		
		WebElement ele=driver.findElement(By.xpath("(//tbody/tr/td[1])[1]"));
		System.out.println(driver.findElement(with(By.tagName("span")).above(ele)).getText());
		WebElement ele1=driver.findElement(By.cssSelector("th[aria-label*='Price']"));
		System.out.println(driver.findElement(with(By.tagName("td")).below(ele1)).getText());
		System.out.println(driver.findElement(By.cssSelector("a[aria-label='Previous']")).getText());
//		System.out.println(driver.findElement(with(By.tagName("a")).toLeftOf(ele2)).getText());
		*/
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement ele2=driver.findElement(By.id("exampleCheck1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(ele2)).getText());
		WebElement ele3=driver.findElement(By.cssSelector("label[for='inlineRadio1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(ele3)).click();
		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.switchTo().newWindow(WindowType.TAB);
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> itr=windows.iterator();
		String parent=itr.next();
		String child=itr.next();
		driver.switchTo().window(child);
		driver.get("https://rahulshettyacademy.com/#?index");
		String course=driver.findElement(By.xpath("(//h2/a)[1]")).getText();
		driver.switchTo().window(parent);
		WebElement name=driver.findElement(By.name("name"));
		name.sendKeys(course);
//		File src=name.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src,new File("logo.png"));
//		File sourceFile=((TakeScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(name.getLocation().getX());
		System.out.println(name.getLocation().getY());
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		System.out.println(name.getRect().height);
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().width);
		System.out.println(name.getRect().getWidth());
		}
	

}
