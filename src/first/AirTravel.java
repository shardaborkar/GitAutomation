package first;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AirTravel {

	
		public static void main(String[] args) throws InterruptedException {
        

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			WebDriver driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://www.spicejet.com/");
			Thread.sleep(3000);
			
			
			String monthYear = "September 2023";
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
		selectDate(driver,monthYear,date);
		
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.cssSelector("div[data-testid='return-date-dropdown-label-test-id']")))
					.doubleClick().build().perform();
			Thread.sleep(3000);
			/*List<WebElement> returncal = driver
					.findElements(By.cssSelector("div[class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));*/
			List<WebElement> returncal = driver
					.findElements(By.cssSelector("div[class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']"));
			Iterator<WebElement> returnitr = returncal.iterator();
			
			for(WebElement ele1:returncal) {
			if (ele1.getText().contains(monthYear)) {
			do {
				if (!(returnitr.next().getText().contains(returnmonthYear))) {
						if (returnitr.hasNext()) {
							WebElement nextMonth = returnitr.next();
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
				
				
			} while (returnitr.hasNext());
			}
			else if(returnitr.hasNext()) {
				returnitr.next();
			}}
			selectDate(driver,returnmonthYear,returndate);
			
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
			Thread.sleep(3000);
			a.moveToElement(driver.findElement(By.cssSelector("div[class='css-1dbjc4n r-13awgt0 r-18u37iz'] div[class='css-1dbjc4n r-zso239']"))).click().build().perform();
			
			a.moveToElement(driver.findElement(By.cssSelector("div[class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']"))).click().build().perform();

		}

		
			
			public static void selectDate(WebDriver driver,String year,String date)  {
			List<WebElement> allmonth = driver.findElements(By.cssSelector("div[data-testid*='undefined-month-']"));
			try {
			for (WebElement ram : allmonth) {
				if (ram.getText().contains(year)) {
					List<WebElement> dates = ram.findElements(By.cssSelector("div[data-testid*='undefined-calendar-day-']"));
					for (WebElement d : dates) {
						System.out.println(d.getText());
						if (d.getText().contains(date)) {
							d.click();
							
							break;
							
							
						}
					}
				}}
				}
			catch(Exception e) {
				System.out.println(e);	
				}
					
				

			}}
			
			
		

			
			
		
		




