package transactions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import frameworkLibrary.BaseClass;
import pageobjects.ApplicationForServicesonDL2Page;
import pageobjects.ApplicationForServicesonDLPage;
import pageobjects.ChangeOfAddressInDLPage;
import pageobjects.DLExtractpage;
import pageobjects.DLServiceSelectionPage;
import pageobjects.DrivingLicenceMenuPage;
import pageobjects.ENDORSEMENTTODRIVEHAZARDOUSMATERIALDLPage;
import pageobjects.EndorsementToDriveInHillRegionDLPage;
import pageobjects.InstructionsforDLServicePage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Transaction_524 extends BaseClass  {

	WebDriver driver;
	boolean stepstatus;

	Flows flows;
	Utilitymethods utilitymethods;
	@BeforeMethod
	public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
	}
	@Test(invocationCount = 1)
public void EndorsementToDriveInHillregioninDLService() throws Exception {
	StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
	stateSelectionPage.Selectstatename(getdata("State"));
	StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
	stateSpecificHomePage.closeContactlessLicenceServicesPopup();
	DrivingLicenceMenuPage Dlmenu= new DrivingLicenceMenuPage(driver);
	wait(2);
	Dlmenu.Mouserhoveron_DrivingLicence();
	Dlmenu.Clickon_ServicesonDL();
	InstructionsforDLServicePage instructionsforDLService= new InstructionsforDLServicePage(driver);
	instructionsforDLService.Clickon_ContinuebuttoninInstructionsPage();
	ApplicationForServicesonDLPage applicationForServicesonDL= new ApplicationForServicesonDLPage(driver);
	applicationForServicesonDL.SetDLnumber();
	applicationForServicesonDL.SetDateofbirth();
	applicationForServicesonDL.EnterCaptchatoFetchDetails();
	applicationForServicesonDL.checkboxPolicyTerms();
	applicationForServicesonDL.Clickon_Getdetails();
	
	if(alertExist(driver)) {
		acceptAlert(driver);
		wait(2);
		
	}else {
		System.out.println("There is no Alert");
	}
	wait(3);
	ApplicationForServicesonDL2Page applicationForServicesonDL2page= new ApplicationForServicesonDL2Page(driver);
	applicationForServicesonDL2page.SelectYesOrNofromDropdown();
	wait(3);
//	applicationForServicesonDL2page.ClearPincode();
	wait(3);
	applicationForServicesonDL2page.SelectRTO();
	applicationForServicesonDL2page.Confirmbutton();
	applicationForServicesonDL2page.Confirmbutton2();
	 utilitymethods = new Utilitymethods(driver);
	 utilitymethods.authentication();
	 DLServiceSelectionPage dLServiceSelectionPage= new DLServiceSelectionPage(driver);
		dLServiceSelectionPage.selectserviceforENDORSEMENTTODRIVEInHillRegion();
		dLServiceSelectionPage.ClickProceedinServiceSelectionPage();
		EndorsementToDriveInHillRegionDLPage ETDHR=new EndorsementToDriveInHillRegionDLPage(driver);
		ETDHR.Enter_HillCertificateNumber();
		ETDHR.selectDate();
		ETDHR.IssuedBy();
		ETDHR.ClickonCONFIRM();
		
		if (driver.getPageSource().contains(" Please fill the Self declaration as to Physical Fitness Details")) {
			ChangeOfAddressInDLPage changeOfAddressInDLPage= new ChangeOfAddressInDLPage(driver);
			changeOfAddressInDLPage.Form_1_Check();
		} else {
			
			System.out.println("There is no Self declaration option");
		}
		ENDORSEMENTTODRIVEHAZARDOUSMATERIALDLPage ehm=new ENDORSEMENTTODRIVEHAZARDOUSMATERIALDLPage(driver);
		ehm.CheckBoxDisclaimers();
		ehm.SelectOrganDonor();
		ehm.EnterCaptcha();
		ehm.ClickSubmitForServiceReq();
		Flows flows = new Flows(driver);
		flows.VerifyFlows();
		flows.RTOLevel_Status();
}
}
