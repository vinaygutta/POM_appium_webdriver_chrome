package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class WebTablePageLocators {

	@FindBy(css = "#app > div > div > div.pattern-backgound.playgound-header > div")
	public WebElement wbtable_heading;

	@FindBys({ @FindBy(css = "#searchBox") })
	public WebElement wbtable_searchbox;

	@FindBys({
			@FindBy(css = "#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.web-tables-wrapper > div.ReactTable.-striped.-highlight > div.rt-table") })
	public WebElement wbtable_datatable;

	@FindBys({ @FindBy(css = "#addNewRecordButton") })
	public WebElement wbtable_addbutton;

}
