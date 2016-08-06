/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel.helper.Button;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.modular.parallel.interfaces.IwebComponent;

/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public class ButtonHelper implements IwebComponent {
	
	private WebDriver driver;
	
	public ButtonHelper(WebDriver driver) {
		this.driver = driver;
		System.err.println("Button Helper : " + this.driver.hashCode());
	}
	
	public void click(By locator) {
		click(driver.findElement(locator));
	}
	
	public void click(WebElement element){
		element.click();
	}
}
