/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel.helper.Alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.modular.parallel.interfaces.IwebComponent;



/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public class AlertHelper implements IwebComponent{
	
	private WebDriver driver;
	
	public AlertHelper(WebDriver driver) {
		this.driver = driver;
		System.err.println("AlertHelper : " +this.driver.hashCode());
	}
	
	public Alert getAlert() {
		return driver.switchTo().alert();
	}
	
	public void AcceptAlert() {
		getAlert().accept();
	}
	
	public void DismissAlert() {
		getAlert().dismiss();
	}

	public String getAlertText() {
		String text = getAlert().getText();
		return text;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			// Ignore
			return false;
		}
	}

	public void AcceptAlertIfPresent() {

		if (!isAlertPresent())
			return;
		AcceptAlert();
	}

	public void DismissAlertIfPresent() {

		if (!isAlertPresent())
			return;
		DismissAlert();
	}
	
	public void AcceptPrompt(String text) {
		
		if (!isAlertPresent())
			return;
		
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
	}
}
