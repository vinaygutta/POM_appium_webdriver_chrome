package com.toolsqa.pages.actions;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.DatePickerPageLocators;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.SortablePageLocators;
import com.toolsqa.pages.locators.WebTablePageLocators;

public class DatePickerPage extends BasePageInit {

	public DatePickerPageLocators dpplc;

	public DatePickerPage() {

		this.dpplc = new DatePickerPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(factory, this.dpplc);

	}

	public void chooseDateFromCalender(String dateMMDDYYYYslash) {

		click(dpplc.dppage_dateinput, "date entry box");
		String datNumb = dateMMDDYYYYslash.split("/")[1];
		String mnthNumb = dateMMDDYYYYslash.split("/")[0];
		String yreNumb = dateMMDDYYYYslash.split("/")[2];

		String mnthString = new DateFormatSymbols().getMonths()[Integer.valueOf(mnthNumb) - 1];

		chooseFromSelect(dpplc.dppage_calmonthdropdown, mnthString, "month");
		chooseFromSelect(dpplc.dppage_calyeardropdown, yreNumb, "year");

		int dateelementindex = getIdxOftextWebElementsList(dpplc.dppage_calalldays, datNumb, "date picker");

		click(dpplc.dppage_calalldays.get(dateelementindex), "date picker");

	}

	public void chooseDateTimeFromCalender(String datetime) {

		click(dpplc.dppage_datetimeinput, "date time entry box");
		String tme = datetime.split(" ")[1];
		String datNumb = datetime.split(" ")[0].split("/")[1];
		String mnthNumb = datetime.split(" ")[0].split("/")[0];
		String yreNumb = datetime.split(" ")[0].split("/")[2];

		String mnthString = new DateFormatSymbols().getMonths()[Integer.valueOf(mnthNumb) - 1];

		click(dpplc.dppage_datetimemonthdisp, "month picker");

		int mntelementindex = getIdxOftextWebElementsList(dpplc.dppage_datetimemonthlist, mnthString, "month picker");

		click(dpplc.dppage_datetimemonthlist.get(mntelementindex), "month picker");

		Calendar now = Calendar.getInstance();
		int curryear = now.get(Calendar.YEAR);
		String curryearInString = String.valueOf(curryear);

		click(dpplc.dppage_datetimeyeardisp, "month picker");

		int yrelementindex = getIdxOftextWebElementsListScroll(dpplc.dppage_datetimeyearlist, yreNumb, "year picker");

		click(dpplc.dppage_datetimeyearlist.get(yrelementindex), "year picker");

		int dateelementindex = getIdxOftextWebElementsList(dpplc.dppage_datetimedaylist, datNumb, "date picker");

		click(dpplc.dppage_datetimedaylist.get(dateelementindex), "date picker");
		
		int timeelementindex = getIdxOftextWebElementsList(dpplc.dppage_datetimetimelist, tme, "date picker");

		click(dpplc.dppage_datetimetimelist.get(timeelementindex), "time picker");

	}

}
