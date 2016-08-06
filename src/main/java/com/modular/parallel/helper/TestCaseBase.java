/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel.helper;

import org.openqa.selenium.WebDriver;

import com.modular.parallel.helper.Alert.AlertHelper;
import com.modular.parallel.helper.Button.ButtonHelper;
import com.modular.parallel.helper.Javascript.JavaScriptHelper;

/**
 * @author rsr
 *
 *         Aug 6, 2016
 */
public class TestCaseBase extends InitializeWebDrive {

	protected ButtonHelper button;
	protected AlertHelper alert;
	protected JavaScriptHelper javaScript;

	void initializeComponent() throws Exception {
		try {
			button = ButtonHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			alert = AlertHelper.class.getConstructor(WebDriver.class)
					.newInstance(getDriver());
			javaScript = JavaScriptHelper.class.getConstructor(WebDriver.class)
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