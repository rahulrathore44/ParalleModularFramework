/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.modular.parallel.interfaces;

import com.modular.parallel.configuration.browser.BrowserType;



/**
 * @author rsr
 *
 * Aug 6, 2016
 */
public interface IconfigReader {
	public String getUserName();
	public String getPassword();
	public String getWebsite();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
}
