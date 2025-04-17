package actions;

import org.openqa.selenium.WebDriver;

import pageobjects.NewDLSubmissionPage;

public class Action_240 {
	WebDriver driver;
	
	
	public void DLClubApproval() {
		NewDLSubmissionPage NewDLSubmissionPage = new NewDLSubmissionPage(driver);
		NewDLSubmissionPage.Enter_DLClub_ApplicationNo();
		//NewDLSubmissionPage.Clickon_Submitbtn();
		NewDLSubmissionPage.Clickon_Clubbutton();
		NewDLSubmissionPage.Clickon_Approvebutton();
		NewDLSubmissionPage.capturemesg();
	}
}
