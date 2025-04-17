package transactions;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;

import pageobjects.CL_Applicationfor_Serviceson_CLPage01;
import pageobjects.CL_Applicationfor_Serviceson_CLPage02;
import pageobjects.CL_ChangeOfName_ApplicationAcknowledgementPage;
import pageobjects.CL_Services_ChangeOfNamePage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Transaction_559 extends BaseClass {

	WebDriver driver;

	Flows validate;
	Utilitymethods utility;

	public void TC_ChangeOfNameinCL()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException, AWTException {

		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
		utilitymethods.ArrangeDataSet();
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		stateSpecificHomePage.Mouserhoveron_ConductorLicence();
		stateSpecificHomePage.Clickon_ServicesOnConductorLicence();

		CL_Applicationfor_Serviceson_CLPage01 clservice = new CL_Applicationfor_Serviceson_CLPage01(driver);
		clservice.Enter_ConductorLicencenumber(getdata("CLNumber"));
		clservice.Enter_DateOfBirth(getdata("DateOfBirth"));
		clservice.Enter_Captcha("123456");
		clservice.Clickon_Proceed();

		CL_Applicationfor_Serviceson_CLPage02 clservice1 = new CL_Applicationfor_Serviceson_CLPage02(driver);
		clservice1.Enter_MobileNumber(getdata("MobileNumber"));
		clservice1.Clickon_Confirm();
		clservice1.Select_RtoOffice(getdata("RTOOffice"));
		clservice1.Clickon_Go();
		clservice1.Clickon_ChangeOfName();
		clservice1.Clickon_Submitbutton();
		utility = new Utilitymethods(driver);
		utility.authentication();

		CL_Services_ChangeOfNamePage Name = new CL_Services_ChangeOfNamePage(driver);
		Name.Clickon_ShoworHidePersonalandLicenceDetails();

		utilitymethods.ArrangeDataSet();
		Name.Enter_NewFullName(getdata("Applicantfullname"));
		Name.Enter_FirstName(getdata("Applicantfirstname"));
		Name.Enter_MiddleName(getdata("Applicantmiddlename"));
		Name.Enter_LastName(getdata("Applicantlastname"));
		Name.Select_Relation(getdata("Relation"));
		Name.Enter_RelationFirstName(getdata("Relationfirstname"));
		Name.Enter_RelationMiddleName(getdata("RelationMiddleName"));
		Name.Enter_RelationLastName(getdata("Relationlastname"));
		Name.Select_ReasonForChangeOfName(getdata("ReasonForChangeOfName"));
		Name.Enter_EffectiveDate(getdata("EffectiveDate"));
		Name.Clickon_Confirm();
		Name.Clickon_Submit();
		CL_ChangeOfName_ApplicationAcknowledgementPage acknowledgement = new CL_ChangeOfName_ApplicationAcknowledgementPage(
				driver);
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
		String Testcase = "TC_ApplicationStatus";
		System.out.println("Testcase is : " + Testcase);

		if (Testcase.equalsIgnoreCase("TC_CL_Service")) {
			System.out.println("inside NewConductorLicence");
			TC_ChangeOfNameinCL();
		}

		else if (Testcase.equalsIgnoreCase("TC_ApplicationStatus")) {
			System.out.println("inside ApplicationStatus");
			CL_Service_ApplicationStatus();
		}
	}
}
