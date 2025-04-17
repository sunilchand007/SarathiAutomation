package transactions;

import java.awt.AWTException;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import frameworkLibrary.BaseClass;
import pageobjects.*;
import utility.Utilitymethods;

public class Transaction_556 extends BaseClass {

	
	WebDriver driver;
	CL_BacklogPage clbacklog;
	Utilitymethods utility;
	RTO_LoginHomePage rto_LoginHomePage;

	@BeforeMethod
	public void LaunchApplication() throws IOException {

		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}

	public void CLBacklogs()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException, AWTException {

		Utilitymethods utilitymethods = new Utilitymethods(driver);
		utilitymethods.ArrangeDataSet();
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.clickLoginbutton();
		LoginPage RTO = new LoginPage(driver);
		System.out.println(GetCurrentDate());
		RTO.setUserName(getdata("UserName"));
		RTO.setpassword(getdata("Password"));
		RTO.ClickonLogin();
        CL_BacklogPage clbacklog = new CL_BacklogPage(driver);
		clbacklog.ClickonCL();
		clbacklog.ClickonCLBacklog();
		clbacklog.SetFirstissuedate(getdata("Firstissuedate"));
		clbacklog.SetOriginalCLno(getdata("OriginalCLno"));
		clbacklog.SetNumericCLno(getdata("NumericCLno"));
	    clbacklog.SetName(getdata("Applicantfirstname"));
		clbacklog.SetLastName(getdata("Applicantlastname"));
		clbacklog.SetRelation(getdata("Relation"));
		clbacklog.SetRelationfirstname(getdata("Relationfirstname"));
		clbacklog.SetRelationLastname(getdata("Relationlastname"));
		clbacklog.ClickonGender();
		clbacklog.SetAge(getdata("Age"));
		clbacklog.SetBloodgroup(getdata("Bgrp"));  
		clbacklog.SetQualification(getdata("Qualification"));
		clbacklog.SetMobilenumber(getdata("Mobilenumber"));
		clbacklog.ClickAddressTab();
		clbacklog.SetState(getdata("State"));
		clbacklog.TypeofDistdetails();
		clbacklog.EnterHouseNo();
		clbacklog.EnterStreetName();
		clbacklog.SetPincode(getdata("Pincode"));
		clbacklog.ClickonCheckbox();
		clbacklog.ClickonLicencedetails();
		clbacklog.EnterTestDate(getdata("Firstissuedate"));
		clbacklog.EnterBadgeNo(getdata("BadgeNo"));
		clbacklog.ClickOnSubmit();
		CLbacklogdetailsExtractionPage clbacklogdetailsExtraction = new CLbacklogdetailsExtractionPage(driver);
		clbacklogdetailsExtraction.capturedetailsinClbacklogPage();

		rto_LoginHomePage = new RTO_LoginHomePage(driver);
		rto_LoginHomePage.Clickon_Misc();
		rto_LoginHomePage.Click_on_applicationstatus();
		rto_LoginHomePage.EnterApplicationNumber(getdata("ApplicationNo"));
		rto_LoginHomePage.Click_on_viewflows();
		utilitymethods = new Utilitymethods(driver);
		utilitymethods.Validating_Flows();

	}

	public void CL_Backlog_ApplicationStatus() throws IOException, AWTException, InterruptedException, ClassNotFoundException, SQLException {
		
		
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
		// utilitymethods.ArrangeDataSet();
		StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
		stateSelectionPage.Selectstatename(getdata("State"));
		StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.closeContactlessLicenceServicesPopup();

		//ApplicationStatusPage appstatus = new ApplicationStatusPage(driver);
		//appstatus.Clickon_Application_Status();
		//appstatus.Set_Application_Number(getdata("ApplicationNo"));
		//appstatus.Set_DateofBirth(getdata("DateofBirth"));
		//appstatus.enterCaptcha();
		//driver.findElement(By.xpath("//input[@id ='entcaptxt']")).sendKeys("123456");
		//appstatus.Clickon_Submit_Button();
		Utilitymethods utility = new Utilitymethods(driver);
		utility.Validating_Flows();

		

	}

	@Test(invocationCount = 2)

	public void CLBacklog_Public()
			throws IOException, ClassNotFoundException, SQLException, InterruptedException, AWTException {
		// String Testcase = ("Scenerio");
		String Testcase = "CLBacklog";
		System.out.println("Testcase is : " + Testcase);

		if (Testcase.equalsIgnoreCase("CLBacklog")) {
			System.out.println("inside CL backlog");
			CLBacklogs();
			// CL_Backlog_ApplicationStatus();
		}

		else if (Testcase.equalsIgnoreCase("CLbacklog_ApplicationStatus")) {
			CL_Backlog_ApplicationStatus();

		} else {
			System.out.println(" Please check the Testcase");
		}
	}


@AfterMethod
public void CloseBrowser() {
	System.out.println("**************After Method***************");
}
}


