/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package com.modular.parallel.helper.TextBox;

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
public class TextBoxHelper extends GenericHelper {

	private WebDriver driver;
	
	public TextBoxHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		System.err.println("TextBoxHelper : " + this.driver.hashCode());
	}
	
	public void sendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void clear(By locator) {
		getElement(locator).clear();
	}
	
	public String getText(By locator) {
		return getElement(locator).getText();
	}
	
	public void clearAndSendKeys(By locator,String value) {
		WebElement element =  getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

}
