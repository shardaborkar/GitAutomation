package rahulshettyacademy.testcomponent;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobject.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage lp;
	public XSSFSheet sheet;
	int count=1;
	public WebDriver initializeDriver() throws IOException{
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		pro.load(fis);
		
		String browserName=System.getProperty("browser")!=null?System.getProperty("browser") :pro.getProperty("browser");
		if(browserName.contains("chrome")){
	    ChromeOptions options=new ChromeOptions();
	    
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")) {
		options.addArguments("headless");
		}
		driver=new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
	//		WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public List<HashMap<String, String>> getJSONdata(String filePath) throws IOException {
		
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		
		return data;
	}	
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot s=(TakesScreenshot)driver;
		File file=s.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir") + "//screenshots//"+testCaseName+".png");
		FileUtils.copyFile(file, destFile);
		return System.getProperty("user.dir") + "//screenshots//"+testCaseName+".png";
	}
	
	public Object[][] getExcelData(String filepath,String sheetName) throws IOException
	 {
	 //fileInputStream argument
		 
	 File file=new File(filepath);
	 FileInputStream fis=new FileInputStream(file);
	 XSSFWorkbook workbook=new XSSFWorkbook(fis);

	 int sheets=workbook.getNumberOfSheets();
	 for(int i=0;i<sheets;i++)
	 {
	 if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
	 {
	 sheet=workbook.getSheetAt(i);
	 }}
	 //Identify Testcases coloum by scanning the entire 1st row
	 int rownum=sheet.getLastRowNum();
	 
	 int column=sheet.getRow(0).getPhysicalNumberOfCells();
	 int actualColumn=column-1;
	 Object[][] obj=new Object[rownum][actualColumn];
	 for(int k=1;k<=rownum;k++) {
		 for(int j=1;j<column;j++) {
		obj[k-1][j-1]=sheet.getRow(k).getCell(j).getStringCellValue();
		
	 }}
	 return obj;
	 }
    
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApp() throws IOException {
		driver=initializeDriver();
		lp=new LandingPage(driver);
		lp.goTo();	
		return lp;
		
	}
  @AfterMethod(alwaysRun=true)
	  public void tearDown() {
	  driver.close();
  }
  }

