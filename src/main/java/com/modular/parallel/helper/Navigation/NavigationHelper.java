/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package com.modular.parallel.helper.Navigation;

import java.net.URL;

import org.openqa.selenium.WebDriver;

import com.modular.parallel.interfaces.IwebComponent;

/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 *
 */
public class NavigationHelper implements IwebComponent {
	
	private WebDriver driver;

	public NavigationHelper(WebDriver driver) {
		this.driver = driver;
		System.err.println("NavigationHelper : " + this.driver.hashCode());
	}
	
	public void navigateTo(String url) {
		driver.get(url);
	}

	public void naviagteTo(URL url) {
		driver.get(url.getPath());
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	

}
