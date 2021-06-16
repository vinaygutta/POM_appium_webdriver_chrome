package com.toolsqa.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.utils.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.toolsqa.pages.actions.LeftNavPage;
import com.toolsqa.utilities.ExcelReader;
import com.toolsqa.utilities.ExcelWriter;
import com.toolsqa.utilities.ExtentManager;
import com.toolsqa.utilities.Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;

public class BasePageInit {

	/*
	 * WebDriver
	 * 
	 * ExcelReader Logs WebDriverWait ExtentReports
	 * 
	 * 
	 * 
	 * 
	 */
	public static AndroidDriver<WebElement> driver;
	static {
		System.setProperty("sele.log", System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\sel.log");
		System.setProperty("appl.log", System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\app.log");
	}
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");

	public static WebDriverWait wait;
	public static ExtentReports extentreport;
	public static ExtentTest extentreporttestdesc;
	public static ExtentTest extentreporttest;
	public static String browser;
	// public static TopNavigation topNav;
	public static LeftNavPage lnavPage = null;

	public static void initExtentReportConf(String name) {

		extentreport = ExtentManager.getInstance(name);
	}

	public static void closeExtentReportinst() {
		ExtentManager.closeInstance();
	}

	public static void initConfiguration(String launchBrowser) {

		Utilities.killProcess("chromedriver.exe");
		Utilities.killProcess("msedgedriver.exe");
		Utilities.killProcess("geckodriver.exe");
		browser = launchBrowser;

		if (launchBrowser.equals("firefox")) {

			
		} else if (launchBrowser.equals("chrome")) {

			
		} else if (launchBrowser.equals("androidchrome")) {

			

			try {
				driver = CreateBrowserSession.initializeAndroidDriver("Android");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e.getLocalizedMessage());
			}
			log.debug("Launching Chrome");
		} else if (launchBrowser.equals("msedge")) {

			
		} else if (launchBrowser.equals("ie")) {

			
		}

		driver.get(Parameters.testsiteurl);
		//driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Parameters.implicitwait,
		// TimeUnit.SECONDS);
		// wait = new WebDriverWait()
		// topNav = new TopNavigation(driver);

		// Utilities.detectLaunchedBrowserVersion();

		ExtentManager.setExtentReportSysInfo(launchBrowser);

	}

	public static void click(WebElement element, String elementName) {

		scrollWebPage(element);
		log.debug("Clicking on an Element : " + elementName);
		extentreporttestdesc.log(Status.INFO, "Clicking on : " + elementName);

		element.click();

	}

	public static void doubleclick(WebElement element, String elementName) {

		scrollWebPage(element);
		log.debug("Double Clicking on an Element : " + elementName);
		extentreporttestdesc.log(Status.INFO, "Double Clicking on : " + elementName);

		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();

	}
	
	public static void startAndroidRecording() {

		((CanRecordScreen) driver).startRecordingScreen();
	

	}
	
	public static void stopAndroidRecording(ITestResult arg0) {

		String media = ((CanRecordScreen) driver).stopRecordingScreen();
		String folder = System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\testcase-recordings\\";
		File videodir = new File(folder);
		if (!videodir.exists()) {
			videodir.mkdirs();
		}
		try {
			FileOutputStream stream = new FileOutputStream(folder+arg0.getName()+".mp4");
			stream.write(Base64.decode(media));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Base64DecodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	

	}

	public static void rightclick(WebElement element, String elementName) {

		scrollWebPage(element);
		log.debug("Double Clicking on an Element : " + elementName);
		extentreporttestdesc.log(Status.INFO, "Double Clicking on : " + elementName);

		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();

	}

	public static void jsclick(WebElement element, String elementName) {

		scrollWebPage(element);
		log.debug("Clicking on an Element : " + elementName);
		extentreporttestdesc.log(Status.INFO, "Clicking on : " + elementName);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public static void type(WebElement element, String value, String elementName) {

		scrollWebPage(element);
		log.debug("Typing in an Element : " + elementName + " entered value as : " + value);

		extentreporttestdesc.log(Status.INFO, "Typing in : " + elementName + " entered value as " + value);

		element.sendKeys(value);

	}

	public static void dragsort(List<WebElement> collectionelements, int src, int dest, String elementName) {

		log.debug("Draging and Sorting element : " + elementName);
		extentreporttestdesc.log(Status.INFO, "Draging and Sorting element : " + elementName);

		Actions action = new Actions(driver);

		WebElement target = collectionelements.get(src);
		WebElement destloc = collectionelements.get(dest);
		action.click(target).clickAndHold().moveToElement(destloc).moveByOffset(0, 10).release().build().perform();

	}

	public static synchronized void waitForElementVisibilityAndClick(WebElement element, int timeOut,
			String elementName) {

		log.debug("Waiting for visibility of : " + elementName);
		extentreporttestdesc.log(Status.INFO, "Waiting for visibility of : " + elementName);

		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.visibilityOf(element));
			log.debug("Now the : " + elementName + " is visible");
			extentreporttestdesc.log(Status.INFO, "Now the : " + elementName + " is visible");
			log.debug("Clicked the : " + elementName);
			extentreporttestdesc.log(Status.INFO, "Clicked the : " + elementName);
			element.click();
		} catch (Exception e) {
		}
	}

	public static synchronized void waitForElementEnableAndClick(WebElement element, int timeOut, String elementName) {

		log.debug("Waiting for enabling of : " + elementName);
		extentreporttestdesc.log(Status.INFO, "Waiting for enabling of : " + elementName);

		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			log.debug("Now the : " + elementName + " is enabled");
			extentreporttestdesc.log(Status.INFO, "Now the : " + elementName + " is enabled");
			log.debug("Clicked the : " + elementName);
			extentreporttestdesc.log(Status.INFO, "Clicked the : " + elementName);
			element.click();
		} catch (Exception e) {
		}
	}

