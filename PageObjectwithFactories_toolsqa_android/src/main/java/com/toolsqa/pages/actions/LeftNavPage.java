package com.toolsqa.pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.LeftNavPageLocators;

public class LeftNavPage extends BasePageInit {

	public LeftNavPageLocators lnavloc;

	public LeftNavPage() {

		this.lnavloc = new LeftNavPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.lnavloc);

	}

	public UploadPage clickLeftNavElements_upload(boolean alreadyOpen) {
		if (!alreadyOpen) {
			
			click(lnavloc.leftNavelements,"left nav elements link");
			scrollWebPage(lnavloc.leftNavelements_upload);
			click(lnavloc.leftNavelements_upload, "left nav upload link");
		} else {
			scrollWebPage(lnavloc.leftNavelements_upload);
			click(lnavloc.leftNavelements_upload, "left nav upload link");
		}

		return new UploadPage();
	}
	
	public WebTablePage clickLeftNavElements_webtable(boolean alreadyOpen) {
		if (!alreadyOpen) {
			
			click(lnavloc.leftNavelements,"left nav elements link");
			scrollWebPage(lnavloc.leftNavelements_webtable);
			click(lnavloc.leftNavelements_webtable, "left nav webtable link");
		} else {
			scrollWebPage(lnavloc.leftNavelements_webtable);
			click(lnavloc.leftNavelements_webtable, "left nav webtable link");
		}

		return new WebTablePage();
	}
	
	public ButtonPage clickLeftNavElements_buttons(boolean alreadyOpen) {
		if (!alreadyOpen) {
			
			click(lnavloc.leftNavelements,"left nav elements link");
			scrollWebPage(lnavloc.leftNavelements_buttons);
			click(lnavloc.leftNavelements_buttons, "left nav buttons link");
		} else {
			scrollWebPage(lnavloc.leftNavelements_buttons);
			click(lnavloc.leftNavelements_buttons, "left nav buttons link");
		}

		return new ButtonPage();
	}
	
	public DynamicPage clickLeftNavElements_dp(boolean alreadyOpen) {
		if (!alreadyOpen) {
			
			click(lnavloc.leftNavelements,"left nav elements link");
			scrollWebPage(lnavloc.leftNavelements_dp);
			click(lnavloc.leftNavelements_dp, "left nav dynamic properties link");
		} else {
			scrollWebPage(lnavloc.leftNavelements_dp);
			click(lnavloc.leftNavelements_dp, "left nav dynamic properties link");
		}

		return new DynamicPage();
	}
	
	public SortablePage clickLeftNavInteractions_sortable(boolean alreadyOpen) {
		if (!alreadyOpen) {
			
			click(lnavloc.leftNavinteractions,"left nav interactions link");
			scrollWebPage(lnavloc.leftNavinteractions_sortable);
			click(lnavloc.leftNavinteractions_sortable, "left nav sortable link");
		} else {
			scrollWebPage(lnavloc.leftNavinteractions_sortable);
			click(lnavloc.leftNavinteractions_sortable, "left nav sortable link");
		}

		return new SortablePage();
	}
	
	public AlertsPage clickLeftNavalertsfrmwin_alerts(boolean alreadyOpen) {
		if (!alreadyOpen) {
			
			click(lnavloc.leftNavalertsfrmwin,"left nav alerts frame win link");
			scrollWebPage(lnavloc.leftNavalertsfrmwin_alerts);
			click(lnavloc.leftNavalertsfrmwin_alerts, "left nav alerts frame win link");
		} else {
			scrollWebPage(lnavloc.leftNavalertsfrmwin_alerts);
			click(lnavloc.leftNavalertsfrmwin_alerts, "left nav alerts frame win link");
		}

		return new AlertsPage();
	}
	public DatePickerPage clickLeftNavwidgets_datepicker(boolean alreadyOpen) {
		if (!alreadyOpen) {
			
			click(lnavloc.leftNavwidgets,"left nav widgets link");
			scrollWebPage(lnavloc.leftNavwidgets_datepicker);
			click(lnavloc.leftNavwidgets_datepicker, "left nav date picker link");
		} else {
			scrollWebPage(lnavloc.leftNavwidgets_datepicker);
			click(lnavloc.leftNavwidgets_datepicker, "left nav date picker link");
		}

		return new DatePickerPage();
	}
	
	public SliderPage clickLeftNavwidgets_slider(boolean alreadyOpen) {
		if (!alreadyOpen) {
			
			click(lnavloc.leftNavwidgets,"left nav widgets link");
			scrollWebPage(lnavloc.leftNavwidgets_slider);
			click(lnavloc.leftNavwidgets_slider, "left nav date picker link");
		} else {
			scrollWebPage(lnavloc.leftNavwidgets_slider);
			click(lnavloc.leftNavwidgets_slider, "left nav date picker link");
		}

		return new SliderPage();
	}

}
