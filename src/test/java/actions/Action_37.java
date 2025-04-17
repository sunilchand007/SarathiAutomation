package actions;

import org.openqa.selenium.WebDriver;

import frameworkLibrary.BaseClass;
import pageobjects.IDPLicenceDetailsPage;
import pageobjects.StateSpecificHomePage;

public class Action_37 extends BaseClass{

	
	WebDriver driver;

	public void Menuitem_Display_IDP_Details() {
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.clickon_PrintDrivingLicence();
		stateSpecificHomePage.Clickon_Display_IDP_Details();
		IDPLicenceDetailsPage idpLicenceDetailsPage = new IDPLicenceDetailsPage();
		idpLicenceDetailsPage.Enter_DLNumber_IDP(getdata("DLNO"));
		idpLicenceDetailsPage.Enter_IDP_No(getdata("IDPNO"));
		idpLicenceDetailsPage.Enter_IDP_DOB(getdata("DOB"));
		idpLicenceDetailsPage.Clickon_IDP_Submit();
		
		idpLicenceDetailsPage.Clickon_IDP_Print();
		

	}
}
