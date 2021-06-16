package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class RegFormMDPageLocators {

	@FindBy(css = "#registration-form-modal")
	public WebElement regformmd_heading;

	@FindBys({ @FindBy(css = "#firstName") })
	public WebElement regformmd_firstname;

	@FindBys({
			@FindBy(css = "#lastName") })
	public WebElement regformmd_lastname;

	@FindBys({ @FindBy(css = "#userEmail") })
	public WebElement regformmd_email;

	@FindBys({ @FindBy(css = "#age") })
	public WebElement regformmd_age;
	
	@FindBys({ @FindBy(css = "#salary") })
	public WebElement regformmd_salary;
	
	@FindBys({ @FindBy(css = "#department") })
	public WebElement regformmd_dept;
	
	@FindBys({ @FindBy(css = "#submit") })
	public WebElement regformmd_submit;
}
