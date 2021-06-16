package com.toolsqa.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.errorcollectors.ErrorCollector;
import com.toolsqa.pages.actions.ButtonPage;
import com.toolsqa.pages.actions.DynamicPage;
import com.toolsqa.pages.actions.HomePage;
import com.toolsqa.pages.actions.RegFormMDPage;
import com.toolsqa.pages.actions.UploadPage;
import com.toolsqa.pages.actions.WebTablePage;
import com.toolsqa.utilities.Utilities;

public class AllElementsTests {
	
	public HomePage homepage;

	@BeforeTest
	public void setUp() {

		BasePageInit.initConfiguration(System.getProperty("usebrowserpom"));
		//BasePageInit.initConfiguration("chrome");
		homepage = new HomePage();
		
		
		

	}

	@Test(priority=0, description = "To verify upload.", enabled=false)
	public void choosefileTest() {

		
		
		UploadPage uppage = BasePageInit.lnavPage.clickLeftNavElements_upload(true);
		uppage.clickChooseFile(true);
		ErrorCollector.verifyEquals(uppage.getTextUploadedPath(), "C:\\fakepath\\1INTR.MP4");

	}
	
	@Test(priority=1, description = "To verify if able to add row to web table.")
	public void addRowWebTableTest() {

		homepage.clickElements();
		WebTablePage wtpage = BasePageInit.lnavPage.clickLeftNavElements_webtable(true);
		RegFormMDPage rmdpage = wtpage.clickAddButton();
		rmdpage.enterdataAndSubmit();
		//ErrorCollector.verifyEquals(uppage.getTextUploadedPath(), "C:\\fakepath\\1INTR.MP4");

	}
	
	@Test(priority=2, description = "To verify if able to click various buttons.")
	public void clickButtonsTest() {

		
		ButtonPage bpage = BasePageInit.lnavPage.clickLeftNavElements_buttons(true);
		bpage.doubleClickButton();
		BasePageInit.waitSomeTime(5);
		bpage.rightClickButton();
		BasePageInit.waitSomeTime(5);
		bpage.rndidClickButton();
		//ErrorCollector.verifyEquals(uppage.getTextUploadedPath(), "C:\\fakepath\\1INTR.MP4");

	}
	
	@Test(priority=2, description = "To verify if able to click late visible and late enabled buttons.")
	public void clickdynaButtonsTest() {

		
		DynamicPage dpage = BasePageInit.lnavPage.clickLeftNavElements_dp(true);
		dpage.ltenabledClickButton();
		dpage.ltvisibleClickButton();
		//ErrorCollector.verifyEquals(uppage.getTextUploadedPath(), "C:\\fakepath\\1INTR.MP4");

	}

	@AfterTest
	public void tearDown() {
		
		if (BasePageInit.driver != null) {
			BasePageInit.quitBrowser();
		}
	}
}
