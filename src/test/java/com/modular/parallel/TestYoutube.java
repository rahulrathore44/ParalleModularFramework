package com.modular.parallel;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;


/**
 * Unit test for simple App.
 */
public class TestYoutube extends TestCaseBase {
	
	@Test
	public void name() throws Exception {
		getDriver().navigate().to("https://www.youtube.com/");
		getDriver().findElement(By.xpath("//button//span[text()='Sign in']")).click();
		Thread.sleep(5000);
	}
	
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
   
}
