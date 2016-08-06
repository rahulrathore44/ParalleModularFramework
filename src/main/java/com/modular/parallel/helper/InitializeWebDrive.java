/**
 * rsr 
 *
 *Aug 5, 2016
 */
package com.modular.parallel.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.modular.parallel.configreader.PropertyFileReader;
import com.modular.parallel.configuration.browser.ChromeBrowser;
import com.modular.parallel.configuration.browser.FirefoxBrowser;
import com.modular.parallel.configuration.browser.HtmlUnitBrowser;
import com.modular.parallel.configuration.browser.IExploreBrowser;
import com.modular.parallel.configuration.browser.PhantomJsBrowser;
import com.modular.parallel.exception.NoSutiableDriverFoundException;
import com.modular.parallel.interfaces.IconfigReader;

/**
 * @author rsr
 *
 *         Aug 5, 2016
 */

public abstract class InitializeWebDrive {

	private WebDriver driver;
	private IconfigReader reader;

	protected InitializeWebDrive() {
		reader = new PropertyFileReader();
		try {
			setUpDriver();
		} catch (Exception e) {
		}

	}

	protected InitializeWebDrive(String fileName) {
		reader = new PropertyFileReader(fileName);
		try {
			setUpDriver();
		} catch (Exception e) {
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public IconfigReader getConfigReader() {
		return reader;
	}

	// @BeforeTest
	public void setUpDriver() throws Exception {

		switch (reader.getBrowser()) {

		case Chrome:
			ChromeBrowser chrome = ChromeBrowser.class.newInstance();
			driver = chrome.getChromeDriver(chrome.getChromeCapabilities());
			break;

		case Firefox:
			FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
			driver = firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());
			break;

		case HtmlUnitDriver:
			HtmlUnitBrowser htmlUnit = HtmlUnitBrowser.class.newInstance();
			driver = htmlUnit.getHtmlUnitDriver(htmlUnit
					.getHtmlUnitDriverCapabilities());
			break;

		case Iexplorer:
			IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
			driver = iExplore.getIExplorerDriver(iExplore
					.getIExplorerCapabilities());
			break;

		case PhantomJs:
			PhantomJsBrowser jsBrowser = PhantomJsBrowser.class.newInstance();
			driver = jsBrowser.getPhantomJsDriver(
					jsBrowser.getPhantomJsService(),
					jsBrowser.getPhantomJsCapability());
			break;

		default:
			throw new NoSutiableDriverFoundException(" Driver Not Found : "
					+ reader.getBrowser());
		}
		System.err.println("InitializeWebDrive : " + this.driver.hashCode());
		driver.manage().timeouts()
				.pageLoadTimeout(reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.get(reader.getWebsite());
		driver.manage().window().maximize();
		System.err.println("Driver HashCode : " + driver.hashCode());

	}

	@AfterTest(alwaysRun = true)
	public void tearDownDriver() throws Exception {
		if (driver != null)
			driver.quit();
	}

}
