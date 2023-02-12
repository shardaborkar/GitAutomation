package rahulshettyacademy.seleniumframeworkdesign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacademy.testcomponent.BaseTest;
import rahulshettyacademy.testcomponent.Retry;

public class ErrorValidation extends BaseTest{
	@Test(groups= {"errorHandling"},retryAnalyzer=Retry.class)
	public void incorrectCredentials() {
		lp.login("asx@gmail.com" ,"asx123");
		String mesg=lp.getErrorMesg();
		Assert.assertEquals(mesg, "Incorrect email or password.");
	}
	
	@Test(dataProvider="errorTestData")
	public void productError(String email,String password,String productName) throws InterruptedException, IOException {
		
	//	String email="abcxyz92@gmail.com",password="Abcxyz@123",productName="ZARA COAT 3";
        ProductCatalogue pc=lp.login(email, password);
        pc.selectAndAddProducttoCart(productName);
        CartPage cp=pc.addtoCart();
        boolean b=cp.cartProductVerification(productName);
        Assert.assertTrue(b);
       
	}

	@DataProvider(name="errorTestData")
	 
	 public Object[][] getData() throws IOException{
     Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//rahulshettydata//EXcelTestData.xlsx","ErrorTestData");	 
	 return d;
	 }
	 
	
}
