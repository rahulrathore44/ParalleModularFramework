/**
 * rsr 
 *
 *Aug 5, 2016
 */
package com.modular.parallel.helper;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.modular.parallel.configuration.browser.ChromeBrowser;


/**
 * @author rsr
 *
 * Aug 5, 2016
 */
public class InitializeWebDrive {
	
	private WebDriver driver;
	
	public WebDriver getDriver() {
			return driver;
	}
	
	@BeforeTest
	public void setUpDriver() throws Exception {
		ChromeBrowser browser = ChromeBrowser.class.newInstance();
		driver = browser.getChromeDriver(browser.getChromeCapabilities());
	}
	
	@AfterTest(alwaysRun=true)
	public void tearDownDriver() throws Exception {
		if(driver != null)
			driver.quit();
	}

	

}
