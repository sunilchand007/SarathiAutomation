package actions;

import org.openqa.selenium.WebDriver;

import pageobjects.CLbacklogApprovalPage;

public class Action_225 {

	WebDriver driver;
	
	 public void CL_BacklogApproval() {
		  CLbacklogApprovalPage clbacklogApprovalPage = new CLbacklogApprovalPage(driver);
		    clbacklogApprovalPage.EnterCLAppNo();
			clbacklogApprovalPage.ClickProceed();
			clbacklogApprovalPage.ClickApproveButton();
			//clbacklogApprovalPage.Clickon_Logout();
	  }
}
