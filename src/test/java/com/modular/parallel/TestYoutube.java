package com.modular.parallel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;

public class TestYoutube extends TestCaseBase {
	
	@Test
	public void name() throws Exception {
		getDriver().navigate().to("https://www.youtube.com/");
		getDriver().findElement(By.xpath("//button//span[text()='Sign in']")).click();
		Thread.sleep(5000);
	}
	
	
   
}
