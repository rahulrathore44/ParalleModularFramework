/**
 * rsr 
 *
 *Aug 5, 2016
 */
package com.modular.parallel.helper;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import com.modular.parallel.configreader.PropertyFileReader;
import com.modular.parallel.configuration.browser.ChromeBrowser;
import com.modular.parallel.configuration.browser.FirefoxBrowser;
import com.modular.parallel.configuration.browser.HtmlUnitBrowser;
import com.modular.parallel.configuration.browser.IExploreBrowser;
import com.modular.parallel.configuration.browser.PhantomJsBrowser;
import com.modular.parallel.exception.NoSutiableDriverFoundException;
import com.modular.parallel.helper.Logger.LoggerHelper;
import com.modular.parallel.interfaces.IconfigReader;

/**
 * @author rsr
 *
 *         Aug 5, 2016
 */

public abstract class InitializeWebDrive {

	private WebDriver driver;
	private IconfigReader reader;
	private Logger oLog = LoggerHelper.getLogger(InitializeWebDrive.class);

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

	public void setUpDriver() throws Exception {
		oLog.info(reader.getBrowser());
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
		oLog.info("InitializeWebDrive : " + this.driver.hashCode());
		driver.manage().timeouts()
				.pageLoadTimeout(reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.get(reader.getWebsite());
		driver.manage().window().maximize();

	}

	@AfterTest(alwaysRun = true)
	public void tearDownDriver() throws Exception {
		oLog.info("Shutting Down the driver");
		try {
			if (driver != null)
				driver.quit();
		} catch (Exception e) {
			oLog.error(e);
			throw e;
		}
		
	}

}
