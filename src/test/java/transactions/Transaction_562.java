package transactions;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.CL_Applicationfor_Serviceson_CLPage01;
import pageobjects.CL_Applicationfor_Serviceson_CLPage02;
import pageobjects.CL_ExtractCL_ApplicationAcknowledgementPage;
import pageobjects.CL_Services_ExtractCLPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Utilitymethods;

public class Transaction_562 extends BaseClass {

	WebDriver driver;
	
	CL_Applicationfor_Serviceson_CLPage01 clservice;
	Utilitymethods utility;


	public void TC_ExtractCL()
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
		clservice1.Enter_MobileNumber(getdata("MobileNumber"));
		clservice1.Clickon_Confirm();
		clservice1.Select_RtoOffice(getdata("RTOOffice"));
		clservice1.Clickon_Go();
		clservice1.Clickon_ExtractCL();
		clservice1.Clickon_Submitbutton();
		utility = new Utilitymethods(driver);
		utility.authentication();

		CL_Services_ExtractCLPage clextract = new CL_Services_ExtractCLPage(driver);
		clextract.Clickon_ShoworHidePersonalandLicenceDetails();
		clextract.Enter_ReasonForCLExtract(getdata("ReasonForCLEXTRACT"));
		clextract.Clickon_Confirm();
		clextract.Clickon_Submit();

		CL_ExtractCL_ApplicationAcknowledgementPage acknowledgement = new CL_ExtractCL_ApplicationAcknowledgementPage(
				driver);
		acknowledgement.Capture_CLService_AcknowledgementDetails();
		CL_Service_ApplicationStatus();

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
		String Testcase = "TC_ApplicationStatus";
		System.out.println("Testcase is : " + Testcase);

		if (Testcase.equalsIgnoreCase("TC_CL_Service")) {
			System.out.println("inside NewConductorLicence");
			TC_ExtractCL();
		}

		else if (Testcase.equalsIgnoreCase("TC_ApplicationStatus")) {
			System.out.println("inside ApplicationStatus");
			CL_Service_ApplicationStatus();
		}
	}

}