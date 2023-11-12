package first;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;




public class Locator {
 	public Locator(){
		
		System.out.println("Constructor is called");	
	}
	static int b=20;
    public void p() {
    	System.out.println(b);
    	System.out.println("Method P is called");
    }
    public static void n() {
    	System.out.println(b);
    	System.out.println("Method N is called");
    }
	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
		int a=10;
		System.out.println(b);
		System.out.println(a);
	    Locator loc=new Locator();
	    loc.p();
    	n();
	
	
/*		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("sharda");
		driver.findElement(By.name("inputPassword")).sendKeys("abc@123");
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector("p[class='error']")).getText());
		driver.findElement(By.partialLinkText("Forgot your ")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Sharda");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc@email.com");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("0987654321");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	String message=driver.findElement(By.cssSelector(".infoMsg")).getText();
	System.out.println(message);
	driver.findElement(By.cssSelector(".go-to-login-btn")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("#inputUsername")).sendKeys("sharda");
	driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
	
	driver.findElement(By.id("chkboxTwo")).click();
	
	driver.findElement(By.className("signInBtn")).click();
	String mesg=driver.findElement(By.cssSelector("p[style*='color']")).getText();
//	String mesg=driver.findElement(By.cssSelector("p")).getText();
	System.out.println(mesg);
	Assert.assertEquals(mesg, "You are successfully logged in.");
	driver.findElement(By.xpath("//button[text()='Log Out']")).click();
	driver.close();
	
	
	
	*/
		

		
	    

	}

}
