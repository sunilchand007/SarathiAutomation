package transactions;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;


import pageobjects.CL_Applicationfor_Serviceson_CLPage01;
import pageobjects.CL_Applicationfor_Serviceson_CLPage02;
import pageobjects.CL_ChangeOfAddress_ApplicationAcknowledgementPage;
import pageobjects.CL_Services_ChangeOfAddressPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Utilitymethods;

public class Transaction_553 extends BaseClass {
	WebDriver driver;
	
	CL_Applicationfor_Serviceson_CLPage01 clservice;
	Utilitymethods utility;
	Transaction_556 clbacklog;
	

	public void TC_ChangeOfAddressinCL()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException, AWTException {
		
		
        Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
		// utilitymethods.ArrangeDataSet();
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		stateSpecificHomePage.Mouserhoveron_ConductorLicence();
		stateSpecificHomePage.Clickon_ServicesOnConductorLicence();
		
        clservice = new CL_Applicationfor_Serviceson_CLPage01(driver);
		clservice.Enter_ConductorLicencenumber(getdata("CLNumber"));
		clservice.Enter_DateOfBirth(getdata("DateOfBirth"));
		clservice.Enter_Captcha("123456");
		clservice.Clickon_Proceed();

		CL_Applicationfor_Serviceson_CLPage02 clservice1 = new CL_Applicationfor_Serviceson_CLPage02(driver);
		clservice1.Enter_MobileNumber(getdata("Mobilenumber"));
		clservice1.Clickon_Confirm();
		clservice1.Select_RtoOffice(getdata("RTOOffice"));
		clservice1.Clickon_Go();
		clservice1.Clickon_ChangeOfAddress();
		clservice1.Clickon_Submitbutton();
		utility = new Utilitymethods(driver);
		utility.authentication();

		CL_Services_ChangeOfAddressPage address = new CL_Services_ChangeOfAddressPage(driver);
		address.Clickon_ShoworHidePersonalandLicenceDetails();
		address.Clickon_Both_PresentandPermanentAddress();
		address.Select_PresentState(getdata("SelectState"));
		address.Select_PresentDistrict(getdata("District"));
		address.Select_PresentSubDistrict(getdata("SubDistrict"));
		address.Select_PresentVillageorTown(getdata("Village/Town"));
		address.Enter_PresentHouseno(getdata("Houseno"));
		address.Enter_PresentStreet(getdata("Street"));
		address.Enter_PresentPincode(getdata("Pincode"));
		address.Enter_PresentPhonenumber(getdata("Phonenumber"));
		address.Clickon_CopytoPermanentAddress();
		address.Clickon_Confirm();
		address.Clickon_Submit();

		CL_ChangeOfAddress_ApplicationAcknowledgementPage acknowledgement = new CL_ChangeOfAddress_ApplicationAcknowledgementPage(driver);
		acknowledgement.Capture_CLService_AcknowledgementDetails();

		Utilitymethods utilities = new Utilitymethods(driver);
		utilities.Validating_Flows();
 
	}


	public void CL_Service_ApplicationStatus() throws AWTException, IOException, ClassNotFoundException, SQLException {

		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
		// utilitymethods.ArrangeDataSet();
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();

		//appstatus = new ApplicationStatusPage(driver);
		//appstatus.Clickon_Application_Status();
		//appstatus.Set_Application_Number(getdata("ApplicationNo"));
		//appstatus.Set_DateofBirth(getdata("DateofBirth"));
		//appstatus.enterCaptcha();
		//appstatus.Clickon_Submit_Button();
		Utilitymethods utility = new Utilitymethods(driver);
		utility.Validating_Flows();

	}

	@Test(invocationCount = 1)
	public void CL_Service()
			throws AWTException, IOException, ClassNotFoundException, SQLException, InterruptedException {

		// String Testcase = getdata("Scenario");
		String Testcase = "TC_CL_Service";
		System.out.println("Testcase is : " + Testcase);
		Transaction_556 clbacklog= new Transaction_556();

		if (Testcase.equalsIgnoreCase("TC_CL_Service")) {
			System.out.println("inside NewConductorLicence");
			TC_ChangeOfAddressinCL();
		}

		else if (Testcase.equalsIgnoreCase("TC_ApplicationStatus")) {
			System.out.println("inside ApplicationStatus");
			CL_Service_ApplicationStatus();
		}
		
	}
}
