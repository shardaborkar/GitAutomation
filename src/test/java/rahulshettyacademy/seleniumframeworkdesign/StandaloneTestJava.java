package rahulshettyacademy.seleniumframeworkdesign;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTestJava {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String email="abcxyz92@gmail.com",password="Abcxyz@123",productName="ZARA COAT 3";
        driver.get("https://rahulshettyacademy.com/client/");
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("userPassword")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-body")));
        List<WebElement> products=driver.findElements(By.cssSelector(".card-body"));
        WebElement ele=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        ele.findElement(By.cssSelector(".btn.w-10.rounded")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='cartSection'] h3")));
        List<WebElement> cartProducts=driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
        
       Assert.assertTrue(cartProducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName)));
       driver.findElement(By.cssSelector(".totalRow .btn.btn-primary")).click();
       driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("section[class*=group] button")));
       List<WebElement> country=driver.findElements(By.cssSelector("section[class*=group] button"));
       for(WebElement e:country) {
    	  if(e.getText().equalsIgnoreCase("india")) {
    		  e.click();
    		  break;
       }}
     JavascriptExecutor js=(JavascriptExecutor)driver;
     js.executeScript("window.scrollBy(0,100)");
     Thread.sleep(3000);
     driver.findElement(By.cssSelector("a[class*='submit']")).click();
     System.out.println(driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText());
	}

}
