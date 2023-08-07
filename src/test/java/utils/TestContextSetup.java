package utils;

import java.io.IOException;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network;
import org.openqa.selenium.devtools.v114.network.model.ConnectionType;

import mainPageObject.TravelHomePage;


public class TestContextSetup {

	public WebDriver driver;
	
	public TravelHomePage travelHomePage;
	public TestBase testBase;
//	public Highlighter highlighter;
	public GenericUtils genericUtils;

	
	public TestContextSetup() throws IOException
	{
		testBase = new TestBase();
		travelHomePage = new TravelHomePage(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());
		
       DevTools devTools = ((ChromeDriver) testBase.WebDriverManager()).getDevTools();
		
		devTools.createSession();
		
		//send command to CDP Methods-> CDP Methods will invoke and get access to chrome dev tools
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		
		devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
		
		devTools.addListener(Network.loadingFailed(), loadingFailed->
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());
			
			
		});
	}
		

	}
	