////////////
//RTO.ClickonMobile();
//RTO.setMobileNumber(getdata("JPMobileno"));
//RTO.ClickonPWDLessAuthentification();
//RTO.chkconcentlogin();
//RTO.ClickonSignIn();
//wait(3);
//RTO.SetOTP();
//RTO.ClickonotpSubmitButton();





////////////////////

/*Utilitymethods utilitymethods = new Utilitymethods(driver);
utilitymethods.ArrangeDataSet();
StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
stateSelectionPage.Selectstatename(getdata("State"));
StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
stateSpecificHomePage.closeContactlessLicenceServicesPopup();
stateSpecificHomePage.Clickon_Application_Status();
ApplicationStatusStage01Page applicationStatusStage01Page = new ApplicationStatusStage01Page(driver);
applicationStatusStage01Page.Set_Application_Number();
applicationStatusStage01Page.Set_DateofBirth();
 applicationStatusStage01Page.enterCaptcha("123456");
applicationStatusStage01Page.Clickon_Submit_Button();
ApplicationStatusStage02Page applicationStatusstage02 = new ApplicationStatusStage02Page(driver);
int remainingFlows = applicationStatusstage02.numberOfRemainingFlows();
System.out.println("Count of Remaining Flows are  " + remainingFlows);
for (int i = 1; i <= remainingFlows; i++) {
	String nextFlow = applicationStatusstage02.getAndEnterNextFlow();
	System.out.println("The Next Flow for LL is  " + nextFlow);
	applicationStatusstage02.Clickon_Proceed_Button();
	if (nextFlow.contains("UPLOAD PHOTO AND SIGNATURE")) {
		UploadPhoto_SignaturePage uploadPhotoandSign = new UploadPhoto_SignaturePage(driver);
		uploadPhotoandSign.Robot_Clickon_Browse_Button1();
		uploadPhotoandSign.Robot_Clickon_Browse_Button2();
		uploadPhotoandSign.Clickon_UploadandViewfiles();
		uploadPhotoandSign.Clickon_SavephotoandSignature();
		uploadPhotoandSign.Clickon_Next();
		if (driver.getPageSource().contains("Application Status")) {
			applicationStatusStage01Page.enterCaptcha(getdata("123456"));
			applicationStatusStage01Page.Clickon_Submit_Button();
		}
	} else if (nextFlow.contains("UPLOAD DOCUMENTS")) {
		System.out.println("Inside Upload Documents Flow");

		UploadDocumentsStage02Page uploadDocumentsStage02 = new UploadDocumentsStage02Page(driver);
		uploadDocumentsStage02.click_on_SubmitButtoninUploadDocument02();
		UploadDocumentsStage03Page uploadDocumentsStage03 = new UploadDocumentsStage03Page(driver);
		uploadDocumentsStage03.uploadDocuments();
		if (driver.getPageSource().contains("Application Status")) {
			applicationStatusStage01Page.enterCaptcha(getdata("123456"));
			applicationStatusStage01Page.Clickon_Submit_Button();
		}
	}
}

applicationStatusstage02.Clickon_HOME_Button();
stateSelectionPage.clickLoginbutton();
LoginRTO RTO = new LoginRTO(driver);
System.out.println(GetCurrentDate());
RTO.setUserName(getdata("UserName"));
RTO.setpassword(getdata("Password"));
RTO.ClickonLogin();
//RTO.ClickonMobile();
//RTO.setMobileNumber(getdata("JPMobileno"));
//RTO.ClickonPWDLessAuthentification();
//RTO.chkconcentlogin();
//RTO.ClickonSignIn();
//wait(3);
//RTO.SetOTP();
//RTO.ClickonotpSubmitButton();
Flows flow = new Flows(driver);
flow.RTOLevel_Status();
// clbacklog.Clickon_Logout();

CLbacklogApprovalPage clbacklogApprovalPage = new CLbacklogApprovalPage(driver);
clbacklogApprovalPage.ClickonCL();
clbacklogApprovalPage.ClickonCLBacklogApproval();
clbacklogApprovalPage.EnterCLAppNo(getdata("ApplicationNo"));
clbacklogApprovalPage.ClickProceed();
clbacklogApprovalPage.ClickApproveButton();
clbacklogApprovalPage.Clickon_Logout();
clbacklogApprovalPage.Clickon_URL_ofstateHomePage();*/
