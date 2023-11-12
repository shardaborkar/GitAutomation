package first;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Practice_a {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
		driver.findElement(By.id("checkBoxOption2")).click();
		String selectedOption=driver.findElement(By.cssSelector("label[for='benz']")).getText();
		WebElement ele=driver.findElement(By.id("dropdown-class-example"));
		Select sel=new Select(ele);
		List<WebElement> options=sel.getOptions();
		for(WebElement o:options) {
			if(o.getText().contains(selectedOption)) {
				o.click();
				break;
			}
		}
		driver.findElement(By.name("enter-name")).sendKeys(selectedOption);
		driver.findElement(By.id("alertbtn")).click();
	Assert.assertTrue(driver.switchTo().alert().getText().contains(selectedOption));	
		
	}

}
