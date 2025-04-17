package actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BaseClass;
import frameworkLibrary.BasePage;
import pageobjects.ApplicationStatusStage01Page;
import pageobjects.AuthenticationPage;
import pageobjects.Form1Page;
import pageobjects.NewLLAcknowledgementPage;
import pageobjects.NewLLCategoryAndHoldingPage;
import pageobjects.NewLLInstructionsPage;
import pageobjects.NewLLSubmissionPage;
import pageobjects.StateSpecificHomePage;

public class Action_200 extends BaseClass {
	
	Form1Page form1Page;
	WebDriver driver;
	NewLLSubmissionPage newLLSubmissionPage;
	StateSpecificHomePage stateSpecificHomePage;
	AuthenticationPage authenticationPage;
	ApplicationStatusStage01Page applicationStatusstage01;
	
	public Action_200(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void FILL_APPLICATION_DETAILS_FOR_LL() throws ClassNotFoundException, SQLException, IOException {
		
		stateSpecificHomePage = new StateSpecificHomePage(driver);
		stateSpecificHomePage.Mouserhoveron_LearnerLicence();
		stateSpecificHomePage.Clickon_Application_for_New_LearnerLicence();
		NewLLInstructionsPage newLLInstructions = new NewLLInstructionsPage(driver);
		newLLInstructions.clickonContinue();
		NewLLCategoryAndHoldingPage newLLCategoryAndHolding = new NewLLCategoryAndHoldingPage(driver);
		newLLCategoryAndHolding.clickSubmitButton_in_NewLLCategory_and_Holding();
		// EKYC PAGE VALIDATION
		authenticationPage = new AuthenticationPage(driver);
		authenticationPage.authentication();
		System.out.println("Inside fill application details for LL method ");
		newLLSubmissionPage = new NewLLSubmissionPage(driver);
		newLLSubmissionPage.Set_RTO_Office(getdata("RTOCode"));
		newLLSubmissionPage.SetFirstName(getdata("Applicantfirstname"));
		newLLSubmissionPage.SetMiddlename("yty");
		newLLSubmissionPage.SetLastName(getdata("Applicantlastname"));
		newLLSubmissionPage.SetRelationType(getdata("RT"));
		newLLSubmissionPage.SetRelationFirstName(getdata("Relationfirstname"));
		newLLSubmissionPage.SetRelationLastName(getdata("Relationlastname"));
		newLLSubmissionPage.SetGender();
		newLLSubmissionPage.SetAge(getdata("Age"));
		newLLSubmissionPage.SetQualification(getdata("Qualification"));
		newLLSubmissionPage.SetBloodgroup(getdata("Bgrp"));
		newLLSubmissionPage.SetMobilenumber(getdata("Phone"));
		newLLSubmissionPage.SetIdentificationMarks1("A mole on Right Side");
		newLLSubmissionPage.SetState();
		newLLSubmissionPage.TypeDist();
		newLLSubmissionPage.SetLocation("Hyderabad");
		newLLSubmissionPage.SetPincode(getdata("Pin"));
		newLLSubmissionPage.SetCopytopermenentaddress();
		newLLSubmissionPage.SetCOV(getdata("COV1"));
		newLLSubmissionPage.SetCOV1(getdata("COV2"));
		// newLLSubmissionPage.SetCOV2(getdata("COV3"));
		newLLSubmissionPage.SetRightarrow();
		newLLSubmissionPage.ClickonWillingToDonate();
		newLLSubmissionPage.Entercaptcha_in_newllpage("123456");
	//boolean form1=	driver.findElement(By.xpath("//input[@id = 'submitform']")).isDisplayed();
	//System.out.println("Boolean status of form1 is " + form1);
	//	String form1req = getdata("form1req");
		if (driver.getPageSource().contains("Fill-up Form1 details before submitting the application")) {
		newLLSubmissionPage.ClickonForm1_buttton();
		SwitchtoWindowByTitle("formOne", driver);
		form1Page = new Form1Page(driver);
		form1Page.Fill_Form1Details("Application for NewLL");
	    }
		else {
			System.out.println("there is form1");
			
		}
		newLLSubmissionPage.SetSubmitthree();
		
		NewLLAcknowledgementPage llapplicationReferencePage = new NewLLAcknowledgementPage(driver);
		llapplicationReferencePage.CaptureDetails();
		llapplicationReferencePage.click_on_NextButton();
		applicationStatusstage01 = new ApplicationStatusStage01Page(driver);
		applicationStatusstage01.enterdetails_In_Applicationstaus();
	}
	
	
	
}

	
