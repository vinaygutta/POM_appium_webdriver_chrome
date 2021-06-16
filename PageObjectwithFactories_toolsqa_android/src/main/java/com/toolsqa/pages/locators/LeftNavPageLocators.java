package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LeftNavPageLocators {

	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(1) > span > div > div.header-right")
	public WebElement leftNavelements;

	@FindBy(css = "#item-7 > span")
	public WebElement leftNavelements_upload;

	@FindBy(css = "#item-3 > span")
	public WebElement leftNavelements_webtable;
	
	@FindBy(xpath = "//span[text()='Buttons']")
	public WebElement leftNavelements_buttons;
	
	@FindBy(xpath = "//span[text()='Dynamic Properties']")
	public WebElement leftNavelements_dp;

	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > span > div > div.header-right")
	public WebElement leftNavfrms;

	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(3) > span > div > div.header-right")
	public WebElement leftNavalertsfrmwin;
	
	@FindBy(xpath = "//span[text()='Alerts']")
	public WebElement leftNavalertsfrmwin_alerts;

	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(4) > span > div > div.header-right")
	public WebElement leftNavwidgets;
	
	@FindBy(xpath = "//span[text()='Date Picker']")
	public WebElement leftNavwidgets_datepicker;
	
	@FindBy(xpath = "//span[text()='Slider']")
	public WebElement leftNavwidgets_slider;

	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(5) > span > div > div.header-right")
	public WebElement leftNavinteractions;

	@FindBy(xpath = "//span[text()='Sortable']")
	public WebElement leftNavinteractions_sortable;

	@FindBy(css = "#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(6) > span > div > div.header-right")
	public WebElement leftNavbookstoreapp;

}
