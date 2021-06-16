package com.toolsqa.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.actions.HomePage;
import com.toolsqa.pages.actions.UploadPage;
import com.toolsqa.utilities.Utilities;

public class UploadDownloadTests {
	
	public HomePage homepage;

	@BeforeTest
	public void setUp() {

		BasePageInit.initConfiguration(System.getProperty("usebrowserpom"));
		//BasePageInit.initConfiguration("chrome");
		homepage = new HomePage();
		
		

	}

	@Test(priority=0, description = "To verify upload.")
	public void choosefileTest() {

		
		homepage.clickElements();
		UploadPage uppage = BasePageInit.lnavPage.clickLeftNavElements_upload(true);
		uppage.clickChooseFile(true);

	}

	@AfterTest
	public void tearDown() {
		
		if (BasePageInit.driver != null) {
			BasePageInit.quitBrowser();
		}
	}
}
