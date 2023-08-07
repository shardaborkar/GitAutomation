package rahulshettyacademy.testcomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import AbstractComponents.Reusable;
import rahulshettyacademy.resources.ExtentReporterNG;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;



public class Listener extends BaseTest implements ITestListener{
    ExtentReports extent=ExtentReporterNG.getReportObject();
    ExtentTest test;
    static int count =1;
    XSSFWorkbook workbook;
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
    
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed");
		try {
			
			String filePath=System.getProperty("user.dir") +"//src//test//java//rahulshettydata//EXcelTestData.xlsx";
			String sheetName=(String) result.getTestClass().getRealClass().getField("sheetName").get(result.getInstance());
			int column=(int) result.getTestClass().getRealClass().getField("column").get(result.getInstance());
			writeIntoExcel(filePath,sheetName,column,"Passed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
	try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}catch (Exception e) {
			e.printStackTrace();
		}
		String path=null;
		try {
			path = Reusable.getScreenshot(result.getMethod().getMethodName()+count,driver);
			count++;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
try {
			
			String filePath=System.getProperty("user.dir") +"//src//test//java//rahulshettydata//EXcelTestData.xlsx";
			String sheetName=(String) result.getTestClass().getRealClass().getField("sheetName").get(result.getInstance());
			int column=(int) result.getTestClass().getRealClass().getField("column").get(result.getInstance());
			writeIntoExcel(filePath,sheetName,column,"Failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	public void writeIntoExcel(String filepath,String sheetName,int column,String testcaseResult) throws IOException
	 {
	 //fileInputStream argument
		 
	 File file=new File(filepath);
	 FileInputStream fis=new FileInputStream(file);
	  workbook=new XSSFWorkbook(fis);
 DataFormatter format=new DataFormatter();
	 int sheets=workbook.getNumberOfSheets();
	 
	 for(int i=0;i<sheets;i++)
	 {
	 if(workbook.getSheetName(i).equalsIgnoreCase(sheetName))
	 {
	 sheet=workbook.getSheetAt(i);
	 }}
	 //Identify Testcases coloum by scanning the entire 1st row
	 int rownum=sheet.getLastRowNum();
//	 int count=1;
//	 int column=sheet.getRow(0).getPhysicalNumberOfCells();
//	 int actualColumn=column-1;
//	 Object[][] obj=new Object[rownum][];
	 for(int k=1;k<=rownum;k++) {
		
			Row row=sheet.getRow(k);
			Cell cell=row.getCell(column);
			if(format.formatCellValue(cell).isEmpty()) {
			row.createCell(column).setCellValue(testcaseResult);
			FileOutputStream out=new FileOutputStream(filepath);
			workbook.write(out);
			out.close();
			break;
	 }
		 else {
			 continue;
		 }
		 }}

}
