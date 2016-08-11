/**
 * @author rahul.rathore
 *	
 *	11-Aug-2016
 */
package com.modular.parallel.helper.DataProvider;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

import com.modular.parallel.helper.ExcelReader.ExcelReaderHelper;
import com.modular.parallel.helper.Logger.LoggerHelper;
import com.modular.parallel.interfaces.IdataReader;
import com.modular.parallel.utility.ResourceHelper;


/**
 * @author rahul.rathore
 *
 *         11-Aug-2016
 *
 */
public class DataProviderHelper {

	public static final Logger log = LoggerHelper
			.getLogger(DataProviderHelper.class);

	@DataProvider(name = "getLoginData")
	public static Object[][] getLoginData() throws Exception {
		log.info("Data Provider");
		IdataReader helper = new ExcelReaderHelper(
				ResourceHelper.getResourcePath("exceldata/Login.xlsx"));
		return helper.getData("LoginDetails");
	}

	@DataProvider(name = "getLoginDatafromAno")
	public static Object[][] getLoginDatafromAno(Method mth) throws Exception {
		log.info("Data Provider");
		ExcelFileLocation location = mth.getAnnotation(ExcelFileLocation.class);
		IdataReader helper = new ExcelReaderHelper(
				ResourceHelper.getResourcePath("exceldata/"
						+ location.xlFileName()));
		return helper.getData(location.sheetName());
	}

}
