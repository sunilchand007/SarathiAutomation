package actions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.Login_DLApprovalPage;

public class Action_205 extends BasePage{

	WebDriver driver;
	Login_DLApprovalPage Login_DLApprovalPage;
	
	public void ApproveDL() {
		scrooldown(driver);
		Login_DLApprovalPage = new Login_DLApprovalPage(driver);
		Login_DLApprovalPage.ClickonApprove();
		NewDLNumber = DL_No(driver, "//div[@class='col-md-12 text-center']/h4");
		Login_DLApprovalPage.setdata("DLNumber", NewDLNumber.substring(74).trim());
	}
}
