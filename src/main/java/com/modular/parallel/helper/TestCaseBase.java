/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel.helper;

import org.openqa.selenium.WebDriver;

import com.modular.parallel.helper.Alert.AlertHelper;
import com.modular.parallel.helper.Browser.BrowserHelper;
import com.modular.parallel.helper.Button.ButtonHelper;
import com.modular.parallel.helper.CheckBox.CheckBoxOrRadioButtonHelper;
import com.modular.parallel.helper.DropDown.DropDownHelper;
import com.modular.parallel.helper.HyperLink.LinkHelper;
import com.modular.parallel.helper.Javascript.JavaScriptHelper;
import com.modular.parallel.helper.Navigation.NavigationHelper;
import com.modular.parallel.helper.TextBox.TextBoxHelper;
import com.modular.parallel.helper.Wait.WaitHelper;
import com.modular.parallel.interfaces.IconfigReader;

/**
 * @author rsr
 *
 *         Aug 6, 2016
 */
public class TestCaseBase extends InitializeWebDrive {

	protected ButtonHelper button;
	protected AlertHelper alert;
	protected JavaScriptHelper javaScript;
	protected BrowserHelper browser;
	protected CheckBoxOrRadioButtonHelper chkBox;
	protected WaitHelper wait;
	protected DropDownHelper dropDown;
	protected LinkHelper link;
	protected NavigationHelper navigate;
	protected TextBoxHelper txtBox;

	void initializeComponent() throws Exception {
		try {
			button = ButtonHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			alert = AlertHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			javaScript = JavaScriptHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			browser = BrowserHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			chkBox = CheckBoxOrRadioButtonHelper.class.getConstructor(
					WebDriver.class).newInstance(getDriver());
			wait = WaitHelper.class.getConstructor(WebDriver.class,
					IconfigReader.class).newInstance(getDriver(),
					getConfigReader());
			dropDown = DropDownHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			link = LinkHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			navigate = NavigationHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			txtBox = TextBoxHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
		} catch (Exception e) {
			throw e;
		}
	}

	public TestCaseBase() {
		try {
			initializeComponent();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}