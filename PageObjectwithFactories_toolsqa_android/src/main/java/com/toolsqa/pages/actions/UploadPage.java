package com.toolsqa.pages.actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.toolsqa.base.BasePageInit;
import com.toolsqa.pages.locators.HomePageLocators;
import com.toolsqa.pages.locators.LeftNavPageLocators;
import com.toolsqa.pages.locators.UploadPageLocators;

public class UploadPage extends BasePageInit {

	public UploadPageLocators upageloc;

	public UploadPage() {

		this.upageloc = new UploadPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.upageloc);

	}
	
	public String getTextUploadedPath() {
		return BasePageInit.getTextFromElement(upageloc.upage_uploadeFilePath, "Uploaded File Path");
	}

	public void clickChooseFile(boolean useautoit) {
		jsclick(upageloc.upage_chosefileButton, "choose file button");
		if (!useautoit) {

			waitSomeTime(30);

			Robot rb;
			try {
				rb = new Robot();

				// copying File path to Clipboard
				StringSelection str = new StringSelection("C:\\1INTR.MP4");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

				// press Contol+V for pasting
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);

				// release Contol+V for pasting
				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);

				// for pressing and releasing Enter
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			waitSomeTime(20);

			try {
				Process atitp = Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "\\src\\test\\resources\\autoitscripts\\fileupload.exe");
				atitp.waitFor();
				if (atitp.exitValue() == 0) {
					// System.out.println("YAY!");
					log.debug("autoit script successful");
				} else {
					// System.out.println("boo");
					log.error("autoit script not successful");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// waitSomeTime(20);

		}
	}

}
