package rahulshettyacademy.stepdefinition;

import java.io.IOException;
import java.util.List;

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
@Before()
//@Given("User landed on the landing page")
public void ecomerceLandingPage() throws IOException {
	landingpage=launchApp();
	}
@After()
public void closeBrowser()
{
	StepDefinition sd=new StepDefinition();
	sd.tearDown();
}
@Given("^User is logged in with username (.+) and password (.+)$")
public void login(String username,String password) {
	
	pc=landingpage.login(username, password);
}





@When("^User add the product (.+) to cart$")
public void addProductToCart(String productName) {
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

@Then("order is placed and order id is generated successfully")
public void submitorder() {
	String orderid=cm.getOrderID();
    System.out.println(orderid);
}

@Then ("{string} message is displayed")
public void errorvalidation(String error) {
	String mesg=landingpage.getErrorMesg();
	Assert.assertEquals(mesg, error);
}

}
