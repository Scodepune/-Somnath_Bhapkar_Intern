package com.rhsv1.utilities.ExtentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rhsv1.testCases.RHSBase;

public class ExtentReporting extends RHSBase implements ITestListener {

	public ExtentReports extentReports;
	public ExtentSparkReporter sparkReporter;
	public ExtentTest logger;
	public String reportName;

	public void onStart(ITestContext iTestContext) {

		DateTimeFormatter formatedDateTime = DateTimeFormatter.ofPattern("ddMMYY_HHmmss");
		String timeStampString = LocalDateTime.now().format(formatedDateTime);

		 reportName = "./test-output/test-report/Test-Report_"+ timeStampString + ".html";
		
		sparkReporter = new ExtentSparkReporter(reportName);
		/*
		 * try {
		 * sparkReporter.loadXMLConfig("./rhsv1/Configuration/ExtentReportConfig.xml");
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("HostName", "localhost");
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("user", "Gangad");

	}

	public void onTestSuccess(ITestResult iTestResult) {

		logger = extentReports.createTest(iTestResult.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult iTestResult) {

		logger = extentReports.createTest(iTestResult.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.RED));

		DateTimeFormatter formatedDateTime = DateTimeFormatter.ofPattern("ddMMYY_HHmmss");
		String timeStampString = LocalDateTime.now().format(formatedDateTime);

		// iTestResult.getMethod().getMethodName(); points the exact method of the test
		// where the test failed
		String screenShotName = iTestResult.getMethod().getMethodName() + timeStampString + ".png";
		String screenShotPath = "./Screenshots/" + screenShotName;
		System.out.println(screenShotPath);
		
		try {
			captureScreenShot(iTestResult.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		logger.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath, iTestResult.getName()).build());

	}

	public void onTestSkipped(ITestResult iTestResult) {

		logger = extentReports.createTest(iTestResult.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.ORANGE));

	}

	public void onFinish(ITestContext iTestContext) {

		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File(reportName).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
