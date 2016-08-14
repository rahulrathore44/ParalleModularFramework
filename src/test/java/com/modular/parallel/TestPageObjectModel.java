/**
 * @author rahul.rathore
 *	
 *	14-Aug-2016
 */
package com.modular.parallel;

import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;
import com.modular.parallel.helper.PageObject.BugzilaPage.DetailPage;
import com.modular.parallel.helper.PageObject.BugzilaPage.HomePage;
import com.modular.parallel.helper.PageObject.BugzilaPage.LoginPage;

/**
 * @author rahul.rathore
 *	
 *	14-Aug-2016
 *
 */
public class TestPageObjectModel extends TestCaseBase {
	
	@Test
	public void testPageObject() {
		navigate.navigateTo("http://localhost:5001/");
		HomePage hpage = new HomePage(getDriver());
		LoginPage lpage = hpage.clickNewBug();
		lpage.waitForElement(lpage.LoginTxtBx, getConfigReader().getExplicitWait());
		DetailPage dpage = lpage.clickLogin(getConfigReader().getUserName(), getConfigReader().getPassword());
		dpage.waitForElement(dpage.LogoutBtn, getConfigReader().getExplicitWait());
		dpage.LogoutBtn.click();
	}

}