	public static synchronized void waitForAlertAndClick(int timeOut) {

		log.debug("Waiting for alert");
		extentreporttestdesc.log(Status.INFO, "Waiting for alert");

		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofMillis(500));
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();

			log.debug("Now the Alert is available");
			extentreporttestdesc.log(Status.INFO, "Now the Alert is available");
			log.debug("Accepted the alert " + alert.getText());
			extentreporttestdesc.log(Status.INFO, "Accepted the alert " + alert.getText());

			alert.accept();
		} catch (Exception e) {
		}
	}

	public static String getTextFromElement(WebElement element, String elementName) {

		scrollWebPage(element);
		log.debug("Getting text displayed in Element : " + elementName);

		extentreporttestdesc.log(Status.INFO, "Getting text displayed in Element : " + elementName);

		return element.getText();

	}

	public static void chooseFromSelect(WebElement element, String value, String elementName) {

		log.debug("Choosing in the Element : " + elementName + " the value as : " + value);

		extentreporttestdesc.log(Status.INFO, "Choosing in : " + elementName + " value as " + value);

		Select selectElement = new Select(element);

		selectElement.selectByVisibleText(value);

	}

	public static int getIdxOftextWebElementsList(List<WebElement> elementsList, String dispText, String elementName) {

		log.debug("Getting index of the Element in list : " + elementName + " with text as : " + dispText);

		extentreporttestdesc.log(Status.INFO,
				"Getting index of the Element in list : " + elementName + " with text as : " + dispText);

		for (int i = 0; i <= elementsList.size() - 1; i++) {

			if (dispText.equalsIgnoreCase(elementsList.get(i).getText())) {

				return i;

			}

		}

		return 1;
	}

	public static void moveSlider(WebElement element, int percentage, String elementName) {
		
		log.debug("Moving slider : " + elementName + " to : " + percentage + "%");

		extentreporttestdesc.log(Status.INFO,
				"Moving slider : " + elementName + " to : " + percentage + "%");

		int width = element.getSize().getWidth();
		Actions move = new Actions(driver);
		move.moveToElement(element);
		move.clickAndHold();
		move.moveByOffset(0, 0);
		move.build().perform();
		
		move.moveToElement(element);
		move.clickAndHold();
		move.moveByOffset((width*percentage)/100, 0);
		move.build().perform();

	}

	public static int getIdxOftextWebElementsListScroll(List<WebElement> elementsList, String dispText,
			String elementName) {

		log.debug("Getting index of the Element in list : " + elementName + " with text as : " + dispText);

		extentreporttestdesc.log(Status.INFO,
				"Getting index of the Element in list : " + elementName + " with text as : " + dispText);

		String lastElmtYear = elementsList.get(elementsList.size() - 2).getText();

		if (Integer.valueOf(lastElmtYear) > Integer.valueOf(dispText)) {

			int diff = Integer.valueOf(lastElmtYear) - Integer.valueOf(dispText);

			for (int i = 0; i <= diff; i++) {
				click(elementsList.get(elementsList.size() - 1), "year scroll down button");
			}

			for (int i = 1; i < elementsList.size(); i++) {

				if (dispText.equalsIgnoreCase(elementsList.get(i).getText())) {

					return i;

				}

			}

		} else if (Integer.valueOf(lastElmtYear) + 10 < Integer.valueOf(dispText)) {

			int diff = Integer.valueOf(dispText) - (Integer.valueOf(lastElmtYear) + 10);

			for (int i = 0; i <= diff; i++) {
				click(elementsList.get(0), "year scroll up button");
			}

			for (int i = 1; i < elementsList.size(); i++) {

				if (dispText.equalsIgnoreCase(elementsList.get(i).getText())) {

					return i;

				}

			}
		} else {

			for (int i = 1; i < elementsList.size(); i++) {

				if (dispText.equalsIgnoreCase(elementsList.get(i).getText())) {

					return i;

				}

			}
		}

		return -1;
	}

	public static String getElementAttributeValue(WebElement element, String attribute, String elementName) {

		log.debug("Reading the value of the attribute\"" + attribute + "\" in the element : " + elementName);

		extentreporttestdesc.log(Status.INFO,
				"Reading the value of the attribute\"" + attribute + "\" in the element : " + elementName);

		return element.getAttribute(attribute);

	}

	public static void scrollWebPage(String countPixels) {
		log.debug("Scrolling page");

		extentreporttestdesc.log(Status.INFO, "Scrolling page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + countPixels + ")");
	}

	public static void scrollWebPage(WebElement element) {
		log.debug("Scrolling page");

		extentreporttestdesc.log(Status.INFO, "Scrolling page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollWebPage() {
		log.debug("Scrolling page");

		extentreporttestdesc.log(Status.INFO, "Scrolling page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void waitSomeTime(long secondswait) {
		try {
			Thread.sleep(secondswait * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void quitBrowser() {

		driver.quit();

	}

}
