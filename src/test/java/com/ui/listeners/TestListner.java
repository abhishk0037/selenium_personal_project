package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ui.utilities.BrowserUtility;
import com.ui.utilities.ExtentReporterUtility;
import com.ui.utilities.LoggerUtility;

public class TestListner implements ITestListener {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	public void onStart(ITestContext context) {
		logger.info("test suite started");
		ExtentReporterUtility.setupSparkReporter("report.html");
	}
	
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
		}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentTest test=ExtentReporterUtility.getTest();
		test.log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
   
		logger.info("capturing screenshot of the failed test cases");
		String screenshotPath = BrowserUtility.takeScreenShot(result.getMethod().getMethodName());
		logger.info("Attaching the screenshot to the HTML file");
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
	}
	
	public void onFinish(ITestContext context) {
		logger.info("test suite completed");
		ExtentReporterUtility.flushReport();
	}

}

