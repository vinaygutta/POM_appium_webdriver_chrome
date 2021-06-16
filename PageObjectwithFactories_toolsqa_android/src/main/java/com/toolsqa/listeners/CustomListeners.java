package com.toolsqa.listeners;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.toolsqa.base.BasePageInit;
import com.toolsqa.utilities.ExcelWriter;
import com.toolsqa.utilities.MonitoringMail;
import com.toolsqa.utilities.RecordingUtility;
import com.toolsqa.utilities.TestConfig;
import com.toolsqa.utilities.Utilities;

public class CustomListeners extends BasePageInit implements ITestListener, ISuiteListener, IReporter {

	public String messageBody;

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult arg0) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentreporttestdesc.log(Status.FAIL,
				arg0.getName().toUpperCase() + " Failed with exception : " + arg0.getThrowable());
		// test.addScreenCaptureFromPath(Utilities.screenshotPath);
		extentreporttestdesc.fail(MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotPath).build());
		extentreporttestdesc.log(Status.INFO, "<a href=\""
				+ Utilities.replaceSpaceEncoded(RecordingUtility.recordedFileName) + "\"> Link to Recording </a> ");

		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName
				+ " height=200 width=200></img></a>");
		// rep.endTest(test);
		extentreport.flush();
		waitSomeTime(10);
		BasePageInit.stopAndroidRecording(arg0);

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

		extentreporttestdesc.log(Status.SKIP, arg0.getName().toUpperCase() + " Skipped the test as the Run mode is NO");
		// rep.endTest(test);
		extentreport.flush();
		waitSomeTime(10);
		BasePageInit.stopAndroidRecording(arg0);
		

	}

	@Override
	public void onTestStart(ITestResult arg0) {

		// extentreporttest =
		// extentreporttestsuite.createNode(arg0.getName().toUpperCase());
		extentreporttest = extentreport.createTest(arg0.getName().toUpperCase());
		extentreporttest.assignCategory(BasePageInit.browser);
		extentreporttestdesc = extentreporttest.createNode(arg0.getMethod().getDescription());
		
		BasePageInit.startAndroidRecording();

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

		extentreporttestdesc.log(Status.PASS, arg0.getName().toUpperCase() + " PASS");
		// test.log(Status.INFO, "<video width=\"320\" height=\"240\" controls> <source
		// src=\"C:\\1INTR.MP4\" type=\"video/mp4\"></video>");
		// extentreporttest.log(Status.INFO, RecordingUtility.recordedFileName);

//		test.log(Status.INFO, "<video width=\"320\" height=\"240\" controls>  <source src="
//				+ Utilities.replaceSpaceEncoded(RecordingUtility.recordedFileName) + " type=\"video/avi\"></video>");

		/*
		 * test.log(Status.INFO, "<EMBED SCR=\"" +
		 * Utilities.replaceSpaceEncoded(RecordingUtility.recordedFileName) + "\" /");
		 */

		extentreporttestdesc.log(Status.INFO, "<a href=\""
				+ Utilities.replaceSpaceEncoded(RecordingUtility.recordedFileName) + "\"> Link to Recording </a> ");

		// rep.endTest(test);
		extentreport.flush();
		
			waitSomeTime(10);
			BasePageInit.stopAndroidRecording(arg0);

	}

	@Override
	public void onFinish(ISuite arg0) {

		closeExtentReportinst();

		MonitoringMail mail = new MonitoringMail();

		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/LiveProject-PageObjectWithFactories/Extent_Report/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
//		} catch (AddressException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onStart(ISuite arg0) {

		initExtentReportConf(arg0.getName());
		// this will initilize one html report for each test ng suite.

	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub

		

		ExcelWriter excelresults = new ExcelWriter(
				System.getProperty("user.dir") + "\\target\\surefire-reports\\excelresults\\testresults.xlsx");
		
//		ExcelWriter excelresults = new ExcelWriter(
//				System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testresults.xlsx");

		excelresults.saveToExcel(suites);

	}

}
