package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",monochrome=true,dryRun=false,tags="@Error",glue="rahulshettyacademy.stepdefinition",plugin={"pretty","html:cucumberTarget/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
