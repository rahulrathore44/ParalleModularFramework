/**
 * rsr 
 *
 *Aug 13, 2016
 */
package com.modular.parallel;

import java.util.Map;

import org.testng.annotations.Test;

import com.modular.parallel.helper.TestCaseBase;
import com.modular.parallel.helper.DataProvider.DataProviderHelper;
import com.modular.parallel.helper.DataProvider.ExcelFileLocation;

/**
 * @author rsr
 *
 * Aug 13, 2016
 */
public class TestDataProviderClass extends TestCaseBase {
	
	@Test(dataProvider="getLoginData",dataProviderClass=DataProviderHelper.class)
	public void testDataProvider(Map<String, Object> data) {
		for (String key : data.keySet()) {
			System.out.println(data.get(key));
		}
	}
	
	@Test(dataProvider="getLoginData",dataProviderClass=DataProviderHelper.class)
	@ExcelFileLocation(xlFileName="Login.xlsx",sheetName="LoginDetails")
	public void testDataProviderFromAno(Map<String, Object> data) {
		for (String key : data.keySet()) {
			System.out.println(data.get(key));
		}
	}


}
