package com.toolsqa.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.ButtonsPageLocators;
import com.toolsqa.pages.locators.DynamicPageLocators;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.WebTablePageLocators;

public class DynamicPage extends BasePageInit {

	public DynamicPageLocators dplc;

	public DynamicPage() {

		this.dplc = new DynamicPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this.dplc);

	}

	public void ltenabledClickButton() {

		click(dplc.dynapage_lateenableButton, "late enabled button");

	}

	public void ltvisibleClickButton() {

		click(dplc.dynapage_latevisButton, "late visible button");

	}

}
