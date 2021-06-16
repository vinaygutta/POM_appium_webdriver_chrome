package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SortablePageLocators {

	@FindBy(css = "#app > div > div > div.pattern-backgound.playgound-header > div")
	public WebElement sortable_heading;
	
	@FindBys({ @FindBy(css = "#demo-tab-list") })
	public WebElement sortable_listtablink;
	
	@FindBys({ @FindBy(css = "#demo-tab-grid") })
	public WebElement sortable_gridtablink;

	@FindBys({ @FindBy(css = "#demo-tabpane-list .list-group-item") })
	public List<WebElement> sortable_listtab;

	@FindBys({
			@FindBy(css = "#demo-tabpane-grid .list-group-item") })
	public List<WebElement> sortable_gridtab;

	@FindBys({ @FindBy(css = "#demo-tabpane-list > div > div:nth-child(1)") })
	public WebElement sortable_listOne;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-list > div > div:nth-child(2)") })
	public WebElement sortable_listTwo;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-list > div > div:nth-child(3)") })
	public WebElement sortable_listThree;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-list > div > div:nth-child(4)") })
	public WebElement sortable_listFour;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-list > div > div:nth-child(5)") })
	public WebElement sortable_listFive;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-list > div > div:nth-child(6)") })
	public WebElement sortable_listSix;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(1)") })
	public WebElement sortable_gridOne;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(2)") })
	public WebElement sortable_gridTwo;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(3)") })
	public WebElement sortable_gridThree;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(4)") })
	public WebElement sortable_gridFour;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(5)") })
	public WebElement sortable_gridFive;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(6)") })
	public WebElement sortable_gridSix;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(7)") })
	public WebElement sortable_gridSeven;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(8)") })
	public WebElement sortable_gridEight;
	
	@FindBys({ @FindBy(css = "#demo-tabpane-grid > div > div > div:nth-child(9)") })
	public WebElement sortable_gridNine;

}
