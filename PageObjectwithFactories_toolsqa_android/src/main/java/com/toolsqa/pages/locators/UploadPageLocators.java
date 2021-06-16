package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class UploadPageLocators {

	@FindBy(css = "#app > div > div > div.pattern-backgound.playgound-header > div")
	public WebElement upage_heading;

	@FindBys({ @FindBy(css = "#downloadButton") })
	public WebElement upage_downloadButton;

	@FindBys({ @FindBy(css = "#uploadFile") })
	public WebElement upage_chosefileButton;
	
	@FindBys({ @FindBy(css = "#uploadedFilePath") })
	public WebElement upage_uploadeFilePath;

}
