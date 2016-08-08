/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;

/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public class TestJavaScript extends TestCaseBase {
	
	
	@Test
	public void testGetAlertText() {
		getDriver().get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		wait.waitForIframe(By.id("iframeResult"), getConfigReader().getExplicitWait(), 300);
		browser.switchToFrame(By.id("iframeResult"));
		button.click(By.xpath("html/body/button"));
		Assert.assertEquals(alert.getAlertText(),"Please enter your name");
		alert.AcceptPrompt("Harry Potter");
		button.click(By.xpath("html/body/button"));
		alert.DismissAlertIfPresent();
		getDriver().switchTo().defaultContent();
	}
	
	@Test
	public void testPromt() {
		getDriver().get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		wait.waitForIframe(By.id("iframeResult"), getConfigReader().getExplicitWait(), 300);
		browser.switchToFrame(By.id("iframeResult"));
		button.click(By.xpath("html/body/button"));
		alert.AcceptPrompt("Harry Potter");
		button.click(By.xpath("html/body/button"));
		alert.DismissAlertIfPresent();
		getDriver().switchTo().defaultContent();
	}
	
	
	
	@Test
	public void testScrollToAncClick() throws IOException, InterruptedException {
		getDriver().get("https://www.udemy.com/");
		javaScript.scrollToElemetAndClick(wait.handleStaleElement(By.xpath("//a[text()='Sign Up' and @class='signup-link btn btn-success signup-btn mt20']"), 5, 2));
		wait.takeScreenShot("testScrollToClick");
		browser.goBack();
		browser.goForward();
		javaScript.scrollIntoViewAndClick(wait.handleStaleElement(By.xpath("//a[text()='Sign Up' and @class='dropdown__main-link']"), 5, 2));
		wait.takeScreenShot("testScrollIntoViewClick");
	}

}
