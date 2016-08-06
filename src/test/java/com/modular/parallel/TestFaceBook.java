/**
 * rsr 
 *
 *Aug 5, 2016
 */
package com.modular.parallel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.modular.parallel.helper.InitializeWebDrive;

/**
 * @author rsr
 *
 * Aug 5, 2016
 */
public class TestFaceBook extends InitializeWebDrive{
	
	@Test
	public void name() throws Exception {
		getDriver().navigate().to("https://www.facebook.com/");
		getDriver().findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(6000);
	}
}
