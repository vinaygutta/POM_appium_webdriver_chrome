package com.toolsqa.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.errorcollectors.ErrorCollector;
import com.toolsqa.pages.actions.DatePickerPage;
import com.toolsqa.pages.actions.HomePage;
import com.toolsqa.pages.actions.RegFormMDPage;
import com.toolsqa.pages.actions.SliderPage;
import com.toolsqa.pages.actions.SortablePage;
import com.toolsqa.pages.actions.UploadPage;
import com.toolsqa.pages.actions.WebTablePage;
import com.toolsqa.utilities.Utilities;

public class AllWidgetsTests {

	public HomePage homepage;

	@BeforeTest
	public void setUp() {

		BasePageInit.initConfiguration(System.getProperty("usebrowserpom"));
		// BasePageInit.initConfiguration("chrome");
		homepage = new HomePage();

	}

	@Test(priority = 1, description = "To verify if date is chosen from calender.", enabled=false)
	public void chooseDateFromCalTest() {

		homepage.clickWidgets();

		DatePickerPage dppage = BasePageInit.lnavPage.clickLeftNavwidgets_datepicker(true);
		dppage.chooseDateFromCalender("04/22/2019");

	}

	@Test(priority = 2, description = "To verify if date time is chosen from calender.")
	public void chooseDateTimeFromCalTest() {
		
		new HomePage().clickWidgets();
		BasePageInit.lnavPage.clickLeftNavwidgets_datepicker(true);

		//DatePickerPage dppage = BasePageInit.lnavPage.clickLeftNavwidgets_datepicker(true);
		new DatePickerPage().chooseDateTimeFromCalender("12/22/2030 12:42");

	}
	
	@Test(priority = 3, description = "To verify if slider is moved.", enabled=false)
	public void moveSliderTest() {

		SliderPage slpage = BasePageInit.lnavPage.clickLeftNavwidgets_slider(true);
		slpage.slideSlider(25);

	}

	@AfterTest
	public void tearDown() {

		if (BasePageInit.driver != null) {
			BasePageInit.quitBrowser();
		}
	}
}
