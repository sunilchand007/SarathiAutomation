package actions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.DLEndorsementApprove;

public class Action_152 extends BasePage {

	WebDriver driver;
	DLEndorsementApprove DLEndorsementApprove;
	public void LLEdit_Approval() {
		scrooldown(driver);
		DLEndorsementApprove = new DLEndorsementApprove(driver);
		DLEndorsementApprove.Clickon_Approve();
	}
}
