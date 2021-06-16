package com.toolsqa.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.WebTablePageLocators;

public class WebTablePage extends BasePageInit {
	
	public WebTablePageLocators wtplc;
	

	public WebTablePage(){
		
		this.wtplc = new WebTablePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.wtplc);
		
	}
	
	
	public RegFormMDPage clickAddButton(){
		
		
		click(wtplc.wbtable_addbutton,"webtable add button");
		
		return new RegFormMDPage();
		
	}
	
	
	
	

}
