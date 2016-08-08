/**
 * rsr 
 *
 *Aug 8, 2016
 */
package com.modular.parallel;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;

/**
 * @author rsr
 *
 * Aug 8, 2016
 */
public class TestAlert extends TestCaseBase {
	
	@Test
	public void testAlert() {
		getDriver().get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		wait.waitForIframe(By.id("iframeResult"), getConfigReader().getExplicitWait(), 300);
		browser.switchToFrame(By.id("iframeResult"));
		button.click(By.xpath("html/body/button"));
		Assert.assertEquals(alert.getAlertText(),"I am an alert box!");
		alert.AcceptAlertIfPresent();
		getDriver().switchTo().defaultContent();
	}
	
	@Test
	public void testBlert() {
		getDriver().get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		wait.waitForIframe(By.id("iframeResult"), getConfigReader().getExplicitWait(), 300);
		browser.switchToFrame(By.id("iframeResult"));
		button.click(By.xpath("html/body/button"));
		Assert.assertEquals(alert.getAlertText(),"I am an alert box!");
		alert.AcceptAlertIfPresent();
		getDriver().switchTo().defaultContent();
	}


}
