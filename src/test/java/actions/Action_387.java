package actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.CL_ExtractApprovalPage;
import pageobjects.CL_ExtractReportPage;

public class Action_387 extends BasePage{
	WebDriver driver;
	
	public void CL_ExtractReport() {
		CL_ExtractReportPage Extract=new CL_ExtractReportPage(driver);
		Extract.Enter_ApplicationNo();
		Extract.Clickon_Submitbtn();
		CL_ExtractApprovalPage ExtractApproval=new CL_ExtractApprovalPage(driver);
		ExtractApproval.Clickon_SubmitorPrintbtn();
		
			Robot bot;
			try {
				bot = new Robot();
				wait(1);
				bot.keyPress(KeyEvent.VK_CONTROL);
				bot.keyPress(KeyEvent.VK_J);
				bot.keyRelease(KeyEvent.VK_CONTROL);
				bot.keyRelease(KeyEvent.VK_J);
//				bot.keyPress(KeyEvent.VK_ENTER);
//		        bot.keyRelease(KeyEvent.VK_ENTER);
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
