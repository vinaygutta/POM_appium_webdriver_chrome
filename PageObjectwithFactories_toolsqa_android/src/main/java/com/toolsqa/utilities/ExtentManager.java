package com.toolsqa.utilities;

import java.io.File;
import java.util.Map;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.toolsqa.base.Parameters;

public class ExtentManager {

	private static ExtentReports extent;

	private static Properties properties = System.getProperties();
	// properties.forEach((k, v) -> System.out.println(k + ":" + v));
	
	public static void closeInstance() {
		extent = null;
	}
	
	public static void setExtentReportSysInfo(String browser) {
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("Browser Version", Utilities.detectLaunchedBrowserVersion(browser));

		for (Map.Entry<Object, Object> entry : properties.entrySet()) {
			// System.out.println(entry.getKey() + " : " + entry.getValue());
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			switch (key) {
			case "java.vm.version":
				extent.setSystemInfo(key, value);
				break;
			case "java.vm.name":
				extent.setSystemInfo(key, value);
				break;
			case "user.dir":
				extent.setSystemInfo(key, value);
				break;
			case "java.runtime.version":
				extent.setSystemInfo(key, value);
				break;
			case "os.arch":
				extent.setSystemInfo(key, value);
				break;
			case "os.name":
				extent.setSystemInfo(key, value);
				break;
			case "os.version":
				extent.setSystemInfo(key, value);
				break;
			case "user.name":
				extent.setSystemInfo(key, value);
				break;
			case "java.version":
				extent.setSystemInfo(key, value);
				break;
			}

		}
	}

	public static ExtentReports getInstance(String name) {

		if (extent == null) {
			
			ExtentSparkReporter reporter = new ExtentSparkReporter(
					System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\"+Utilities.replaceSpaceWithUnderscore(name)+"_extent508.html");

			reporter.config().setDocumentTitle(name + " Test Results");
			reporter.config().setReportName(name + " Test Suite Results");
		

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			
			

		}

		return extent;

	}

}
