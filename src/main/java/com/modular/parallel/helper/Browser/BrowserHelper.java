/**
 * @author rahul.rathore
 *	
 *	06-Aug-2016
 */
package com.modular.parallel.helper.Browser;

import java.util.LinkedList;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.modular.parallel.helper.Logger.LoggerHelper;
import com.modular.parallel.interfaces.IwebComponent;

/**
 * @author rahul.rathore
 *
 *         06-Aug-2016
 *
 */
public class BrowserHelper implements IwebComponent {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(BrowserHelper.class);

	public BrowserHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("BrowserHelper : " + this.driver.hashCode());
	}

	public void goBack() {
		driver.navigate().back();
		oLog.info("");
	}

	public void goForward() {
		driver.navigate().forward();
		oLog.info("");
	}

	public void refresh() {
		driver.navigate().refresh();
		oLog.info("");
	}

	public Set<String> getWindowHandlens() {
		oLog.info("");
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());

		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);

		driver.switchTo().window(windowsId.get(index));
		oLog.info(index);
	}

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());
		driver.switchTo().window(windowsId.get(0));
		oLog.info("");
	}

	public void switchToParentWithChildClose() {
		switchToParentWindow();

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());

		for (int i = 1; i < windowsId.size(); i++) {
			oLog.info(windowsId.get(i));
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}

		switchToParentWindow();
	}

}
