package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.LoginPage;
import pageobjects.RTO_LoginHomePage;
import pageobjects.RTO_WiseLanguage_ReportOn_STALLConductedPage;
import pageobjects.StateSelectionPage;
import utility.Utilitymethods;

public class Action_466 extends BaseClass {
	WebDriver driver;
	
	
	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}
	@Test(invocationCount = 1)
	public void reports() {
		
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.clickLoginbutton();
		LoginPage login = new LoginPage(driver);
		login.setUserName(getdata("UserName"));
		login.setpassword(getdata("Password"));
		login.ClickonLogin();
		RTO_LoginHomePage rto_loginHomePage = new RTO_LoginHomePage(driver);
		rto_loginHomePage.Clickon_Reports();
			rto_loginHomePage.clickon_languagewise_stallconduct_state();
			RTO_WiseLanguage_ReportOn_STALLConductedPage rto_WiseLanguage_ReportOn_STALLConducted = new RTO_WiseLanguage_ReportOn_STALLConductedPage(driver);
			rto_WiseLanguage_ReportOn_STALLConducted.clickon_From_Radiobutton();
			rto_WiseLanguage_ReportOn_STALLConducted.setfromdate("01-01-2020");
			rto_WiseLanguage_ReportOn_STALLConducted.settodate("11-03-2022");
			rto_WiseLanguage_ReportOn_STALLConducted.clickon_submitbutton();
			
		

	}
	
}
