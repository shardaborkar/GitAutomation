package first;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_Checkbox {

	public static void main(String[] args) {

		

//				System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
				WebDriver driver = new ChromeDriver(options);

				driver.manage().window().maximize();

				driver.get("https://rahulshettyacademy.com/AutomationPractice/");

				driver.findElement(By.id("checkBoxOption1")).click();
				
				System.out.println(driver.findElement(By.id("checkBoxOption1")).getAttribute("value"));
				System.out.println(driver.findElement(By.id("checkBoxOption1")).getText());  
				System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());

				driver.findElement(By.id("checkBoxOption1")).click();

				System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());

		        countOfCheckbox(driver);

				

			}
	
	public static void countOfCheckbox(WebDriver driver){

		        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

				System.out.println("No of checkboxes present are " + checkboxes.size());

		}

		}
