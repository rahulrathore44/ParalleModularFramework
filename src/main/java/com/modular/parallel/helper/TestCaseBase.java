/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel.helper;

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
import com.modular.parallel.settings.ObjectRepo;

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
			button = new ButtonHelper(getDriver());
			alert = new AlertHelper(getDriver());
			javaScript = new JavaScriptHelper(getDriver());
			browser = new BrowserHelper(getDriver());
			chkBox = new CheckBoxOrRadioButtonHelper(getDriver());
			wait = new WaitHelper(getDriver(), getConfigReader());
			dropDown = new DropDownHelper(getDriver());
			link = new LinkHelper(getDriver());
			navigate = new NavigationHelper(getDriver());
			txtBox = new TextBoxHelper(getDriver());
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
		ObjectRepo.data.add(getDriver());		
	}
}