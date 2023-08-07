package rahulshettyacademy.seleniumframeworkdesign;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BappaTest {
    @Test
	public void bappaTest() throws InterruptedException, MalformedURLException {

		/*ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver =new EdgeDriver(options); 
		
    	DesiredCapabilities caps=new DesiredCapabilities();
//		caps.setBrowserName("edge");
        caps.setCapability("Platform", Platform.WIN10);
        caps.setCapability("Browser", Browser.EDGE);
		WebDriver driver=new RemoteWebDriver(caps);*/
    	DesiredCapabilities caps=new DesiredCapabilities();
    	WebDriver driver=new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),caps);
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		System.out.println(driver.getTitle());
		driver.close();
/*		String monthYear = "September 2023";
		String date = "12";
		String returnmonthYear = "November 2023";
		String returndate = "24";
		String origin="//*[text()='Dehradun Airport']";
		String destination="//*[text()='Gwalior Airport']";
		driver.findElement(By.cssSelector("div[data-testid='round-trip-radio-button']")).click();
		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin']")).click();
		driver.findElement(By.xpath(origin)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(destination)).click();
		select(driver, monthYear, date);

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")))
				.doubleClick().build().perform();
		Thread.sleep(3000);
		List<WebElement> cal = driver
				.findElements(By.cssSelector("div[class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
		Iterator<WebElement> itr = cal.iterator();
		
		for(WebElement ele:cal) {
		if (ele.getText().contains(monthYear)) {
		do {
			if (!(itr.next().getText().contains(returnmonthYear))) {
					if (itr.hasNext()) {
						WebElement nextMonth = itr.next();
						if (!(nextMonth.getText().contains(returnmonthYear))) {
							driver.findElement(By.cssSelector(
									"div[data-testid='undefined-calendar-picker'] div[class*=' r-u8s1d']:nth-child(1)"))
									.click();
						} else {
							break;
						}
					} else {
						break;
					}
				}

				else {
					break;
				}
			
			
		} while (itr.hasNext());
		}
		else if(itr.hasNext()) {
		itr.next();
		}}
		
		List<WebElement> allmonth = driver.findElements(By.cssSelector("div[data-testid*='undefined-month-']"));
		for (WebElement ram : allmonth) {
			if (ram.getText().contains(returnmonthYear)) {
				List<WebElement> dates = ram.findElements(By.cssSelector("div[data-testid*='undefined-calendar-day-']"));
				for (WebElement d : dates) {
					System.out.println(d.getText());
					if (d.getText().contains(returndate)) {
						d.click();
						break;

					}
				}
			}

		}
		
		driver.findElement(By.cssSelector("div[data-testid='home-page-travellers']")).click();
		for(int i=0;i<5;i++) {
		driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']")).click();
		}
		for(int i=0;i<3;i++) {
			driver.findElement(By.cssSelector("div[data-testid='Children-testID-plus-one-cta']")).click();

		}
		for(int i=0;i<2;i++) {
			driver.findElement(By.cssSelector("div[data-testid='Infant-testID-plus-one-cta']")).click();

		}
		
		
		driver.findElement(By.cssSelector("div[data-testid='home-page-travellers-done-cta']")).click();
		
		driver.findElement(By.xpath("//div[@style='flex: 0.3 1 0%; margin-left: 10px;']")).click();
		List<WebElement> curr= driver.findElements(By.cssSelector("div[class='css-76zvg2 r-homxoj r-ubezar']"));
		for(WebElement elem:curr) {
			if(elem.getText().contains("INR")) {
				elem.click();
				break;
			}
		}
		
		
		driver.findElement(By.xpath("(//div[@style='position: relative; z-index: 1;'])[2]")).click();
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		
		

	}

	public static void select(WebDriver driver, String monthYear, String date) {

		List<WebElement> cal = driver
				.findElements(By.cssSelector("div[class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
		Iterator<WebElement> itr = cal.iterator();
		do {
			if (!(itr.next().getText().contains(monthYear))) {
				if (itr.hasNext()) {
					WebElement nextMonth = itr.next();
					if (!(nextMonth.getText().contains(monthYear))) {
						driver.findElement(By.cssSelector(
								"div[data-testid='undefined-calendar-picker'] div[class*=' r-u8s1d']:nth-child(1)"))
								.click();
					} else {
						break;
					}
				} else {
					break;
				}
			}

			else {
				break;
			}
		} while (itr.hasNext());

		List<WebElement> allmonths = driver.findElements(By.cssSelector("div[data-testid*='undefined-month-']"));
		for (WebElement am : allmonths) {
			if (am.getText().contains(monthYear)) {
				List<WebElement> dates = am.findElements(By.cssSelector("div[data-testid*='undefined-calendar-day-']"));
				for (WebElement d : dates) {
					System.out.println(d.getText());
					if (d.getText().contains(date)) {
						d.click();
						break;

					}
				}
			}

		}*/
	}
	
	}


