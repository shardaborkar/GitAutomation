/*package rahulshettyacademy.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import rahulshettyacademy.pageobject.CartPage;
import rahulshettyacademy.pageobject.Checkout;
import rahulshettyacademy.pageobject.Confirmationpage;
import rahulshettyacademy.pageobject.LandingPage;
import rahulshettyacademy.pageobject.ProductCatalogue;
import rahulshettyacademy.testcomponent.BaseTest;

public class StepDefinition extends BaseTest {

LandingPage landingpage;
ProductCatalogue pc;
Confirmationpage cm;
BaseTest bt=new BaseTest();

@Given("User landed on the landing page")
public void ecomerceLandingPage() throws IOException {
	landingpage=bt.launchApp();
	}

@Given("^User is logged in with username (.+) and password (.+)$")
public void login1(String username,String password) throws IOException, InvalidFormatException {
	
	pc=landingpage.login(username, password);
}








@When("^User add the product (.+) to cart$")
public void addProductToCart(String productName) throws IOException {
 pc.selectAndAddProducttoCart(productName);
}

@And("^Checkout (.+) and submit the order$")
public void checkout(String product) throws InterruptedException {
    CartPage cp=pc.addtoCart();
    boolean b=cp.cartProductVerification(product);
    Assert.assertTrue(b);
    Checkout co=cp.checkout();
    co.checkoutOrder();
    cm=co.confirmOrder();
    
}
@Then ("{string} message is displayed")
public void errorvalidation(String error) {
	String mesg=landingpage.getErrorMesg();
	Assert.assertEquals(mesg, error);
}





@Then("order is placed and order id is generated successfully")
public void submitorder() throws IOException, InvalidFormatException {
	
	String orderid=cm.getOrderID();
    System.out.println(orderid);
}

@After()
public void closeBrowser() {
	bt.tearDown();
}





@Given("User is logged in and checkout with below details")
public void login2(DataTable data) throws IOException, InterruptedException, InvalidFormatException {
	List<Map<String, String>> testdata= data.asMaps(String.class,String.class);
	
	pc=landingpage.login(testdata.get(0).get("name"), testdata.get(0).get("password"));
	 pc.selectAndAddProducttoCart(testdata.get(0).get("productName"));
	 CartPage cp=pc.addtoCart();
	    
	    boolean b=cp.cartProductVerification(testdata.get(0).get("productName"));
	    Assert.assertTrue(b);
	    Checkout co=cp.checkout();
	    co.checkoutOrder();
	    cm=co.confirmOrder();
	    
	   
}

@Given("User is logged in and checkout with below details")
public void login2(DataTable data) throws IOException, InterruptedException {
	Map<String, String> testdata= data.asMap(String.class,String.class);
	
	System.out.println(testdata);
}
@Given("User is logged in and checkout with below details")
public void login2(DataTable data) throws IOException, InterruptedException {
	Map<String, String> testdata= data.asMap(String.class,String.class);
	
	System.out.println(testdata);
}

@Given("User is logged in and checkout with below details")
public void login2(DataTable data) throws IOException, InterruptedException {
	List<List<String>> testdata= data.asLists(String.class);
	
	System.out.println(testdata);
}

@Given("User is logged in and checkout with below details")
public void login2(DataTable data) throws IOException, InterruptedException {
	List<String> testdata= data.asList(String.class);
	
	System.out.println(testdata);
}


@After()
public void closeBrowser() {
	tearDown();
}






@When("User add the product to cart")
public void addProductToCart(DataTable data) throws IOException {
 List<Map<String, String>> testdata= data.asMaps(String.class,String.class);
 for(int i=0;i<testdata.size();i++){
 pc.selectAndAddProducttoCart(testdata.get(i).get("productName"));
}}

@And("Checkout and submit the order")
public void checkout(DataTable data) throws InterruptedException {
	List<Map<String, String>> testdata= data.asMaps(String.class,String.class);
    CartPage cp=pc.addtoCart();
    for(int i=0;i<testdata.size();i++){
    boolean b=cp.cartProductVerification(testdata.get(i).get("productName"));
    Assert.assertTrue(b);
    Checkout co=cp.checkout();
    co.checkoutOrder();
    cm=co.confirmOrder();
    
}}





}
*/

