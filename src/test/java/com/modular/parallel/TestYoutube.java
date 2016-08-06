package com.modular.parallel;

import org.openqa.selenium.By;
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
		getDriver().get("http://www.google.com");
		javaScript.executeScript("alert('Please enter your name');");
		System.out.println(alert.getAlertText());
		alert.AcceptAlertIfPresent();
	}
   
}
