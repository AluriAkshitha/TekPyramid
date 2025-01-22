package com.vtiger.ListenorUtility;

import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Amazon.generic.webdriverutility.UtilityClassObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.BaseClassUtility.BaseTest;

public class Listener implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public ExtentTest test;

	public void onStart(ISuite suite) {
		// Create the SparkReport
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReports/report" + time + ".html");

		// Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the Learning Selenium Page");
		spark.config().setReportName("RegressionSuite||Verification of Welcome Page");
		spark.config().setTheme(Theme.STANDARD);

		// Create the Extent Report
		report = new ExtentReports();

		// Attach the spark report and Extent Report
		report.attachReporter(spark);

		// Configure the System Information
		report.setSystemInfo("DeviceName", "Akshitha");
		report.setSystemInfo("OperatingSystems", "WINDOWS 11");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("BrowserVersion", "chrome-128.0.6613.85");
	}

	public void onFinish(ISuite suite) {
		System.out.println("BackUping the report");
		if (report != null) {
		report.flush();
	}
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("=====" + result.getMethod().getMethodName() + "=====start=====");
		test = report.createTest(result.getMethod().getMethodName());
		// once the test object is created
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "==>started<==");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=====" + result.getMethod().getMethodName() + "====end======");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==>completed<==");
	}

	public void onTestFailure(ITestResult result) {
		if (test != null) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseTest.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(filepath, testName + " " + time);

		test.log(Status.FAIL, result.getMethod().getMethodName() + "======>failed");

	}
	 else {
        System.out.println("ExtentTest object is null for method: " + result.getMethod().getMethodName());
    }
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName() + "==>skipped<==");

	}

}
