package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.DL_Backlog;

public class Action_239 extends BasePage{

	WebDriver driver;
	public void ApproveDLBacklog() {
		scrooldown(driver);
		
		DL_Backlog DL_Backlog = new DL_Backlog(driver);
		try {
			DL_Backlog.Verify_GenerateOTPforApproval();
			wait(5);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
