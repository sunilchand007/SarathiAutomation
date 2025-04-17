package actions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.DLEndorsementApprove;

public class Action_246 extends BasePage{

	WebDriver driver;
	DLEndorsementApprove DLEndorsementApprove;
	public void ApproveOfENDORSEMENTSONDL() {
		scrooldown(driver);
		DLEndorsementApprove = new DLEndorsementApprove(driver);
		DLEndorsementApprove.Clickon_Approve();
	}
}

