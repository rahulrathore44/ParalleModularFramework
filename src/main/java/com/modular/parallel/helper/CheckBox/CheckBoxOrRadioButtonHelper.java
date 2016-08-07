/**
 * @author rahul.rathore
 *	
 *	06-Aug-2016
 */
package com.modular.parallel.helper.CheckBox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.modular.parallel.interfaces.IwebComponent;

/**
 * @author rahul.rathore
 *
 *         06-Aug-2016
 *
 */
public class CheckBoxOrRadioButtonHelper implements IwebComponent {
	private WebDriver driver;

	public CheckBoxOrRadioButtonHelper(WebDriver driver) {
		this.driver = driver;
		System.err.println("CheckBoxOrRadioButtonHelper : " + this.driver.hashCode());
	}
	
	public void selectCheckBox(By locator) {
		selectCheckBox(driver.findElement(locator));
	}
	
	public void unSelectCheckBox(By locator) {
		unSelectCheckBox(driver.findElement(locator));
	}
	
	public boolean isIselected(By locator) {
		return isIselected(driver.findElement(locator));
	}
	
	public boolean isIselected(WebElement element) {
		boolean flag = element.isSelected();
		return flag;
	}
	
	public void selectCheckBox(WebElement element) {
		if(!isIselected(element))
			element.click();
	}
	
	public void unSelectCheckBox(WebElement element) {
		if(isIselected(element))
			element.click();
	}

}
