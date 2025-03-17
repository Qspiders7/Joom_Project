package com.joom.automation.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.joom.automation.WebDriverUtility.UtilityClassObject;
import com.joom.automation.baseutility.BaseClassForUser;

public class ListImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Extentreport Configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("Joom test suite results");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Browser", "Chrome");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		System.out.println("Report:"+report+" test:"+test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "===>STARTED<===");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println("==== ====>" + result.getMethod().getMethodName() + "<===END====");
		
		test.log(Status.PASS,result.getMethod().getMethodName()+"===>COMPLETED<===");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClassForUser.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromBase64String(temp, testname + "_" + time);

		test.log(Status.FAIL, result.getMethod().getMethodName() + "===>FAILED<===");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

}
