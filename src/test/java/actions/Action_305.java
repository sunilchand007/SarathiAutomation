package actions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.MobileNumberUpdatePage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;

public class Action_305 extends BaseClass {

	WebDriver driver;
	StateSelectionPage stateSelectionPage;
	StateSpecificHomePage stateSpecificHomePage;
	@Test(invocationCount = 1)
	public void TC_Mobile_Number_Update() throws IOException {
		
		
	
		stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		MobileNumberUpdatePage mobileNumberUpdatePage = new MobileNumberUpdatePage();
		mobileNumberUpdatePage.Clickon_Mobile_Number_Update();
		String selectcriteria = mobileNumberUpdatePage.Select_Criteria(getdata("SelectCriteria"));
		wait(2);
		mobileNumberUpdatePage.Enter_Licence_Issue_Date();
		if (selectcriteria.equalsIgnoreCase("LL")) {
		//	 boolean stepstatus = setText(LicenNumber, getdata("LL_DL_CL_Number"));
			//reportEvent(stepstatus, "Able to Enter LLNumber ", "Unable to Enter LLNumber", driver);
		} else if (selectcriteria.equalsIgnoreCase("DL")) {
		//	stepstatus =setText(LicenNumber, getdata("LL_DL_CL_Number"));
		//	reportEvent(stepstatus, "Able to Enter DLNumber ", "Unable to Enter DLNumber", driver);
		} else if (selectcriteria.equalsIgnoreCase("CL")) {
		//	stepstatus = setText(LicenNumber, getdata("LL_DL_CL_Number"));
		//	reportEvent(stepstatus, "Able to Enter CLNumber ", "Unable to Enter CLNumber", driver);
		} else {
			System.out.println("Selected Criteria not available");
		}
		mobileNumberUpdatePage.Enter_DateOFbirth();
		mobileNumberUpdatePage.Clickon_Submitbutton();
		mobileNumberUpdatePage.Clickon_Proceedbutton();
		mobileNumberUpdatePage.Enter_NewMobileNo();
		mobileNumberUpdatePage.Enter_ConfNewMobileNo();
		mobileNumberUpdatePage.Enter_Reasonforchange();
		mobileNumberUpdatePage.Clickon_ProceedbuttonatConf();
		String env = getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
		//	GetlogotpforConfirmationMobileNumber(prop.getProperty("SarathiCOVeKYCLogURL"));
		} else if (env.equalsIgnoreCase("SarathiProd")) {
		//	GetlogotpforConfirmationMobileNumber(prop.getProperty("SarathiprodeKYCLogURL"));
		} else {
			System.out.println("Log URL is not matched.Please try again");
		}
		mobileNumberUpdatePage.Clickon_finalProceedbuttonatConf();
		wait(2);
		

	}


	
	
}
