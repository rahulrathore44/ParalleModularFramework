/**
 * @author rahul.rathore
 *	
 *	14-Aug-2016
 */
package com.modular.parallel;

import java.util.Map;

import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;
import com.modular.parallel.helper.DataProvider.DataProviderHelper;
import com.modular.parallel.helper.DataProvider.ExcelFileLocation;
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
		DetailPage dpage = lpage.clickLogin(getConfigReader().getUserName(), getConfigReader().getPassword(),true);
		dpage.waitForElement(dpage.LogoutBtn, getConfigReader().getExplicitWait());
		dpage.LogoutBtn.click();
	}
	
	@Test(dataProvider="getLoginData",dataProviderClass=DataProviderHelper.class)
	@ExcelFileLocation(xlFileName="Login.xlsx",sheetName="LoginDetails")
	public void testDataProviderFromAno(Map<String, Object> map) {
		navigate.navigateTo("http://localhost:5001/");
		HomePage hpage = new HomePage(getDriver());
		LoginPage lpage = hpage.clickNewBug();
		lpage.waitForElement(lpage.LoginTxtBx, getConfigReader().getExplicitWait());
		lpage.clickLogin(map.get("UserName").toString(), map.get("Password").toString(),true);
	}

}
