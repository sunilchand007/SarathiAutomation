package actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.CL_CLPrintPage;

public class Action_145 extends BasePage {

	WebDriver driver;
	public void CLPrint() {
		CL_CLPrintPage CLPrint=new CL_CLPrintPage(driver);
		CLPrint.Clickon_ApplicationNoRadiobtn();
		CLPrint.Set_Application_No();
		CLPrint.Clickon_ViewApplicationsButton();
		CLPrint.Clickon_CLNumberLink();
	
		Robot bot;
		try {
			bot = new Robot();
			wait(1);
			bot.keyPress(KeyEvent.VK_CONTROL);
			bot.keyPress(KeyEvent.VK_J);
			bot.keyRelease(KeyEvent.VK_CONTROL);
			bot.keyRelease(KeyEvent.VK_J);
//			bot.keyPress(KeyEvent.VK_ENTER);
//	        bot.keyRelease(KeyEvent.VK_ENTER);
			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				closeWindowByTitle("Downloads", driver);
				driver.switchTo().window(winHandleBefore);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
