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
public class TestGoogle extends InitializeWebDrive {
	
	@Test
	public void name() throws Exception {
		getDriver().navigate().to("https://www.google.com/");
		getDriver().findElement(By.xpath("//input[@value='Google Search']")).click();
		Thread.sleep(6000);
	}

}
