package com.toolsqa.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageLocators {

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[3]/h5")
	public WebElement elements;

	@FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(2) > div")
	public WebElement frms;

	@FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(3) > div")
	public WebElement alertsfrmwin;

	@FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(4)")
	public WebElement widgets;

	@FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(5)")
	public WebElement interactions;

	@FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(6)")
	public WebElement bookstoreapp;

}
