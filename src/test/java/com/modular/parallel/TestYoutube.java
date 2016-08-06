package com.modular.parallel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.modular.parallel.helper.InitializeWebDrive;


/**
 * Unit test for simple App.
 */
public class TestYoutube extends InitializeWebDrive {
	
	@Test
	public void name() throws Exception {
		getDriver().navigate().to("https://www.youtube.com/");
		getDriver().findElement(By.xpath("//button//span[text()='Sign in']")).click();
		Thread.sleep(5000);
	}
   
}
