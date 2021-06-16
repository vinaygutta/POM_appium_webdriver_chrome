package com.toolsqa.testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.actions.HomePage;
import com.toolsqa.pages.actions.RegFormMDPage;
import com.toolsqa.pages.actions.WebTablePage;


public class WebTablePageTests {
	
	public HomePage homepage;

	@BeforeTest
	public void init() {

		BasePageInit.initConfiguration(System.getProperty("usebrowserpom"));
		homepage = new HomePage();
	}

	@Test(priority = 0, description = "To Add a new row in the web table.")
	public void addNewRowTest() {

		homepage.clickElements();
		WebTablePage wtp = BasePageInit.lnavPage.clickLeftNavElements_webtable(true);
		RegFormMDPage rfmdp = wtp.clickAddButton();
		rfmdp.enterdataAndSubmit();

	}

	@AfterTest
	public void tearDown() {
		if (BasePageInit.driver != null) {
			BasePageInit.quitBrowser();
		}
	}
}
