package com.toolsqa.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.HomePageLocators;

public class HomePage extends BasePageInit {

	public HomePageLocators home;

	public HomePage() {

		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.home);

	}

	public void clickElements() {

		// if (lnavPage==null) {
		lnavPage = new LeftNavPage();
		// }

		click(home.elements, "home page elements link");

	}

	public void clickInteractions() {

		// if (lnavPage==null) {
		lnavPage = new LeftNavPage();
		// }

		click(home.interactions, "home page interactions link");

	}
	
	public void clickAlertFrmWin() {

		// if (lnavPage==null) {
		lnavPage = new LeftNavPage();
		// }

		click(home.alertsfrmwin, "home page alert frame win link");

	}
	
	public void clickWidgets() {

		// if (lnavPage==null) {
		lnavPage = new LeftNavPage();
		// }

		click(home.widgets, "home page widgets win link");

	}

}
