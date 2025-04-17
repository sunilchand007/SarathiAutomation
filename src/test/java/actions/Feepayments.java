package actions;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import frameworkLibrary.BaseClass;
import pageobjects.*;
import utility.Utilitymethods;

public class Feepayments extends BaseClass{

	WebDriver driver;
	Action_200 action_200;
@BeforeMethod
public void LaunchApplication() throws IOException {
		
		Utilitymethods utilitymethods = new Utilitymethods(driver);
		driver = utilitymethods.Launch_ApplicationUrl();

	}
	

@Test(invocationCount = 1)
public void TC_Fee_Payments() throws IOException, InterruptedException, ClassNotFoundException, SQLException {
	
	StateSelectionPage stateSelectionPage = new StateSelectionPage(driver);
	stateSelectionPage.Selectstatename(getdata("State"));
	StateSpecificHomePage stateSpecificHomePage = new StateSpecificHomePage(driver);
	stateSpecificHomePage.closeContactlessLicenceServicesPopup();
	stateSpecificHomePage.Mouserhoveron_LearnerLicence();
	
	  stateSpecificHomePage.Clickon_Application_for_New_LearnerLicence();
	  NewLLInstructionsPage newLLInstructions = new NewLLInstructionsPage (driver);
	  newLLInstructions.clickonContinue(); NewLLCategoryAndHoldingPage
	  newLLCategoryAndHolding = new NewLLCategoryAndHoldingPage(driver);
	  newLLCategoryAndHolding.clickSubmitButton_in_NewLLCategory_and_Holding();
	  action_200 = new Action_200(driver);
	  action_200.FILL_APPLICATION_DETAILS_FOR_LL(); NewLLAcknowledgementPage
	  newLLAcknowledgementPage = new NewLLAcknowledgementPage(driver);
	  newLLAcknowledgementPage.click_on_HomeButton();
	  stateSpecificHomePage.Mouserhoveron_FeePayments();
	  stateSpecificHomePage.Clickon_FeePayments();
	  InstructionsForOnlinePaymentPage instructionsForOnlinePaymentPage = new
	  InstructionsForOnlinePaymentPage(driver);
	  instructionsForOnlinePaymentPage.Clickon_EPayment();
	  instructionsForOnlinePaymentPage.Clickon_ApplicationFee();
	  ApplicationFeeforLLDLTestPage applicationFeeforLLDLTestPage = new ApplicationFeeforLLDLTestPage(driver);
	  applicationFeeforLLDLTestPage.Enter_Application_Number(getdata(
	  "ApplicationNo"));
	  applicationFeeforLLDLTestPage.Enter_DateofBirth(getdata("DateofBirth"));
	  applicationFeeforLLDLTestPage.Clickon_Calculate_Fee();
	  applicationFeeforLLDLTestPage.SelectBank(getdata("SelectBankforFeePayment"));
	  applicationFeeforLLDLTestPage.EnterCaptcha();
	  applicationFeeforLLDLTestPage.Clickon_Paynow_Button();
	  FeepaymentTermsandconditionsPage feepaymentTermsandconditionsPage = new FeepaymentTermsandconditionsPage(driver);
	  feepaymentTermsandconditionsPage.ClickonCheckbox_Termsandconditions();
	  feepaymentTermsandconditionsPage.Clickon_Proceedforpayment(); SBHIntroPage
	  sBHIntro = new SBHIntroPage(driver);
	  sBHIntro.Clickon_ContinuetoLogin_Button(); 
	  SBHhomePage sBHhome = new SBHhomePage(driver); 
	  sBHhome.Clickon_Pressheretocontinue_Button();
	  ApplicationFeePaymentSuccessAckPage applicationFeePaymentSuccessAck= new ApplicationFeePaymentSuccessAckPage(driver); 
	  applicationFeePaymentSuccessAck.Clickon_NextbuttoninApplicationFeePaymentSuccessAck();
	 
	
}

}
