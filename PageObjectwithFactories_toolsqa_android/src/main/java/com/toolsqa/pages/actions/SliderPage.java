package com.toolsqa.pages.actions;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.DatePickerPageLocators;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.SliderPageLocators;
import com.toolsqa.pages.locators.SortablePageLocators;
import com.toolsqa.pages.locators.WebTablePageLocators;

public class SliderPage extends BasePageInit {

	public SliderPageLocators slplc;

	public SliderPage() {

		this.slplc = new SliderPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(factory, this.slplc);

	}

	public void slideSlider(int percentage) {

		moveSlider(slplc.slpage_slider,percentage, "slider");

	}

}
