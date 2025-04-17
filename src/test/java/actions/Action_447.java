package actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.ApplicationCancellationPage;
import pageobjects.ApplicationCancellationStatusPage;
import pageobjects.NewLLAcknowledgementPage;
import pageobjects.NewLLCategoryAndHoldingPage;
import pageobjects.NewLLInstructionsPage;
import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.Flows;
import utility.Utilitymethods;

public class Action_447 extends BaseClass {
	WebDriver driver;

	Flows validate;

	Utilitymethods utilitymethods;
	StateSelectionPage stateSelectionPage;
	StateSpecificHomePage stateSpecificHomePage;
	ApplicationCancellationPage applicationCancellationPage;
	ApplicationCancellationStatusPage applicationCancellationStatusPage;
	
	Action_200 action_200;
	
	@BeforeMethod
	public void LaunchApplication() throws IOException {

		 utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();
	}

	
	



	

	@Test(invocationCount = 1)
	public void TC_Cancel_Application() throws IOException, ClassNotFoundException, SQLException {
        String testcase = "cancelap";
        if(testcase.equalsIgnoreCase("cancelappl")) {
        	utilitymethods = new Utilitymethods(driver);
    		utilitymethods.ArrangeDataSet();
    		stateSelectionPage = new StateSelectionPage(driver);
    		stateSelectionPage.Selectstatename(getdata("State"));
    		stateSpecificHomePage = new StateSpecificHomePage(driver);
    		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
    		stateSpecificHomePage.Mouserhoveron_LearnerLicence();
    		stateSpecificHomePage.Clickon_Application_for_New_LearnerLicence();
    		NewLLInstructionsPage newLLInstructions = new NewLLInstructionsPage(driver);
    		newLLInstructions.clickonContinue();
    		NewLLCategoryAndHoldingPage newLLCategoryAndHolding = new NewLLCategoryAndHoldingPage(driver);
    		newLLCategoryAndHolding.clickSubmitButton_in_NewLLCategory_and_Holding();
    		// EKYC PAGE VALIDATION
    	    utilitymethods.authentication();
    		action_200 = new Action_200(driver);
    		action_200.FILL_APPLICATION_DETAILS_FOR_LL();
    		NewLLAcknowledgementPage llapplicationReferencePage = new NewLLAcknowledgementPage(driver);
    		llapplicationReferencePage.CaptureDetails();
    		llapplicationReferencePage.click_on_HomeButton();
    		stateSpecificHomePage = new StateSpecificHomePage(driver);
    		stateSpecificHomePage.Mouserhoveron_Others();
    		stateSpecificHomePage.Clickon_CancelApplication_Number();
    		applicationCancellationPage = new ApplicationCancellationPage(driver);
    		applicationCancellationPage.Set_Application_Number();
    		applicationCancellationPage.Set_DateofBirth();
    		applicationCancellationPage.set_captcha_in_applicationcancellation("123456");
    		applicationCancellationPage.Clickon_Submit_Button();
    		applicationCancellationStatusPage = new  ApplicationCancellationStatusPage(driver);
    		applicationCancellationStatusPage.Clickon_CancelApplication_No();
    		applicationCancellationStatusPage.Clickon_Proceed_CancelApplication_No();
    		applicationCancellationStatusPage.setOtp("123456");
    		applicationCancellationStatusPage.Clickon_submit_button();
    	  
    	     Clickon_Terms_Checkbox();
    		Clickon_Final_CancelApplication_No();
    	
        	
        }else {
        	utilitymethods = new Utilitymethods(driver);
    		utilitymethods.ArrangeDataSet();
    		stateSelectionPage = new StateSelectionPage(driver);
    		stateSelectionPage.Selectstatename(getdata("State"));
    		stateSpecificHomePage = new StateSpecificHomePage(driver);
    		stateSpecificHomePage.closeContactlessLicenceServicesPopup();
    		stateSpecificHomePage.Mouserhoveron_Others();
    		stateSpecificHomePage.Clickon_CancelApplication_Number();
    		applicationCancellationPage = new ApplicationCancellationPage(driver);
    		applicationCancellationPage.Set_Application_Number();
    		applicationCancellationPage.Set_DateofBirth();
    		applicationCancellationPage.set_captcha_in_applicationcancellation("123456");
    		applicationCancellationPage.Clickon_Submit_Button();
    		applicationCancellationStatusPage = new  ApplicationCancellationStatusPage(driver);
    		applicationCancellationStatusPage.Clickon_CancelApplication_No();
    		applicationCancellationStatusPage.Clickon_Proceed_CancelApplication_No();
    		applicationCancellationStatusPage.setOtp("123456");
    		applicationCancellationStatusPage.Clickon_submit_button();
    	   
    		Clickon_Terms_Checkbox();
    	    Clickon_Final_CancelApplication_No();
        }

		
	}
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='chkTermsandCond']")
	WebElement terms;

	public void Clickon_Terms_Checkbox() {
		wait(30);
	boolean	stepstatus =clickElement(terms);
		reportEvent(stepstatus, "Able to click Checkbox", "Unable to click Checkbox", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//button[@name='checkConfirm']")
	WebElement Proceedfinalcancel;

	public void Clickon_Final_CancelApplication_No() {
		boolean	stepstatus =clickElement(Proceedfinalcancel);
		reportEvent(stepstatus, "Able to click ProceedCancelApplication_Number",
				"Unable to click ProceedCancelApplication_Number", driver, true);
	}





	

}
