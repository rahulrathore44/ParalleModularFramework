/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel.helper.Javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.modular.parallel.interfaces.IwebComponent;

/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public class JavaScriptHelper implements IwebComponent {
	
private WebDriver driver;
	
	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		System.err.println("JavaScriptHelper : " + this.driver.hashCode());
	}
	
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])",
				element.getLocation().x, element.getLocation().y);
	}

	public void scrollToElemet(By locator) {
		scrollToElemet(driver.findElement(locator));
	}

	public void scrollToElemetAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollToElemet(element);
		element.click();
	}

	public void scrollToElemetAndClick(WebElement element) {
		scrollToElemet(element);
		element.click();
	}

	public void scrollIntoView(WebElement element) {
		executeScript("arguments[0].scrollIntoView()", element);
	}

	public void scrollIntoView(By locator) {
		scrollIntoView(driver.findElement(locator));
	}

	public void scrollIntoViewAndClick(By locator) {
		WebElement element = driver.findElement(locator);
		scrollIntoView(element);
		element.click();
	}

	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
	}
}
