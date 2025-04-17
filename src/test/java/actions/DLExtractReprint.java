package actions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BaseClass;
import pageobjects.DLextractDetailsPage;
import pageobjects.StateSpecificHomePage;

public class DLExtractReprint extends BaseClass{

	WebDriver driver;
	

	public void Menuitem_DL_Extract_Reprint() {
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.clickon_PrintDrivingLicence();
		stateSpecificHomePage.clickon_Dl_ExtractPrint();
		DLextractDetailsPage dLextractDetailsPage = new DLextractDetailsPage();
		dLextractDetailsPage.Enter_DLExtractrePrint_applicationno(getdata("AppNo"));
		dLextractDetailsPage.Clickon_DLExtractrePrint_Submit();
		scrooldown(driver);
		dLextractDetailsPage.Clickon_DLExtractrePrint_Submit();
		wait(3);
	

	}
}
