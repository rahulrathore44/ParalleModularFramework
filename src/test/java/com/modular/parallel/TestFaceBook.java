/**
 * rsr 
 *
 *Aug 5, 2016
 */
package com.modular.parallel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;

/**
 * @author rsr
 *
 * Aug 5, 2016
 */
public class TestFaceBook extends TestCaseBase{
	
	@Test
	public void testFacebook() throws Exception {
		getDriver().navigate().to("https://www.facebook.com/");
		getDriver().findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(6000);
	}
	

	@Test
	public void testScrollTo() throws IOException {
		getDriver().get("https://www.udemy.com/");
		javaScript.scrollToElemet(By.xpath("//a[text()='Sign Up' and @class='signup-link btn btn-success signup-btn mt20']"));
		javaScript.scrollIntoView(By.xpath("//a[text()='Sign Up' and @class='dropdown__main-link']"));
	}
	
}
