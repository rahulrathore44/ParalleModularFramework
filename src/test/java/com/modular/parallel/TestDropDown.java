/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 */
package com.modular.parallel;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;

/**
 * @author rahul.rathore
 *	
 *	07-Aug-2016
 *
 */
public class TestDropDown extends TestCaseBase {

	@Test
	public void dropDownTest() {
		getDriver().get("http://phptravels.net/");
		wait.elementExistAndVisible(By.xpath("//div[@id='HOTELS']//select[@name='adults']"), getConfigReader().getExplicitWait(), 250);
		dropDown.SelectUsingVisibleValue(By.xpath("//div[@id='HOTELS']//select[@name='adults']"), "4");
		dropDown.SelectUsingVisibleValue(By.xpath("//div[@id='HOTELS']//select[@name='child']"), "5");
		Assert.assertEquals(dropDown.getSelectedValue(By.xpath("//div[@id='HOTELS']//select[@name='adults']")), "4");
		Assert.assertEquals(dropDown.getSelectedValue(By.xpath("//div[@id='HOTELS']//select[@name='child']")), "5");
		javaScript.scrollIntoView(By.xpath("//li[@data-title='DOHOP']//a[normalize-space()='Flights']"));
		button.click(By.xpath("//li[@data-title='DOHOP']//a[normalize-space()='Flights']"));
		wait.elementExistAndVisible(By.id("trip"), getConfigReader().getExplicitWait(), 300);
		dropDown.SelectUsingVisibleValue(By.id("trip"), "Round Trip");
		Assert.assertEquals(dropDown.getSelectedValue(By.id("trip")), "Round Trip");
		
	}
	
	@Test
	public void linkHelperTest() {
		getDriver().get("https://www.pluralsight.com/");
		wait.elementExistAndVisible(By.partialLinkText("Business"), getConfigReader().getExplicitWait(), 250);
		link.clickPartialLink("Business");
		Assert.assertEquals(getDriver().getTitle(), "Group Plans | Pluralsight");
	}
}
