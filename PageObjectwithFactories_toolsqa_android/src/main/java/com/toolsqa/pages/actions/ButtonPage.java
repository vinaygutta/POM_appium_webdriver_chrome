package com.toolsqa.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.ButtonsPageLocators;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.WebTablePageLocators;

public class ButtonPage extends BasePageInit {

	public ButtonsPageLocators bplc;

	public ButtonPage() {

		this.bplc = new ButtonsPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.bplc);

	}

	public void doubleClickButton() {

		doubleclick(bplc.buttonspage_dblclickButton, "double click button");

	}

	public void rightClickButton() {

		rightclick(bplc.buttonspage_rclickButton, "right click button");

	}
	
	public void rndidClickButton() {

		click(bplc.buttonspage_randidButton, "click random id button");

	}

}
