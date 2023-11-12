package first;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditboxesDropdown_Assignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		String name="sharda",email="borkar.sharda92@gmail.com",password="abc@123",DOB="01-05-1992";
		driver.findElement(By.cssSelector("input[name='name']:nth-child(2)")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		driver.findElement(By.id("exampleCheck1")).click();
		Select sel=new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		sel.selectByIndex(1);
		List<WebElement> dd=sel.getOptions();
		for(WebElement ele:dd) {
			System.out.println(ele.getText());
		}
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.cssSelector("input[name='bday']")).sendKeys(DOB);
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
		System.out.println(driver.findElement(By.cssSelector("input[name='bday']")).getRect().getDimension().getHeight());
		System.out.println(driver.findElement(By.cssSelector("input[name='bday']")).getRect().getDimension().getWidth());
		System.out.println(driver.findElement(By.cssSelector("input[name='bday']")).getRect().height);
		System.out.println(driver.findElement(By.cssSelector("input[name='bday']")).getRect().width);
		System.out.println(driver.findElement(By.cssSelector("input[name='bday']")).getRect().getDimension().height);
		System.out.println(driver.findElement(By.cssSelector("input[name='bday']")).getRect().getDimension().width);
		System.out.println(driver.findElement(By.cssSelector("input[name='bday']")).getRect().getHeight());
		System.out.println(driver.findElement(By.cssSelector("input[name='bday']")).getRect().getWidth());
		
		
		
		
		
		
	}

}
