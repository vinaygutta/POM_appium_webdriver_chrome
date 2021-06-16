package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SliderPageLocators {
	
	@FindBy(css = "#app > div > div > div.pattern-backgound.playgound-header > div")
	public WebElement slpage_heading;
	
	@FindBy(css = "#sliderContainer > div.col-9 > span > input")
	public WebElement slpage_slider;
	
	@FindBy(css = "#sliderValue")
	public WebElement slpage_slidervalue;

	
}
