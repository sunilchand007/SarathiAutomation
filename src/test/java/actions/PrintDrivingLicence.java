package actions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.Dlprint_citizenPage;
import pageobjects.StateSpecificHomePage;

public class PrintDrivingLicence extends BasePage{
	WebDriver driver;

	public void Menuitem_Print_Driving_Licence() {
		
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.clickon_PrintDrivingLicence();
		Dlprint_citizenPage dlprint_citizenPage = new Dlprint_citizenPage();
		dlprint_citizenPage.Enter_DLPrint_ApplicationNo(getdata("AppNo"));
		dlprint_citizenPage.Enter_DLPrint_dob(getdata("DOB"));
		dlprint_citizenPage.Clickon_DLPrint_Submit();
		dlprint_citizenPage.Clickon_DLPrint_btn();
		
	}
	
}
