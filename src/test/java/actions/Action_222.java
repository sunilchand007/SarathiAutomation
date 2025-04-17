package actions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import frameworkLibrary.BasePage;
import pageobjects.CL_BacklogPage;
import pageobjects.CL_CLBacklog_CaptureDetails;

public class Action_222 extends BasePage {
	WebDriver driver;
	BasePage basepage = new BasePage();
	CL_BacklogPage clbacklog;
	CL_CLBacklog_CaptureDetails CaptureDetails;

	
// CL Backlog Application Form 
	
	public void FILL_APPLICATION_DETAILS_FOR_CLBacklog() throws IOException, InterruptedException {
		System.out.println("Inside fill application details for CLBacklog method ");
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
		clbacklog.SetState(prop.getProperty(getdata("State")));
		clbacklog.TypeofDistdetails();
		clbacklog.EnterHouseNo();
		clbacklog.EnterStreetName();
		clbacklog.SetPincode(getdata("Pincode"));
		clbacklog.ClickonCheckbox();
		clbacklog.ClickonLicencedetails();
		clbacklog.EnterTestDate(getdata("Firstissuedate"));
		clbacklog.EnterBadgeNo(getdata("BadgeNo"));
		clbacklog.ClickOnSubmit();
		CaptureDetails = new CL_CLBacklog_CaptureDetails(driver);
		CaptureDetails.capturedetailsinClbacklogPage();

	}
}
