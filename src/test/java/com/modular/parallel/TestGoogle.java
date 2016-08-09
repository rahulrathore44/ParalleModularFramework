/**
 * rsr 
 *
 *Aug 5, 2016
 */
package com.modular.parallel;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;

/**
 * @author rsr
 *
 * Aug 5, 2016
 */
public class TestGoogle extends TestCaseBase {
	
	@Test
	public void testGoogle() throws Exception {
		getDriver().navigate().to("https://www.google.com/");
		txtBox.sendKeys(By.xpath("//input[@name='q']"), "Selenium");
		button.click(By.xpath("//button[@value='Search']"));
		Thread.sleep(3000);
	}
	
	@Test
	public void testConfirm() {
		getDriver().get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		wait.waitForIframe(By.id("iframeResult"), getConfigReader().getExplicitWait(), 300);
		browser.switchToFrame(By.id("iframeResult"));
		button.click(By.xpath("html/body/button"));
		alert.AcceptAlertIfPresent();
		Assert.assertEquals(txtBox.getText(By.id("demo")),"You pressed OK!");
		button.click(By.xpath("html/body/button"));
		alert.DismissAlertIfPresent();
		Assert.assertEquals(txtBox.getText(By.id("demo")),"You pressed Cancel!");
		getDriver().switchTo().defaultContent();
	}
	

}
