package transactions;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import frameworkLibrary.BaseClass;
import pageobjects.ApplicationStatusStage01Page;
import pageobjects.CL_NEWCL_AcknowledgementPage;
import pageobjects.CL_NewCLInstructionsPage;
import pageobjects.CL_New_CLSubmissionPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Transaction_551 extends BaseClass {

	WebDriver driver;

	CL_New_CLSubmissionPage CLSubmissionPage;
	
	ApplicationStatusStage01Page applicationStatusstage01;
	Flows validate;
	Utilitymethods utility;
	

	public void TC_NewConductorLicence()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException, AWTException {

		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
		// utilitymethods.ArrangeDataSet();
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		stateSpecificHomePage.Mouserhoveron_ConductorLicence();
		stateSpecificHomePage.Clickon_NewConductorLicence();
		CL_NewCLInstructionsPage newCLInstructions = new CL_NewCLInstructionsPage(driver);
		newCLInstructions.clickonContinue();
		// Authentication
		utility = new Utilitymethods(driver);
		utility.authentication();

		CLSubmissionPage = new CL_New_CLSubmissionPage(driver);
		CLSubmissionPage.Clickon_CLState(getdata("State"));
		CLSubmissionPage.Clickon_CLRTO(getdata("RTOCode"));
		utilitymethods.ArrangeDataSet();
		CLSubmissionPage.Enter_CLFirstname(getdata("Applicantfirstname"));
		CLSubmissionPage.Enter_CLMiddlename("ApplicantMiddlename");
		CLSubmissionPage.Enter_CLLastname(getdata("Applicantlastname"));
		CLSubmissionPage.Select_CLRelationname(getdata("Relation"));
		CLSubmissionPage.Enter_CLRFirstname(getdata("Relationfirstname"));
		CLSubmissionPage.Enter_CLRMiddlename("RelationMiddlename");
		CLSubmissionPage.Enter_CLRLastname(getdata("Relationlastname"));
		CLSubmissionPage.Select_CLGender();
		CLSubmissionPage.Select_CLAge(getdata("CLAge"));
		CLSubmissionPage.Select_CLEducation(getdata("CLEducation"));
		CLSubmissionPage.Enter_CLMobilenumber(getdata("CLMobile"));
		CLSubmissionPage.Clickon_AddressTab();
		CLSubmissionPage.Select_StateSelectionin_AddressTab();
		CLSubmissionPage.TypeDist();
		CLSubmissionPage.Enter_HouseNumber(getdata("HouseNo"));
		CLSubmissionPage.Enter_StreetAddress(getdata("Street"));
		CLSubmissionPage.Enter_Pincode(getdata("Pincode"));
		CLSubmissionPage.Clickon_Checkbox();
		CLSubmissionPage.Clickon_MedicalDetailsTab();
		CLSubmissionPage.Enter_FAIssuing_InstitutionName_In_First_Aid_Details(getdata("InstituteName"));
		CLSubmissionPage.Enter_Certification_Number_In_First_Aid_Details(getdata("CertificateNo"));
		CLSubmissionPage.Enter_PlaceofIssued_In_First_Aid_Details("testplace");
		CLSubmissionPage.Enter_Issued_Date_In_First_Aid_Details(getdata("IssueDate"));
		CLSubmissionPage.Enter_Fitness_CertificateNo_In_MedicalFitness(getdata("FitnessCertificateNo"));
		CLSubmissionPage.Enter_Doctor_Name_In_MedicalFitness("Kethrin");
		CLSubmissionPage.Enter_RegistrationNo_of_Doctor_In_MedicalFitness("RegNoOfDoct");
		CLSubmissionPage.Enter_ClinicName_and_Place_In_MedicalFitness("ClinicName");
		CLSubmissionPage.Enter_IssueeDate_In_MedicalFitness(getdata("MedicalIssuedate"));
		CLSubmissionPage.Clickon_Question();
		CLSubmissionPage.Clickon_Donate();
		CLSubmissionPage.Enter_Captcha("123456");
		CLSubmissionPage.Clickon_Submitbutton();
		CL_NEWCL_AcknowledgementPage clApplicationAcknowledgement = new CL_NEWCL_AcknowledgementPage(driver);
		clApplicationAcknowledgement.Capture_AcknowledgementDetails();

		utility.Validating_Flows();

	}


	public void TC_NEW_CL_ApplicationStatus()throws ClassNotFoundException, IOException, SQLException, InterruptedException, AWTException {


		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
		// utilitymethods.ArrangeDataSet();
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();

		applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
		applicationStatusstage01.enterdetails_In_Applicationstaus();
		Utilitymethods utility = new Utilitymethods(driver);
		utility.Validating_Flows();

	}

	@Test(invocationCount = 3 )
	
	public void NEW_CL() throws ClassNotFoundException, IOException, SQLException, InterruptedException, AWTException {
		// String Testcase = getdata("Scenario");
		String Testcase = "TC_NewConductorLicence";
		System.out.println("Testcase is : " + Testcase);

		if (Testcase.equalsIgnoreCase("TC_NewConductorLicence")) {
			System.out.println("inside NewConductorLicence");
			TC_NewConductorLicence();
		}

		else if (Testcase.equalsIgnoreCase("TC_NEW_CL_ApplicationStatus")) {
			System.out.println("inside ApplicationStatus");
			TC_NEW_CL_ApplicationStatus();
		}
	}

	@AfterMethod
	public void CloseBrowser() {
		System.out.println("**************After Method***************");
		
		
	
	}

}
