package com.toolsqa.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.AlertsPageLocators;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.WebTablePageLocators;

public class AlertsPage extends BasePageInit {
	
	public AlertsPageLocators aplc;
	

	public AlertsPage(){
		
		this.aplc = new AlertsPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.aplc);
		
	}
	
	
	public void clickAlertButton(){
		
		
		click(aplc.alerts_alertbutton,"alert button");
		waitForAlertAndClick(10);
		
	}
	
public void clickdelayAlertButton(){
		
		
		click(aplc.alerts_timeralertbutton,"alert button");
		waitForAlertAndClick(10);
		
	}
	
	
	
	

}
