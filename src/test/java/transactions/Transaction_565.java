package transactions;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageobjects.CL_TemporaryCL_SubmissionPage;
import pageobjects.TemporaryCL_ApplicationAcknowledgementPage;
import pageobjects.TemporaryCL_InstructionsPage;
import frameworkLibrary.BaseClass;

import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Utilitymethods;

public class Transaction_565 extends BaseClass {
	WebDriver driver;
	CL_TemporaryCL_SubmissionPage TempCLSubmissionPage;
	
	Utilitymethods utility;


	public void TC_TemporaryCL_NewConductorLicence()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException, AWTException {

		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		stateSpecificHomePage.Mouserhoveron_ConductorLicence();
		stateSpecificHomePage.Clickon_TemporaryConductorLicence();
		TemporaryCL_InstructionsPage temporaryCLInstructions = new TemporaryCL_InstructionsPage(driver);
		temporaryCLInstructions.clickonContinue();
		utility = new Utilitymethods(driver);
		utility.authentication();

		TempCLSubmissionPage = new CL_TemporaryCL_SubmissionPage(driver);

		TempCLSubmissionPage.Clickon_CLState(getdata("State"));
		TempCLSubmissionPage.Clickon_CLRTO(getdata("RTOCode"));
		utilitymethods.ArrangeDataSet();
		TempCLSubmissionPage.Enter_CLFirstname(getdata("Applicantfirstname"));
		TempCLSubmissionPage.Enter_CLMiddlename(getdata("ApplicantMiddlename"));
		TempCLSubmissionPage.Enter_CLLastname(getdata("Applicantlastname"));
		TempCLSubmissionPage.Select_CLRelationname(getdata("Relation"));
		TempCLSubmissionPage.Enter_CLRFirstname(getdata("Relationfirstname"));
		TempCLSubmissionPage.Enter_CLRMiddlename(getdata("RelationMiddlename"));
		TempCLSubmissionPage.Enter_CLRLastname(getdata("Relationlastname"));
		TempCLSubmissionPage.Select_CLGender();
		TempCLSubmissionPage.Select_CLAge(getdata("CLAge"));
		TempCLSubmissionPage.Select_CLEducation(getdata("CLEducation"));
		TempCLSubmissionPage.Enter_CLMobilenumber(getdata("CLMobile"));
		TempCLSubmissionPage.Clickon_AddressTab();
		TempCLSubmissionPage.Select_StateSelectionin_AddressTab();
		TempCLSubmissionPage.TypeDist();
		TempCLSubmissionPage.Enter_HouseNumber(getdata("HouseNo"));
		TempCLSubmissionPage.Enter_StreetAddress(getdata("Street"));
		TempCLSubmissionPage.Enter_Pincode(getdata("Pincode"));
		TempCLSubmissionPage.Clickon_Checkbox();
		TempCLSubmissionPage.Clickon_MedicalDetailsTab();
		TempCLSubmissionPage.Enter_FAIssuing_InstitutionName_In_First_Aid_Details(getdata("InstituteName"));
		TempCLSubmissionPage.Enter_Certification_Number_In_First_Aid_Details(getdata("CertificateNo"));
		TempCLSubmissionPage.Enter_PlaceofIssued_In_First_Aid_Details("testplace");
		TempCLSubmissionPage.Enter_Issued_Date_In_First_Aid_Details(getdata("IssueDate"));
		TempCLSubmissionPage.Enter_End_Date_In_First_Aid_Details(getdata("EndDate"));
		TempCLSubmissionPage.Enter_Fitness_CertificateNo_In_MedicalFitness(getdata("FitnessCertificateNo"));
		TempCLSubmissionPage.Enter_Doctor_Name_In_MedicalFitness(getdata("DoctorName"));
		TempCLSubmissionPage.Enter_RegistrationNo_of_Doctor_In_MedicalFitness(getdata("RegNoOfDoct"));
		TempCLSubmissionPage.Enter_ClinicName_and_Place_In_MedicalFitness(getdata("ClinicName"));
		TempCLSubmissionPage.Enter_IssueeDate_In_MedicalFitness(getdata("MedicalIssuedate"));
		TempCLSubmissionPage.Clickon_Question();
		TempCLSubmissionPage.Enter_Captcha("123456");
		TempCLSubmissionPage.Clickon_Submitbutton();
		TemporaryCL_ApplicationAcknowledgementPage temporaryCL_applicationAcknowledgement = new TemporaryCL_ApplicationAcknowledgementPage(
				driver);
		temporaryCL_applicationAcknowledgement.Capture_TemporaryCL_AcknowledgementDetails();
		utility.Validating_Flows();

	}


	public void TC_TemporaryCL_Applicationstatus() throws IOException, InterruptedException, AWTException, ClassNotFoundException, SQLException {

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
		// driver.findElement(By.xpath("//input[@id ='entcaptxt']")).sendKeys("123456");
		//appstatus.Clickon_Submit_Button();
		Utilitymethods utility = new Utilitymethods(driver);
		utility.Validating_Flows();

	}

	@Test(invocationCount = 2)


	public void Temporary_CL()
			throws ClassNotFoundException, IOException, SQLException, InterruptedException, AWTException  {

		// String Testcase = getdata("Scenario");
		String Testcase = "Temporary_NewConductorLicence";
		System.out.println("Testcase is : " + Testcase);

		if (Testcase.equalsIgnoreCase("Temporary_NewConductorLicence")) {
			System.out.println("inside NewConductorLicence");
			TC_TemporaryCL_NewConductorLicence();
		}

		else if (Testcase.equalsIgnoreCase("Temporary_CL_ApplicationStatus")) {
			System.out.println("inside ApplicationStatus");
			TC_TemporaryCL_Applicationstatus();
		}
	}

	@AfterMethod
	public void CloseBrowser() {

		System.out.println("**************After Method***************");
	}

}
