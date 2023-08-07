package rahulshettyacademy.seleniumframeworkdesign;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.Checkout;
import rahulshettyacademy.pageobject.Confirmationpage;
import rahulshettyacademy.pageobject.OrderPage;
import rahulshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacademy.testcomponent.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class SubmitOrderTest extends BaseTest {
String productName="ZARA COAT 3";
String sheetName;

 /* @Test(dataProvider="getData",groups= {"purchaseOrder"})
	public void submitorder(HashMap<String,String> input) throws InterruptedException, IOException {
		
		
        ProductCatalogue pc=lp.login(input.get("email"), input.get("password"));
        pc.selectAndAddProducttoCart(input.get("product"));
        CartPage cp=pc.addtoCart();
        boolean b=cp.cartProductVerification(input.get("product"));
        Assert.assertTrue(b);
        Checkout co=cp.checkout();
        co.checkoutOrder();
        Confirmationpage cm=co.confirmOrder();
        String orderid=cm.getOrderID();
        System.out.println(orderid);
	} 
*/

@Test(dataProvider="PurchaseData",groups= {"purchaseOrder"})
	public void submitorder(String email,String password,String product) throws InterruptedException, IOException, InvalidFormatException {
		
	   getSheetName("PurchaseData",4);
	   
       ProductCatalogue pc=lp.login(email,password);
       pc.selectAndAddProducttoCart("Submit Order_Product catalogue Page"+product,product);
       CartPage cp=pc.addtoCart();
       boolean b=cp.cartProductVerification("Submit Order_Cart Page"+product,product);
       Assert.assertTrue(b);
       Checkout co=cp.checkout();
       co.checkoutOrder();
       Confirmationpage cm=co.confirmOrder("Submit Order_Checkout page"+product );
       String orderid=cm.getOrderID("Submit Order_Confirmation Page"+product);
       System.out.println(orderid);
      
	}
 @DataProvider(name="PurchaseData")
 
 public Object[][] getData() throws IOException{
sheetName="PurchaseData";
Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//rahulshettydata//EXcelTestData.xlsx",sheetName);	 
return d;
 }
/*@Test(dependsOnMethods= {"submitorder"})
 public void ordersVerification() throws IOException {
	lp.login("qazplm@gmail.com","Qazplm@890");
	OrderPage op= lp.verifyOrderinOrdersPage();
	boolean b=op.orderValidation(productName);
	Assert.assertTrue(b);
 }*/
 
 /*@DataProvider
 public Object[][] getData() throws IOException{
	 
	HashMap<String,String> map= new HashMap<String,String>();
	 map.put("email", "rahulshetty@gmail.com");
	 map.put("password", "Iamking@000");
	 map.put("product", "ZARA COAT 3");
	 
	 HashMap<String,String> map1= new HashMap<String,String>();
	 map1.put("email", "abcxyz92@gmail.com");
	 map1.put("password", "Abcxyz@123");
	 map1.put("product", "ADIDAS ORIGINAL");
	List<HashMap<String,String>> data=getJSONdata(System.getProperty("user.dir")+"//src//test//java//rahulshettydata//purchaseorder.json");
	 return new Object[][] {{data.get(0)},{data.get(1)}};
	 
 } 
 

 
 */
 
@Test(dataProvider="CartData")
	public void cartValidation(String email,String password,String productName) throws InterruptedException, IOException, InvalidFormatException {
		
	//	String email="abcxyz92@gmail.com",password="Abcxyz@123",productName="ZARA COAT 3";
	 getSheetName("CartData",4);
     ProductCatalogue pc=lp.login(email, password);
     
     pc.selectAndAddProducttoCart("Cart Validation_Product catalogue Page"+productName,productName);
    
     CartPage cp=pc.addtoCart();
     
     boolean b=cp.cartProductVerification("Cart Validation_Cart Page"+productName,productName);
     
     Assert.assertTrue(b);
    
	}

	@DataProvider(name="CartData")
	 
	 public Object[][] geterrorData() throws IOException{
sheetName="CartData";
  Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//rahulshettydata//EXcelTestData.xlsx",sheetName);	 
	 return d;
	 }
	
	
}