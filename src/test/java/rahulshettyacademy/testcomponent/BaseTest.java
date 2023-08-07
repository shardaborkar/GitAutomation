package rahulshettyacademy.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import AbstractComponents.Reusable;
import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobject.LandingPage;


public class BaseTest {
	public WebDriver driver;
	public LandingPage lp;
	public XSSFSheet sheet;
	public String sheetName;
	public int column;
	public int count = 1;
	public DesiredCapabilities caps;


	public WebDriver initializeDriver() throws IOException {

		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		pro.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: pro.getProperty("browser");
		String platform = System.getProperty("platform") != null ? System.getProperty("platform")
				: pro.getProperty("platform");


		if (browserName.contains("chrome_")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			
		}
		
		else if (browserName.contains("grid")) {
			if(browserName.contains("chrome") && platform.contains("windows10")) {
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--remote-allow-origins=*");
			caps=new DesiredCapabilities();
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.WIN10);
//			System.out.println(caps.getPlatform());
	        System.out.println("Chrome and Win10 node is selected");
			}
			else if(browserName.contains("edge") && platform.contains("windows10")) {
				caps=new DesiredCapabilities();
				caps.setBrowserName("edge");
				caps.setPlatform(Platform.WIN10);
//				System.out.println(caps.getPlatform());
				System.out.println("Edge and Win10 node is selected");
				}
			driver=new RemoteWebDriver(new URL("http://192.168.1.37:4444/wd/hub"),caps);	
		}
		
		else if (browserName.contains("browserstack")) {
			caps=new DesiredCapabilities();
		//	driver=new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),caps); http://localhost:45454/
			driver=new RemoteWebDriver(new URL("http://localhost:45454/"),caps);

		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
			// WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<WebDriver>();
		threadSafeDriver.set(driver);
		threadSafeDriver.get().manage().window().maximize();
		threadSafeDriver.get().manage().window().setSize(new Dimension(1440, 900));
		threadSafeDriver.get().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return threadSafeDriver.get();
	}

	public List<HashMap<String, String>> getJSONdata(String filePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(filePath));
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}

	public Object[][] getExcelData(String filepath, String sheetName) throws IOException {
		// fileInputStream argument

		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		DataFormatter format = new DataFormatter();
		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				sheet = workbook.getSheetAt(i);
			}
		}
		// Identify Testcases coloum by scanning the entire 1st row
		int rownum = sheet.getLastRowNum();

		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		int actualColumn = column - 1;
		Object[][] obj = new Object[rownum][actualColumn];
		for (int k = 1; k <= rownum; k++) {
			for (int j = 1; j < column; j++) {
				Row row = sheet.getRow(k);
				Cell cell = row.getCell(j);
				obj[k - 1][j - 1] = format.formatCellValue(cell);

			}
		}
		return obj;
	}

	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApp() throws IOException {
		driver = initializeDriver();

		lp = new LandingPage(driver);
		lp.goTo();
		return lp;

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InvalidFormatException, IOException {
		driver.close();
	}

	
	

	public void getSheetName(String sheetName, int column) {
		this.sheetName = sheetName;
		this.column = column;
		// Above fields are used in listener but when it was fetched from actual test it
		// was giving exception that the respective field is not found hence these
		// fields are brought in base class from actual test class then used in listener
		// for writing into excel
	}
	
	@AfterSuite()
	public void copyScreenshotsIntoWord() throws InvalidFormatException, IOException {

		XWPFDocument doc = new XWPFDocument();
		File destfile = new File(
				"C:\\Users\\Admin\\eclipse-workspace\\seleniumframeworkdesign\\evidences\\testCaseScreenshots.docx");
		File srcfile = new File("C:\\Users\\Admin\\eclipse-workspace\\seleniumframeworkdesign\\screenshots");
		File[] list = srcfile.listFiles();
		System.out.println("Source folder item list " + list.length);
		for (int k = 0; k < list.length; k++) {
			if (list[k].isFile()) {
				System.out.println("File - " + list[k].getName());
				XWPFParagraph p = doc.createParagraph();
				XWPFRun r = p.createRun();

				FileInputStream fis = new FileInputStream(list[k].getPath());
				r.setText(list[k].getName());

				r.addPicture(fis, XWPFDocument.PICTURE_TYPE_PNG, list[k].getPath(), Units.toEMU(400), Units.toEMU(450));
				fis.close();

			} else if (list[k].isDirectory()) {
				System.out.println("Directory - " + list[k].getName());
				// If directory do nothing
				// A recursive logic can be implemented to handle the files
				// inside folders in source folder
			}

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
