package first;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Windoe_Ass {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		driver.navigate().back();
		driver.navigate().forward();
		Set<String> windows=driver.getWindowHandles();
		System.out.println(windows.size());
		
	    
		List<String> allwinid=new ArrayList<String>(windows);
		
		
		
		
		System.out.println(allwinid.size());
		Iterator<String> itr=windows.iterator();		
		System.out.println(itr.next());
		System.out.println(itr.next());
		
		driver.switchTo().window("allwinid.get(0)");
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.switchTo().window(allwinid.get(1));
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		System.out.println(driver.getWindowHandle());
 //       driver.close();
		driver.quit();
	}


}
