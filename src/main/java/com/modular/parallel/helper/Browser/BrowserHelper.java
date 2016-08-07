/**
 * @author rahul.rathore
 *	
 *	06-Aug-2016
 */
package com.modular.parallel.helper.Browser;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.modular.parallel.interfaces.IwebComponent;

/**
 * @author rahul.rathore
 *
 *         06-Aug-2016
 *
 */
public class BrowserHelper implements IwebComponent {

	private WebDriver driver;

	public BrowserHelper(WebDriver driver) {
		this.driver = driver;
		System.err.println("BrowserHelper : " + this.driver.hashCode());
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void goForward() {
		driver.navigate().forward();
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public Set<String> getWindowHandlens() {
		return driver.getWindowHandles();
	}

	public void SwitchToWindow(int index) {

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());

		if (index < 0 || index > windowsId.size())
			throw new IllegalArgumentException("Invalid Index : " + index);

		driver.switchTo().window(windowsId.get(index));
	}

	public void switchToParentWindow() {
		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());
		driver.switchTo().window(windowsId.get(0));
	}

	public void switchToParentWithChildClose() {
		switchToParentWindow();

		LinkedList<String> windowsId = new LinkedList<String>(
				getWindowHandlens());

		for (int i = 1; i < windowsId.size(); i++) {
			driver.switchTo().window(windowsId.get(i));
			driver.close();
		}

		switchToParentWindow();
	}

}
