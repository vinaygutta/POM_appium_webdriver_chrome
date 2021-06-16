package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class DatePickerPageLocators {
	
	@FindBy(css = "#app > div > div > div.pattern-backgound.playgound-header > div")
	public WebElement dppage_heading;

	@FindBy(css = "#datePickerMonthYear > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > button.react-datepicker__navigation.react-datepicker__navigation--previous")
	public WebElement dppage_calleftbutton;

	@FindBys({ @FindBy(css = "#datePickerMonthYear > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > button.react-datepicker__navigation.react-datepicker__navigation--next") })
	public WebElement dppage_calrightbutton;

	@FindBys({ @FindBy(css = "#datePickerMonthYear > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown") })
	public WebElement dppage_calmonthname;
	
	@FindBys({ @FindBy(css = "#datePickerMonthYear > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__month-dropdown-container.react-datepicker__month-dropdown-container--select > select") })
	public WebElement dppage_calmonthdropdown;
	
	@FindBys({ @FindBy(css = "#datePickerMonthYear > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__year-dropdown-container.react-datepicker__year-dropdown-container--select > select") })
	public WebElement dppage_calyeardropdown;
	
	@FindBy(css = "#datePickerMonthYear > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month div.react-datepicker__day")
	public List<WebElement> dppage_calalldays;
	
	@FindBy(css = "#datePickerMonthYearInput")
	public WebElement dppage_dateinput;
	
	@FindBy(css = "#dateAndTimePickerInput")
	public WebElement dppage_datetimeinput;

	@FindBy(css = "#dateAndTimePicker > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > button.react-datepicker__navigation.react-datepicker__navigation--previous")
	public WebElement dppage_datetimeleftbutton;
	
	@FindBy(css = "#dateAndTimePicker > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > button.react-datepicker__navigation.react-datepicker__navigation--next.react-datepicker__navigation--next--with-time")
	public WebElement dppage_datetimerightbutton;
	
	@FindBy(css = "#dateAndTimePicker > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--scroll > div.react-datepicker__month-dropdown-container.react-datepicker__month-dropdown-container--scroll > div.react-datepicker__month-dropdown div.react-datepicker__month-option")
	public List<WebElement> dppage_datetimemonthlist;
	
	@FindBy(css = "#dateAndTimePicker > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--scroll > div.react-datepicker__month-dropdown-container.react-datepicker__month-dropdown-container--scroll")
	public WebElement dppage_datetimemonthdisp;
	
	@FindBy(css = "#dateAndTimePicker > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--scroll > div.react-datepicker__year-dropdown-container.react-datepicker__year-dropdown-container--scroll > div")
	public WebElement dppage_datetimeyeardisp;
	
	@FindBy(css = "#dateAndTimePicker > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--scroll > div.react-datepicker__year-dropdown-container.react-datepicker__year-dropdown-container--scroll > div.react-datepicker__year-dropdown div.react-datepicker__year-option")
	public List<WebElement> dppage_datetimeyearlist;
	
	@FindBy(css = "#dateAndTimePicker > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__time-container > div.react-datepicker__time > div > ul li.react-datepicker__time-list-item")
	public List<WebElement> dppage_datetimetimelist;
	
	@FindBy(css = "#dateAndTimePicker > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month div.react-datepicker__day")
	public List<WebElement> dppage_datetimedaylist;
}
