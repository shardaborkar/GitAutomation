package AbstractComponents;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.ITestResult;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.OrderPage;



public class Reusable {
	WebDriver driver;
	
	public Reusable(WebDriver driver) {
		this.driver=driver;
		
	}
	
	@FindBy(css="button[routerlink='/dashboard/cart']")
    WebElement addtoCartButton;
	
	@FindBy(css="button[routerlink='/dashboard/myorders']")
    WebElement orderButton;
	By orderButtonBy=By.cssSelector("button[routerlink='/dashboard/myorders']");
	
	public static void getScreenshot(String testCaseName,WebDriver driver,int count) throws IOException, InvalidFormatException {
		TakesScreenshot s=(TakesScreenshot)driver;
		File file=s.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir") + "//screenshots//"+testCaseName+count+".png");
		FileUtils.copyFile(file, destFile);
		
		
	}
	
	public static String getScreenshot(String testCaseName,WebDriver driver) throws IOException, InvalidFormatException {
		TakesScreenshot s=(TakesScreenshot)driver;
		File file=s.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir") + "//screenshot//"+testCaseName+".png");
		FileUtils.copyFile(file, destFile);
		String path=System.getProperty("user.dir") + "//screenshot//"+testCaseName+".png";
        return path;
		
	}

	public void waitForElement(By findBy){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
	
	public void waitForElementToDisappear(By findBy){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public CartPage addtoCart() throws InterruptedException {
		Thread.sleep(3000);
		addtoCartButton.click();
		return new CartPage(driver);
	}
	
	public OrderPage verifyOrderinOrdersPage() {
		waitForElement(orderButtonBy);
		orderButton.click();
		return new OrderPage(driver);
	}
	
/*	public void copyScreenshotsIntoWord() throws InvalidFormatException, IOException {
		File destfile = new File(
				"C:\\Users\\Admin\\eclipse-workspace\\seleniumframeworkdesign\\evidences\\testCaseScreenshots.docx");
		XWPFDocument doc = new XWPFDocument();
		File srcfile = new File("C:\\Users\\Admin\\eclipse-workspace\\seleniumframeworkdesign\\screenshots");
		File[] list = srcfile.listFiles();
		
		System.out.println("Source folder item list " + list.length);
		for (int j = 0; j < list.length; j++) {
			if (list[j].isFile()) {
				System.out.println("File - " + list[j].getName());
				XWPFParagraph p = doc.createParagraph();
				XWPFRun r = p.createRun();

				FileInputStream fis = new FileInputStream(list[j].getPath());
				r.setText(list[j].getName());

				r.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, list[j].getPath(), Units.toEMU(400), Units.toEMU(450));
				fis.close();
				
				}

			 else if (list[j].isDirectory()) {
				System.out.println("Directory - " + list[j].getName());
				// If directory do nothing
				// A recursive logic can be implemented to handle the files
				// inside folders in source folder
			}
			FileOutputStream fos = new FileOutputStream(destfile);

			doc.write(fos);

			fos.close();
			doc.close();
			
			for (int k = 0; k < list.length; k++) {
				list[k].delete();
			}

			
			
		}
		
		

		
	}
*/

}
