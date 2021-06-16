package com.toolsqa.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.RegFormMDPageLocators;
import com.toolsqa.pages.locators.WebTablePageLocators;

public class RegFormMDPage extends BasePageInit {
	
	public RegFormMDPageLocators regmd;
	

	public RegFormMDPage(){
		
		this.regmd = new RegFormMDPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
		PageFactory.initElements(factory, this.regmd);
		
	}
	
	
	public void enterdataAndSubmit(){
		
		type(regmd.regformmd_firstname,"UserFn","First Name");
		type(regmd.regformmd_lastname,"UserLn","Last Name");
		type(regmd.regformmd_email,"user@user.com","Email");
		type(regmd.regformmd_dept,"nodep","Department");
		type(regmd.regformmd_salary,"100000","Salary");
		type(regmd.regformmd_age,"22","Age");
		
		click(regmd.regformmd_submit,"Submit");
		
		
	}
	
	
	
	

}
