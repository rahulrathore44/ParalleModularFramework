/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package com.modular.parallel.helper.HyperLink;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.modular.parallel.helper.Generic.GenericHelper;

/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 *
 */
public class LinkHelper extends GenericHelper {

	private WebDriver driver;

	public LinkHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		System.err.println("LinkHelper : " + this.driver.hashCode());
	}
	
	public void clickLink(String linkText) {
		getElement(By.linkText(linkText)).click();
	}
	
	public void clickPartialLink(String partialLinkText) {
		getElement(By.partialLinkText(partialLinkText)).click();
	}
	
	public String getHyperLink(By locator){
		return getHyperLink(getElement(locator));
	}
	
	public String getHyperLink(WebElement element) {
		return element.getAttribute("hreg");
	}
}
