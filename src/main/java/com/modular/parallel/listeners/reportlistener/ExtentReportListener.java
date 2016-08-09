/**
 * rsr 
 *
 *Aug 8, 2016
 */
package com.modular.parallel.listeners.reportlistener;

import org.apache.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.modular.parallel.helper.Generic.GenericHelper;
import com.modular.parallel.helper.Logger.LoggerHelper;
import com.modular.parallel.settings.ObjectRepo;
import com.modular.parallel.utility.DateTimeHelper;
import com.modular.parallel.utility.ResourceHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author rsr
 *
 * Aug 8, 2016
 */
public class ExtentReportListener implements ISuiteListener, ITestListener {

	public final Logger log = LoggerHelper
			.getLogger(ExtentReportListener.class);

	private volatile ExtentReports exReport = null;
	private volatile ExtentTest exTest = null;

	public void onFinish(ISuite arg0) {
		exReport.endTest(exTest);
		try {
			exReport.flush();
		} finally {
			exReport.close();
		}
	}

	public void onStart(ISuite suite) {
		exReport = new ExtentReports(
				ResourceHelper.getResourcePath("reports/extentreport/")
						+ suite.getName() + DateTimeHelper.getCurrentDateTime()
						+ ".html");
		exTest = exReport.startTest(suite.getName());

	}

	public void onFinish(ITestContext test) {
	}

	public void onStart(ITestContext test) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	public void onTestFailure(ITestResult test) {
		exTest.log(LogStatus.FAIL, test.getTestClass().getName() + "." + test.getMethod().getMethodName());
		exTest.log(LogStatus.FAIL, test.getThrowable());
		try {
			String src = new GenericHelper(ObjectRepo.data.get(Thread.currentThread().getName()+Thread.currentThread().getId())).takeScreenShot(test.getMethod().getMethodName());
			exTest.log(LogStatus.INFO, exTest.addScreenCapture( src == null ? "" : src ));
		}catch (Exception e) {
			log.error("Cannot Add the ScreenShot", e);
		}
	}

	public void onTestSkipped(ITestResult arg0) {
	}

	public void onTestStart(ITestResult arg0) {
	}

	public void onTestSuccess(ITestResult test) {
		exTest.log(LogStatus.PASS, test.getTestClass().getName() + "." + test.getMethod().getMethodName());
	}

}
