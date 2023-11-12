package first;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {
	public static JavascriptExecutor js;
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
//		options.addArguments("browser","browser.HtmlUnitDriver");*/
		WebDriverManager.chromedriver().setup();
//		MutableCapabilities cap=new MutableCapabilities();
//		cap.setCapability("Browser", Browser.HTMLUNIT);
//		cap.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 WebElement ele1=driver.findElement(By.xpath("//div[@class='tableFixHead']/table/tbody/tr[6]/td[2]"));
		 WebElement elem2=driver.findElement(By.xpath("//div[@class='tableFixHead']/table/tbody/tr[1]/td[1]"));
        js=(JavascriptExecutor)driver;
  //      js.executeScript("scroll(0,500)"); below is alternate way
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("window.scrollBy(0,-500)");
        js.executeScript("arguments[0].scrollIntoView(true)",ele1);
        js.executeScript("arguments[0].scrollLeft",ele1);
 //     How to scroll horizontally using scrollIntoView       
        highlighter(ele1);
        js.executeScript("arguments[0].scrollIntoView(false)",elem2);
        highlighter(elem2);
 
  //      js.executeScript("document.querySelector('.tableFixHead').scrollTop(5000)"); 
        
        List<WebElement> amounts=driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody/tr/td[4]"));
        int sum=0;
        for(WebElement ele:amounts) {
        	int am=Integer.parseInt(ele.getText());
        	sum=sum+am;
        }
        System.out.println(sum);
        WebElement ele2=driver.findElement(By.className("totalAmount"));
        highlighter(ele2);
        System.out.println(ele2.getText().split(":")[1].trim());
        
        amounts=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
        int sum1=0;
        for(WebElement ele:amounts) {
        	int am=Integer.parseInt(ele.getText());
        	sum1=sum1+am;
        }
        System.out.println(sum1);
	}

/*	public static void highlighter(WebElement ele) throws InterruptedException {
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2 px solid black;');",ele);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('style','border: solid 2 px white');",ele);
		
	}*/
	
	public static void highlighter(WebElement ele) throws InterruptedException {
		js.executeScript("arguments[0].style.background= 'yellow'; arguments[0].style.border= '2 px solid black'",ele);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border= 'solid 2 px white'",ele);
		
	}
	
	

}
