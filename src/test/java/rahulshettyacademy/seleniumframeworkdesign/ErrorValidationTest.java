package rahulshettyacademy.seleniumframeworkdesign;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacademy.testcomponent.BaseTest;
import rahulshettyacademy.testcomponent.Retry;

public class ErrorValidationTest extends BaseTest{
	String sheetName;
	@Test(dataProvider="ErrorData",groups= {"errorHandling"},retryAnalyzer=Retry.class)
	public void incorrectCredentials(String username,String password) throws IOException, InvalidFormatException {
		
		getSheetName("ErrorData",3);
		lp.login(username ,password);
		
		String mesg=lp.getErrorMesg();
		Assert.assertEquals(mesg, "Incorrect email or password.");
		
	}
	
	
	 @DataProvider(name="ErrorData")
	 
	 public Object[][] getData() throws IOException{
	sheetName="ErrorData";
	Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//rahulshettydata//EXcelTestData.xlsx",sheetName);	 
	return d;
	 }
	

	  
	
}
