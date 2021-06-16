package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ButtonsPageLocators {

	@FindBy(css = "#app > div > div > div.pattern-backgound.playgound-header > div")
	public WebElement buttonspage_heading;

	@FindBys({ @FindBy(css = "#doubleClickBtn") })
	public WebElement buttonspage_dblclickButton;

	@FindBys({ @FindBy(css = "#rightClickBtn") })
	public WebElement buttonspage_rclickButton;
	
	@FindBys({ @FindBy(xpath = "//div[@class='mt-4']/button[text()='Click Me']") })
	public WebElement buttonspage_randidButton;

}
