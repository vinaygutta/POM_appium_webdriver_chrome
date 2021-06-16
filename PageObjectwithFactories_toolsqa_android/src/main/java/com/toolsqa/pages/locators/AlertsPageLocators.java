package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class AlertsPageLocators {

	@FindBy(css = "#app > div > div > div.pattern-backgound.playgound-header > div")
	public WebElement alerts_heading;

	@FindBys({ @FindBy(css = "#alertButton") })
	public WebElement alerts_alertbutton;

	@FindBys({
			@FindBy(css = "#timerAlertButton") })
	public WebElement alerts_timeralertbutton;

	@FindBys({ @FindBy(css = "#confirmButton") })
	public WebElement alerts_confbutton;
	
	@FindBys({ @FindBy(css = "#promtButton") })
	public WebElement alerts_promptbutton;

}
