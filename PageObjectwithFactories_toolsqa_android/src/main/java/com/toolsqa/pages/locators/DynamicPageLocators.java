package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class DynamicPageLocators {

	@FindBy(css = "#app > div > div > div.pattern-backgound.playgound-header > div")
	public WebElement dynapage_heading;

	@FindBys({ @FindBy(css = "#enableAfter") })
	public WebElement dynapage_lateenableButton;

	@FindBys({ @FindBy(css = "#colorChange") })
	public WebElement dynapage_rclickButton;
	
	@FindBys({ @FindBy(css = "#visibleAfter") })
	public WebElement dynapage_latevisButton;

}
