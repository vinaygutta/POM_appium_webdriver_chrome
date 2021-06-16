package com.toolsqa.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.base.Parameters;

public class Utilities extends BasePageInit {

	public static String screenshotPath;
	public static String screenshotName;

	private static final String TASKLIST = "tasklist";
	// command used to kill a task
	private static final String KILL = "taskkill /F /IM ";

	public static String detectLaunchedBrowserVersion(String browser) {
		String browserversion = "Unknown";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String browseragent = js.executeScript("return navigator.userAgent", "").toString();
		// System.out.println(browseragent);

		if (browser.equalsIgnoreCase("chrome")) {
			if (browseragent.contains("Chrome")) {
				int strIndex = browseragent.indexOf("Chrome");
				browserversion = browseragent.substring(strIndex, strIndex + 19);
			}

		} else if (browser.equalsIgnoreCase("msedge")) {
			if (browseragent.contains("Edg")) {
				int strIndex = browseragent.indexOf("Edg");
				browserversion = browseragent.substring(strIndex, strIndex + 15);
			}

		} else if (browser.equalsIgnoreCase("firefox")) {
			if (browseragent.contains("Firefox")) {
				int strIndex = browseragent.indexOf("Firefox");
				browserversion = browseragent.substring(strIndex, strIndex + 12);
			}
		}

		return browserversion;
	}

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName;

		FileUtils.copyFile(scrFile, new File(screenshotPath));

	}

	public static void killProcess(String serviceName) {

		try {
			Runtime.getRuntime().exec(KILL + serviceName);
			Thread.sleep(5000);
			// System.out.println(serviceName + " killed successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][1];

		Hashtable<String, String> table = null;

		for (int rowNum = 2; rowNum <= rows; rowNum++) { // 2

			table = new Hashtable<String, String>();

			for (int colNum = 0; colNum < cols; colNum++) {

				// data[0][0]
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum - 2][0] = table;
			}

		}

		return data;

	}

	public static String replaceSpaceEncoded(String inputStr) {
		inputStr = inputStr.trim();
		inputStr = inputStr.replaceAll(" ", "%20");
		return inputStr;
	}
	
	public static String replaceSpaceWithUnderscore(String inputStr) {
		inputStr = inputStr.trim();
		inputStr = inputStr.replaceAll(" ", "_");
		return inputStr;
	}

	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);

		for (int rNum = 2; rNum <= rows; rNum++) {

			String testCase = excel.getCellData(sheetName, "TCID", rNum);

			if (testCase.equalsIgnoreCase(testName)) {

				String runmode = excel.getCellData(sheetName, "Runmode", rNum);

				if (runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}

		}
		return false;
	}

}
