package first;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebAssignment {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/");

		driver.findElement(By.cssSelector("a[href*='Automation']")).click();
		System.out.println("Total no of rows are " + "=" + " "
				+ driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());
		System.out.println("Total no of columns are " + "=" + " "
				+ driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size());
		List<WebElement> column=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
		System.out.println("Second row details are : ");
		for(int i=0;i<column.size();i++) {
		System.out.println(column.get(i).getText());
	}}

}
