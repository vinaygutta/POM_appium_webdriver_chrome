package com.toolsqa.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.SortablePageLocators;
import com.toolsqa.pages.locators.WebTablePageLocators;

public class SortablePage extends BasePageInit {

	public SortablePageLocators splc;

	public SortablePage() {

		this.splc = new SortablePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.splc);

	}

	public void dragsortElementinList(int elementloc, int destloc, String elementname) {
		
		click(splc.sortable_listtablink,"Tab Link");

		dragsort(splc.sortable_listtab, elementloc, destloc, elementname);

	}

	public void dragsortElementinGrid(int elementloc, int destloc, String elementname) {
		
		click(splc.sortable_gridtablink,"Grid link");

		dragsort(splc.sortable_gridtab, elementloc, destloc, elementname);

	}

}
