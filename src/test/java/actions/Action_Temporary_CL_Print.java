package actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.Temporary_CL_PrintPage;

public class Action_Temporary_CL_Print extends BasePage{

	WebDriver driver;
	
	  
	  public void Temporary_CL_Print() {
		  Temporary_CL_PrintPage CLPrint = new Temporary_CL_PrintPage(driver);
		  CLPrint.ProvisionalCL_Print();
		 

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
