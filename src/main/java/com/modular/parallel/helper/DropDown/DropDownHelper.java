/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package com.modular.parallel.helper.DropDown;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.modular.parallel.helper.Generic.GenericHelper;

/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 *
 */
public class DropDownHelper extends GenericHelper {
	
	private WebDriver driver;

	public DropDownHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		System.err.println("DropDownHelper : " + this.driver.hashCode());
	}
	
	public void SelectUsingVisibleValue(By locator,String visibleValue) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleValue);
	}
	
	public void SelectUsingValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public void SelectUsingIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	public String getSelectedValue(By locator) {
		return getSelectedValue(getElement(locator));
	}
	
	public String getSelectedValue(WebElement element) {
		return new Select(element).getFirstSelectedOption().getText();
	}
	
	
	public List<String> getAllDropDownValues(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
		
		for (WebElement element : elementList) {
			valueList.add(element.getText());
		}
		return valueList;
	}
}
